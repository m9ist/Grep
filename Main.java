package home;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
D:\!data\Java\Grep\out\production\Grep>C:\Downloads\Chrome\GetGnuWin32\gnuwin32\bin\cat test.txt | java home.Main
 */

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        boolean meth = true;
        ArrayList<String> keyWords = new ArrayList<String>();
        ArrayList<Pattern> regs = new ArrayList<Pattern>();
        if (args.length > 0) {
            Pattern p;
            for (String i : args) {
                if (meth) {
                    p = Pattern.compile(i);
                    regs.add(p);
                    System.out.println("Added regex");
                    System.out.println("Result of key is " + p.matcher("key").matches());
                } else {
                    keyWords.add(i);
                    System.out.println("Added key word");
                }
            }
        } else keyWords.add("key");

        Scanner sc = new Scanner(System.in);
        ArrayList<String> out = new ArrayList<String>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine().toLowerCase();

            if (!meth) {
                for (String i : keyWords) {
                    if (s.contains(i)) {
                        out.add(s);
                    }
                }
            } else {
                for (Pattern i : regs) {
                    if (i.matcher(s).matches()) {
                        out.add(s);
                    }
                }
            }
//            if (s.contains("end")) break;
        }

        System.out.println(System.getProperty("line.separator") + "<---- Result");
        for (String p : out) {
            System.out.println(p);
        }
    }
}
