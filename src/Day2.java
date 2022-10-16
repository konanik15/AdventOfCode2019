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

        for(int i=0;i <= data.size();i+=4) {
            //Reading arguments for arethic
            int arg1= data.get(data.get(i+1));
            int arg2= data.get(data.get(i+2));

            switch (data.get(i)) {
                case 1:
                    data.set(data.get(i+3),arg1 + arg2);
                    break;
                case 2:
                    data.set(data.get(i+3),arg1 * arg2);
                    break;
                default:
                    return data;
            }
        }
        return data;

    }


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("resources\\day2.txt"));
        scanner.useDelimiter("\\D");
        ArrayList<Integer> dataArr2 = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            dataArr2.add(scanner.nextInt());
        }

        dataArr2.set(1,12);
        dataArr2.set(2,2);

        System.out.println(programAlarm(dataArr2).get(0));

    }

}
