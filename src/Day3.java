import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    class

    public static int findCrossings(String[] wire1,String[] wire2) {

        HashMap<Point,Integer> wireMap = new HashMap<>();

        int x=0;
        int y=0;
        Point point = new Point(x,y);

        for(String move : wire1) {

            switch (move.charAt(0)) {
                case 'R':


                case 'L':
                    x -= Integer.parseInt(move.replaceAll("[\\D]", ""));
                    Point point = new Point(x,y);
                    if(wireMap.containsKey(point)){
                        wireMap.put(point, wireMap.get(point) + 1 );
                    }
                    else wireMap.put(point,1);
                case 'U':
                    y += Integer.parseInt(move.replaceAll("[\\D]", ""));
                    Point point = new Point(x,y);
                    if(wireMap.containsKey(point)){
                        wireMap.put(point, wireMap.get(point) + 1 );
                    }
                    else wireMap.put(point,1);
                case 'D':
                    y -= Integer.parseInt(move.replaceAll("[\\D]", ""));
                    Point point = new Point(x,y);
                    if(wireMap.containsKey(point)){
                        wireMap.put(point, wireMap.get(point) + 1 );
                    }
                    else wireMap.put(point,1);


            }
        }



        return minDist;

    }



    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("resources\\day3.txt"));
        String wire1 = scanner.nextLine();
        String wire2 = scanner.nextLine();

        String[] wire1Array = wire1.split(",");
        String[] wire2Array = wire2.split(",");


    }
}
