package algorithms;
import java.awt.Color;
import java.util.Random;

import view.SortArray;
public class SuffleArray extends Algorithm{
	
	public SuffleArray(SortArray sortArray) {
		// TODO Auto-generated constructor stub
		super(sortArray);
		
		for(int i=0; i<n; i++) {
			this.barColors[i] = Color.white;
		}
	}
	public void suffle() {
		Random random =new Random();
		for(int i=n-1; i>0 ;i--) {
			
			int j = random.nextInt(i+1);
			//System.out.println(j);
			try {
				this.sortArray.swap(i,j,0);   
				// thread to sleep 10 milliseconds
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}