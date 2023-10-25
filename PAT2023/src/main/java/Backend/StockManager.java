/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User-Pc
 */
public class StockManager {

    // Defines a constant file name for the stock data
    private static final String fileName = "stock.txt";

// Adds an item to the stock file
    public static void addItem(String itemName, String itemType, double itemPrice) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            // Write the item data in the format "itemName#itemType#itemPrice" to the file
            pw.print("\n" + itemName + "#" + itemType + "#" + itemPrice);
        } catch (IOException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //counts the amount of items in the txt file to know how big the array is
    private static int countStockItems() {
        int count = 0;
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                count++;

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;

    }
    
    // Gets the stock data as a two-dimensional array for use with a JTable
public static String[][] getStockDataAsTable() {
    String[][] stockItems = new String[countStockItems()][3];
    int currentRow = 0;
    try {
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            try {
                Scanner lineSc = new Scanner(line).useDelimiter("#").useLocale(Locale.UK);

                if (lineSc.hasNext()) {
                    String name = lineSc.next();
                    if (lineSc.hasNext()) {
                        String type = lineSc.next();
                        if (lineSc.hasNextDouble()) {
                            double price = lineSc.nextDouble();

                            stockItems[currentRow][0] = name;
                            stockItems[currentRow][1] = type;
                            stockItems[currentRow][2] = String.valueOf(price);

                            currentRow++;
                        } else {
                            // Handle the absence of the double value appropriately
                            System.err.println("NoSuchElementException: Missing price value in the input data.");
                        }
                    } else {
                        // Handle the absence of the type value appropriately
                        System.err.println("NoSuchElementException: Missing type value in the input data.");
                    }
                } else {
                    // Handle the absence of the name value appropriately
                    System.err.println("NoSuchElementException: Missing name value in the input data.");
                }
            } catch (NoSuchElementException e) {
                // Handle the NoSuchElementException appropriately
                System.err.println("NoSuchElementException: Missing element in the input data.");
                // You might want to log the exception or take other appropriate actions
            }
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
    }

    return stockItems;
}

   //it deletes the item from a txt file and the table
    
    public static void deleteItem(String itemName, String itemType, double itemPrice) {
        String output = "";
        try {
            File inputFile = new File(fileName);
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineSc = new Scanner(line).useDelimiter("#").useLocale(Locale.UK);
                String name = lineSc.next();
                String type = lineSc.next();
                double price = lineSc.nextDouble();
                if (!(name.equalsIgnoreCase(itemName) && type.equalsIgnoreCase(itemType) && price == itemPrice)) {
                    output += line + "\n";
                }
                lineSc.close();
            }
            fileScanner.close();

            PrintWriter pw = new PrintWriter(new FileWriter(fileName, false));
            pw.print(output);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Stock file not found");
        } catch (IOException ex) {
            System.out.println("Could not delete stock");
        }
}
}


