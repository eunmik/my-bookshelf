package com.cleancode.chapter14;

public class Application {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l, p#, d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            execcuteApplication(logging, port, directory);
        } catch (ArgsException e){
            System.out.printf("Argument error: %s\n", e.errorMessage());

        }
    }

    private static void execcuteApplication(boolean logging, int port, String directory){
        System.out.println("logging : " + logging);
        System.out.println("port : " + port);
        System.out.println("directory : " + directory);
    }
}


