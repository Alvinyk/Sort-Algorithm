package TestSort;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sort.CSort;

/** 
* @author : 
* @version 创建时间：2017年7月6日 上午10:18:57 
* 类说明 
*/
public class CSortTest {

	private final int n = 10;
	
	private int[] array = new int[n];
	private int[] arrEp = new int[n];
	private CSort sort = new CSort();
	
	@Before
	public void setUp() throws Exception {
		Random rand = new Random(47);
		
		Set<Integer> set = new HashSet<>();
		
		int i = 0;
		while(set.size() != n)
		{
			int num = rand.nextInt(n);
			if(set.contains(num) == false)
			{
				set.add(num);
				array[i++] = num;
			}
			
		}
		
		for(i = 0; i < n ;i++)
		{
			arrEp[i] = i;
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
	
	@Test
	public void testHeapSort()
	{
		sort.HeapSort(array);
		
		assertArrayEquals(arrEp,array);
	}
	
	@Test
	public void testQuickSort()
	{
		sort.QuickSort(array);
		
		assertArrayEquals(arrEp,array);
	}
}
