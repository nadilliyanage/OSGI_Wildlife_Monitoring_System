package habitathealthsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import airqualitycontrolsystem.AirQualityControlService;
import climatecontrolsystem.ClimateControlService;
import noisemonitoringsystem.NoiseMonitoringService;
import watermanagementsystem.WaterManagementService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        System.out.println("🚀 Habitat Health System Bundle Started.");

        HabitatHealthSystem healthSystem = new HabitatHealthSystem();
        registration = context.registerService(HabitatHealthService.class.getName(), healthSystem, null);

        // Get references to the control services
        ServiceReference<?> airQualityRef = context.getServiceReference(AirQualityControlService.class.getName());
        ServiceReference<?> climateControlRef = context.getServiceReference(ClimateControlService.class.getName());
        ServiceReference<?> noiseMonitoringRef = context.getServiceReference(NoiseMonitoringService.class.getName());
        ServiceReference<?> waterManagementRef = context.getServiceReference(WaterManagementService.class.getName());

        if (airQualityRef != null && climateControlRef != null && noiseMonitoringRef != null && waterManagementRef != null) {
            // Fetch control services
            AirQualityControlService airQualityControlService = (AirQualityControlService) context.getService(airQualityRef);
            ClimateControlService climateControlService = (ClimateControlService) context.getService(climateControlRef);
            NoiseMonitoringService noiseMonitoringService = (NoiseMonitoringService) context.getService(noiseMonitoringRef);
            WaterManagementService waterManagementService = (WaterManagementService) context.getService(waterManagementRef);

            // Set services in the health system
            healthSystem.setAirQualityControlService(airQualityControlService);
            healthSystem.setClimateControlService(climateControlService);
            healthSystem.setNoiseMonitoringService(noiseMonitoringService);
            healthSystem.setWaterManagementService(waterManagementService);

            // Assess habitat using real-time data
            healthSystem.assessHabitat();

            printBanner();
        } else {
            System.out.println("❌ Error: Required services are not available.");
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
            + "\n  ,---.            ,--.                             ,--.  ,--.                ,------.                              ,--.   \r\n"
            + " /  O  \\ ,--.,--.,-'  '-. ,---. ,--,--,--. ,--,--.,-'  '-.`--' ,---. ,--,--,  |  .--. ' ,---.  ,---. ,---. ,--.--.,-'  '-. \r\n"
            + "|  .-.  ||  ||  |'-.  .-'| .-. ||        |' ,-.  |'-.  .-',--.| .-. ||      \\ |  '--'.'| .-. :| .-. | .-. ||  .--''-.  .-' \r\n"
            + "|  | |  |'  ''  '  |  |  ' '-' '|  |  |  |\\ '-'  |  |  |  |  |' '-' '|  ||  | |  |\\  \\ \\   --.| '-' ' '-' '|  |     |  |   \r\n"
            + "`--' `--' `----'   `--'   `---' `--`--`--' `--`--'  `--'  `--' `---' `--''--' `--' '--' `----'|  |-' `---' `--'     `--'\r\n"
            + "-----------------------------------------------------------------------------------------------------------------------------" +
            "\n\t\t\t\t\tAutomation Habitat Health System                                           \n" +
            "\t\t\t\t\t\tVersion 1.0.0\t\t                                                              \n";

        System.out.println(banner);
    }
}