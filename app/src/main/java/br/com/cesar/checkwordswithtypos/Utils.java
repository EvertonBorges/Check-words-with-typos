package br.com.cesar.checkwordswithtypos;

class Utils {

    static boolean checkTypo(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) return false;
        if (Math.abs(firstWord.length() - secondWord.length()) > 1) return false;
        if (firstWord.equals(secondWord)) return true;

        if (checkInsertTypo(firstWord, secondWord)) return true;
        if (checkRemoveTypo(firstWord, secondWord)) return true;
        return checkReplaceTypo(firstWord, secondWord);
    }

    private static boolean checkInsertTypo(String firstWord, String secondWord) {
        if (secondWord.length() - firstWord.length() == 1) {
            return isTypoInsertOrRemoveBetween(secondWord, firstWord);
        }

        return false;
    }

    private static boolean checkRemoveTypo(String firstWord, String secondWord) {
        if (firstWord.length() - secondWord.length() == 1) {
            return isTypoInsertOrRemoveBetween(firstWord, secondWord);
        }

        return false;
    }

    private static boolean checkReplaceTypo(String firstWord, String secondWord) {
        if (firstWord.length() == secondWord.length()) {
            return isTypoReplaceBetween(firstWord, secondWord);
        }

        return false;
    }

    private static boolean isTypoInsertOrRemoveBetween(String word, String compareWord) {
        if (word.contains(compareWord)) return true;

        for(int i = 0; i < word.length(); i++) {
            final String newWordToCompare = word.substring(0, i) + word.substring(i + 1);
            if (newWordToCompare.equals(compareWord)) return true;
        }

        return false;
    }

    private static boolean isTypoReplaceBetween(String word, String compareWord) {
        for(int i = 0; i < compareWord.length(); i++) {
            final String firstWordToCompare =
                    word.substring(0, i) + word.substring(i + 1);

            final String secondWordToCompare =
                    compareWord.substring(0, i) + compareWord.substring(i + 1);

            if (firstWordToCompare.equals(secondWordToCompare)) return true;
        }

        return false;
    }

}