package com.yx.datastructure;


import java.util.Stack;

public class RPN {
    /*计算逆波兰式（后缀表达式）的值
运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
例如：
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))) {
                stack.push(Integer.parseInt(tokens[i]));
            } else if (stack.size() > 1) {
                int second = stack.pop();
                int first = stack.pop();
                switch (tokens[i]) {
                    case "+": {
                        result = (first + second);
                        stack.push(result);
                        continue;
                    }
                    case "-": {
                        result = (first - second);
                        stack.push(result);
                        continue;
                    }
                    case "*": {
                        result = (first * second);
                        stack.push(result);
                        continue;
                    }
                    case "/": {
                        result = (first / second);
                        stack.push(result);
                        continue;
                    }
                    default:
                        return 0;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(RPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

}
