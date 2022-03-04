package com.cleancode.chapter13;

import com.cleancode.chapter13.common.MessageUtils;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class Server implements Runnable{
    ServerSocket serverSocket;
    volatile boolean keepProcessing = true;
    ConnectionManager connectionManager;
    //ClientScheduler clientScheduler = new ThreadPerRequestScheduler();
    ClientScheduler clientScheduler = new ExecutorClientScheduler(10);


    public Server(int port, int millisecondsTimeout) throws IOException {
        connectionManager = new ConnectionManager(port, millisecondsTimeout);
    }

    public void run(){
        System.out.println("Server Starting\n");

        while(keepProcessing) {
            try{
                ClientConnection clientConnection = connectionManager.awaitClient();
                ClientRequestProcessor requestProcessor = new ClientRequestProcessor(clientConnection);
                clientScheduler.schedule(requestProcessor);

            } catch (Exception e){
                handle(e);
            }
        }
        connectionManager.shutdown();
    }

    private void handle(Exception e){
        if (!(e instanceof SocketException)){
            e.printStackTrace();
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        closeIgnoringException(serverSocket);
    }

    void process(Socket socket){
        if (socket == null)
            return;

        Runnable clientHandler = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.printf("Server: getting message\n");
                    String message = MessageUtils.getMessage(socket);
                    System.out.printf("Server: got message: %n", message);
                    Thread.sleep(1000);
                    System.out.printf("Server: sending reply: %s\n", message);
                    MessageUtils.sendMessage(socket, "Processed: " + message);
                    System.out.printf("Server: sent\n");
                    closeIgnoringException(socket);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Thread clientConnection = new Thread(clientHandler);
        clientConnection.start();

    }

    private void closeIgnoringException(Socket socket){
        if(socket != null)
            try{
                socket.close();
            } catch (IOException ignore) {}
    }

    private void closeIgnoringException(ServerSocket serverSocket){
        if(serverSocket != null)
            try{
                serverSocket.close();
            } catch (IOException ignore) {}
    }
}
