package com.devrim.stockManagement.product_service.service;

import com.devrim.stockManagement.product_service.entities.Product;
import com.devrim.stockManagement.product_service.enums.Language;
import com.devrim.stockManagement.product_service.request.ProductCreateRequest;
import com.devrim.stockManagement.product_service.request.ProductUpdatedRequest;

import java.util.List;

public interface IProductRepositoryService {
    Product createProduct(Language language, ProductCreateRequest productCreateRequest);
    Product getProduct(Language language, Long id);
    List<Product> getProducts(Language language);
    Product updateProduct(Language language, Long id, ProductUpdatedRequest
                          productUpdatedRequest);
    Product deleteProduct(Language language, Long id);
}
