package com.atividade.codinglab.atividadeSpringBoot.controller;

import com.atividade.codinglab.atividadeSpringBoot.dto.DTOOrder;
import com.atividade.codinglab.atividadeSpringBoot.exception.EntityNotFoundException;
import com.atividade.codinglab.atividadeSpringBoot.exception.InvalidRegistryException;
import com.atividade.codinglab.atividadeSpringBoot.services.OrderServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

    @Autowired
    private OrderServiceService service;

    //Exercicio Primeiras APIs - 1
    @GetMapping("/findById/{idPedido}")
    public ResponseEntity findById(@PathVariable("idPedido") int idOrder) throws EntityNotFoundException {
        DTOOrder order = service.findById(idOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    //Exercicio Primeiras APIs - 3
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody DTOOrder order) {
        service.save(order);
        //Exercicio Primeiras APIs - 4
        return new ResponseEntity<>("http://localhost:8080/findById/" + (service.getCurrentId() - 1),
                HttpStatus.ACCEPTED);
    }

    //Exercicio Primeiras APIs - 5
    @PostMapping("/update/{idPedido}")
    public ResponseEntity<DTOOrder> update(@PathVariable("idPedido") int idPedido, @RequestBody DTOOrder order)
            throws EntityNotFoundException, InvalidRegistryException {
        service.update(idPedido, order);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

    //Exercicio Primeiras APIs - 6
    @GetMapping("/delete/{idOrder}")
    public ResponseEntity delete(@PathVariable("idOrder") int idOrder) {
        DTOOrder order = service.delete(idOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
