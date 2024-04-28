package screens;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.util.Arrays;
import java.util.List;

import core.selenide.SkipElementWaiting;

public abstract class BaseScreen {
    public void waitForScreenElementsLoad() {
        getPrimaryElements().forEach(el ->
                el.shouldBe(visible)
                        .shouldBe(enabled));
    }

    public boolean isOpened() {
        waitForScreenElementsLoad();
        return getPrimaryElements().stream().allMatch(SelenideAppiumElement::isDisplayed);
    }

    private List<SelenideAppiumElement> getPrimaryElements() {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> {
                    field.setAccessible(true);
                    return SelenideAppiumElement.class.isAssignableFrom(field.getType()) && !field.isAnnotationPresent(SkipElementWaiting.class);
                })
                .map(field -> {
                    try {
                        return (SelenideAppiumElement) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new ClassCastException(String.format("Unable to cast field to the type SelenideAppiumElement\n%s", e));
                    }
                })
                .toList();
    }

}
