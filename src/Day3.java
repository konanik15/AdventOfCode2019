import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3 {


    public static HashMap<Point,Integer> mapWire(String[] wire) {
        HashMap<Point,Integer> wireMap = new HashMap<>();
        int[] dir = new int[2];

        int x=0;
        int y=0;

        int oldX=0;
        int oldY=0;

        int stepCounter = 0;

        // Pierwszy wire
        for(String move : wire) {

            //resetowanie kierunku
            dir[0] = 0;
            dir[1] = 0;


            //Okreslanie kierunku ex: (1,0)(-1,0)(0,1)(0,-1)
            switch (move.charAt(0)) {
                case 'R':
                    dir[0] = 1;
                    break;
                case 'L':
                    dir[0] = -1;
                    break;
                case 'U':
                    dir[1] = 1;
                    break;
                case 'D':
                    dir[1] = -1;
                    break;
            }

            int distance = Math.abs(Integer.parseInt(move.replaceAll("[\\D]", "")));

            // Wyznaczanie punktu koncowego po parametrze move
            x = oldX + dir[0] * Integer.parseInt(move.replaceAll("[\\D]", ""));
            y = oldY + dir[1] * Integer.parseInt(move.replaceAll("[\\D]", ""));


            for(int i = 1; i <= distance;++i){
                stepCounter++;
                wireMap.put(new Point(oldX + dir[0] * i,oldY + dir[1] * i),stepCounter);

            }
            oldX = x;
            oldY = y;

        }

        return wireMap;
    }



    public static int findCrossings3a(String[] wire1,String[] wire2) {

        int minDist=Integer.MAX_VALUE;

        HashMap<Point,Integer> wireMap = new HashMap<>();
        int[] dir = new int[2];

        int x=0;
        int y=0;

        int oldX=0;
        int oldY=0;

        // Pierwszy wire
        for(String move : wire1) {

            //resetowanie kierunku
            dir[0] = 0;
            dir[1] = 0;


            //Okreslanie kierunku ex: (1,0)(-1,0)(0,1)(0,-1)
            switch (move.charAt(0)) {
                case 'R':
                    dir[0] = 1;
                    break;
                case 'L':
                    dir[0] = -1;
                    break;
                case 'U':
                    dir[1] = 1;
                    break;
                case 'D':
                    dir[1] = -1;
                    break;
            }

            int distance = Math.abs(Integer.parseInt(move.replaceAll("[\\D]", "")));

            // Wyznaczanie punktu koncowego po parametrze move
            x = oldX + dir[0] * Integer.parseInt(move.replaceAll("[\\D]", ""));
            y = oldY + dir[1] * Integer.parseInt(move.replaceAll("[\\D]", ""));


            for(int i = 1; i <= distance;++i){
                wireMap.put(new Point(oldX + dir[0] * i,oldY + dir[1] * i),1);
            }
            oldX = x;
            oldY = y;

        }
        // Drugi Wire

        oldX = 0;
        oldY = 0;

        int stepCounter = 0;

        for(String move : wire2) {

            //Resetowanie kierunku
            dir[0] = 0;
            dir[1] = 0;


            //Okreslanie kierunku ex: (1,0)(-1,0)(0,1)(0,-1)
            switch (move.charAt(0)) {
                case 'R':
                    dir[0] = 1;
                    break;
                case 'L':
                    dir[0] = -1;
                    break;
                case 'U':
                    dir[1] = 1;
                    break;
                case 'D':
                    dir[1] = -1;
                    break;
            }
            // Wyznaczanie punktu koncowego po parametrze move
            x = oldX + dir[0] * Integer.parseInt(move.replaceAll("[\\D]", ""));
            y = oldY + dir[1] * Integer.parseInt(move.replaceAll("[\\D]", ""));

            int distance = Math.abs(Integer.parseInt(move.replaceAll("[\\D]", "")));

            for(int i = 1; i <= distance;i++){

                Point point = new Point(oldX + dir[0] * i,oldY + dir[1] * i);

                if(wireMap.containsKey(point) && wireMap.get(point) != 2) {
                    wireMap.put(point,2);
                }
                else {
                    wireMap.put(point,1);
                }


            }
            oldX = x;
            oldY = y;
        }

        for(Map.Entry<Point,Integer> set : wireMap.entrySet()) {
            if(set.getValue() == 2 ) {
                System.out.println("Punkt skrzyzowanie to : " + set.getKey().toString());
                int dist = (int) (Math.abs(set.getKey().getX()) + Math.abs(set.getKey().getY()));
                if (dist < minDist){
                    System.out.println("Min dist : " + dist);
                    minDist = dist;
                }
            }
        }

        return minDist;

    }

    public static int findClosestCrossings(HashMap<Point,Integer> wire1map,HashMap<Point,Integer> wire2map) {
        int minDist = Integer.MAX_VALUE;
        for(Point point : wire1map.keySet()) {
            if(wire2map.containsKey(point)) {
                int dist = wire1map.get(point) + wire2map.get(point);
                if(minDist > dist) {
                    minDist = dist;
                }

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

        HashMap wire1Map = mapWire(wire1Array);
        HashMap wire2Map = mapWire(wire2Array);

        // 3a
        System.out.println("Smolest dist ist : " + findCrossings3a(wire1Array,wire2Array));

        // 3b
        System.out.println("Smolest dist ist : " + findClosestCrossings(wire1Map,wire2Map));



    }
}
