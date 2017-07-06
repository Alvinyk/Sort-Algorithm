package sort;

import java.util.Arrays;

/** 
* @author : 
* @version 创建时间：2017年7月6日 上午10:16:52 
* 类说明 
*/
public class CSort {

	private static final int n = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSort sort = new CSort();
		int[] A = new int[n];
		for(int i = 0 ;i<n;i++)
		{
			A[i] = n-i;
		}
		

		System.out.println(Arrays.toString(A));
		
		//sort.BubbleSort(A);
		sort.MergeSort(A);
		System.out.println(Arrays.toString(A));
		
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

	public void DirectedBubbleSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		int left = 0; 
		int right = n-1;
		while(left < right)
		{
			for(int i = left;i<right;i++)
			{
				if(array[i] > array[i+1])
				{
					exchange(array,i,i+1);
				}
			}
			right--;
			
			for(int i = right; i>left;i--)
			{
				if(array[i] < array[i-1])
				{
					exchange(array,i,i-1);
				}
			}
			left++;
		}

	}

	public void InsertSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		
		for(int i = 1; i<n;i++)
		{
			int temp = array[i];
			int j = i - 1;
			while(j>=0 && array[j]>temp)
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
		
	}

	public void BinaryInsertSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		int left, right,middle,temp;
		
		for(int i = 1;i<n;i++)
		{
			temp = array[i];
			left = 0;
			right = i -1;
			while(left < right)
			{
				middle = (left + right)/2;
				if(array[middle] > temp)
				{
					right = middle -1;
				}else
				{
					left = middle + 1;
				}
			}
			
			for(int j = i;j>left;j--)
			{
				array[j] = array[j-1];
			}
			array[left] = temp;
		}
	}

	public void ShellSort(int[] array) {
		// TODO Auto-generated method stub	
		int n = array.length;
		int h = n / 2;
		int temp = 0;
		while(h > 0)
		{
			for(int i = h;i<n;i++)
			{
				int j = i - h;
				temp = array[i];
				while(j >=0 && array[j] > temp)
				{
					array[j+h] = array[j];
					j = j - h;
				}
				array[j+h] = temp;
			}
			
			h = h/2;
		}
	}

	public void MergeSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		
		mergeSort(array,0,n-1);
	}

	private void mergeSort(int[] A,int left,int right)
	{
		int middle = (left + right) / 2;
		if(left < right)
		{
			mergeSort(A,left,middle);
			mergeSort(A,middle+1,right);
			merge(A,left,middle,right);
		}
	}
	
	private void merge(int[] A,int left,int middle,int right)
	{
		int lenleft = middle - left + 1;
		int lenright = right - middle;
		
		int[] LA = new int[lenleft]; 
		System.arraycopy(A, left, LA, 0, lenleft);;
		int[] RA = new int[lenright];
		System.arraycopy(A, middle+1, RA, 0, lenright);
		
		int i = 0,j = 0,k = left;
		while(i<lenleft && j <lenright)
		{
			if(LA[i] <= RA[j])
			{
				A[k] = LA[i];
				i++;
			}else
			{
				A[k] = RA[j];
				j++;
			}
			k++;
		}
		
		if(i < lenleft)
		{
			System.arraycopy(LA, i, A, k, lenleft - i);
		}
		
		if(j < lenright)
		{
			System.arraycopy(RA, j, A, k, lenright - j);
		}
		
	}
	
}
