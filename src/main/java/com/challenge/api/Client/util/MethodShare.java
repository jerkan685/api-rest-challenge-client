/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.api.Client.util;
import com.challenge.api.Client.entity.Cliente;
import java.util.Calendar;
import java.util.Date;
import static java.util.Objects.isNull;

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
    
    public static String validCliente(Cliente client) {
        if (isNull(client) ||
                isNull(client.getNombre()) ||
                isNull(client.getApellido()) ||
                isNull(client.getEdad()) ||
                isNull(client.getFechaNacimiento())) {
           return "datos del cliente incompletos";
        }
        return null;
    }
    
}
