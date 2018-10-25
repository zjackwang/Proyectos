import java.util.*;

public class SortByCard implements Comparator<Card> {
	
	public int compare(Card a, Card b){
		
		return a.compareTo(b);
	}
}
