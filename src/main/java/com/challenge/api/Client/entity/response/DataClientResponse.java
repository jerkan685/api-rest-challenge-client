/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.api.Client.entity.response;

import com.challenge.api.Client.entity.Cliente;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jerka
 */
@Data
@Getter
@Setter
@Builder
public class DataClientResponse {
    
   private Cliente cliente;
   private Date fechaDeath;
    
}
