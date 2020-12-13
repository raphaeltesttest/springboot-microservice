package com.br.myfood.pedido.message;

import com.br.myfood.pedido.dto.ClientOrderDto;
import com.br.myfood.pedido.entity.ClientOrder;
import com.br.myfood.pedido.repository.ClientOrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public ClientReceiveMessage(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @RabbitListener(queues = {"${cadastro.client.rabbitmq.queue}"})
    public void receiveMessage(@Payload ClientOrderDto clientOrderDto) {
        System.out.println(clientOrderDto);
        clientOrderRepository.save(new ClientOrder(null, clientOrderDto.getIdClient()));
    }
}
