String compressBetter(String str) {
	//Check if compression would create a longer string
	int size = countCompression(str);
	if(size>=str.length())
		return str;
}

StringBuffer mystr = new StringBuffer();
char last = str.charAt(0);
int count = 1;
for(int i=1; i<str.length(); i++) {
	if(str.charAt(i)==last)
		count++;
	else {
		mystr.append(last);
		mystr.append(count);
		last = str.charAt(i);
		count = 1;
	}
}

//deal with end repeated characters
mystr.append(last);
mystr.append(count);
return mystr.toString();

int countCompression(String str) {
	if(str==null || str.isEmpty())
		return 0;
	char last = str.charAt(0);
	int size = 0;
	int count = 1;
	//get length of a compression string
	for(int i=1; i<str.length(); i++) {
		if(str.charAt(i)==last)
			count++;
		else {
			last = str.charAt(i);
			size+=1+String.valueOf(count).length();
			count = 1;
		}
	}
	size+=1+String.valueOf(count).length();
	return size;
}

O(n) O(n)