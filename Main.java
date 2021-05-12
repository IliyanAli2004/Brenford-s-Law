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
