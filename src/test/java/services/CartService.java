package services;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import screens.CartScreen;

@Slf4j
public class CartService {

    private CartScreen cartScreen = new CartScreen();

    @Step("Removing cart item")
    public void removeItem() {
        log.info("Removing selected item from the cart");
        cartScreen.getRemoveItemButton().tap();
    }

    @Step("Proceeding to checkout")
    public void proceedToCheckout() {
        log.info("Proceeding to checkout");
        cartScreen.getProceedToCheckoutButton().tap();
    }

    @Step("Continue shopping")
    public void goShopping() {
        cartScreen.getGoShoppingButton().tap();
    }

}
