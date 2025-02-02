package Level2;

import java.util.HashMap;

public class Q035_RecurringFraction {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder str = new StringBuilder();
        if(numerator == 0){
            return "0";
        }
        if((numerator<0) ^ (denominator<0)){
            str.append("-");
        }   
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        HashMap<Long,Integer> map = new HashMap<>();
        long quo = num/den;
        long rem = num%den;
        str.append(quo);
        if(rem==0){
            return str.toString();
        }
        str.append(".");
        while(rem!=0){
            if(map.containsKey(rem)){
                str.insert(map.get(rem), "(");
                str.append(')');
                return str.toString();
            }
            map.put(rem,str.length());
            rem*=10;
            quo = rem/den;
            rem = rem%den;
            str.append(quo);
        }
        return str.toString();

    }
}
