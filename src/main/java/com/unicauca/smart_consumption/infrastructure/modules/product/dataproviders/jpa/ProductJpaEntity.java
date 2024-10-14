package com.unicauca.smart_consumption.infrastructure.modules.product.dataproviders.jpa;

import com.unicauca.smart_consumption.domain.product.ProductStatus;
import com.unicauca.smart_consumption.infrastructure.modules.store.dataproviders.jpa.StoreJPAEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductJpaEntity {
    @Id
    private String id;

    private String name;
    @Embedded
    private CategoryEmbeddable category;

    @Embedded
    private DetailEmbeddable detail;

    @Embedded
    private SustainabilityCriteriaEmbeddable sustainabilityCriteria;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private double price;

    @ManyToMany(mappedBy = "products")
    private List<StoreJPAEntity> stores;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.id)  || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
