import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main { extends Application 

    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("\nCounting the total occurance of every first digit in the file.\n");// using \n for new line

        // Creating File instance to reference text file in Java change the path to
        // wherever your sales.csv is need to change backslashes "\" to dashes "/"
        Scanner reader = new Scanner(System.in);
        System.out.println("Paste the file path and change backslashes '\' to dashes '/'. If you do not have one, please enter 'no'.");
        String userFile = reader.nextLine();
        // Use the default file if user do not have one
        if (userFile.equals("no")) {
            File text = new File("sales.csv");
            // Calling counting method
            countFirstDigit(text);

        } else {
            File text = new File(userFile);
            // Calling counting method
            countFirstDigit(text);
        }
        reader.close();   
       launch(args);
    }
            
    /*
    * Done by: Iliyan, Amy
    * Name: countFirstDigit
    * Step 1: Read the file and count the total occurance of every first digit
    * @param text: the file from user. This file is the file where all the data is loaded
    */

    // Declare the counters. These are counters for each number and records how often each number was readed as the first digit inside the sales file.

    public static void countFirstDigit(File text) throws FileNotFoundException {
      int counter1=0;
      int counter2=0;
      int counter3=0;
      int counter4=0;
      int counter5=0;
      int counter6=0;
      int counter7=0;
      int counter8=0;
      int counter9=0;

      // Creating Scanner named fileReader to read File in Java (sales file).
      Scanner fileReader = new Scanner(text);

      // read from the first line
      int lineNumber = 1;

      while(fileReader.hasNextLine()) {

        String line = fileReader.nextLine();
        // Set the reader to read only the first digit of sales
        char fDigit = line.charAt(4); //The index Value of the first Digit inside the csv file is at the index of 4. 
        //Eg.       Y 1 A , 4 8 4 6 1 6
        //Index:    0 1 2 3 4 5 6 7 8 9

        String firstDigit = String.valueOf(fDigit);
        // counter +1 when it equals to the number

        if (firstDigit.equals("1")){
          counter1++; //Updating counter for number 1. At the end this will have the value of how many times the number 1 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("2")) { 
          counter2++; //Updating counter for number 2. At the end this will have the value of how many times the number 2 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("3")) {
          counter3++; //Updating counter for number 3. At the end this will have the value of how many times the number 3 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("4")) {
          counter4++; //Updating counter for number 4. At the end this will have the value of how many times the number 4 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("5")) {
          counter5++; //Updating counter for number 5. At the end this will have the value of how many times the number 5 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("6")) {
          counter6++; //Updating counter for number 1. At the end this will have the value of how many times the number 1 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("7")) {
          counter7++; //Updating counter for number 7. At the end this will have the value of how many times the number 7 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("8")) {
          counter8++; //Updating counter for number 8. At the end this will have the value of how many times the number 8 was in first digit place. Increasing by 1
        }
        else if (firstDigit.equals("9")) {
          counter9++; //Updating counter for number 9. At the end this will have the value of how many times the number 9 was in first digit place. Increasing by 1
        }

      }
        
        //Creating new array to pass on values in an array to other methods
        int[] numCounter= {counter1, counter2, counter3, counter4, counter5, counter6, counter7, counter8, counter9};

        // Printing out how many times each number occured inside the file at the place of first digit place. 

        for(int i=0; i< numCounter.length; i++){
          System.out.println("The number "+(i+1)+" "+"occured "+numCounter[i]+" times" );
        }

        getFrequency(numCounter);
    }
                   
                 
