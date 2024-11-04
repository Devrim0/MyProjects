package com.devrim.stockManagement.product_service.controller.impl;

import com.devrim.stockManagement.product_service.controller.ProductController;
import com.devrim.stockManagement.product_service.entities.Product;
import com.devrim.stockManagement.product_service.enums.Language;
import com.devrim.stockManagement.product_service.exception.enums.FriendlyMessageCode;
import com.devrim.stockManagement.product_service.exception.utils.FriendlyMessageUtils;
import com.devrim.stockManagement.product_service.request.ProductCreateRequest;
import com.devrim.stockManagement.product_service.request.ProductUpdatedRequest;
import com.devrim.stockManagement.product_service.response.FriendlyMessage;
import com.devrim.stockManagement.product_service.response.InternalApiResponse;
import com.devrim.stockManagement.product_service.response.ProductResponse;
import com.devrim.stockManagement.product_service.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(value = "/api/1.0/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final IProductRepositoryService productRepositoryService;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(Language language, ProductCreateRequest productCreateRequest) {
        log.debug("[{}][Creating product] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        Product product=productRepositoryService.createProduct(language, productCreateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][Product created] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCode.PRODUCT_SUCCESSFULLY_CREATED))
                .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{language}/get/{id}")
    public InternalApiResponse<ProductResponse> getProduct(@PathVariable("language") Language language, @PathVariable("id") Long productId) {
        log.debug("[{}][Get product] -> request: {}", this.getClass().getSimpleName(), productId);
        Product product = productRepositoryService.getProduct(language, productId);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][Product get] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/{language}/update/{id}")
    public InternalApiResponse<ProductResponse> updateProduct(@PathVariable Language language, @PathVariable("id") Long productId, @RequestBody ProductUpdatedRequest productUpdatedRequest) {
        log.debug("[{}][Update product] -> request: {} {}", this.getClass().getSimpleName() ,productId, productUpdatedRequest);
       Product product = productRepositoryService.updateProduct(language, productId, productUpdatedRequest);
       ProductResponse productResponse = convertProductResponse(product);
       log.debug("[{}][Product updated] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.PRODUCT_SUCCESSFULLY_UPDATED))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{language}/products")
    public InternalApiResponse<List<ProductResponse>> getProducts(@PathVariable Language language) {
        log.debug("[{}][Product gets]", this.getClass().getSimpleName());
        List<Product> products = productRepositoryService.getProducts(language);
        List<ProductResponse> productResponses = convertProductResponseList(products);
        log.debug("[{}][Product gets] -> response: {}", this.getClass().getSimpleName(), productResponses);
        return InternalApiResponse.<List<ProductResponse>>builder()
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponses)
                .build();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{language}/delete/{id}")
    public InternalApiResponse<ProductResponse> deleteProduct(@PathVariable("language") Language language, @PathVariable("id") Long productId) {
        log.debug("[{}][Delete product] -> request: {}", this.getClass().getSimpleName(), productId);
        Product product = productRepositoryService.deleteProduct(language, productId);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][Product deleted] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCode.PRODUCT_SUCCESSFULLY_DELETED))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    private List<ProductResponse> convertProductResponseList(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();

        return productResponses.stream()
                .map(argument -> ProductResponse.builder()
                        .productId(argument.getProductId())
                        .productName(argument.getProductName())
                        .quantity(argument.getQuantity())
                        .price(argument.getPrice())
                        .productCreatedDate(argument.getProductCreatedDate())
                        .productUpdatedDate(argument.getProductUpdatedDate())
                        .build())
                .collect(Collectors.toList());
    }

    private static ProductResponse convertProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .productCreatedDate(product.getProductCreatedDate())
                .productUpdatedDate(product.getProductUpdatedDate())
                .build();
    }
}
