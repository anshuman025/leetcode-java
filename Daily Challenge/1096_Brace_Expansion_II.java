import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0).set;
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    static class Node {
        Set<String> set;
        int index;

        Node(Set<String> set, int index) {
            this.set = set;
            this.index = index;
        }
    }

    private Node parse(String s, int i) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {
            char c = s.charAt(i);

            if (c == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            } else if (c == '{') {
                Node node = parse(s, i + 1);
                current = multiply(current, node.set);
                i = node.index + 1;
            } else {
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(c));
                current = multiply(current, letter);
                i++;
            }
        }

        result.addAll(current);
        return new Node(result, i);
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}