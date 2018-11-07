// source: https://www.careercup.com/question?id=5222410521935872

import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class SpecialEquivalent {
	public static int countUnique(String[] strs){
		Set<String> out = new HashSet<>();
		for (String st : strs) {
			List<Character> evens = new ArrayList<>();
			List<Character> odds = new ArrayList<>();
			for (int i =0; i<st.length(); i = i+2){
				if (i %2 == 0) evens.add(st.charAt(i));
				else odds.add(st.charAt(i));
			}
			Collections.sort(evens);
			Collections.sort(odds);

			StringBuilder builder = new StringBuilder(st.length());
		    for(Character ch: evens)
		        builder.append(ch);
		    for(Character ch: odds)
		        builder.append(ch);
		    out.add(builder.toString());
		}
		return out.size();
	}

	public static void main(String[] args) {
		String[] ss = new String[] {
			"abcd", "acbd", "adcb", "cdba", "bcda", "badc"
		};
		int count = countUnique(ss);
		System.out.println(count);
	}

}
