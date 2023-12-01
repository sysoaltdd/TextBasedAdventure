
/**
 * 判断输入的是否是数字，返回boolean
 */

public class CustomMethod {
	
	public static boolean isDigit(String input) {
		 
        // null or length < 0, return false.
        if (input == null || input.length() < 0)
            return false;
 
        // empty, return false
        input = input.trim();
        if ("".equals(input))
            return false;
 
        if (input.startsWith("-")) {
            // negative number in string, cut the first char
            return input.substring(1).matches("[1-9]*");
        } else {
            // positive number, good, just check
            return input.matches("[1-9]*");
        }
 
    }
	
}
