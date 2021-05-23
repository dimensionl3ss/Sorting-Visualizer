package algorithms;

import java.awt.Color;
import view.SortArray;

public class Algorithm {
	protected int arr[] = null;
	protected int n;
	protected SortArray sortArray =  null;
	protected final long DEFAULT_SLEEPING_TIME = 10;
	protected Color barColors[] = null;
	public Algorithm(SortArray sortArray) {
		// TODO Auto-generated constructor stub
		this.sortArray = sortArray;
		this.n = this.sortArray.n;
		this.arr = this.sortArray.arr;
		this.barColors = this.sortArray.barColors;
	}
}
