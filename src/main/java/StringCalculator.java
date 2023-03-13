import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    public int retNumber(String number) throws Exception{
        if(number.isEmpty()){
            return 0;
        }
        if(number.length() == 1){
            return Character.getNumericValue(number.charAt(0));
        }
        if(number.charAt(0) == '-'){
            throw new Exception("Negative number");
        }
        List<Integer> numbers = new ArrayList<Integer>();
        boolean isNewNumber = true;
        for(int i = 0; i < number.length(); i++){
            if(Character.isDigit(number.charAt(i))){
                int num = Character.getNumericValue(number.charAt(i));
                if(isNewNumber){
                    numbers.add(num);
                    isNewNumber = false;
                }else {
                    int newNum = numbers.get(numbers.size()-1)*10 + num;
                    numbers.set(numbers.size()-1, newNum);
                }
            }
            else {
                isNewNumber = true;
            }
        }
        int sum = 0;
        for (Integer integer: numbers
             ) {
            if(integer < 1000) {
                sum += integer;
            }
        }
        return sum;
    }
}
