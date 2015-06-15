<<<<<<< HEAD
public boolean isAnagram(String s1, String s2) {
	return Arrays.sort(s1.toCharArray())==Arrays.sort(s2.toCharArray());
}


public boolean isAnagram(String s1, String s2) {
	if(s=="" || t=="")
		return false;
	if(s1.length()!=s2.length())
		return false;

	int[] check = new int[256];
	for(int i=0; i<s1.length(); i++)
	{
		check[(int)(s1.charAt[i])]++;
		check[(int)(s2.charAt[i])]--;
	}

	for(int i=0; i<256; i++)
		if(check[i]!=0)
			return false;
	return true;
}

=======
public boolean isAnagram(String s1, String s2) {
	return Arrays.sort(s1.toCharArray())==Arrays.sort(s2.toCharArray());
}


public boolean isAnagram(String s1, String s2) {
	if(s=="" || t=="")
		return false;
	if(s1.length()!=s2.length())
		return false;

	int[] check = new int[256];
	for(int i=0; i<s1.length(); i++)
	{
		check[(int)(s1.charAt[i])]++;
		check[(int)(s2.charAt[i])]--;
	}

	for(int i=0; i<256; i++)
		if(check[i]!=0)
			return false;
	return true;
}

>>>>>>> 231aada596112e7d62583bef1b008ea64f59cfb7
Note: 第二种解法很妙