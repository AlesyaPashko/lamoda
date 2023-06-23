package org.example.utils;

public class Waiters {

    public static void waiter() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
