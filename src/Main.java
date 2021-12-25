import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringBuffer true_text = new StringBuffer();
        char orientation = 'P';
        String text = "o;pbrupi";

        char orientation2 = 'T';
        String text2 = "gwkkiwcwetibw";
        String recoverText = recoverText(orientation, text);
        String recoverText2 = recoverText(orientation2, text2);

        String text3 = "nguyen thi ngoc";
        String text4 = "nguyen thi thuy";
        String text5 = "nguyen xuan hoa";
        String swipe3 = countDistinctChar(text3);
        String swipe4 = countDistinctChar(text4);
        String swipe5 = countDistinctChar(text5);

        System.out.println("@@@@ swipe3 to : "+swipe3 +"   swipe4 = "+swipe4  +"   swipe5 = "+swipe5);

    }

    // task 1
    public static String recoverText(char orientation, String text) {

        StringBuffer true_text = new StringBuffer();
        char[][] character = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'}};


        for (int index = 0; index < text.length(); index++) {
            char true_char = ' ';
            char typed_char = text.charAt(index);

            outer:
            for (int row = 0; row < character.length; row++) {
                for (int column = 0; column < character[row].length; column++) {
                    char wrong_char = character[row][column];
                    if (typed_char == wrong_char && orientation == 'P') {
                        true_char = character[row][column - 1];
                        true_text.append(String.valueOf(true_char));
                        break outer;
                    }
                    if (typed_char == wrong_char && orientation == 'T') {
                        true_char = character[row][column + 1];
                        true_text.append(String.valueOf(true_char));
                        break outer;
                    }
                }
            }

        }

        System.out.println("true_text = " + true_text);
        return text;
    }

    // task 2
    public static String countDistinctChar(String text) {
        int countDistinctChar = 0;
        int length = text.length();
        char[] ch = new char[length];
        ch = text.toCharArray();

        Set<Character> set = new HashSet<>();

        for (int i = 0 ; i < ch.length; i++) {
            char value = ch[i];
            if (value != ' ') {
                set.add(value);
            }
        }

        int countlength = set.size();
        countDistinctChar = countlength;

        System.out.println("@@@@ countDistinctChar = "+countDistinctChar);


        if (countDistinctChar %2 ==0) {
            return "swipe right";
        } else {
            return "swipe left";
        }

    }

}
