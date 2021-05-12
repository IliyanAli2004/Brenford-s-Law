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
public class Main { // extends Application 

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
