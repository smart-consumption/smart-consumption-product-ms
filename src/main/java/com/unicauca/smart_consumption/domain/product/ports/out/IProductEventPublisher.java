package com.unicauca.smart_consumption.domain.product.ports.out;

import com.unicauca.smart_consumption.domain.product.Product;


/**
 * Interface that defines the behavior for publishing events related to products.
 * It is used to send notifications when products are created in the system.
 */
public interface IProductEventPublisher {

  /**
   * Publishes an event indicating that a new product has been created.
   *
   * @param product the product that has been created.
   * @throws IllegalArgumentException if the product is null.
   */
  void publishProductCreated(Product product);


  /**
   * Publishes an event indicating that a product has been updated.
   *
   * @param product the product that has been updated.
   * @throws IllegalArgumentException if the product is null.
   */
  void publishProductUpdated(Product product);

}
