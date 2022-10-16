import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static ArrayList<Integer> programAlarm(ArrayList<Integer> data) {

        ArrayList<Integer> dataCopy = (ArrayList<Integer>) data.clone();

        for(int i=0;i <= dataCopy.size();i+=4) {
            //Reading arguments for arethic
            int arg1= dataCopy.get(dataCopy.get(i+1));
            int arg2= dataCopy.get(dataCopy.get(i+2));

            switch (dataCopy.get(i)) {
                case 1:
                    dataCopy.set(dataCopy.get(i+3),arg1 + arg2);
                    break;
                case 2:
                    dataCopy.set(dataCopy.get(i+3),arg1 * arg2);
                    break;
                default:
                    return dataCopy;
            }
        }
        return dataCopy;

    }


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("resources\\day2.txt"));
        scanner.useDelimiter("\\D");
        ArrayList<Integer> dataArr2 = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            dataArr2.add(scanner.nextInt());
        }


        for(int i=0;i<=99;i++) {
            for(int j=0;j<=99;j++){

                dataArr2.set(1,i); // noun
                dataArr2.set(2,j); // verb
                int get0 = programAlarm(dataArr2).get(0);
                if(get0 == 19690720) System.out.println("Wynik to: " + (100 * i + j));


            }
        }
       // System.out.println(programAlarm(dataArr2).get(0));

    }

}
