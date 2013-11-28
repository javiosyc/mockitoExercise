package mockito;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;


@RunWith(MockitoJUnitRunner.class)
public class TestMockito {

	public List<String> mockedList = null;
	@Before
	public void setup(){
		mockedList = mock(List.class);
		mockedList.add("once");
		
		mockedList.add("twice");
		mockedList.add("twice");
	}
	
	
	@Test
	public void testVerifyMethodCall(){
		
		verify(mockedList).add("once");
		verify(mockedList,atLeastOnce()).add("once");
		
		//verify(mockedList).clear();

	}
	
	@Test
	public void testVerifyMethodCallTimes(){
			
		verify(mockedList,times(1)).add("once");
		verify(mockedList,times(2)).add("twice");
		
		//verify(mockedList,times(2)).add("once");
	}
	
	@Test
	public void testVerifyMethodCallAtLeastTimes(){
			
		verify(mockedList,atLeast(1)).add("once");
		verify(mockedList,atLeast(1)).add("twice");
		verify(mockedList,atLeast(2)).add("twice");
			
		verify(mockedList,atLeastOnce()).add("once");
		
		//verify(mockedList,atLeast(3)).add("twice");
	}
	
	@Test
	public void testVerifyMethodCallAtMostTimes(){
	
		
		verify(mockedList,atMost(1)).add("once");		
		verify(mockedList,atMost(2)).add("twice");
		
		//verify(mockedList,atMost(1)).add("twice");
		
		
	}
	
	@Test
	public void testVerifyMethodCallNever(){
	
		verify(mockedList,never()).add("never");
		
		//verify(mockedList,never()).add("once");
	}
	
	
}
