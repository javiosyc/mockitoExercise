package mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.LinkedList;

import mockito.ArgumentMatcher.IsAnyFiles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMockitoStub {

	public LinkedList<Object> list;
	@Before
	public void setup(){
		list = mock(LinkedList.class);
	
		//stubbing
		when(list.get(0)).thenReturn("Frist");
		
		when(list.get(1)).thenReturn("one");
		when(list.get(1)).thenReturn("two");
		
		when(list.get(2)).thenReturn("first").thenReturn("second");
		
		
		when(list.set(anyInt(),eq(1))).thenReturn("test");
		
		when(list.contains(anyString())).thenReturn(true);
		
		when(list.indexOf(argThat(new IsAnyFiles()))).thenReturn(9);
	}
	
	@Test
	public void testStubbing(){
		
		System.out.println("list.get(0)=====");		
		System.out.println(list.get(0));

		System.out.println("list.get(1)=====");		
		System.out.println(list.get(1));
		System.out.println(list.get(1));
		
		System.out.println("list.get(2)=====");		

		System.out.println(list.get(2));
		System.out.println(list.get(2));
		System.out.println(list.get(2));
		
				
		System.out.println("list.set(anyInt(),1)=====");		

		System.out.println(list.set(1,1));
		System.out.println(list.set(2,1));
		System.out.println(list.set(2, 3));

		System.out.println("list.contains(anyString())=====");		

		System.out.println(list.contains("1"));
		System.out.println(list.contains("2"));
		System.out.println(list.contains("3"));

		
		System.out.println("list.indexOf(isAnyFiles())=====");
		System.out.println(list.indexOf(new File("test")));
	}
	
}

