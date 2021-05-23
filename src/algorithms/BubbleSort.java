package algorithms;

import java.awt.Color;

import view.SortArray;

public class BubbleSort extends Algorithm{
	
	public BubbleSort(SortArray sortArray) {
		// TODO Auto-generated constructor stub
		super(sortArray);
		
	}
	public void sort() throws InterruptedException {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i-1; j++) {
				
				this.barColors[j] = Color.red;
				this.barColors[j+1] = Color.BLUE;
				//Thread.sleep(DEFAULT_SLEEPING_TIME);
				if(arr[j] > arr[j+1]) {
					this.sortArray.swap(j, j+1, DEFAULT_SLEEPING_TIME);
				}
				this.barColors[j] = Color.white;
				this.barColors[j+1] = Color.white;
				
			}
			this.barColors[n-i-1] = new Color(153, 153, 255);
		}
		
	}
	
}
