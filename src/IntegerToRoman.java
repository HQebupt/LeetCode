    /**
     * 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
     * 这道题比较简单，只要搞清楚每个数字在每个位置应该如何表示就可以，
     * 罗马数字对于每个位有三个单位：1,5,10，
     * 对于1到9，表示方法如下：
     * 1-3：用1表示； 
     * 4：5左边加一个1； 
     * 5： 直接用5表示； 
     * 6-8 : 5右边加相应的1；
     * 9： 10左边加一个1。
     * 
     * @param num
     * @return
     */
public class IntegerToRoman {
    private static final String[] R = { "M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};       
    private static final int[] V = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 }; 

    public String intToRoman(int num) {
	String result = "";
	for (int i = 0; num > 0; i++) {
	    int count = num / V[i];
	    num %= V[i];
	    while (count > 0) {
		result += R[i];
		count--;
	    }
	}
	return result;
    }
    
    public static void main(String[] args) {
	IntegerToRoman sol = new IntegerToRoman();
	int num = 1437;
	System.out.println(sol.intToRoman(num));
    }
}