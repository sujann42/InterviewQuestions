import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class CompoundInterestCalculator {

    public static void main(String[] args) {
        double p = 10000;
        double r = 15;
        double t = 10;
        String cf = "semi-annually";

        r /= 100;
        //double n = (getN(cf));
        double n = getN_Value(cf);
        double r_over_n = r / n;

        double n_times_t = n * t;

        double amount = p * Math.pow((1 + r_over_n), n_times_t);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double total_Amount = Double.parseDouble(decimalFormat.format(amount));

        System.out.printf("Principal: %8.2f\n", p);
        System.out.printf("Interest : %8.2f\n", total_Amount - p);
        System.out.printf("Total    : %8.2f", total_Amount);
    }

    public static double getN_Value(String frequency) {
        Map<String, Integer> freq_map = new LinkedHashMap<String, Integer>();
        freq_map.put("yearly", 1);
        freq_map.put("semi-annually", 2);
        freq_map.put("quarterly", 4);
        freq_map.put("bi-monthly", 6);
        freq_map.put("monthly", 12);
        freq_map.put("weekly", 52);
        freq_map.put("daily", 365);

        return freq_map.get(frequency);
    }
}
