package ua.edu.ucu.tempseries;


public class TemperatureSeriesAnalysis {
        private double[] temperatureSeries;



    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;

    }

    public double average(){
        double count = 0;
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i< temperatureSeries.length; i++){
            count +=temperatureSeries[i];
        }
        return count/temperatureSeries.length;
    }

    public double deviation() {
        int count = 0;
        int length = 0;
        int average = 0;
        int sumofsquares = 0;
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i< temperatureSeries.length; i++){
            count += temperatureSeries[i];
            length += 1;
        }
        average = count/length;
        for (int i = 0; i< temperatureSeries.length; i++){
            sumofsquares += Math.pow((temperatureSeries[i] - average), 2);
        }return Math.sqrt(sumofsquares/length);
    }

    public double min(){
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double minimum = temperatureSeries[0];
        for (int i = 1; i<temperatureSeries.length; i++){
            if (temperatureSeries[i]<minimum){
                minimum = temperatureSeries[i];
            }
        }
        return minimum;
    }

    public double max() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double maximum = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > maximum) {
                maximum = temperatureSeries[i];
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double closest = Math.abs(0 - temperatureSeries[0]);
        double answer = temperatureSeries[0];

        for (int i = 1; i < temperatureSeries.length; i++) {
            double temp = Math.abs(0 - temperatureSeries[i]);
            if (temp<closest){
                closest = temp;
                answer = temperatureSeries[i];
            }
        }
        for (int t = 1; t < temperatureSeries.length; t++) {
            if (temperatureSeries[t] == Math.abs(answer)){
                answer = temperatureSeries[t];
            }
        }
        return answer;
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();

        }
        double closest = Math.abs(tempValue - temperatureSeries[0]);
        double answer = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            double temp = Math.abs(tempValue - temperatureSeries[i]);
            if (temp<closest){
                closest = temp;
                answer = temperatureSeries[i];
            }
        }
        for (int t = 1; t < temperatureSeries.length; t++) {
            if (temperatureSeries[t] == Math.abs(answer)) {
                answer = temperatureSeries[t];
            }
        }return answer;
    }

    public double[] findTempsLessThen(double tempValue) {
        int count = 0;
        int y =0;
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();

        }

        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue){
                count += 1;
            }
        }
        double[] lst1 = new double[count];

        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue){
                lst1[y] = temperatureSeries[i];
                y++;
            }
        }
        System.out.println(lst1.length);
        return lst1;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int count = 0;
        int y = 0;
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue){
                count += 1;
            }
        }
        double[] lst1 = new double[count];

        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue){
                lst1[y] = temperatureSeries[i];
                y++;
            }
        }
        return lst1;
    }

    public TempSummaryStatistics summaryStatistics() {
        if(temperatureSeries.length >= 1){
            TempSummaryStatistics obj = new TempSummaryStatistics(average(), deviation(), min(), max());
            return obj;
        }else{
            throw new IllegalArgumentException();
        }

    }

    public int addTemps(double...temps) {
        int count = 0;
        int i = 0;
        int j = 0;

        for (int a = 0; a < temperatureSeries.length; a++) {
            if (count != temps.length) {
                double[] lst4 = new double[temperatureSeries.length * 2];
                while (i != temperatureSeries.length) {
                    lst4[i] = temperatureSeries[i];
                    i++;
                }
                while (j != temps.length) {
                    for (int e = 0; e < lst4.length; e++) {
                        if (lst4[e] == 0) {
                            lst4[e] = temps[j];
                            break;
                        }

                    }
                    j++;
                }
                for (int r = 0; r < lst4.length; r++) {
                    if (lst4[r] != 0) {
                        count += 1;
                    }
                }
                return count;
            } else {
                int p = 0;
                while (p != temps.length) {
                    for (int e = 0; e < temperatureSeries.length; e++) {
                        if (temperatureSeries[e] == 0) {
                            temperatureSeries[e] = temps[j];
                            break;
                        }

                    }p++;
                }
                for(int r = 0; r < temperatureSeries.length; r++){
                    if(temperatureSeries[r] != 0 ){
                        count += 1;
                    }
                }return count;
            }

        }return count;

    }


}
