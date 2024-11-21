package Stack.v1;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        long start = System.currentTimeMillis();
//        List<String> backtrackingGenerateParenthesis = backtrackingGenerateParenthesis(n);
        List<String> dynamicProgrammingGenerateParenthesis = dynamicProgrammingGenerateParenthesis(n);
//        List<String> bruteForceGenerateParenthesis = bruteForceGenerateParenthesis(n);
        long end = System.currentTimeMillis();
//        System.out.println(bruteForceGenerateParenthesis);
        System.out.println(dynamicProgrammingGenerateParenthesis.size());
        System.out.println(end - start);
    }

    public static List<String> bruteForceGenerateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        depthFirstSearch("", res, n);
        return res;
    }

//    Check every possible combination
    public static void depthFirstSearch(String parentheses, List<String> res, int n) {
        if (parentheses.length() == 2 * n) {
            if (areParenthesesValid(parentheses)) {
                res.add(parentheses);
            }
            return;
        }
        depthFirstSearch(parentheses + "(", res, n);
        depthFirstSearch(parentheses + ")", res, n);
    }

    public static boolean areParenthesesValid(String parentheses) {
        int open = 0;
        for (char c : parentheses.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) {
                return false;
            }
        }
        return open == 0;
    }

    public static List<String> backtrackingGenerateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtracking(0, 0, n, res, stack);
        return res;
    }

    public static void backtracking(int nOpen, int nClosed, int n, List<String> res, StringBuilder stack) {
        if (nOpen == nClosed && nOpen == n) {
            res.add(stack.toString());
            return;
        }
        if (nOpen < n) {
            stack.append("(");
            backtracking(nOpen + 1, nClosed, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (nClosed < nOpen) {
            stack.append(")");
            backtracking(nOpen, nClosed + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static List<String> dynamicProgrammingGenerateParenthesis(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }

        res.get(0).add("");

        for (int k = 0; k <= n; k++) {
//            System.out.printf("k = %s\n", k);
            for (int i = 0; i < k; i++) {
//                System.out.printf("i = %s\n", i);
                for (String left : res.get(i)) {
//                    System.out.printf("left = %s\n", left);
                    for (String right : res.get(k - i - 1)) {
//                        System.out.printf("right = %s\n", right);
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
//            System.out.println(res.get(k));
//            System.out.println();
        }

        return res.get(n);
    }

}
