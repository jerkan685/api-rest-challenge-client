/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.challenge.api.Client.interfaces.services;

import com.challenge.api.Client.entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jerka
 */
public interface ClientRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> getClients();
    
    @Query(value = "Select AVG(edad) as promedio from cliente", nativeQuery = true)
    Float getPromedy();

    @Query(value = "Select STDDEV(edad) as desvest from cliente", nativeQuery = true)
    Float getDesvest();
    
    

}
