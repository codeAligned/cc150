Assume charset is ASCII (remember to mention that!)

public boolean isUniqueChars(String str) {
	if(str.length()>356)
		return false;
	boolean[] char_set = new boolean[256];
	for(int i=0; i<str.length(); i++) {
		int val = str.charAt(i);
		if(char_set[val])
			return false;
		char_set[val] = true;
	}
	return true;
}	

O(n) O(1)

We can reduce our space usage by a factor of eight by using a bit vector. We will assume,
that the string only uses the lower case letters a through z. This will allow us to use just a single int.
public boolean isUniqueChars(String str) {
	int checker = 0;
	for(int i=0; i<str.length(); i++) {
		int val = str.charAt(i) - 'a';
		if((checker & (1<<val))>0)
			return false;
		checker |= (1<<val);
	}
	return true;
}




public boolean isUniqueChars(String str) {
	HashSet<Character> set = new HashSet<Character>();
	for (int i=0; i<str.length(); i++)
	{
		if(set.contains(str.charAt(i)))
			return false;
		else
			set.add(str.charAt(i));
	}
	return true;
}

Note: O(n), O(n)

2. we can also use brute force O(n^2), O(1)

3. we can sort the string in O(nlogn) and then linearly check the string for duplicates. Careful for some sorting algorithms take up extra space