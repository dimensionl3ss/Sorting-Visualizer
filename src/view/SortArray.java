package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class SortArray extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[] arr;
	public Color [] barColors;
	public int n;
	private final int BAR_WIDTH = 10;
	protected Graphics2D graphics2d = null;
	
	public SortArray() {
		// TODO Auto-generated constructor stub
		initArray();
		
	}
	private void initArray() {
		n = (int)1200/BAR_WIDTH;
		arr = new int [n];
		barColors =new Color[n];
		for(int i=0; i<n; i++) {
			arr[i] = new Random().nextInt(610);
			this.barColors[i] = Color.white;
		}		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		graphics2d = (Graphics2D)g;
		
		int x=0;
		for (int i = 0; i < arr.length; i++) {
			graphics2d.setColor(this.barColors[i]);
			graphics2d.fillRect(x, 0, BAR_WIDTH, arr[i]);        // (x,y,width,height) 
			
			x+=BAR_WIDTH;   // bar width = 10;
		}
	}
	public void swap(int i, int j, long millis) throws InterruptedException {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		Thread.sleep(millis);
		repaint();
	}
	public void setValue(int i, int x, long millis) throws InterruptedException {
		arr[i] = x;
		Thread.sleep(millis);
		repaint();
	}
}