package services;

import enums.AppSection;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import screens.MenuBar;

@Slf4j
public class NavigationService {

    private MenuBar menuBar = new MenuBar();

    @Step("Navigating to main menu app section")
    public void toAppSection(AppSection section) {
        log.info(String.format("Navigating to main menu section %s", section.name()));
        menuBar.getExpandMenuButton().tap();
        switch (section) {
            case CATALOG -> menuBar.getCatalogSection().tap();
            case LOGIN -> menuBar.getLoginSection().tap();
            case LOGOUT -> menuBar.getLogoutSection().tap();
            case GEO_LOCATION -> menuBar.getGeoLocationSection().tap();
            case API_CALLS -> menuBar.getApiCallsSection().tap();
        }
    }

    @Step("Navigation to cart")
    public void toCart() {
        log.info("Navigating to Cart");
        menuBar.getCartButton().tap();
    }
}
