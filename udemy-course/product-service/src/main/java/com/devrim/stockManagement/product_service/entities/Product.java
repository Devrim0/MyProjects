package com.devrim.stockManagement.product_service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product", schema = "stock_management")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "updated_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productUpdatedDate;
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productCreatedDate;
    @Column(name = "is_deleted")
    private Boolean deleted;

    @PrePersist
    protected void onCreate() {
        System.out.println("Setting created and updated dates");
        productCreatedDate = LocalDateTime.now();
        productUpdatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        System.out.println("Updating updated date");
        productUpdatedDate = LocalDateTime.now();
    }


}
