package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Lock {
    private int lastRotation = 50;
    private int zeroCounter = 0;

    private void turn(String instruction){
        char first = instruction.charAt(0);
        int ergebnis;
        int calc = parseInt(instruction.substring(1));
        if(first == 'R'){
            ergebnis = calc % lastRotation;
        }else{
            ergebnis = (calc * (-1)) % lastRotation;
        }



        if(ergebnis == 0){
            zeroCounter++;
        }


    }

    public void turnFromFile(String resourcePath) throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath);
             Scanner myReader = new Scanner(is, StandardCharsets.UTF_8)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                turn(data);
            }
        } catch (Exception e) {
            System.err.println("Error reading resource: " + resourcePath);
            e.printStackTrace();
        }
    }

}
