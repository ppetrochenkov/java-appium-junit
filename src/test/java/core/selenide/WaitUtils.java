package core.selenide;

import com.codeborne.selenide.Selenide;

import org.openqa.selenium.TimeoutException;
import java.util.function.Supplier;

import config.ConfigReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitUtils {

    private final static long WAIT_TIMEOUT = ConfigReader.appConfig.waitTimeout();

    public static void waitUntil(Supplier<Boolean> condition) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + WAIT_TIMEOUT;

        while (System.currentTimeMillis() < endTime) {
            if(condition.get()) {
                return;
            }

            Selenide.sleep(500);
        }

        throw new TimeoutException(String.format("Condition failed after %s ms", WAIT_TIMEOUT));
    }
}
