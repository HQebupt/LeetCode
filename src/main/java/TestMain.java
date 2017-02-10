import java.util.*;
/**
 * 在线测试题目给定的一种模板，类名是Main，在main函数里面写code.
 * @author HuangQiang
 * @date 2015-10-25上午09:40:11
 * @file TestMain.java
 */
public class TestMain {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// get a integer
		int a = sc.nextInt();
		// get two integers separated with half-width break
		int b = sc.nextInt();
		int c = sc.nextInt();
		// get a string
		String s = sc.next();
		
		// output
		System.out.println((a+b+c) + " " + s);
	}
}