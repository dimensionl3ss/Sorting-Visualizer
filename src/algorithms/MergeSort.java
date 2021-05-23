package algorithms;

import java.awt.Color;

import view.SortArray;

public class MergeSort extends Algorithm {
	public MergeSort(SortArray sortArray) {
		// TODO Auto-generated constructor stub
		super(sortArray);
	}
	public void sort() throws InterruptedException {
		mergeSort(0, n-1);
	}
	 void merge(int l, int m, int r) throws InterruptedException
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	 
	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        
	        for (int j = 0; j < n2; ++j)
	            R[j] = arr[m + 1 + j];
	        
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2) {
	        	
	            if (L[i] <= R[j]) {
	            	
	                //arr[k] = L[i];
	         
	                this.sortArray.setValue(k, L[i], DEFAULT_SLEEPING_TIME);
	                //this.barColors[k] = new Color(153, 153, 255);
	                i++;
	                
	            }
	            else {
	            	
	                //arr[k] = R[j];
	            	
	                this.sortArray.setValue(k, R[j], DEFAULT_SLEEPING_TIME);
	                //this.barColors[k] = new Color(153, 153, 255);
	                j++;
	                
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) {
	        	
	            //arr[k] = L[i];
	        	
	            this.sortArray.setValue(k, L[i], DEFAULT_SLEEPING_TIME);
	            //this.barColors[k] = new Color(153, 153, 255);
	            
	            i++;
	            k++;
	            
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) {
	        	
	            //arr[k] = R[j];
	        	
	            this.sortArray.setValue(k, R[j], DEFAULT_SLEEPING_TIME);
	            //this.barColors[k] = new Color(153, 153, 255);
	            j++;
	            k++;
	            
	        }
	    }
	    void mergeSort(int l, int r) throws InterruptedException
	    {
	        if (l < r) {
	           
	            int m =l+ (r-l)/2;
	            
	            mergeSort(l, m);
	            mergeSort(m + 1, r);
	            this.barColors[m] = Color.red;
	            merge(l, m, r);
	            for(int i=l; i<=m; i++) this.barColors[i] = new Color(153, 153, 255);
	            
	            for(int i=m+1; i<=r; i++) this.barColors[i] = new Color(153, 153, 255);
	            //for(int i= m+1; i<=r; i++)
	        }
	    }
}