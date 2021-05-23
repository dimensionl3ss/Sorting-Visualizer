package algorithms;

import java.awt.Color;

import view.SortArray;

public class SelectionSort extends Algorithm{
	
	public SelectionSort(SortArray sortArray) {
		// TODO Auto-generated constructor stub
		super(sortArray);
	}
	public void sort() throws InterruptedException {
		for(int i=0; i<n; i++) {
			int minIndex = i;
			for(int j = i+1; j<n; j++) {
				
				if(arr[j] < arr[minIndex]) {
					 
					minIndex = j;
					
				}
				 
			}
			this.barColors[i] = Color.blue; 
			this.barColors[minIndex] = Color.red;
			//Thread.sleep(100);
			this.sortArray.swap(minIndex, i, DEFAULT_SLEEPING_TIME*5);
			this.barColors[minIndex] = Color.white;
			this.barColors[i] = new Color(153,153,255); 
		}
	}
}
