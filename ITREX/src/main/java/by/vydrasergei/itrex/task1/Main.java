package by.vydrasergei.itrex.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Vydra_Sergei
 * Class Main is main class in this prodramm which links other classes and where all events occur.
 */

public class Main {
    public static void main(String[] args) {
        String text = "";
        boolean booleanRepeatInputText = true;
        boolean booleanRepeatOutputText = true;
        int numberIn;
        int numberOut;

        while (booleanRepeatInputText) {
            System.out.println("Choose the type of input: \n1 - Using the file(input.txt); \n2 - Using the console; ");
            BufferedReader bufferedReaderInput = new BufferedReader(new InputStreamReader(System.in));
            try {
                numberIn = Integer.parseInt(bufferedReaderInput.readLine());
                switch (numberIn) {
                    case 1:
                        text = TextManager.inputFile();
                        booleanRepeatInputText = false;
                        break;
                    case 2:
                        System.out.println("Please, Enter the text");
                        text = TextManager.inputConsole();
                        booleanRepeatInputText = false;
                        break;
                    default:
                        System.out.println("The number wasn't typed correct. Please, enter the value again");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number wasn't typed correct. Please, enter the value again");
            } catch (IOException r) {
                System.out.println("The file wasn't found");
            }
        }

        Remover result = new Remover();
        text = result.removeArticles(text);
        text = result.removeLetterC(text);
        text = result.removeDoubleLetter(text);
        text = result.removeLetterE(text);

        while (booleanRepeatOutputText) {
            System.out.println("Choose the type of output: \n1 - Using the file(output.txt); \n2 - Using the console; ");
            BufferedReader bufferedReaderOutput = new BufferedReader(new InputStreamReader(System.in));
            try {
                numberOut = Integer.parseInt(bufferedReaderOutput.readLine());
                switch (numberOut) {
                    case 1:
                        TextManager.outputFile(text);
                        System.out.println("The text was written in a file(output.txt)");
                        booleanRepeatOutputText = false;
                        break;
                    case 2:
                        TextManager.outputConsole(text);
                        booleanRepeatOutputText = false;
                        break;
                    default:
                        System.out.println("The number wasn't typed correct. Please, enter the value again");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number wasn't typed correct. Please, enter the value again");
            } catch (IOException r) {
                System.out.println("The file wasn't found");
            }
        }
    }
}

