package com.devrim.stockManagement.product_service.service.impl;

import com.devrim.stockManagement.product_service.entities.Product;
import com.devrim.stockManagement.product_service.enums.Language;
import com.devrim.stockManagement.product_service.exception.ProductNotFoundException;
import com.devrim.stockManagement.product_service.exception.enums.FriendlyMessageCode;
import com.devrim.stockManagement.product_service.exception.handler.ProductNotCreatedException;
import com.devrim.stockManagement.product_service.repository.ProductRepository;
import com.devrim.stockManagement.product_service.request.ProductCreateRequest;
import com.devrim.stockManagement.product_service.request.ProductUpdatedRequest;
import com.devrim.stockManagement.product_service.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements IProductRepositoryService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {
       log.debug("[{}][Creating product]-> request : {}", this.getClass().getSimpleName(),productCreateRequest);
       try {
           Product product= Product.builder()
                   .productName(productCreateRequest.getProductName())
                   .quantity(productCreateRequest.getQuantity())
                   .price(productCreateRequest.getPrice())
                   .deleted(false)
                   .build();
           Product productResponse = productRepository.save(product);
           log.debug("[{}][createdProduct]-> response : {}", this.getClass().getSimpleName(), productResponse);
       return productResponse;
       }catch (Exception e){
           log.error(e.getMessage());
           throw new ProductNotCreatedException(language, FriendlyMessageCode.PRODUCT_NOT_CREATED_EXCEPTION, "Product Request"+ productCreateRequest.toString());
       }
    }

    @Override
    public Product getProduct(Language language, Long productId) {
        log.debug("[{}][getProduct]-> request productId: {}", this.getClass().getSimpleName(),productId);
       Product product =productRepository.getByIdAndDeletedFalse(productId);
       if (Objects.isNull(product)){
           throw new ProductNotFoundException(language, FriendlyMessageCode.PRODUCT_NOT_FOUND_EXCEPTION," Product not found for productId:"+ productId);
       }
       log.debug("[{}][getProduct]-> response : {}", this.getClass().getSimpleName(), product);
       return product;
    }

    @Override
    public List<Product> getProducts(Language language) {
        log.debug("[{}][getProducts]", this.getClass().getSimpleName());
        List<Product> products = productRepository.getAllByDeletedFalse();
        if(Objects.isNull(products)){
            throw new ProductNotFoundException(language,FriendlyMessageCode.PRODUCT_NOT_FOUND_EXCEPTION," No products found");
        }
        log.debug("[{}][getProducts]-> response : {}", this.getClass().getSimpleName(), products);

        return products;
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdatedRequest productUpdatedRequest) {
        log.debug("[{}][UpdateProduct] -> request : {}:", this.getClass().getSimpleName(), productUpdatedRequest);
        Product product = productRepository.getByIdAndDeletedFalse(productId);
        product.setProductName(productUpdatedRequest.getProductName());
        product.setQuantity(productUpdatedRequest.getQuantity());
        product.setPrice(productUpdatedRequest.getPrice());
        product.setProductCreatedDate(product.getProductCreatedDate());
        product.setProductUpdatedDate(LocalDateTime.now());
        Product productResponse = productRepository.save(product);
        log.debug("[{}][updatedProduct]-> response : {}", this.getClass().getSimpleName(), productResponse);
        return productResponse;
    }

    @Override
    public Product deleteProduct(Language language, Long id) {
        log.debug("[{}][deletedProduct]: {}",this.getClass().getSimpleName(),id);
        Product product;
        try {
            product = getProduct(language, id);
            product.setDeleted(true);
            product.setProductUpdatedDate(LocalDateTime.now());
            Product productResponse = productRepository.save(product);
            log.debug("[{}][deletedProduct]-> response : {}", this.getClass().getSimpleName(), productResponse);
            return productResponse;
        }
        catch (ProductNotFoundException e){
            throw new ProductNotFoundException(language,FriendlyMessageCode.PRODUCT_ALREADY_DELETED, "Product already deleted product id:"+id);
        }
    }
}
