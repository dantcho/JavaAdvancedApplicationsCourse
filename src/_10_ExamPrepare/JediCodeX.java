package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.valueOf(reader.readLine());
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            text.append(reader.readLine());
        }
        String jediPattern = reader.readLine();
        String messagePattern = reader.readLine();
        String[] indexToken = reader.readLine().split("\\s+");
        List<Integer> ints = Arrays.stream(indexToken).map(Integer::valueOf).collect(Collectors.toList());
        ArrayDeque<Integer> indexes = new ArrayDeque<Integer>(ints);
        String jediRegex = jediPattern + "([A-Za-z]{" + jediPattern.length() + "})[^A-Za-z]";
        String messageRegex = messagePattern + "([A-Za-z0-9]{" + messagePattern.length() + "})";
        List<String> jedis = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        Pattern jPattern = Pattern.compile(jediRegex);
        Pattern mPattern = Pattern.compile(messageRegex);
        Matcher jMatcher = jPattern.matcher(text);
        Matcher mMatcher = mPattern.matcher(text);
        while (jMatcher.find()) {
            jedis.add(jMatcher.group(1));
        }
        while (mMatcher.find()) {
            messages.add(mMatcher.group(1));
        }
        int index = 0;
        LinkedHashMap<String, String> list = new LinkedHashMap<>();
        for (String jedi : jedis) {
            boolean b = true;
            while (b) {
                try {
                    list.put(jedi, messages.get(indexes.remove() - 1));
                    b = false;
                } catch (NoSuchElementException ex) {
                    b=false;
                }catch (IndexOutOfBoundsException ex){

                }
            }
        }
        list.forEach((s, s2) -> System.out.println(s + " - " + s2));
    }
}