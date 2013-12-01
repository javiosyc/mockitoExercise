package mockito;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.argThat;

import java.util.Arrays;
import java.util.List;

import mockito.ArgumentMatcher.IsListOfTwoElements;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestMockitoVerify {

	public List<String> mockedList = null;
	@Before
	public void setup(){
		mockedList = mock(List.class);
		mockedList.add("once");
		
		mockedList.add("twice");
		mockedList.add("twice");
		
		mockedList.addAll(Arrays.asList("one", "two"));
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
	
	@Test
	public void testVerifyAddListOfTwoElements(){
		
		verify(mockedList).addAll(argThat(new IsListOfTwoElements()));
		
	}
}
