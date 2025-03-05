package climatecontrolsystem;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import temperaturesensor.TemperatureService;
import humiditysensor.HumidityService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        ClimateControlSystem climateControl = new ClimateControlSystem();
        registration = context.registerService(ClimateControlService.class.getName(), climateControl, null);

        ServiceReference<?> tempRef = context.getServiceReference(TemperatureService.class.getName());
        ServiceReference<?> humidityRef = context.getServiceReference(HumidityService.class.getName());

        if (tempRef != null && humidityRef != null) {
            TemperatureService tempService = (TemperatureService) context.getService(tempRef);
            HumidityService humidityService = (HumidityService) context.getService(humidityRef);
            climateControl.adjustClimate(tempService.getTemperature(), humidityService.getHumidity());
        }

        System.out.println("🚀 Climate Control System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Climate Control System Bundle Stopped.");
    }
}
