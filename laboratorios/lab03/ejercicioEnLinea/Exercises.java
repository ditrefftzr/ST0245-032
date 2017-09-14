import java.util.LinkedList;

public class Exercises{
    public static void keyboardDisorder(String input) {
	//O(3n), pero no se como expresarlo en el calculo...
        LinkedList<String> list = new LinkedList<>();

        boolean atFirst = true;
        int i = 0;
        while (i < input.length()) {

            if (!isBracket(input.charAt(i))) {
                StringBuilder sb = new StringBuilder();

                int j = i;
                while (j < input.length() && !isBracket(input.charAt(j))) {
                    sb.append(input.charAt(j));
                    j++;
                }

                if (atFirst) {
                    list.addFirst(sb.toString());
                } else {
                    list.addLast(sb.toString());
                }

                i = j;
            } else {
                atFirst = input.charAt(i) == '[';
                i++;
            }
        }

        list.forEach((str) -> {
            System.out.print(str);
        });

        System.out.println();
    }

    private static boolean isBracket(char o) {
        return o == '[' || o == ']';
    }

    public static void main(String[] args){
	keyboardDisorder("This_is_a_[Beiju]_text.");
	keyboardDisorder("hola[Mundo, ], qué[[[] tal?");
    }
}
