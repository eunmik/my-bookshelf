package com.cleancode.chapter13;

public class IdGenerator {
    int lastIdUsed;

    public synchronized void incrementValue() {
        ++lastIdUsed;
    }
}
