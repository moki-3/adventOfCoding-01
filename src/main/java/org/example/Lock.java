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
    private int counter = 0;

    private void turn(String instruction){
        char first = instruction.charAt(0);
        int calc = parseInt(instruction.substring(1));
        int direction = first == 'R' ? calc : -calc;
        lastRotation = turnInstruction(lastRotation + direction);
        counter++;
    }

    private int turnInstruction(int direction) {
        int rersult = direction % 100;
        System.out.println(rersult == 0 ? counter + "\t--->\t" +  rersult : counter + "\t----\t" +  rersult);
        if(rersult == 0){
            zeroCounter++;
        }
        return rersult < 0 ? rersult + 100 : rersult;
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

    public int getZeroCounter(){
        return zeroCounter;
    }

}
