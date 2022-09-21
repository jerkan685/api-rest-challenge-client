/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.api.Client.util;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jerka
 */
public class MethodShare {
    
    public static Date  dateDeathProbably(Date fecha, int promedio) {
     Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, promedio);
        return calendar.getTime();
    }
    
}
