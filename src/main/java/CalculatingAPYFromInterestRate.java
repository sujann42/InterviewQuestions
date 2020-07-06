import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatingAPYFromInterestRate {
    public static void main(String[] args) {
        System.out.println(calculateAPY("3"));
    }
    public static String calculateAPY(String rate){
        if(rate.equals("0")){
            return "ZERO";
        }


        MathContext context = new MathContext(64);
        BigDecimal rateDouble = new BigDecimal(rate, context);
        BigDecimal step1 = rateDouble.multiply(new BigDecimal(0.01, context), context);
        BigDecimal step2 = step1.divide(new BigDecimal(12, context), context);
        BigDecimal step3 = step2.add(new BigDecimal("1", context), context);
        BigDecimal step4 = step3.pow(12, context);
        BigDecimal step5 = step4.subtract(new BigDecimal(1, context), context);
        BigDecimal step6 = step5.multiply(new BigDecimal(10000, context), context);
        BigDecimal lowAPYValue = step6.divide(new BigDecimal("100", context), context);

        String lowAPY = lowAPYValue.setScale(6, RoundingMode.HALF_UP).toString();

        return lowAPY;
    }
}
