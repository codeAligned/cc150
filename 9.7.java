Circus. Given heights and weights of each person, find largest possible number of people in such a tower

Sort the list of people by their heights, and then apply the LongestIncreasingSubsequence algorithm on their weights


public List<HtWt> getIncreasingSequence(List<HtWt> items) {
	Collections.sort(items);
	return longestIncreasingSubsequence(items);
}

public void List<HtWt> longestIncreasingSubsequence(List<HtWt> array) {
	List<HtWt>[] solutions = new ArrayList[array.size()];
	longestIncreasingSubsequence(array, solutions, 0);

	List<HtWt> best_sequence = null;
	for(int i=0; i<array.size(); i++)
		best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
	return best_sequence;
}

public void longestIncreasingSubsequence(List<HtWt> array, List<HtWt>[] solutions, int current_index) {
	if(current_index>=array.size() || current_index<0)
		return;
	HtWt current_element = array.get(current_index);

	//Find longest sequence we can append current_element to
	List<HtWt> best_sequence = null;
	for(int i=0; i<current_index; i++) {
		if(array.get(i).isBefore(current_element)) {
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}
	}

	//Append current_element
	List<HtWt> new_solution = new ArrayList<HtWt>();
	if(best_sequence!=null)
		new_solution.addAll(best_sequence);
	new_solution.add(current_element);

	//Add to list and recurse
	solutions[current_index] = new_solution;
	longestIncreasingSubsequence(array, solutions, current_index+1);
}

public void List<HtWt> seqWithMaxLength(List<HtWt> seq1, List<HtWt> seq2) {
	if(seq1==null)
		return seq2;
	if(seq2==null)
		return seq1;
	return seq1.size()>seq2.size()?seq1:seq2;
}


public class HtWt implements Comparable {
	public int compareTo(Object s) {
		HtWt second = (HtWt)s;
		if(this.Ht!=second.Ht)
			return ((Integer)this.Ht).compareTo(second.Ht);
		else
			return ((Integer)this.Wt).compareTo(second.Wt);
	}
}


public boolean isBefore(HtWt other) {
	if(this.Ht < other.Ht && this.Wt < other.Wt)
		return true;
	return false;
}

O(n^2)