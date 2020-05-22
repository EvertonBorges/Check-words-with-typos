package br.com.cesar.checkwordswithtypos;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    @Test
    public void testInsertCharacterTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "apale");
        assertTrue(result);
    }

    @Test
    public void testInsertCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "paale");
        assertTrue(result);
    }

    @Test
    public void testInsertCharacterTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "pales");
        assertTrue(result);
    }

    @Test
    public void testInsertTwoCharacterTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "lypale");
        assertFalse(result);
    }

    @Test
    public void testInsertTwoCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "palyle");
        assertFalse(result);
    }

    @Test
    public void testInsertTwoCharacterTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "palely");
        assertFalse(result);
    }

    @Test
    public void testRemoveCharacterTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "ale");
        assertTrue(result);
    }

    @Test
    public void testRemoveCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "ple");
        assertTrue(result);
    }

    @Test
    public void testRemoveCharacterTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "pal");
        assertTrue(result);
    }

    @Test
    public void testRemoveTwoCharactersTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "le");
        assertFalse(result);
    }

    @Test
    public void testRemoveTwoCharactersTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "pe");
        assertFalse(result);
    }

    @Test
    public void testRemoveTwoCharactersTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "pa");
        assertFalse(result);
    }

    @Test
    public void testReplaceCharacterTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "bale");
        assertTrue(result);
    }

    @Test
    public void testReplaceCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "paae");
        assertTrue(result);
    }

    @Test
    public void testReplaceCharacterTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "palm");
        assertTrue(result);
    }

    @Test
    public void testTwoReplacesCharacterTypoInWordPaleInTheStart() {
        boolean result = Utils.checkTypo("pale", "tole");
        assertFalse(result);
    }

    @Test
    public void testTwoReplacesCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "peek");
        assertFalse(result);
    }

    @Test
    public void testTwoReplacesCharacterTypoInWordPaleInTheEnd() {
        boolean result = Utils.checkTypo("pale", "paco");
        assertFalse(result);
    }

}