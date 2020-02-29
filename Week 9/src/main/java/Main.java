import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
            /* For production when any txt file can be use
            Scanner input = new Scanner(System.in);
            System.out.println("Specify path name: ");
            String filepath = input.next();
            File file = new File(filepath);
            */

        try {
            //for test
            File file = new File("C:\\Users\\asbjo\\OneDrive\\Mandatory Assignments\\Week 9\\src\\main\\resources\\AliceInWonderland.txt");
            Scanner scannner = new Scanner(file);

            String line;
            int countWord = 0;
            int characterCount = 0;
            Map<String, Integer> map = new HashMap<>();

            //TODO lav en scanner på en scanner
            String tempLine = scannner.nextLine();


            while(scannner.hasNext()) {
                line = scannner.next();

                line = line.replace("'", "");
                line = line.replace(".", "");
                line = line.replace(",", "");
                line = line.replace("!", "");
                line = line.replace("?", "");
                line = line.replace("-", "");
                line = line.replace("_", "");
                line = line.replace("[", "");
                line = line.replace("]", "");
                line = line.replace("(", "");
                line = line.replace(")", "");
                line = line.replace("\"", "");
                line = line.replace(";", "");
                line = line.replace(":", "");
                line = line.toLowerCase();

                if (!map.containsKey(line)) {
                    map.put(line, 1);
                } else if (map.containsKey(line)) {
                    int old = map.get(line);
                    map.replace(line, old, old + 1);
                }

                if(!(line.equals(""))) {
                    characterCount += line.length();

                    // \\s+ = space delimiter in java
                    String[] wordList = line.split("\\s+");
                    countWord += wordList.length;
                }
            }

            System.out.println("Total word count = " + countWord);
            System.out.println("Total number of characters = " + characterCount);
            System.out.println(map);

            System.out.println("Search for specfic keyword: ");
            String keyword = input.next().toLowerCase();
            System.out.println("\"" + keyword + "\" is present " + map.get(keyword) + " times in the text");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}