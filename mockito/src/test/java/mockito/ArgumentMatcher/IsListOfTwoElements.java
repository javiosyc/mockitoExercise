package mockito.ArgumentMatcher;

import java.util.List;
import org.mockito.ArgumentMatcher;

public class IsListOfTwoElements extends ArgumentMatcher<List<String>>{
	
	public boolean matches(Object list) {
		       return ((List<?>) list).size() == 2;
		   }

}
