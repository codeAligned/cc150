<<<<<<< HEAD
public int numZeros(int fac) {
	if(fac<0)
		return -1;
	int count = 0;
	for(int i=5; fac/i>0; i*=5)
	{
		count+=fac/i;
	}
	return count;
=======
public int numZeros(int fac) {
	if(fac<0)
		return -1;
	int count = 0;
	for(int i=5; fac/i>0; i*=5)
	{
		count+=fac/i;
	}
	return count;
>>>>>>> 231aada596112e7d62583bef1b008ea64f59cfb7
}