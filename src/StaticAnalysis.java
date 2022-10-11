import java.util.ArrayList;
import java.util.List;

public class StaticAnalysis {

    private static final int size = 25;

    public int bruteForce(String txtToDecode, String exampleTxt) {
        int key = 0;

        List<String> listTextToDecode = findThreeLettersWord(txtToDecode);
        List<String> listTextExample = findThreeLettersWord(exampleTxt);

        for (String word : listTextToDecode) {
            for (String wordEx : listTextExample) {
                int numb1 = word.charAt(0) - wordEx.charAt(0);
                if (numb1 < 0) {
                    numb1 += size;
                }
                int numb2 = word.charAt(1) - wordEx.charAt(1);
                if (numb2 < 0) {
                    numb2 += size;
                }
                int numb3 = word.charAt(2) - wordEx.charAt(2);
                if (numb3 < 0) {
                    numb3 += size;
                }
                if (numb1 == numb2 && numb1 == numb3) {
                    key = numb1;
                    break;
                }
            }
        }
        return key;
    }
    public static List<String> findThreeLettersWord(String text) {
        String delimeter = " ";
        String[] subStrTemp = text.split(delimeter);
        List<String> threeLettersList = new ArrayList<>();
        for (String s : subStrTemp) {
            if (s.length() == 3) {
                threeLettersList.add(s);
            }
        }
        return threeLettersList;
    }
}
