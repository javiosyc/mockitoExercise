package mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMockitoThrowException {

	@Mock
	public List<String> list;

	public List<String> list2;
	@Before
	public void setup() {
		list2 = mock(ArrayList.class);

		doThrow(new RuntimeException("Test")).when(list).clear();
	}

	@Test
	public void testThrowsException() {

		System.out.println(list.getClass());
		System.out.println(list2.getClass());
		try {
			list.clear();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
