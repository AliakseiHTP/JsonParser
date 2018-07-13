package run;

import java.util.*;

import entity.UseJsonFiles;
import entity.WordProcessor;

public class MainApp {
    public static void main(String[] args) {
        UseJsonFiles jsonFile1 = new UseJsonFiles("src/main/resources/fileJson1.json");
        UseJsonFiles jsonFile2 = new UseJsonFiles("src/main/resources/fileJson2.json");
        String sSollution1 = jsonFile1.getString("stringOne");
        String sSollution2 = jsonFile1.getString("stringTwo");
        String sSollution3 = jsonFile2.getString("stringThree");
        String sNeedWords = sSollution3.replaceAll("\\p{Punct}","");
        String[] arrayOfNeedWords = sNeedWords.split(" ");
        Set<String> hashSet = new LinkedHashSet<String>(Arrays.asList(arrayOfNeedWords));
        Iterator<String> iter = hashSet.iterator();
        WordProcessor wP = new WordProcessor();

        // �������1 - ���� ��� ������. ������� � ������� ��� ����� �� ������ ������, ������� ����������� �� ������.

        System.out.println("First task: "+wP.getUnique(sSollution1, sSollution2));

        /* �������2 - ���� ������. ���������� ���������� ������� ��� � ��� ����������� �����-���� �����,
        � ��� �� ���������� � ��� ��� ����� ����������.*/
        System.out.println();
        System.out.println("Second task:");
        while (iter.hasNext()){
            String sWord = iter.next();
                System.out.println(String.format("Count of matches (%s): %s",
                        sWord, wP.getCountOfSameWords(sNeedWords, sWord)));
        }
        System.out.println(String.format("Count of matches (Puncts): %s",wP.getCountOfPuncts(sSollution3)));
    }
}