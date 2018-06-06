package by.vydrasergei.itrex.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vydra_Sergei
 * Class RemoverTest tests the methods from the class Remover.
 */

public class RemoverTest {

    /**
     * Method executeTest checks 2 parameters(text(before editing) and result(after)).
     * Worlds and phrases for testing were taken from the original source.
     */
    @Test
    public void executeTest() {

        Remover testRemover = new Remover();

        String result1 = "suksess";
        String text1 = "success";
        text1 = testRemover.removeLetterC(text1);
        assertEquals(result1, text1);

        String result2 = "uo";
        String text2 = "ooo";
        text2 = testRemover.removeDoubleLetter(text2);
        assertEquals(result2, text2);

        String result3 = "u";
        String text3 = "oou";
        text3 = testRemover.removeDoubleLetter(text3);
        assertEquals(result3, text3);

        String result4 = "i";
        String text4 = "iee";
        text4 = testRemover.removeDoubleLetter(text4);
        assertEquals(result4, text4);

        String result5 = "Th";
        String text5 = "The";
        text5 = testRemover.removeLetterE(text5);
        assertEquals(result5, text5);

        String result6 = "tabl";
        String text6 = "the table";
        text6 = testRemover.removeArticles(text6);
        text6 = testRemover.removeLetterC(text6);
        text6 = testRemover.removeDoubleLetter(text6);
        text6 = testRemover.removeLetterE(text6);
        assertEquals(result6, text6);

        String result7 = "kakao and kofi";
        String text7 = "cacao and coffee";
        text7 = testRemover.removeLetterC(text7);
        text7 = testRemover.removeDoubleLetter(text7);
        text7 = testRemover.removeLetterE(text7);
        text7 = testRemover.removeArticles(text7);
        assertEquals(result7, text7);

        String result8 = "sukses";
        String text8 = "success";
        text8 = testRemover.removeArticles(text8);
        text8 = testRemover.removeLetterC(text8);
        text8 = testRemover.removeDoubleLetter(text8);
        text8 = testRemover.removeLetterE(text8);
        assertEquals(result8, text8);
    }
}
