import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<String> lines = getFileData("src/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < lines.size(); i++) {
            partOneAnswer += getPartOneNumber(lines.get(i));
            partTwoAnswer += getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(String line) {
        int gameNum = 0;
        String temp = line.substring(5,7);
        gameNum = Integer.parseInt(temp.substring(0,1));
        if (isInt(temp.substring(1,2))) {
            gameNum = Integer.parseInt(temp);
        }
        if (line.substring(5,8).equals("100")) {
            gameNum = 100;
        }
        line = line.substring(7);
        int green = 0;
        int red = 0;
        int blue = 0;

        String[] games = line.split(";");

        for (int i = 0; i < games.length; i ++) {
            String[] nums = games[i].split(",");
            for (int j = 0; j < nums.length; j ++) {
                if (nums[j].contains("green")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    green = n.get(0);
                } else if (nums[j].contains("blue")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    blue = n.get(0);
                } else if (nums[j].contains("red")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    red = n.get(0);
                }
                if (red > 12) {
                    return 0;
                }
                if (green > 13) {
                    return 0;
                }
                if (blue > 14) {
                    return 0;
                }
            }
        }


        return gameNum;
    }

    public static int getPartTwoNumber(String line) {
        int gameNum = 0;
        String temp = line.substring(5,7);
        gameNum = Integer.parseInt(temp.substring(0,1));
        if (isInt(temp.substring(1,2))) {
            gameNum = Integer.parseInt(temp);
        }
        if (line.substring(5,8).equals("100")) {
            gameNum = 100;
        }
        line = line.substring(7);
        int green = 0;
        int red = 0;
        int blue = 0;
        int maxGreen = 0;
        int maxRed = 0;
        int maxBlue = 0;
        String[] games = line.split(";");

        for (int i = 0; i < games.length; i ++) {
            String[] nums = games[i].split(",");
            for (int j = 0; j < nums.length; j ++) {
                if (nums[j].contains("green")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    green = n.get(0);
                    if (green > maxGreen) {
                        maxGreen = green;
                    }
                } else if (nums[j].contains("blue")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    blue = n.get(0);
                    if (blue > maxBlue) {
                        maxBlue = blue;
                    }

                } else if (nums[j].contains("red")) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(nums[j]);

                    // Extract integers
                    List<Integer> n = new ArrayList<>();
                    while (matcher.find()) {
                        n.add(Integer.parseInt(matcher.group()));
                    }
                    red = n.get(0);
                    if (red > maxRed) {
                        maxRed = red;
                    }
                }

            }

        }

        int power = maxBlue * maxRed * maxGreen;
        return power;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }


    public static boolean isInt (String gulp) {
        try {
            Integer.parseInt(gulp); // Attempt to parse the string
            return true; // If successful, it's an integer
        } catch (NumberFormatException e) {
            return false; // If parsing fails, it's not an integer
        }
    }
}
