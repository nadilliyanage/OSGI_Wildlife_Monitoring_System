package climatecontrolsystem;

public interface ClimateControlService {
    void adjustClimate(int temperature, int humidity);

	int getTemperature();

	int getHumidity();
}