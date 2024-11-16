import java.util.LinkedList;
import java.util.List;

public abstract class TempHumidTemplate implements TempHumid {
    public LinkedList<Double> data = new LinkedList<>();
    public LinkedList<Double> temperatures = new LinkedList<>();
    public LinkedList<Double> humidities = new LinkedList<>();

    @Override
    public void intakeData(List<Double> data) {
        this.data = new LinkedList<>(data);
    }

    @Override
    public void clean() {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == -999.0 || isDate(data.get(i))) {
                data.remove(i);
                i--;
            }
        }
    }

    @Override
    public void parse() {
        for (int i = 0; i < data.size(); i += 2) {
            temperatures.add(data.get(i));
            humidities.add(data.get(i + 1));
        }
        // data.clear();
    }

    @Override
    public void sort() {
        temperatures.sort(Double::compareTo);
        humidities.sort(Double::compareTo);
    }

    @Override
    public double maxTemperature() {
        if (temperatures.isEmpty()) { return -999.0; }
        return temperatures.getLast();
    }

    @Override
    public double minHumidity() {
        if (humidities.isEmpty()) { return -999.0; }
        return humidities.getFirst();
    }
}