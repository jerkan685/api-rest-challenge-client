/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.api.Client.controller;

import com.challenge.api.Client.entity.Cliente;
import com.challenge.api.Client.entity.response.DataClientResponse;
import com.challenge.api.Client.entity.response.KpideClienteResponse;
import com.challenge.api.Client.interfaces.services.ClientRepository;
import com.challenge.api.Client.util.MethodShare;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jerkan
 */
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class ClientController {
    @Autowired
    private ClientRepository methodDb;
    
    @PostMapping("/creacliente")
    public Cliente saveClient(@RequestBody Cliente client) {
     return methodDb.save(client);
    }
    
    @GetMapping("/listClientes")
    public List<DataClientResponse> getHello() {
        List<Cliente> clientes = methodDb.getClients();
        List<DataClientResponse> response = new ArrayList<>();
        
        for(Cliente client : clientes ) {
          response.add(DataClientResponse.builder().cliente(client).
                  fechaDeath(MethodShare.dateDeathProbably(client.getFechaNacimiento(), methodDb.getPromedy())).build());
        }
        
        return response;
    }
    
    @GetMapping("/kpideclientes")
    public KpideClienteResponse getInfo() {
      return KpideClienteResponse.builder().promedio(methodDb.getPromedy()).desvest(methodDb.getDesvest()).build();
    }
    
}


