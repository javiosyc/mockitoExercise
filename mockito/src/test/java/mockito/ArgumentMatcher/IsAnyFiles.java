package mockito.ArgumentMatcher;

import java.io.File;

import org.mockito.ArgumentMatcher;

public class IsAnyFiles extends ArgumentMatcher<File> {

	@Override
	public boolean matches(Object file) {
		
		return file.getClass()==File.class;
	}

}
