// leetCode 752. open the lock
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
	public static int openLock(String[] deadends, String target) {
		Set<String> set = new HashSet<>(Arrays.asList(deadends));
        	int[] dst = new int[10000];
		Arrays.fill(dst, Integer.MAX_VALUE);
		dst[0] = 0;
		Set<Integer> nodes = new HashSet<Integer>();
		for (int i=0; i<10000; i++) nodes.add(i);
		while (!nodes.isEmpty()){
			Integer u = findMinDist(nodes, dst);
			if (u < 0) break;
			nodes.remove(u);
			String s = intToString(u);
			if (s.equals(target)) return dst[u];
			if (set.contains(s)) continue;
			List<Integer> ns = neighbors(u);
			int cur = dst[u];
			for (Integer n : ns) {
				if (dst[n] > cur+1) dst[n] = cur +1; 
			}

		}
		return -1;	
	}
	
	private static Integer findMinDist(Set<Integer> nodes, int[] dst) {
		Integer min = -1;
		int mindst = Integer.MAX_VALUE;
		for (Integer i: nodes) {
			if (dst[i] < mindst){
				mindst = dst[i];
				min = i;
			}
		}
		return min;
	}

	private static String intToString(Integer a) {
		String s = a.toString();
		String ss = "";
		for (int i=0; i<4-s.length(); i++)
			ss += "0";
		ss += s;
		return ss;
	}

	private static List<Integer> neighbors(Integer a) {
		String s = intToString(a);
		List<Integer> ns = new ArrayList<>();
		for (int i= 0; i<4; i++) {
			char[] chs = s.toCharArray();
			char ch = chs[i];
			chs[i] =(char) (((ch - '0')+1) % 10 + '0');
			String news = new String(chs);
			ns.add(Integer.parseInt(news));

			chs[i] = (char) (Math.floorMod((ch - '0')-1, 10) + '0');
			news = new String(chs);
			ns.add(Integer.parseInt(news));
		}
		return ns;
	}
	
	public static void main(String[] args){
		String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
		String target = "0202";
		int res = openLock(deadends, target);
		System.out.println(res);
	}	
}
