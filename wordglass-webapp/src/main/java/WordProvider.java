import java.util.ArrayList;
import java.util.List;

public class WordProvider {

	/**
	 * Return the lists of words
	 * @return
	 */
	public List<String> getWordlist() {
		return new ArrayList<String>() {
			{
				add("Utish");
				add("Sandesh");
				add("Binod");
			}
		};
	}
}
