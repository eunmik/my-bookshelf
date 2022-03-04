package com.cleancode.chapter13;

import java.net.Socket;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ClientConnection {
    private final Socket socket;

    public ClientConnection(final Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return this.socket;
    }
}

