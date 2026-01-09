package Leet_71_SimplifyPath;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        StringBuilder returnString = new StringBuilder();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        for (String string : stack) {
            returnString.append("/").append(string);
        }

        return returnString.length() > 0 ? returnString.toString() : "/";
    }
}
