import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4 {

//    It is a six-digit number.
//    The value is within the range given in your puzzle input.
//    Two adjacent digits are the same (like 22 in 122345).
//    Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).

    public static final int RANGEMIN = 147981;
    public static final int RANGEMAX = 691423;

//    public static int countNonDecreasing(int i) {
//        List<Integer> numbers = Stream.iterate(1, n -> n + 1)
//                .limit(10)
//                .collect(Collectors.toList());
//
//
//    }

    public static int getNonDecreasingMin(int rangeMin) {
        char[] chars = String.valueOf(rangeMin).toCharArray();
        int highestNumbPos = 0;
        int highestNumb = 0;
        int i =0;
        for (char ch : chars) {

            if(Character.getNumericValue(ch) > highestNumb) {
                highestNumb = Character.getNumericValue(ch);
                highestNumbPos = i;
            }
            i++;
        }

        for(int j = highestNumbPos; j < chars.length;j++) {
            System.out.println(chars);
            chars[j] = (char)highestNumb;
        }



        return Integer.parseInt(String.valueOf(chars));
    }



    public static void main(String[] args) {
        System.out.println(getNonDecreasingMin(RANGEMIN));
    }
}
