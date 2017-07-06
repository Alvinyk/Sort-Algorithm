package TestSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sort.CSort;

/** 
* @author : 
* @version ����ʱ�䣺2017��7��6�� ����10:18:57 
* ��˵�� 
*/
public class CSortTest {

	CSort sort = new CSort();
	private int[] array = null;
	private int[] arrEp = null;
	private final int n = 100;
	
	@Before
	public void setUp() throws Exception {
		
		array = new int[n];
		arrEp = new int[n];
		
		for(int i = 0; i < n ;i++)
		{
			array[i] = n-i;
			arrEp[i] = i+1;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBubbleSort() {
		sort.BubbleSort(array);
		
		assertArrayEquals(arrEp,array);
	}
	@Test
	public void testDirectedBubbleSort()
	{
		sort.DirectedBubbleSort(array);
		
		assertArrayEquals(arrEp,array);
	}

}
