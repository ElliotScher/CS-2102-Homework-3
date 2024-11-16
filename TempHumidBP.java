public class TempHumidBP extends TempHumidTemplate {
    @Override
    public double maxTemperature() {
        super.clean();
        super.parse();
        super.sort();
        return super.maxTemperature();
    }

    @Override
    public double minHumidity() {
        super.clean();
        super.parse();
        super.sort();
        return super.minHumidity();
    }
    
}
