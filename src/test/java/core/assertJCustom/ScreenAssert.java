package core.assertJCustom;

import org.assertj.core.api.AbstractAssert;

import screens.BaseScreen;

public class ScreenAssert extends AbstractAssert<ScreenAssert, BaseScreen> {

    public ScreenAssert(BaseScreen actual) {
        super(actual, ScreenAssert.class);
    }

    public static ScreenAssert assertThat(BaseScreen actual) {
        return new ScreenAssert(actual);
    }

    public ScreenAssert isOpened() {
        isNotNull();
        if(!actual.isOpened()) {
            failWithMessage("Expected %s page to be opened", actual.getClass().getName());
        }

        return this;
    }
}
