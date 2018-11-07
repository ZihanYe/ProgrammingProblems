// add too really big integers, inputted as strings
// source: https://www.careercup.com/question?id=5733573234524160

class AddBigInteger {
	public static String add(String a, String b){
		String ra = "0" + a;
		String rb = "0" + b;
		String res = "";
		int carry = 0;
		int i = ra.length() -1;
		int j = rb.length() -1;
		while (i >= 0 && j >= 0){
			int da = ra.charAt(i) - '0';
			int db = rb.charAt(j) - '0';
			if (da + db + carry> 9) {
				res = new Integer(da + db + carry -10).toString() + res;
				carry = 1;
			} else {
				res = new Integer(da + db+ carry).toString() + res;
				carry = 0;
			}
			i--;
			j--;
		}
		if (i > 0) res = ra.substring(0,i+1) + res;
		if (j > 0) res = rb.substring(0, j+1) + res;
		if (res.charAt(0) == '0') res = res.substring(1,res.length());
		return res;
	}
	
	public static void main(String[] args) {
		String sum = add(args[0], args[1]);
		System.out.println(sum);
	}
}
		
