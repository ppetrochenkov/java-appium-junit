package core.driver;

public final class DriverFactory {

    public static String getDeviceDriver(String deviceMode) {
        switch (deviceMode) {
            case "emulator" -> {
                return EmulatorDriver.class.getName();
            }
            case "device_farm" -> {
                return AwsDeviceFarmDriver.class.getName();
            }
            default -> throw new UnsupportedOperationException("Provided device type is not supported");
        }
    }
}
