package Silver;

import java.io.*;

public class Silver_4659 {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            boolean hasVowel = false;
            int seq = 1;
            boolean isValid = true;

            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);

                if (isVowel(cur)) hasVowel = true;

                if (i > 0) {
                    char prev = input.charAt(i - 1);
                    if (isSeq(prev, cur)) {
                        seq++;
                        if (seq >= 3) {
                            isValid = false;
                            break;
                        }
                    } else {
                        seq = 1;
                    }

                    if (isSame(prev, cur)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!hasVowel) isValid = false;

            if (isValid) {
                sb.append("<").append(input).append("> is acceptable.\n");
            } else {
                sb.append("<").append(input).append("> is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        for (char v : vowels) {
            if (v == c) return true;
        }
        return false;
    }

    static boolean isSeq(char prev, char cur) {
        return isVowel(prev) == isVowel(cur);
    }

    static boolean isSame(char prev, char cur) {
        if (prev == cur) {
            return !(cur == 'e' || cur == 'o');
        }
        return false;
    }
}
