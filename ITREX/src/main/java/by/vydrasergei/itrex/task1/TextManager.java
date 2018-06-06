package by.vydrasergei.itrex.task1;

import java.io.*;

/**
 * @author Vydra_Sergei
 * Class TextManager has 4 method which work with text(input(from the file or from console) and output(from the file or from console)).
 * The files input.txt and output.txt are at "src/main/resources" of the project.
 */

public class TextManager {

    /**
     * Static method inputConsole allows you to enter text from the console.
     */
    public static String inputConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    /**
     * Static method inputConsole allows you to enter text from the file(input.txt).
     */
    public static String inputFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/input.txt")));
        return bufferedReader.readLine();
    }

    /**
     * Static method inputConsole allows you to output text in the console.
     */
    public static void outputConsole(String text) {
        System.out.print("Result is " + text +"\\");
    }

    /**
     * Static method inputConsole allows you to output text in the file(output.txt).
     */
    public static void outputFile(String text) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("src/main/resources/output.txt"));
        out.print(text);
        out.close();
    }
}
