/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author User-Pc
 */
public class StockManager {
    
    private static String fileName = "stock.txt";
    
    public static String getItems() {
		try {
			
			File f = new File(fileName);
			Scanner sc = new Scanner(f);

			
			String output = "";

		
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				output += linesc.next() + "\n";
				linesc.close();
			}
			
			sc.close();
			return output;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}

	
	public static String[] getItemsAsArray() {
		try {
			Scanner sc = new Scanner(new File(fileName));

			
			int numItems = getStockFile();
			String[] outputArr = new String[numItems];
                        
			int currentIndex = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				outputArr[currentIndex] = linesc.next();
				
				currentIndex++;
				linesc.close();
			}
			sc.close();
			return outputArr;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}
        
           public static String getType() {
		try {
			
			File f = new File(fileName);
			Scanner sc = new Scanner(f);

			
			String output = "";

		
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				output += linesc.next() + "\n";
				linesc.close();
			}
			
			sc.close();
			return output;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}

	
	public static String[] getTypesAsArray() {
		try {
			Scanner sc = new Scanner(new File(fileName));

			
			int numTypes = getStockFile();
			String[] outputArr = new String[numTypes];
                        
			int currentIndex = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				outputArr[currentIndex] = linesc.next();
				
				currentIndex++;
				linesc.close();
			}
			sc.close();
			return outputArr;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}
        
         public static int getPrice(int itemNumber) {
			
		try {
			File f = new File(fileName);
			Scanner sc = new Scanner(f);

			
			int output = 0;

		
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				output += linesc.next() + "\n";
				linesc.close();
			}
			
			sc.close();
			return output;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}

	public static int[] gePriceAsArray() {
	
		try {
			Scanner sc = new Scanner(new File(fileName));

			
			int numTypes = getStockFile();
			var outputArr = new int[numTypes];
                        
			int currentIndex = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				Scanner linesc = new Scanner(line).useDelimiter("#");

				
				outputArr[currentIndex] = linesc.next();
				
				currentIndex++;
				linesc.close();
			}
			sc.close();
			return outputArr;
		} catch (FileNotFoundException ex) {
			System.out.println("Stock file not found");
			return null;
		}
	}
        
        	public static void addItem(String itemName, String itemType,int itemPrice) {
		try {
			
			FileWriter fw = new FileWriter(fileName, true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(itemName + "#" + itemType + "#" + itemPrice);
		
			pw.close();
		} catch (IOException ex) {
			System.out.println("Could not write to file");
		}
	}
        
        
                public static void deleteItem(String item) {
		try {
			Scanner sc = new Scanner(new File(fileName));
			String output = "";

			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				Scanner linesc = new Scanner(line).useDelimiter("#");
				String currentitemName = linesc.next();
				linesc.close();
                            String itemName = null;

				if (!currentitemName.equalsIgnoreCase(itemName)) {
					
					output += line + "\n";
				}
			}
			sc.close();

			
			PrintWriter pw = new PrintWriter(new FileWriter(fileName, false));
			pw.print(output);
			pw.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Items file not found");
		} catch (IOException ex) {
			System.out.println("Could not delete item");
		}
	}
        
        
        
    private static int getStockFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void addItem(String itemName, String itemType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String getaddItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
