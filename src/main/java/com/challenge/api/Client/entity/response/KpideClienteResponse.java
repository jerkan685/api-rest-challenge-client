/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.api.Client.entity.response;
import java.io.Serializable;
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
public class KpideClienteResponse implements Serializable {
    
    private Integer promedio;
    private Integer desvest;

    /**
     * @return the promedio
     */
    public int getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    /**
     * @return the desvest
     */
    public int getDesvest() {
        return desvest;
    }

    /**
     * @param desvest the desvest to set
     */
    public void setDesvest(int desvest) {
        this.desvest = desvest;
    }
    
    
    
}
