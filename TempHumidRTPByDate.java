import java.util.LinkedList;

public class TempHumidRTPByDate extends TempHumidRTP {
    public double date;

    public TempHumidRTPByDate(double date) {
        this.date = date;
    }

    @Override
    public void clean() {
        boolean isTargetDate = false;
        LinkedList<Double> cleanedData = new LinkedList<>();

        for (Double value : data) {
            if (isTargetDate) {
                if (value != -999.0) {
                    cleanedData.add(value);
                }
            } else {
                if (value == date) {
                    isTargetDate = true;
                }
            }
        }
        data = cleanedData;
    }

    public LinkedList<Double> getData() {
        return data;
    }
}
