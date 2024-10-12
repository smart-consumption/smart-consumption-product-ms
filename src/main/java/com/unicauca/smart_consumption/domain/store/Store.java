package com.unicauca.smart_consumption.domain.store;

import com.unicauca.smart_consumption.domain.city.City;
import com.unicauca.smart_consumption.domain.product.Product;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Store {
    private String id;
    private String name;
    private List<Product> products;
    private City city;

    public void updateStore(String name, City city) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        if (city != null) {
            this.city = city;
        }
    }
    public void addProducts(List<Product> products) {
        if (Objects.nonNull(products)) {
           products.forEach(product -> this.products.add(product));
        }
    }

}
