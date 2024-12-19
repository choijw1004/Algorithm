package Leet_71_SimplifyPath;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {

        int pathLen = path.length();

        Stack stack = new Stack();


        /*
        조건 1. .
        조건 2. ..
        조건 3. ...
        조건 4. startWith /
        조건 5. notEndWith /

         */
        for(int i = 0 ; i < pathLen; i++){
            char c = path.charAt(i);

            //조건 4.
            if(i == 0 && c == '/'){
                stack.push(c);
            }
            else{
                if(c == '/')
            }




        }

    }
}