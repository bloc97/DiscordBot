/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author bowen
 */
public abstract class OtherUtils {
    
    public static String repeatString(String s, int n) {
        String string = "";
        for (int i=0; i<n; i++) {
            string += s;
        }
        return string;
    }
    
    public static String fillBegin(String string, char c, int finalLength) {
        while (string.length() < finalLength) {
            string = c + string;
        }
        return string;
    }
    public static String fillEnd(String string, char c, int finalLength) {
        while (string.length() < finalLength) {
            string = string + c;
        }
        return string;
    }
    
    public static String formatCapitalUnderscore(String s) {
        String string = "";
        String[] sArr = s.split("_");
        for (String ss : sArr) {
            string += ss.substring(0, 1) + ss.substring(1).toLowerCase() + " ";
        }
        if (string.length() < 1) {
            return "None";
        }
        if (string.endsWith(" ")) {
            string = string.substring(0, string.length()-1);
        }
        return string;
    }
    public static String formatInput(String s) {
        char[] cArr = s.toCharArray();
        String formattedString = "";
        for (int i=0; i<cArr.length; i++) {
            if (isCharTextASCII(cArr[i])) {
                formattedString += cArr[i];
            }
        }
        return formattedString;
    }
    
    public static boolean isCharTextASCII(char c) {
        return (c == 10 || c == 12 || c == 13 || (c >= 32 && c <= 126));
        //10, '\n' newline
        //12, '\f' newpage
        //13, '\r' return to beginning of line
    }
    public static boolean isCharLetterASCII(char c) {
        return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122));
    }
    public static boolean isCharNumberASCII(char c) {
        return ((c >= 48 && c <= 57));
    }
    
    public static String formatNounOutput(String s) { //Formats a unformatted noun for output (capitalize first letter)
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    public static String formatOutput(String s) {
        if (s.isEmpty()) {
            return "None";
        }
        return s;
    }
    
    public static String join(String[] array) {
        String string = "";
        for (String s : array) {
            string = string.concat(s);
        }
        return string;
    }
    public static String join(String[] array, Character c) {
        if (c == null) {
            c = ' ';
        }
        String string = "";
        for (String s : array) {
            string = string.concat(s + c);
        }
        return string.substring(0, string.length()-1);
    }
    
    public static int bound(int i, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be bigger than maximum.");
        }
        if (i < min) {
            i = min;
        }
        if (i > max) {
            i = max;
        }
        return i;
    }
    public static int boundExcludeMax(int i, int min, int limit) {
        if (min >= limit) {
            throw new IllegalArgumentException("Minimum value cannot be bigger or equal than limit.");
        }
        if (i < min) {
            i = min;
        } else if (i >= limit) {
            i = limit - 1;
        }
        return i;
    }
    public static int boundExcludeMin(int i, int limit, int max) {
        if (limit >= max) {
            throw new IllegalArgumentException("Limit value cannot be bigger or equal than maximum.");
        }
        if (i <= limit) {
            i = limit + 1;
        } else if (i > max) {
            i = max;
        }
        return i;
    }
    public static int boundExcludeAll(int i, int minLimit, int maxLimit) {
        if (minLimit + 1 >= maxLimit) {
            throw new IllegalArgumentException("minLimit and maxLimit are too close.");
        }
        if (i <= minLimit) {
            i = minLimit + 1;
        } else if (i >= maxLimit) {
            i = maxLimit - 1;
        }
        return i;
    }
    
    public static boolean containsCharacter(String string, char[] characters) {
        for (char c : characters) {
            if (string.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
    
}