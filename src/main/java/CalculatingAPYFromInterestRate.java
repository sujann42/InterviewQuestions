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
