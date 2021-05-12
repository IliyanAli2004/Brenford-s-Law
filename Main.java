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

public class Main extends Application {

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
    //Creating double fre for each number which will tell how often each number occured in the place of the first digit as a percentage
    static double fre1;
    static double fre2;
    static double fre3;
    static double fre4;
    static double fre5;
    static double fre6;
    static double fre7;
    static double fre8;
    static double fre9;

    /* Done By: Iliyan, Amy
     * Step 2: Get the frequency occurance of every first digit
     * @param arr[] = Type: Double[]. Has the values of all the counters which mean how often each number occured as the first digit
    */
    public static void getFrequency(int[] arr) {
        int total=0;
        //This for loop itterates and finds out the total lines by adding up all the occurances. I chose to do it this was to make code reusable and to minimize hard coding.
        for (int i=0; i<arr.length; i++){
          total+= arr[i];
        }

        double[] numFrequency= new double[arr.length];

        for(int i=0; i<arr.length; i++){
          numFrequency[i]= arr[i];
        }

        System.out.println("");//blank line

        DecimalFormat df = new DecimalFormat("##.#"); //This format will be used below for outputtuing this information to the terminal

        for(int i=0; i<numFrequency.length; i++){
          System.out.println("The frequency of "+(i+1)+" is "+df.format((numFrequency[i] * 100)/total) + "%.");
        }
        
        fre1 = numFrequency[0]*1.0/total;
        fre2 = numFrequency[1]*1.0/total; 
        fre3 = numFrequency[2]*1.0/total; 
        fre4 = numFrequency[3]*1.0/total; 
        fre5 = numFrequency[4]*1.0/total; 
        fre6 = numFrequency[5]*1.0/total; 
        fre7 = numFrequency[6]*1.0/total; 
        fre8 = numFrequency[7]*1.0/total; 
        fre9 = numFrequency[8]*1.0/total; 

        //Creating another array which has all the frequencies to pass onto other methods.
        double[] exportNumFre={fre1, fre2, fre3, fre4, fre5, fre6, fre7, fre8, fre9};

        fraudCheck(fre1); //Sending first digit frequency to fraud method

        System.out.println("\nExport the data file");
        exportFile(exportNumFre); //Sending all frequencies in an array to export File method.
    }
                   
    /*
     * Amy, Iliyan 
     * Step 3: Graphing based on the frequencies
     */

    public void start(Stage primaryStage) throws Exception {
        // Defining string to label XAxis
        String x1 = "1";
        String x2 = "2";
        String x3 = "3";
        String x4 = "4";
        String x5 = "5";
        String x6 = "6";
        String x7 = "7";
        String x8 = "8";
        String x9 = "9";

        // Configuring category and NumberAxis
        CategoryAxis xaxis = new CategoryAxis();
        // Set the range of y-axis, min value, max value, increment
        NumberAxis yaxis = new NumberAxis(0, 36, 4);
        // Labels for two axis
        xaxis.setLabel("First Digit");
        yaxis.setLabel("Percentage of Occurence");

        // Configuring BarChart
        BarChart<String, Float> bar = new BarChart(xaxis, yaxis);
        bar.setTitle("Benford's Law Distribution Leading Digit");

        // Configuring Series for XY chart
        XYChart.Series<String, Float> series = new XYChart.Series<>();
        series.setName("Percentage of Occurence");
        series.getData().add(new XYChart.Data(x1, (fre1 * 100)));
        series.getData().add(new XYChart.Data(x2, (fre2 * 100)));
        series.getData().add(new XYChart.Data(x3, (fre3 * 100)));
        series.getData().add(new XYChart.Data(x4, (fre4 * 100)));
        series.getData().add(new XYChart.Data(x5, (fre5 * 100)));
        series.getData().add(new XYChart.Data(x6, (fre6 * 100)));
        series.getData().add(new XYChart.Data(x7, (fre7 * 100)));
        series.getData().add(new XYChart.Data(x8, (fre8 * 100)));
        series.getData().add(new XYChart.Data(x9, (fre9 * 100)));

        // Adding series to the barchart
        bar.getData().add(series);

        // configuring group and scene
        Group root = new Group();
        root.getChildren().add(bar);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BarChart");
        primaryStage.show();
    }

    /*
     * Amy, Iliyan 
     * Step 4: Export the frequency to the file
     * 
     * @param arr: the array of all frequencies of each number
     */

    public static void exportFile(double[] arr) {
        try {
            // create a file
            File file = new File("results.txt");
            // get the path of the file
            String path = file.getAbsolutePath();
            // for appending on the file instaed of overwriting
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Formatting (rounding) the digits
            DecimalFormat df = new DecimalFormat("##.#");

            // the content will be written in the txt file
            for (int i = 0; i < arr.length; i++) {
                bw.write("\nThe frequency of " + (i + 1) + " is " + df.format(arr[i] * 100) + "%");
            }

            bw.newLine();
            bw.close();
            // print the status and the path of the file
            System.out.println("Done. The file '" + file + "' is in " + path);
        } catch (java.io.IOException e) {
            System.out.println("COULD NOT APPEND. Please check.");
        }
    }

}  

                   
                 
