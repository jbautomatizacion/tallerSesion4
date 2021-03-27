package factoryDevices;

public class FactoryDevices {

    public static final String ANDROID = "android";
    public static final String IOS = "ios";
    public static final String WINDOWSPHONE = "windowsphone";
    public static final String CLOUD_DEVICE = "cloud";

    public static IDevice make(String type) {
        IDevice device;

        switch (type) {
            case ANDROID:
                device = new Android();
                break;
            case IOS:
                device = new IOS();
                break;
            case WINDOWSPHONE:
                device = new WindowsPhone();
                break;
            case CLOUD_DEVICE:
                device = new CloudDevice();
                break;
            default:
                device = new Android();
                break;
        }

        return device;
    }
}