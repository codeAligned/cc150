Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

If it werent for the empty strings, we can simply use binary search.
With empty strings interspersed, all we need to do is fix the comparison against mid, in case mid is an empty string. we
simply move mid to the closest non-empty string.


Recursive:
public int search(String[] strings, String str) {
	if(strings==null || str==null || str=="")
		return -1;
	return searchR(strings, str, 0, strings.length-1);
}

public int searchR(String[] strings, String str, int first, int last) {
	if(first>last)
		return -1;
	int mid = (first+last)/2;
	
	/* if mid is empty, find closest non-empty string */
	if(strings[mid].isEmpty()) {
		int left = mid - 1, right = mid + 1;
		while(true) {
			if(left<first && right>last)
				return -1;
			else if(right<=last && !strings[right].isEmpty()) {
				mid = right;
				break;
			} else if(left>=first && !strings[left].isEmpty()) {
				mid = left;
				break;
			}
			right++;
			left--;
		}
	}

	/* Check for string, and recurse if necessary */
	if(str.equals(string[mid]))
		return mid;
	else if(strings[mid].compareTo(str)<0)
		return searchR(strings, str, mid+1, last);
	else
		return searchR(strings, str, first, mid-1);
}


Non-Recursive:
public int search(String[] strings, String str, int left, int right) {
	if(strings==null || strings.length==0 || str==null || str.length()==0)
		return -1;
	if(str.equals(""))					//注意处理str==""的情况
	{
		for(int i=0; i<strings.length; i++)
		{
			if(strings[i].equals(""))
				return i;
		}
		return -1;
	}

	while(left<=right)
	{
		while(left<=right && strings[right].equals("")) //or strings[right].isEmpty()
			right--;
		if(left<right)
			return -1;
		int mid = (left+right)/2;
		while(strings[mid]=="")
			mid++;
		int compareRes = strings[mid].compareTo(str);	//字符串这么比较比较好操作
		if(compareRes==0)
			return mid;
		else if(compareRes<0)
			left = mid + 1;
		else
			right = mid - 1;
	}
	return -1;
}

Note: 二分法变体 对字符串的操作 熟练


Careful consideration should be given to the situation when search for empty string