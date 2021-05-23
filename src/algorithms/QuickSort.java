package algorithms;

import java.awt.Color;

import view.SortArray;

public class QuickSort extends Algorithm{

	public QuickSort(SortArray sortArray) {
		super(sortArray);
	}
	public void sort() throws InterruptedException {
		quickSort(0, n-1);
	}
	void quickSort(int l, int r) throws InterruptedException {
		
		if( l <= r) {
			int p = partition(l, r);
			quickSort(l , p-1);
			for(int i=l; i<p; i++) this.barColors[i] = new Color(153,153,255);
			quickSort(p+1, r);
		}
		
	}
	int partition(int l, int r) throws InterruptedException 
	{
		int pivot  = arr[r]; // last element as pivot element
		this.barColors[r] = Color.red;   //color of pivot
		
		int i = l-1;
		for(int j = l; j <= r-1; j++ ) {
			
			this.barColors[j] = Color.blue;  //traversing color
			Thread.sleep(DEFAULT_SLEEPING_TIME);  //sleep
			if(arr[j] < pivot) {
				
				i++;
				this.sortArray.swap(i, j, DEFAULT_SLEEPING_TIME);
				this.barColors[i] = Color.orange;    // left side of pivot element
				if(i != j) this.barColors[j] = Color.pink;
				//Thread.sleep(100);
			}
			else {
				
				this.barColors[j] = Color.pink;   // right side of pivot element
			}
		}
		i++;
		this.sortArray.swap(i,r,DEFAULT_SLEEPING_TIME*3);   
		this.barColors[r] = Color.pink;
		this.barColors[i]= new Color(153,153,255);   // sorted bar
		return i;
		
	}
}
