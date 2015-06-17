Confirm if the anagram comparison is case sensitive and whitespace is significant. Here assume case sensitive and
whitespace is significant.

We just need to compare the sorted versions of the strings.
public String sort(String s) {
	char[] content = s.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
}

public boolean permutation(String s, String t) {
	if(s.length()!=t.length())
		return false;
	return sort(s).equals(sort(t));
}


Check if the two strings have identical character counts.
public boolean permutation(String s, String t) {
	if(s.length()!=t.length())
		return false;
	int[] letters = new int[256];
	char[] s_array = s.toCharArray();
	for(char c:s_array)
		letters[c]++;
	for(int i=0; i<t.length(); i++) {
		int c = (int)t.charAt(i);
		if(--letters[c]<0)
			return false;
	}
	return true;
}

Note the assumption for character set was ASCII