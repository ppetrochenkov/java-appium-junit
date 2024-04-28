package tests;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;

import static core.assertJCustom.AppiumElementAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.assertJCustom.ScreenAssert;
import screens.CartScreen;
import screens.CatalogScreen;
import screens.LoginScreen;
import services.CartService;
import services.ProductService;

public class CartTest extends BaseTest {

    private CartService cartService;
    private String productName;

    @BeforeEach
    @DisplayName("Adding item to the cart")
    public void addCartItem() {
        productName = "Sauce Labs Fleece Jacket";
        ProductService productService = new ProductService();
        productService
                .selectProduct(productName)
                .addToCart();
        navigationService.toCart();
        cartService = new CartService();
    }

    @Test
    @DisplayName("Validate add / remove cart operations")
    public void testAddRemoveCartItem() {
        CartScreen cartScreen = new CartScreen();

        cartScreen.getImage().shouldBe(visible);
        assertThat(cartScreen.getName()).hasText(productName);
        cartScreen.getPrice().shouldHave(matchText(priceFormat));
        cartScreen.getColor().shouldBe(visible);
        cartScreen.getProductCounter().shouldBe(visible);
        cartScreen.getRemoveItemButton().shouldBe(visible);
        cartScreen.getProceedToCheckoutButton().shouldBe(visible);

        cartService.removeItem();

        cartScreen.getNoItemsLabel().shouldBe(visible);

        cartService.goShopping();
        CatalogScreen catalogScreen = new CatalogScreen();

        ScreenAssert.assertThat(catalogScreen).isOpened();
    }

    @Test
    @DisplayName("Validate order checkout operation")
    public void testCheckoutOrder() {
        cartService.proceedToCheckout();
        LoginScreen loginScreen = new LoginScreen();

        ScreenAssert.assertThat(loginScreen).isOpened();
    }
}
