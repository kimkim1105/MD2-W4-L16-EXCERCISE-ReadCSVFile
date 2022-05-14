package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader br = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter= null;
        try {
            String line = "";
            fileReader = new FileReader("countrylist.csv");
            br = new BufferedReader(fileReader);
            fileWriter = new FileWriter("export.csv",true);
            bufferedWriter = new BufferedWriter(fileWriter);
            while ((line= br.readLine())!=null){
                printList(readFile(line));
                bufferedWriter.write(br.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String line){
        List<String> countryList = new ArrayList<>();
        if (line!= null){
            String[] result = line.split(",");
            for (int i = 0; i < result.length; i++) {
                countryList.add(result[i]);
            }
        }
        return countryList;
    }
    public static void printList(List<String> country){
        System.out.println(
                "Country has id= " +country.get(0)
                +", code= "+country.get(1)
                +", name= "+country.get(2)
        );
    }

}
