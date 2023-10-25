/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.awt.Component;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User-Pc
 */
public class SalesHistoryManager {
    private static final String fileName = "sale_history.txt";
    
     
   public static void addItemToSalesHistory(double itemTotal, String itemName, String customerName, Date salesDate, boolean isCollected) {
    FileWriter fw = null;
    try {
        // Opens the FileWriter in append mode
        fw = new FileWriter(fileName, true);
        PrintWriter pw = new PrintWriter(fw);

        // Formatting the salesDate
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(salesDate);

        // Writes the item data in the format "itemTotal#itemName#customerName#salesDate#isCollected"
        pw.println(itemTotal + "#" + itemName + "#" + customerName + "#" + formattedDate + "#" + isCollected);
    } catch (IOException ex) {
        ex.printStackTrace();
        System.err.println("Error writing to file: " + ex.getMessage());
    } finally {
        if (fw != null) {
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error closing the file: " + ex.getMessage());
            }
        }
    }
}
   //counts the amount of items in the txt file to know how big the array is
   private static int countItems() {
    int count = 0;
    try {
        File file = new File(fileName);
        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                count++;
            }
            fileScanner.close();
        } else {
            System.err.println("File does not exist.");
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
        System.err.println("Error reading from file: " + ex.getMessage());
    }
    return count;
}
   //inserts the data from the txt file into the Jtable
    public static String[][] getSalesHistoryDataAsTable() {
    String[][] salesHistoryItems = new String[countItems()][5];
    int currentRow = 0;
    try {
        File file = new File(fileName);
        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("#");

                if (data.length == 5) {
                    try {
                        double total = Double.parseDouble(data[0]);
                        String name = data[1];
                        String customer = data[2];
                        String date = data[3].trim(); // Removes any leading or trailing whitespaces
                        boolean isCollected = Boolean.parseBoolean(data[4]);

                        salesHistoryItems[currentRow][0] = String.valueOf(total);
                        salesHistoryItems[currentRow][1] = name;
                        salesHistoryItems[currentRow][2] = customer;
                        salesHistoryItems[currentRow][3] = date;
                        salesHistoryItems[currentRow][4] = String.valueOf(isCollected);

                        currentRow++;
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Error parsing data from line: " + line + "\nException: " + e.getMessage());
                        }
                      } else {
                        System.err.println("Invalid data format in line: " + line);
                    }
                }
                fileScanner.close();
            } else {
                System.err.println("File does not exist.");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return salesHistoryItems;
    }



}







 


 

        


