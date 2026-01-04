package org.example;

import java.io.IOException;

public class ForPi {
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static void run() throws IOException {
        Lock l = new Lock();
        l.turnFromFile("input.txt");
        System.out.println("Es wurde " + l.getZeroCounter() + " mal auf die Stelle 0 gedreht");
    }
}
