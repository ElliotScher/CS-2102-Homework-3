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
        boolean isTargetDate = false;
        LinkedList<Double> cleanedData = new LinkedList<>();

        for (Double value : data) {
            if (value == date) {
                isTargetDate = true;
            }
            
            if (isTargetDate && value != -999.0) {
                cleanedData.add(value);
            }

            if (isDate(value) && isTargetDate) {
                isTargetDate = false;
            }
        }
        data = cleanedData;
        super.clean();
    }
}
