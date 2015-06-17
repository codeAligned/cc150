lintcode space replacement

public void replaceSpaces(char[] str, int length) {
	int spaceCount = 0, len = 0;
	for(i=0; i<length; i++) {
		if(str[i]==' ')
			spaceCount++;
	}
	int newLength = length + spaceCount*2 - 1;
	for(int i=length-1; i>=0; i--) {
		if(str[i]==' ') {
			str[newLength] = '0';
			str[newLength-1] = '2';
			str[newLength-2] = '%';
			newLength-=3;
		}
		else {
			str[newLength] = str[i];
			newLength--;
		}
	}
}