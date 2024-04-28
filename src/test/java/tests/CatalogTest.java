package tests;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;

import static core.assertJCustom.AppiumElementAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import screens.CatalogScreen;
import screens.ProductViewScreen;
import services.ProductService;

public class CatalogTest extends BaseTest {

    @Test
    @DisplayName("Validate UI representation of catalog items")
    public void testCatalogItemsAttributes() {
        CatalogScreen catalogScreen = new CatalogScreen();

        catalogScreen.getProducts().forEach(product -> {
            product.getImage().shouldBe(visible);
            assertThat(product.getName()).hasNotEmptyText();
            product.getPrice().shouldHave(matchText(priceFormat));
        });
    }

    @Test
    @DisplayName("Validate UI representation of product view")
    public void testSelectedProductAttributes() {
        String testProduct = "Sauce Labs Fleece Jacket";

        ProductService productService = new ProductService();
        productService.selectProduct(testProduct);

        ProductViewScreen productViewScreen = new ProductViewScreen();

        assertThat(productViewScreen.getName()).hasText(testProduct);
        productViewScreen.getImage().shouldBe(visible);
        productViewScreen.getPrice().shouldHave(matchText(priceFormat));
        productViewScreen.getAvailableColors().shouldBe(visible);
        productViewScreen.getProductCounter().shouldBe(visible);
        productViewScreen.getAddToCartButton().shouldBe(visible);
    }
}
