import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        int one = 0;
        int two = 0;
        boolean found = false;
        boolean found2 = false;
        while (!found) {
            for (int i = 0; i < line.length(); i ++) {
                if (isInt(line.substring(i, i + 1))) {
                    one = Integer.parseInt(line.substring(i, i + 1));
                    found = true;
                    i = line.length() - 1;
                }
                if (i == line.length() - 1) {
                    found = true;
                }
            }
        }
        while (!found2) {
            for (int i = line.length(); i >= 1; i --) {
                if (isInt(line.substring(i - 1, i))) {
                    two = Integer.parseInt(line.substring(i - 1, i));
                    found2 = true;
                    i = 1;
                }
                if (i == 1) {
                    found2 = true;
                }
            }
        }

        String fin = "" + one + two;

        int glorp = Integer.parseInt(fin);

        return glorp;
    }

    public static int getPartTwoNumber(String line) {
        int one = 0;
        int two = 0;
        boolean found = false;
        boolean found2 = false;
        while (!found) {
            for (int i = 0; i < line.length(); i ++) {
                if (isInt(line.substring(i, i + 1))) {
                    one = Integer.parseInt(line.substring(i, i + 1));
                    found = true;
                    i = line.length() - 1;
                } else if (i < line.length() - 3 && threeMatcher(line.substring(i, i + 3))) {
                    one = threematch(line.substring(i, i + 3));
                    found = true;
                    i = line.length() - 1;
                } else if (i < line.length() - 4 && fourMatcher(line.substring(i, i + 4))) {
                    one = fourmatch(line.substring(i, i + 4));
                    found = true;
                    i = line.length() - 1;
                } else if (i < line.length() - 5 && fiveMatcher(line.substring(i, i + 5))) {
                    one = fivematch(line.substring(i, i + 5));
                    found = true;
                    i = line.length() - 1;
                }
                if (i == line.length() - 1) {
                    found = true;
                }
            }
        }
        while (!found2) {
            for (int i = line.length(); i >= 1; i --) {
                if (isInt(line.substring(i - 1, i))) {
                    two = Integer.parseInt(line.substring(i - 1, i));
                    found2 = true;
                    i = 1;
                } else if (i > 3 && threeMatcher(line.substring(i - 3, i))) {
                    two = threematch(line.substring(i - 3, i));
                    found2 = true;
                    i = 1;
                } else if (i > 4 && fourMatcher(line.substring(i - 4, i))) {
                    two = fourmatch(line.substring(i - 4, i));
                    found2 = true;
                    i = 1;
                } else if (i > 5 && fiveMatcher(line.substring(i - 5, i))) {
                    two = fivematch(line.substring(i - 5, i));
                    found2 = true;
                    i = 1;
                }
                if (i == 1) {
                    found2 = true;
                }
            }
        }
        System.out.println("one: " + one);
        System.out.println("two: " + two);
        String fin = "" + one + two;
        System.out.println(fin);
        int glorp = Integer.parseInt(fin);

        return glorp;

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

    public static boolean threeMatcher (String gulp) {
        if (gulp.equals("one")) {
            return true;
        } else if (gulp.equals("two")) {
            return true;
        } else if (gulp.equals("six")){
            return true;
        }
        return false;
    }

    public static boolean fourMatcher (String gulp) {
        if (gulp.equals("four")) {
            return true;
        } else if (gulp.equals("five")) {
            return true;
        } else if (gulp.equals("nine")){
            return true;
        }
        return false;
    }

    public static boolean fiveMatcher (String gulp) {
        if (gulp.equals("three")) {
            return true;
        } else if (gulp.equals("seven")) {
            return true;
        } else if (gulp.equals("eight")){
            return true;
        }
        return false;
    }

    public static int threematch (String gulp) {
        if (gulp.equals("one")) {
            return 1;
        } else if (gulp.equals("two")) {
            return 2;
        } else {
            return 6;
        }
    }

    public static int fourmatch (String gulp) {
        if (gulp.equals("four")) {
            return 4;
        } else if (gulp.equals("five")) {
            return 5;
        } else {
            return 9;
        }
    }

    public static int fivematch (String gulp) {
        if (gulp.equals("three")) {
            return 3;
        } else if (gulp.equals("seven")) {
            return 7;
        } else {
            return 8;
        }
    }
    
}