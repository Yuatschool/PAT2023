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
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User-Pc
 */
public class CurrentOrderManager {
    
    
    private static final String[][] currentOrder = new String[1000][6];
    private static int itemCount = 0;
    
    //adds the item to the txt file
    public static void addItemToCurrentOrder(String itemName, String itemType, double itemPrice, int itemQuantity, String customerName, boolean isCollected) {
        currentOrder[itemCount][0] = itemName;
        currentOrder[itemCount][1] = itemType;
        currentOrder[itemCount][2] = String.valueOf(itemPrice);
        currentOrder[itemCount][3] = String.valueOf(itemQuantity);
        currentOrder[itemCount][4] = customerName;
        currentOrder[itemCount][5] = String.valueOf(isCollected);
        itemCount++;
    }

    //deletes the item from the txt file
    public static void deleteItem(String itemName, String itemType, double itemPrice, int itemQuantity, String customerName, boolean isCollected) {
        for (int i = 0; i < itemCount; i++) {
            if (currentOrder[i][0].equalsIgnoreCase(itemName) && currentOrder[i][1].equalsIgnoreCase(itemType)
                    && Double.parseDouble(currentOrder[i][2]) == itemPrice && Integer.parseInt(currentOrder[i][3]) == itemQuantity
                    && currentOrder[i][4].equalsIgnoreCase(customerName) && Boolean.parseBoolean(currentOrder[i][5]) == isCollected) {
                for (int j = i; j < itemCount - 1; j++) {
                    for (int k = 0; k < 6; k++) {
                        currentOrder[j][k] = currentOrder[j + 1][k];
                    }
                }
                itemCount--;
                break;
            }
        }
    }
    
    // Gets the stock data as a two-dimensional array for use with a JTable
    public static String[][] getCurrentOrderDataAsTable() {
        String[][] currentOrderItems = new String[itemCount][6];
        for (int i = 0; i < itemCount; i++) {
            for (int j = 0; j < 6; j++) {
                currentOrderItems[i][j] = currentOrder[i][j];
            }
        }
        return currentOrderItems;
    }
}

