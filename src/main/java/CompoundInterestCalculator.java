import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class CompoundInterestCalculator {

    //Total Amount = P*(1+(rate/n)^(t*n)
    public static void main(String[] args) {
        double p = 10000;
        double r = 15;
        double t = 10;
        String cf = "semi-annually";

        //Converting rate into decimal
        r /= 100;
        
        //getting n based on the frequency of the interest that is compounded
        double n = getN_Value(cf);
        double r_over_n = r / n;

        double n_times_t = n * t;

        //Calculating total interest
        double amount = p * Math.pow((1 + r_over_n), n_times_t);
        //Formatting the amount to 2 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double total_Amount = Double.parseDouble(decimalFormat.format(amount));

        System.out.printf("Principal: %8.2f\n", p);
        System.out.printf("Interest : %8.2f\n", total_Amount - p);
        System.out.printf("Total    : %8.2f", total_Amount);
    }

    public static double getN_Value(String frequency) {
        //creating a map to store the value of frequency 
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

/*

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatingAPYFromInterestRate {
    public static void main(String[] args) {
        System.out.println(calculateAPY("4"));
    }
    public static String calculateAPY(String rate){
        if(rate.equals("0")){
            return "ZERO";
        }


        MathContext context = new MathContext(64);
        BigDecimal rateDouble = new BigDecimal(rate, context);
        BigDecimal s1 = rateDouble.multiply(new BigDecimal(0.01, context), context);
        BigDecimal s2 = s1.divide(new BigDecimal(12, context), context);
        BigDecimal s3 = s2.add(new BigDecimal("1", context), context);
        BigDecimal s4 = s3.pow(12, context);
        BigDecimal s5 = s4.subtract(new BigDecimal(1, context), context);
        BigDecimal s6 = s5.multiply(new BigDecimal(10000, context), context);
        BigDecimal lowAPI = s6.divide(new BigDecimal("100", context), context);

        String finalAPY = lowAPI.setScale(6, RoundingMode.HALF_UP).toString();

        return finalAPY;
    }
}


*/
