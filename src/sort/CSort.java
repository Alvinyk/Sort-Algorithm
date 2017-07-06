package sort;

import java.util.Arrays;

/** 
* @author : 
* @version 创建时间：2017年7月6日 上午10:16:52 
* 类说明 
*/
public class CSort {

	private static final int n = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSort sort = new CSort();
		int[] A = new int[n];
		
		sort.initArray(A,n);
		System.out.println(Arrays.toString(A));
		
		sort.BubbleSort(A);
		
		System.out.println(Arrays.toString(A));
		
	}
	
	public void initArray(int[]A,int n)
	{
		for(int i = 0 ;i<n;i++)
		{
			A[i] = n-i;
		}
	}
	
	public void exchange(int[] A, int i,int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public void BubbleSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		
		for(int i = 0; i < n-1; i++)
		{
			for(int j=0; j < n-1-i; j++)
			{
				if(array[j] > array[j+1])
				{
					exchange(array,j,j+1);
				}
			}
		}
	}

	
}
