/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author User-Pc
 */
public class LoginManager {
    public static boolean isValidLogin(String username,String password)throws FileNotFoundException{
        File f = new File("username.txt");
        Scanner sc = new Scanner(f);
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Scanner lineSc = new Scanner(line).useDelimiter("#");
            String currentUser = lineSc.next();
            String currentPassword = lineSc.next();
            
            if(username.equalsIgnoreCase(currentUser) && password.equals(currentPassword)){
                
                
                return true;
            }
        }
        return false;    
    }
}
    
        

