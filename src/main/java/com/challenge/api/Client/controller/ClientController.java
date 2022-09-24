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
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
@Api(value = "Api challenge", description = "Manejo de datos clientes")
public class ClientController {
  @Autowired
  private ClientRepository methodDb;

  @PostMapping("/creacliente")
  @ApiOperation(value = "Crea un nuevo cliente", response = DataClientResponse.class)
  public ResponseEntity<String> saveClient(@RequestBody Cliente client) {
    String validate = MethodShare.validCliente(client);
    if (validate != null) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body("Error faltan datos de clientes para la creacion");
    }
    try {
      methodDb.save(client);
      return ResponseEntity.status(HttpStatus.CREATED).body("Cliente  " + client.getNombre() + " creado !!!!!!");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Fallo la creacion del cliente " + e);
    }
  }

  @GetMapping("/listClientes")
  @ApiOperation(value = "Obtiene informacion de los clientes y la fecha probable de su muerte", response = DataClientResponse.class)
  public List<DataClientResponse> getlistClient() throws JsonProcessingException, ParseException {
    List<Cliente> clientes = methodDb.getClients();
    List<DataClientResponse> response = new ArrayList<>();

    for (Cliente client : clientes) {
      response.add(DataClientResponse.builder().cliente(client)
          .fechaDeath(MethodShare.dateDeathProbably(client.getEdad())).build());
    }

    return response;
  }

  @GetMapping("/kpideclientes")
  @ApiOperation(value = "Obtenemos la desviacion estandar y el promedio de todas las edades de los clientes", response = KpideClienteResponse.class)
  public KpideClienteResponse getInfo() throws JsonProcessingException, ParseException {
    return KpideClienteResponse.builder().promedio(methodDb.getPromedy()).desvest(methodDb.getDesvest()).build();
  }

}
