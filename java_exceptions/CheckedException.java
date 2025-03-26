package com.bridgelabz.collections.exceptionhandling.checkedexception;

import java.io.*;

public class CheckedException {
    public static void main(String[] args) {
        File file=new File("src/com/bridgelabz/collections/iostream/checkedexception/data.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }
    }
}
