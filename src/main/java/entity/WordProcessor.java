package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor {

    public String getUnique(String sSource1, String sSource2){
        String s = "";
        String[] arrayOfStrings = sSource1.split(" ");
        for (int i = 0; i < arrayOfStrings.length; i++) {
            if (!sSource2.contains(arrayOfStrings[i])) {
                s += arrayOfStrings[i] + " ";                                  // s = s + arrayOfStrings[i] + " ";
            }
        }
        return s;
    }
    public int getCountOfSameWords(String sSource, String sFindWord){
        int i = 0;
        Pattern pattern = Pattern.compile(sFindWord);
        Matcher matcher = pattern.matcher(sSource);
        while (matcher.find()) {
            i++;
        }
        return i;
    }
    public int getCountOfPuncts (String sSource){          //для вывода какие именно знаки int->String [:punct:] \p{Punct}
        int i = 0;                                         //для вывода какие именно знаки int->String String string = stringpunct = "";
        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(sSource);
        while (matcher.find()) {
            i++;                                            //stringpunct += (" " + matcher.group());
        }
        return i;
    }
}
