/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Vinicius
 */
public class DateFormatterFactory {
    public static DateFormat dateFormatddMMyyy() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public static DateFormat dateFormatyyyyMMdd() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

   
}