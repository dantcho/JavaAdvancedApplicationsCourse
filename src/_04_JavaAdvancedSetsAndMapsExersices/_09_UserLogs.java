package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String,LinkedHashMap<String,Integer>> usernames = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] logRow = input.split(" ");
            String usrename = logRow[2].split("=")[1];
            String ip = logRow[0].split("=")[1];
            if (!usernames.containsKey(usrename)){
                usernames.put(usrename,new LinkedHashMap<>());
                usernames.get(usrename).put(ip,1);
            }else {
                if (!usernames.get(usrename).containsKey(ip)){
                    usernames.get(usrename).put(ip,1);
                }else {
                    usernames.get(usrename).put(ip,usernames.get(usrename).get(ip)+1);
                }
            }
            input = scanner.nextLine();

            for (LinkedHashMap<String, Integer> stringIntegerLinkedHashMap : usernames.values()) {


            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usernames.entrySet()) {
            LinkedHashMap<String, Integer> ips = user.getValue();
            StringBuilder rowOut = new StringBuilder();
            rowOut.append(user.getKey()+":\n");


            for (Map.Entry<String, Integer> ip : ips.entrySet()) {
                rowOut.append(ip.getKey()).append(" => ").append(ip.getValue()).append(", ");
            }
            rowOut.delete(rowOut.length()-2,rowOut.length());
            rowOut.append(".");
            System.out.println(rowOut);
        }

    }
}
