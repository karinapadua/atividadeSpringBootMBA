package com.atividade.codinglab.atividadeSpringBoot.services;

import com.atividade.codinglab.atividadeSpringBoot.dto.DTOOrder;
import com.atividade.codinglab.atividadeSpringBoot.entity.Order;
import com.atividade.codinglab.atividadeSpringBoot.exception.EntityNotFoundException;
import com.atividade.codinglab.atividadeSpringBoot.exception.InvalidRegistryException;
import com.atividade.codinglab.atividadeSpringBoot.repository.OrderServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceService {

    private OrderServiceRepository repository;
    private int idAtual;

    @Autowired
    public OrderServiceService(OrderServiceRepository repository) {
        this.repository = repository;
        this.idAtual = 0;
    }

    public DTOOrder findById(int id) throws EntityNotFoundException {
        Order order = repository.findById(id);

        if (order == null)
            throw new EntityNotFoundException("Pedido com ID " + id + " não encontrado.");

        DTOOrder DTOOrder = new DTOOrder(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        return DTOOrder;
    }

    public void save(DTOOrder order) {
        Order ord = new Order(idAtual, order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        this.repository.save(ord);
        idAtual++;
    }

    public void update(int idOrder, DTOOrder order) throws EntityNotFoundException, InvalidRegistryException {
        if (repository.findById(idOrder) == null)
            throw new EntityNotFoundException("Pedido com ID " + idOrder + " não encontrado.");
        repository.update(idOrder, order);
    }

    public DTOOrder delete(int idOrder) {
        Order order = repository.delete(idOrder);
        DTOOrder DTOOrder = new DTOOrder(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        return DTOOrder;
    }

    public int getCurrentId() {
        return this.idAtual;
    }

}
