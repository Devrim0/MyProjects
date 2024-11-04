package com.devrim.stockManagement.product_service.controller;

import com.devrim.stockManagement.product_service.enums.Language;
import com.devrim.stockManagement.product_service.request.ProductCreateRequest;
import com.devrim.stockManagement.product_service.request.ProductUpdatedRequest;
import com.devrim.stockManagement.product_service.response.InternalApiResponse;
import com.devrim.stockManagement.product_service.response.ProductResponse;

import java.util.List;

public interface ProductController {
    InternalApiResponse<ProductResponse> createProduct(Language language, ProductCreateRequest productCreateRequest);
    InternalApiResponse<ProductResponse> getProduct(Language language, Long productId);
    InternalApiResponse<ProductResponse> updateProduct(Language language, Long productId, ProductUpdatedRequest productUpdatedRequest);
    InternalApiResponse<List<ProductResponse>> getProducts(Language language);
    InternalApiResponse<ProductResponse> deleteProduct(Language language, Long productId);
}
