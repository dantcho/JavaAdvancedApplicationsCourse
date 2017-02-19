package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NMS {
    final static String STOP = "---NMS SEND---";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder allText = new StringBuilder();
        while (!input.equals(STOP)) {
            allText.append(input);
            input = reader.readLine();
        }
        String delimiter = reader.readLine();
        System.out.println(decrypt(allText.toString(), delimiter));

    }

    private static String decrypt(String allText, String delimiter) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < allText.length() - 1; i++) {
            if (allText.toLowerCase().charAt(i + 1) >= allText.toLowerCase().charAt(i)) {
                out.append(allText.charAt(i));
            } else {
                out.append(allText.charAt(i)).append(delimiter);
            }
        }
        out.append(allText.charAt(allText.length() - 1));

        return out.toString();
    }
}
