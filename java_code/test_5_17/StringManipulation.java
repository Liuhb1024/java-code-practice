package test_5_17;
import java.util.ArrayList;
public class StringManipulation {
    public static void main(String[] args) {
        String str1 = "welcome to ctve";
        String str2 = "come";
        ArrayList<Character> arrList = new ArrayList<Character>();

        for(int i=0; i<str1.length(); i++) {
            char letter = str1.charAt(i);
            if(str2.indexOf(letter) == -1) {
                arrList.add(letter);
            }
        }

        for(char c : arrList) {
            System.out.print(c);
        }
    }
}
