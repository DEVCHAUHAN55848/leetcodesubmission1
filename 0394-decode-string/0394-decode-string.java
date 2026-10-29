
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Formulate the multi-digit number k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and string onto stacks
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset for the inner content
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the multiplier and the parent string builder
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Repeat the inner content k times and append to the parent string
                while (repeatTimes > 0) {
                    decodedString.append(currentString);
                    repeatTimes--;
                }
                
                // Set currentString to the combined result
                currentString = decodedString;
            } else {
                // It's a normal character, append to the current working string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
