package com.unicauca.smart_consumption.infrastructure.modules.product.publisher;

import static com.unicauca.smart_consumption.infrastructure.config.RabbitConfig.ROUTING_KEY_PRODUCT_CREATED;
import static com.unicauca.smart_consumption.infrastructure.config.RabbitConfig.ROUTING_KEY_PRODUCT_UPDATED;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductEventPublisher;
import com.unicauca.smart_consumption.infrastructure.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPublisher implements IProductEventPublisher {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public ProductPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void publishProductCreated(Product product) {
    System.out.println("Send message queue: " + product);
    rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_EXCHANGE, ROUTING_KEY_PRODUCT_CREATED , product);
  }

  @Override
  public void publishProductUpdated(Product product) {
    rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_EXCHANGE, ROUTING_KEY_PRODUCT_UPDATED, product);
  }
}
