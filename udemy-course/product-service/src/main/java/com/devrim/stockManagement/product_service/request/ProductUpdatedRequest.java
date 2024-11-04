package com.devrim.stockManagement.product_service.request;

import lombok.Data;

@Data
public class ProductUpdatedRequest {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
}
