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

    private Float promedio;
    private Float desvest;

    /**
     * @return the promedio
     */
    public Float getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    /**
     * @return the desvest
     */
    public Float getDesvest() {
        return desvest;
    }

    /**
     * @param desvest the desvest to set
     */
    public void setDesvest(Float desvest) {
        this.desvest = desvest;
    }

}
