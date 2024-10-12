package com.unicauca.smart_consumption.infrastructure.modules.store.dataproviders.jpa;

import com.unicauca.smart_consumption.infrastructure.modules.city.dataproviders.jpa.CityJPAEntity;
import com.unicauca.smart_consumption.infrastructure.modules.product.dataproviders.jpa.ProductJpaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StoreJPAEntity {
  @Id
  private String id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "store_product",
      joinColumns = @JoinColumn(name = "store_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  @ToString.Exclude
  private List<ProductJpaEntity> products;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "city_id")
  private CityJPAEntity city;

  @PrePersist
  public void prePersist() {
    if (Objects.isNull(this.id)  || this.id.isEmpty()) {
      this.id = UUID.randomUUID().toString();
    }
  }
}
