import java.util.ArrayList;
import java.util.List;
/**
 * ��������NλԪ�ĸ����롣ͨ����������ת������Ĺ��ɹ�ʽ��
 * G�������� B����������  , G(N) = (B(n)>>1) XOR B(n)
 * ��λ����+�������
 *
 */
public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>(n);
		int pow = (int) Math.pow(2, n);
		for (int binary = 0; binary < pow; binary++) {
			int grayCode = (binary >> 1) ^ binary;
			list.add(grayCode);
		}
		return list;
	}

	public static void main(String[] args) {
		GrayCode sol = new GrayCode();
		int n = 2;
		System.out.println(sol.grayCode(n));
	}

}
