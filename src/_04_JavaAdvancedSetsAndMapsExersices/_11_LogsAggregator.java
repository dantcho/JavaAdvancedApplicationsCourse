package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfRows= Integer.parseInt(scanner.nextLine());
        TreeMap<String,Integer> userTime = new TreeMap<>();
        TreeMap<String,TreeSet<String>> userIp = new TreeMap<>();

        for (int i = 0; i < numOfRows; i++) {
            String[]dataRow = scanner.nextLine().split(" ");
            String ip = dataRow[0];
            String user = dataRow[1];
            Integer time = Integer.parseInt(dataRow[2]);
            if (!userTime.containsKey(user)){
                userTime.put(user,time);
                userIp.put(user,new TreeSet<String>(){{add(ip);}});
            }else {
                userTime.put(user,userTime.get(user)+time);
                userIp.get(user).add(ip);
            }
        }
        StringBuilder out= new StringBuilder();
        for (Map.Entry<String, Integer> userEntry : userTime.entrySet()) {
            out.append(userEntry.getKey()).append(": ").append(userEntry.getValue()).append(" ").append(userIp.get(userEntry.getKey())).append('\n');
        }
        System.out.println(out);
    }
}
