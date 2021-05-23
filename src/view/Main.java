package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import algorithms.*;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton insertionSortButton;
	private JButton bubbleSortButton;
	private JButton quickSortButton;
	private JButton selectionSortButton;
	private JButton suffleButton;
	private JButton mergeSortButton;
	
	protected boolean isSort = false;
	private SortArray sortPanel = null;
	private SwingWorker<Void, Void> swingWorker=null;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Main() {
		setResizable(false);
		setTitle("Sorting Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1217, 700);
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel panel = new JPanel();
		sortPanel = new SortArray();
		sortPanel.setBounds(0, 50, 1200, 612);
		sortPanel.setBackground(Color.BLACK);
		sortPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		sortPanel.setLayout(null);
		
		contentPane.add(sortPanel);
		
		suffleButton = new JButton("Suffle");
		suffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSimulation("suffle");
				setButton(true);
				
			}
		});
		suffleButton.setBackground(Color.BLACK);
		suffleButton.setForeground(Color.WHITE);
		suffleButton.setFocusable(false);
		suffleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		suffleButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		suffleButton.setBounds(0, 10, 134, 39);
		contentPane.add(suffleButton);
		
		insertionSortButton = new JButton("Insertion Sort");
		insertionSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSimulation("insertionSort");
				setButton(false);
				
			}
		});
		insertionSortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		insertionSortButton.setForeground(Color.WHITE);
		insertionSortButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		insertionSortButton.setFocusable(false);
		insertionSortButton.setBackground(Color.BLACK);
		insertionSortButton.setBounds(144, 10, 146, 39);
		contentPane.add(insertionSortButton);
		
		quickSortButton = new JButton("Quick Sort");
		quickSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSimulation("quickSort");
				setButton(false);
			}
		});
		quickSortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		quickSortButton.setForeground(Color.WHITE);
		quickSortButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		quickSortButton.setFocusable(false);
		quickSortButton.setBackground(Color.BLACK);
		quickSortButton.setBounds(300, 10, 146, 39);
		contentPane.add(quickSortButton);
		
		bubbleSortButton = new JButton("Bubble Sort");
		bubbleSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				runSimulation("bubbleSort");
				setButton(false);
				
			}
		});
		bubbleSortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bubbleSortButton.setForeground(Color.WHITE);
		bubbleSortButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		bubbleSortButton.setFocusable(false);
		bubbleSortButton.setBackground(Color.BLACK);
		bubbleSortButton.setBounds(456, 10, 146, 39);
		contentPane.add(bubbleSortButton);
		
		selectionSortButton = new JButton("Selection Sort");
		selectionSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSimulation("selectionSort");
				setButton(false);
				
			}
		});
		selectionSortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		selectionSortButton.setForeground(Color.WHITE);
		selectionSortButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		selectionSortButton.setFocusable(false);
		selectionSortButton.setBackground(Color.BLACK);
		selectionSortButton.setBounds(612, 10, 146, 39);
		contentPane.add(selectionSortButton);
		
		mergeSortButton = new JButton("Merge Sort");
		mergeSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runSimulation("mergeSort");
				setButton(false);
			}
		});
		mergeSortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mergeSortButton.setForeground(Color.WHITE);
		mergeSortButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mergeSortButton.setFocusable(false);
		mergeSortButton.setBackground(Color.BLACK);
		mergeSortButton.setBounds(770, 10, 146, 39);
		contentPane.add(mergeSortButton);
		
		//SortArray sort = new SortArray();
		//setContentPane(sort);
	}
	void setButton(boolean enable) {
		selectionSortButton.setEnabled(enable);
		suffleButton.setEnabled(enable);
		quickSortButton.setEnabled(enable);
		insertionSortButton.setEnabled(enable);
		bubbleSortButton.setEnabled(enable);
		mergeSortButton.setEnabled(enable);
	}
	void runSimulation(String algo)    
	{
		swingWorker = new SwingWorker<Void, Void>() {
			
			@Override
			public Void doInBackground() throws InterruptedException {
				
				
				
				switch (algo) {
				case "insertionSort": {
					
					new InsertionSort(sortPanel).sort();
					suffleButton.setEnabled(true);
					break;
				}
				case "suffle" : {
					
					new SuffleArray(sortPanel).suffle();
					suffleButton.setEnabled(true);
					break;
				}
				case "quickSort" : {
					
					new QuickSort(sortPanel).sort();
					suffleButton.setEnabled(true);
					break;
				}
				case "selectionSort" : {
					
					new SelectionSort(sortPanel).sort();
					suffleButton.setEnabled(true);
					break;
				}
				case "bubbleSort" : {
					new BubbleSort(sortPanel).sort();
					suffleButton.setEnabled(true);
					break;
				}
				case "mergeSort" : {
					
					new MergeSort(sortPanel).sort(); suffleButton.setEnabled(true);
					 
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + algo);
				}
				
				return null;
			}
			
			@Override
			public void done() {
				super.done();
			}
			
		};
		swingWorker.execute();
	}
}
