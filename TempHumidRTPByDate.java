import java.util.LinkedList;
import java.util.List;

public class TempHumidRTPByDate extends TempHumidRTP {
    public double date;

    public TempHumidRTPByDate(double date) {
        this.date = date;
    }

    @Override
    public void intakeData(List<Double> data) {
        this.data = new LinkedList<>(data);
        clean();
        super.parse();
        super.sort();
    }

    @Override
    public void clean() {
        LinkedList<Double> filteredData = new LinkedList<>();
        boolean foundTargetDate = false;

        for (int i = 0; i < data.size(); i++) {
            Double currentValue = data.get(i);

            if (foundTargetDate && isDate(currentValue)) {
                foundTargetDate = false;
            }

            // If the current value is a date and matches the target date, start adding data
            if (currentValue == date) {
                foundTargetDate = true;
            }

            // If the target date is found, add all subsequent data points
            else if (foundTargetDate) {
                filteredData.add(currentValue);
            }

            
        }
        data = filteredData;
        super.clean();
    }
}
