import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != '(') {
                ans.append(s.charAt(i));
                i++;
            } else {
                int start = i + 1;

                while (s.charAt(i) != ')') {
                    i++;
                }

                String key = s.substring(start, i);

                String value = "?";

                for (int j = 0; j < knowledge.size(); j++) {
                    if (knowledge.get(j).get(0).equals(key)) {
                        value = knowledge.get(j).get(1);
                        break;
                    }
                }

                ans.append(value);
                i++;
            }
        }

        return ans.toString();
    }
}
