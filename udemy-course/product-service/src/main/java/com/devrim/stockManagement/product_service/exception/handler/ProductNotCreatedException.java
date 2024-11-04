package com.devrim.stockManagement.product_service.exception.handler;

import com.devrim.stockManagement.product_service.enums.Language;
import com.devrim.stockManagement.product_service.exception.enums.IFriendlyMessageCode;
import com.devrim.stockManagement.product_service.exception.utils.FriendlyMessageUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ProductNotCreatedException extends RuntimeException{
private final Language language;
private final IFriendlyMessageCode friendlyMessageCode;
public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
    super(FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode));
    this.language=language;
    this.friendlyMessageCode=friendlyMessageCode;
    log.error("[ProductNotFoundException]->message: developer message: {}", FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode), message);
}


}
