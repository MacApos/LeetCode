package Stack.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";
        String path2 = "/home/user/Documents/../Pictures";
        String path3 = "/.../a/../b/c/../d/./";
        String path4 = "/../";
        String path5 = "/a/../../b/../c//.//";

        String simplifyPath = simplifyPath(path5);
        System.out.println(simplifyPath);
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();

        for (String s : split) {
            if (s.equals("..")) {
                if (sb.lastIndexOf("/") >= 0) {
                    int length = sb.length();
                    sb.delete(sb.lastIndexOf("/"), length);
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                sb.append("/").append(s);
            }
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
