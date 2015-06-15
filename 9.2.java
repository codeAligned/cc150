Write a method to sort an array of strings so that all the anagrams are next to each other

public class AnagramComparator implements Comparator<String> {
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Array.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2)); //compareToIgnoreCase
	}
}
Array.sort(array, new AnagramComparator());

O(nlogn)


Note: 这题扩展看leetcode anagram

String to char[]: s.toCharArray()
char[] to String: new String(char[]) or String.valueOf(char[])


We can use a hash table which maps from the sorted version of a word to a list of its anagrams. Once we have grouped all the words
into these lists by anagram, we can then put them back into the array

public void sort(String[] array) {
	Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

	/* Group words by anagram */
	for(String s : array) {
		String key = sortChars(s);
		if(!hash.containsKey(key))
			hash.put(key, new LinkedList<String>());
		LinkedList<String> anagrams = hash.get(key);
		anagrams.push(s);
	}

	/*Convert hash table to array */
	int index = 0;
	for(String key : hash.keySet()) {
		LinkedList<String> list = hash.get(key);
		for(String t : list) {
			array[index] = t;
			index++;
		}
	}
}

this algorithm is a modification of bucket sort