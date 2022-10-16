import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Day1 {

    public static int sumFuelReq1(List<String> data) {
        return data.stream().mapToInt(number -> (Integer.parseInt(number) / 3) - 2).sum();
    }

    public static int sumFuelReq2(List<String> data) {
        return data.stream().mapToInt(number -> fuelReq(Integer.parseInt(number))).sum();
    }

    public static int fuelReq(int number) {
        int sum = 0;
        for(int requirement = (number/3) - 2 ; requirement> 0 ;) {
            sum+=requirement;
            requirement = (requirement/3) - 2;
        }
        return sum;

    }



    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("resources\\day1.txt"));
        //System.out.println(sumFuelReq1(lines));
        System.out.println(sumFuelReq2(lines));


    }
}