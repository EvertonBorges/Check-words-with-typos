package br.com.cesar.checkwordswithtypos;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    @Test
    public void testInsertCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "pales");
        assertTrue(result);
    }

    @Test
    public void testRemoveCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "ple");
        assertTrue(result);
    }

    @Test
    public void testRemoveCharacterTypoInWordPales() {
        boolean result = Utils.checkTypo("pales", "pale");
        assertTrue(result);
    }

    @Test
    public void testReplaceCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "bale");
        assertTrue(result);
    }

    @Test
    public void testTwoReplacesCharacterTypoInWordPale() {
        boolean result = Utils.checkTypo("pale", "bake");
        assertFalse(result);
    }

}