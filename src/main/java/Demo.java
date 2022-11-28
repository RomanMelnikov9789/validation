import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        System.out.println(validation(str));

    }

    public static Object validation(String str) {
        char[] strChars = str.toCharArray();
        Character[] result = new Character[strChars.length];
        int count = 0;
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] == '(') {
                for (int j = i + 1; j < strChars.length; j++) {
                    if (strChars[j] == ')') {
                        result[i] = strChars[i];
                        result[j] = strChars[j];
                        strChars[i] = '0';
                        strChars[j] = '0';
                        count++;
                        break;
                    }
                }
            }
        }
        List<Character> list = new ArrayList<>(Arrays.asList(result));
        list.removeAll(Collections.singleton(null));
        if (count > 0) {
            return count * 2 + " - " + "\"" + list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("")) + "\"";
        } else return count;
    }

}
