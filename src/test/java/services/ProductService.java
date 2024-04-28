package services;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import screens.CatalogScreen;
import screens.ProductViewScreen;

@Slf4j
public class ProductService {

    @Step("Opening product view")
    public ProductService selectProduct(String name) {
        log.info(String.format("Opening product details view for %s", name));
        CatalogScreen catalogScreen = new CatalogScreen();
        catalogScreen.getProduct(name).open();
        return this;
    }

    @Step("Adding product to the cart")
    public void addToCart() {
        log.info("Adding selected product to the cart");
        ProductViewScreen productViewScreen = new ProductViewScreen();
        productViewScreen.getAddToCartButton().tap();
    }
}
