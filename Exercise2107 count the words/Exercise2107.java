import java.util.*;

public class Exercise2107 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a Map to hold words as keys and count as values
		Map<String, Integer> map = new HashMap<>();

		// Compute and store the occurrence of each word
		String[] words = text.split("[ \n\t\r.,;:!?()]");
		for (String word: words) {
			String key = word.toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Create an ArrayList
		ArrayList<WordOccurrence> list = new ArrayList<>();
		
		// Store the key and value from each entry in the list
		for (Map.Entry<String, Integer> entry: map.entrySet())
			list.add(new WordOccurrence(entry.getKey(), entry.getValue()));

		// Sort the list
		Collections.sort(list);

		// Display the sorted list
		System.out.println(list);
	}
}

class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	Integer count;
	
	/** Construct an instance WordOccurrence 
	  * with specified word and count */
	public WordOccurrence(String word, int count){
		this.word = word;
		this.count = count;
	}
	
	@Override /** Override the compareTo method in the Comparable class */
	public int compareTo(WordOccurrence o) {
		return o.count.compareTo(count);
	}
	
	@Override /** Override the toString method in the */
	public String toString() {
		return word + "=" + count;
	}
}