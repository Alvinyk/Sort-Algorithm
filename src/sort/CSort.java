package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/** 
* @author : 
* @version 创建时间：2017年7月6日 上午10:16:52 
* 类说明 
*/
public class CSort {

	private static final int n =10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSort sort = new CSort();
		int[] A = new int[n];
		int i = 0;
		Random rand = new Random(47);
		
		Set<Integer> set = new HashSet<>();
		while(set.size() != n)
		{
			int num = rand.nextInt(n);
			if(set.contains(num) == false)
			{
				set.add(num);
				A[i++] = num;
			}
			
		}
		
		System.out.println(Arrays.toString(A));
		
		//sort.BubbleSort(A);
		//sort.MergeSort(A);
		//sort.HeapSort(A);
		//sort.QuickSort(A);
		sort.BinaryInsertSort(A);
		System.out.println(Arrays.toString(A));
		
	}
	

	
	private void Swap(int[] A, int i,int j)
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
					Swap(array,j,j+1);
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
					Swap(array,i,i+1);
				}
			}
			right--;
			
			for(int i = right; i>left;i--)
			{
				if(array[i] < array[i-1])
				{
					Swap(array,i,i-1);
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
			right = i-1;
			while(left <= right)
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



	public void HeapSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		
		//构造堆结构
		for(int i = n/2-1;i>=0;i--)
		{
			MaxHeapFixDown(array,i,n);
		}
		//排序
		for(int i = n-1;i>0;i--)
		{
			Swap(array,0,i);
			MaxHeapFixDown(array,0,i);
		}
	}
	
	private void MaxHeapFixDown(int[] A,int i,int n)
	{
		int j = i*2 + 1;
		int temp = A[i];
		
		while(j < n)
		{
			if(j+1 < n && A[j+1] > A[j])
				j++;
			
			if(A[j] <= temp)
				break;
			
			A[i] = A[j];
			i = j;
			j = i*2 +1;
		}
		
		A[i] = temp;
		
	}



	public void QuickSort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		
		quick(array,0,n-1);
	}
	
	private void quick(int[]A,int left,int right)
	{
		int index = 0;
		if(left < right)
		{
			index = partition(A,left,right);
			
			quick(A,left,index-1);
			
			quick(A,index+1,right);
		}
	}
	
	private int partition(int[] A,int left,int right)
	{
		int index = left -1;
		int part = A[right];
		
		for(int i = left;i<right;i++)
		{
			if(A[i] <= part)
			{
				index++;
				Swap(A,index,i);
			}
		}
		
		index++;
		Swap(A,index,right);
		
		return index;
	}
}
