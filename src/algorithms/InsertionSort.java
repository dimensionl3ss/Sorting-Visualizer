package algorithms;

import java.awt.Color;

import view.SortArray;

public class InsertionSort extends Algorithm{
	
	public InsertionSort(SortArray sortArray) {
		super(sortArray);
	}
	public void sort() throws InterruptedException
    {
        for (int i = 1; i < n; ++i) {
        	
        	int key = arr[i];
            int j = i -1;
            this.barColors[i] = Color.red;
            
            while (j >= 0 && arr[j] > key) {
            	
            	this.sortArray.barColors[j] = Color.red;
            	
            		this.sortArray.swap(j, j+1, DEFAULT_SLEEPING_TIME);
            	this.sortArray.barColors[j] = new Color(153, 153, 255);
            	this.barColors[j+1] = new Color(153, 153, 255);
            	j--;	
            }
            this.barColors[i-1] = new Color(153, 153, 255);
        }
    }
}
