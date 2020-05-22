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
            final String differentLettersBetweenSecondWordAndFirstWord =
                    getDifferentLettersBetween(secondWord, firstWord);

            if (differentLettersBetweenSecondWordAndFirstWord.length() == 1) {
                for(int i = 0; i < firstWord.length(); i++) {
                    final String compareString =
                            firstWord.substring(0, i) +
                            differentLettersBetweenSecondWordAndFirstWord +
                            firstWord.substring(i);

                    if (compareString.equals(secondWord)) return true;
                }
                final String compareString =
                        firstWord + differentLettersBetweenSecondWordAndFirstWord;

                return compareString.equals(secondWord);
            }
        }

        return false;
    }

    private static boolean checkRemoveTypo(String firstWord, String secondWord) {
        if (firstWord.length() - secondWord.length() == 1) {
            final String differentLettersBetweemFirstWordAndSecondWord =
                    getDifferentLettersBetween(firstWord, secondWord);

            if (differentLettersBetweemFirstWordAndSecondWord.length() == 1) {
                for(int i = 0; i < secondWord.length(); i++) {
                    final String compareString =
                            secondWord.substring(0, i) +
                            differentLettersBetweemFirstWordAndSecondWord +
                            secondWord.substring(i);

                    if (compareString.equals(firstWord)) return true;
                }
                final String compareString =
                        secondWord +
                        differentLettersBetweemFirstWordAndSecondWord;

                return compareString.equals(firstWord);
            }
        }

        return false;
    }

    private static boolean checkReplaceTypo(String firstWord, String secondWord) {
        if (firstWord.length() == secondWord.length()) {
            final String differentLettersBetweenFirstWordAndSecondWord =
                    getDifferentLettersBetween(firstWord, secondWord);
            final String differentLettersBetweenSecondWordAndFirstWord =
                    getDifferentLettersBetween(secondWord, firstWord);

            if (differentLettersBetweenFirstWordAndSecondWord.length() == 1 &&
                    differentLettersBetweenSecondWordAndFirstWord.length() == 1) {
                int differentLetterPositionInFirstWord = 0;
                for(int i = 0; i < firstWord.length(); i++) {
                    if (differentLettersBetweenFirstWordAndSecondWord.charAt(0) ==
                            firstWord.charAt(i)) {
                        differentLetterPositionInFirstWord = i;
                        break;
                    }
                }

                int differentLetterPositionInSecondWord = 0;
                for(int i = 0; i < firstWord.length(); i++) {
                    if (differentLettersBetweenSecondWordAndFirstWord.charAt(0) ==
                            secondWord.charAt(i)) {
                        differentLetterPositionInSecondWord = i;
                        break;
                    }
                }

                return differentLetterPositionInFirstWord == differentLetterPositionInSecondWord;
            }

        }

        return false;
    }

    private static String getDifferentLettersBetween(String word, String compareWord) {
        String differentLetter = word;
        for(int i = 0; i < compareWord.length(); i++) {
            differentLetter = differentLetter.replace(String.valueOf(compareWord.charAt(i)), "");
        }
        return differentLetter;
    }

}