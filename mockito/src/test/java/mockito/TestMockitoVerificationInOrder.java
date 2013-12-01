package mockito;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoVerificationInOrder {

	public List<String> mockedList = null;

	public List<String> mockedSecondList = null;
	@Before
	public void setUp() {
		mockedList = mock(ArrayList.class);
		
		mockedList.add("add second");
		mockedList.add("add first");
		mockedList.add("add second");
	}
	
	
	@Test
	public void testSingleMockInOrder() {
		
		InOrder inOrder = inOrder(mockedList);
		
		inOrder.verify(mockedList).add("add first");
		inOrder.verify(mockedList).add("add second");
	}
	
	@Test
	public void testSingleMockInOrder2() {
		
		InOrder inOrder = inOrder(mockedList);
		inOrder.verify(mockedList).add("add second");
		inOrder.verify(mockedList).add("add first");
		inOrder.verify(mockedList).add("add second");
	}
	
	@Test
	public void testSingleMockInOrder3() {
		
		InOrder inOrder = inOrder(mockedList);
		
		inOrder.verify(mockedList).add("add second");
		inOrder.verify(mockedList).add("add first");
		
	}
}
