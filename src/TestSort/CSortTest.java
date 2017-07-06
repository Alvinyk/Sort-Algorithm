package TestSort;

import static org.junit.Assert.*;

import java.util.Arrays;

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

	private final int n = 1000;
	
	private int[] array = new int[n];
	private int[] arrEp = new int[n];
	private CSort sort = new CSort();
	
	@Before
	public void setUp() throws Exception {
		
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

	@Test
	public void testInsertSort()
	{
		sort.InsertSort(array);
		
		assertArrayEquals(arrEp,array);
	}
	
	@Test
	public void testBinaryInsertSort()
	{
		sort.BinaryInsertSort(array);
		
		assertArrayEquals(arrEp,array);
	}
	
	@Test
	public void testShellSort()
	{
		
		sort.ShellSort(array);
		
		assertArrayEquals(arrEp,array);
	}
	
	@Test
	public void testMergeSort()
	{
		sort.MergeSort(array);
		
		assertArrayEquals(arrEp,array);
	}
}
