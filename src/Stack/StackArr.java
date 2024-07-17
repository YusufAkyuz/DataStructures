package Stack;

import java.util.Stack;

public class StackArr {
    private int top;
    private int[] arr;
    public StackArr(int capacity) {
        top = -1;
        arr = new int[capacity];
    }
    public StackArr() {
        top = -1;
        arr = new int [10];
    }
    private int length(){
        return arr.length;
    }
    private int size() {
        return top + 1;
    }
    private boolean isFull() {
        return arr.length == size();
    }
    private boolean isEmpty() {
        return top < 0;
    }
    private void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack is Full!");
        }
        top++;
        arr[top] = value;
    }
    private int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        int result = arr[top];
        top--;
        return result;
    }
    private int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return arr[top];
    }
    private void printElement() {
        while (!isEmpty()) {
            System.out.print(pop() + " --> ");
        }
        System.out.println("null");
    }

    private String reverseArr(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (char character : charArr) {
            stack.push(character);
        }
        for (int i = 0; i  < str.length() ; i++) {
            charArr[i] = stack.pop();
        }
        return new String(charArr);
    }

    private boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = expression.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;  // Kapalı parantez geldi, ancak stack boş
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;  // Parantezler eşleşmiyor
                }
            }
        }

        return stack.isEmpty();  // Stack boşsa, parantezler düzgün eşleşmiştir
    }

    public static void main(String[] args) {
        StackArr stack = new StackArr(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.printElement();

        stack.reverseArr("Yusuf");

        System.out.println();

        System.out.println(stack.isValidExpression("[[{}]]"));
    }
}
