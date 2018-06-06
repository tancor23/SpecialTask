package by.vydrasergei.itrex.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vydra_Sergei
 * Class Remover has 4 main method which remove other letters or articles according to the rules.
 */

public class Remover {

    /**
     * Method removeLetterC takes String parameter and replaces symbols(ci, ce, ck, c) to (si, se, k, k) accordingly.
     * Inline flag CASE_INSENSITIVE means the next expression is case insensitive.
     */
    public static String removeLetterC(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("(ci)|(ce)|(ck)|(c)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String foundSequence = matcher.group();
            replaceSequence(start, end, foundSequence, stringBuilder);
        }
        return stringBuilder.toString();
    }

    public static void replaceSequence(int start, int end, String foundSequence, StringBuilder stringBuilder) {
        String replaceSymbols;
        switch (foundSequence) {
            case "ci":
                replaceSymbols = "si";
                break;
            case "ce":
                replaceSymbols = "se";
                break;
            default:
                replaceSymbols = "k";
        }
        stringBuilder.replace(start, end, replaceSymbols);
    }

    /**
     * Method removeDoubleLetter replaces symbols(ee and oo) to (i and u) accordingly and other double letters by one.
     */
    public static String removeDoubleLetter(String text) {
        String lastTextValue = "";

        while (!text.equals(lastTextValue)) {
            lastTextValue = text;
            text = text.replaceAll("(?i)(e)\\1", "i");
            text = text.replaceAll("(?i)(o)\\1", "u");
            text = text.replaceAll("(?i)(.)\\1", "$1");
        }
        return text;
    }

    /**
     * Method removeLetterC removes letter 'e' in the end of each word if word length > 1.
     * Inline flag(?i) means the next expression is case insensitive.
     */
    public static String removeLetterE(String text) {
        text = text.replaceAll("(?i)e(?!\\S)", "");
        return text;
    }

    /**
     * Method removeArticles removes articles “a”, “an” or “the” from text.
     */
    String removeArticles(String text) {
        String result = text.replaceAll("(?i)(\\s*\\b)a(\\b\\s*)", " ");
        result = result.replaceAll("(?i)(\\s*\\b)an(\\b\\s*)", " ");
        result = result.replaceAll("(?i)(\\s*\\b)the(\\b\\s*)", " ");
        return result.trim();
    }
}