package habitathealthsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import temperaturesensor.TemperatureService;
import humiditysensor.HumidityService;
import airqualitysensor.AirQualityService;
import waterqualitysensor.WaterQualityService;
import noisesensor.NoiseService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
    	  System.out.println("\n🚀 Habitat Health System Bundle Started.");

        HabitatHealthSystem healthSystem = new HabitatHealthSystem();
        registration = context.registerService(HabitatHealthService.class.getName(), healthSystem, null);

        ServiceReference<?> tempRef = context.getServiceReference(TemperatureService.class.getName());
        ServiceReference<?> humidityRef = context.getServiceReference(HumidityService.class.getName());
        ServiceReference<?> airQualityRef = context.getServiceReference(AirQualityService.class.getName());
        ServiceReference<?> waterQualityRef = context.getServiceReference(WaterQualityService.class.getName());
        ServiceReference<?> noiseRef = context.getServiceReference(NoiseService.class.getName());

        
       
        
        if (tempRef != null && humidityRef != null && airQualityRef != null && waterQualityRef != null && noiseRef != null) {
            TemperatureService tempService = (TemperatureService) context.getService(tempRef);
            HumidityService humidityService = (HumidityService) context.getService(humidityRef);
            AirQualityService airQualityService = (AirQualityService) context.getService(airQualityRef);
            WaterQualityService waterQualityService = (WaterQualityService) context.getService(waterQualityRef);
            NoiseService noiseService = (NoiseService) context.getService(noiseRef);

            
            
            healthSystem.assessHabitat(
                tempService.getTemperature(),
                humidityService.getHumidity(),
                airQualityService.getAirQuality(),
                waterQualityService.getPHLevel(),
                waterQualityService.getTurbidity(),
                noiseService.getNoiseLevel()
            );
            
          
            printBanner();
        }

        
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Habitat Health System Bundle Stopped.");
    }

    private void printBanner() {
        String banner = 
        		"\n------------------------------------------------------------------------------------------------------------------------------"
        		+"\n  ,---.            ,--.                             ,--.  ,--.                ,------.                              ,--.   \r\n"
        		+ " /  O  \\ ,--.,--.,-'  '-. ,---. ,--,--,--. ,--,--.,-'  '-.`--' ,---. ,--,--,  |  .--. ' ,---.  ,---. ,---. ,--.--.,-'  '-. \r\n"
        		+ "|  .-.  ||  ||  |'-.  .-'| .-. ||        |' ,-.  |'-.  .-',--.| .-. ||      \\ |  '--'.'| .-. :| .-. | .-. ||  .--''-.  .-' \r\n"
        		+ "|  | |  |'  ''  '  |  |  ' '-' '|  |  |  |\\ '-'  |  |  |  |  |' '-' '|  ||  | |  |\\  \\ \\   --.| '-' ' '-' '|  |     |  |   \r\n"
        		+ "`--' `--' `----'   `--'   `---' `--`--`--' `--`--'  `--'  `--' `---' `--''--' `--' '--' `----'|  |-' `---' `--'     `--'\r\n"
        		+ "-----------------------------------------------------------------------------------------------------------------------------"+
            
            "\n\t\t\t\t\tAutomation Habitat Health System                                           \n" +
            "\t\t\t\t\t\tVersion 1.0.0\t\t                                                              \n"
    		;

        System.out.println(banner);
    }
}