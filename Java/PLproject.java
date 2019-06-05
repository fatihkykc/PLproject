/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author fatihkykc
 */
public class PLproject {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String weblog = "weblog.csv";
        File file = new File(weblog);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        FileReader fr = new FileReader(weblog);
        LineNumberReader lnr = new LineNumberReader(fr);

        int linenumber = 0;

        while (lnr.readLine() != null) {
            linenumber++;
        }
        lnr.close();
        fr.close();
        String[][] list = new String[linenumber][2];
        String line = "";
        String time = "";
        int i = 0;
        while ((line = reader.readLine()) != null) {
            list[i][0] = getField(line);
            list[i][1] = line;
            i++;
        }
        sort(list);
        reader.close();
        FileWriter writer = new FileWriter("sorted_weblog.txt");
        for (i = 0; i < list.length; i++) {
            writer.write(list[i][1]);
            writer.write('\n');
        }
        writer.close();

        System.out.println(IPreturn(args[0]));

    }

    private static String getField(String line) {
        return line.split(",")[1];//extract date to sort on
    }

    static void sort(String arr[][]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0].compareToIgnoreCase(arr[min_idx][0]) < 0) {
                    min_idx = j;
                }
            }

            String temp = arr[min_idx][0];
            String temp1 = arr[min_idx][1];
            arr[min_idx][0] = arr[i][0];
            arr[min_idx][1] = arr[i][1];
            arr[i][0] = temp;
            arr[i][1] = temp1;
        }
    }

    public static SortedMap<Integer, String> IPreturn(String key) throws FileNotFoundException, IOException {

        HashMap<String, HashMap<Integer, String>> date2map = new HashMap<String, HashMap<Integer, String>>();
        TreeMap<Integer, String> sorted = new TreeMap<>();
        String filename = "sorted_weblog.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String date = "";
        String ip = "";
        String line = reader.readLine();
        for (int i = 1; line != null; i++) {
            date = line.split(",")[1].split(":")[0];
            ip = line.split(",")[0];
            HashMap<Integer, String> temp = date2map.get(date);
            if (temp == null) {
                HashMap<Integer, String> line2ip = new HashMap<Integer, String>();
                date2map.put(date, line2ip);
                line2ip.put(i, ip);
            } else {
                temp.put(i, ip);
            }
            line = reader.readLine();
        }
        sorted.putAll(date2map.get(key));
        return sorted.tailMap(sorted.lastKey() - 4);
    }

}

