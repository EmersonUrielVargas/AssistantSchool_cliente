package views;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridSystem extends JFrame { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_COLUMN_WIDTH = 1;
	private static final int COLUMNS_NUMBER = 10;
	private static final int DEFAULT_ROWS_HEIGHT = 1;
	private static final int ROWS_NUMBER = 10;
	public static final Dimension INIT_DIMENSION = new Dimension(0, 0);

	private GridBagConstraints constraints;

	public GridSystem(Container component) {
		component.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		generateBasicGrid(component);
		generateBasicGrid2(component);	
	}

	private void generateBasicGrid2(Container component){
		constraints.weighty = DEFAULT_ROWS_HEIGHT;
		for (int i = 0; i < ROWS_NUMBER; i++) {
			constraints.gridy = i;
			component.add(new JLabel(), constraints);
		}
	}
	
	private void generateBasicGrid(Container component){
		constraints.weightx = DEFAULT_COLUMN_WIDTH;
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			constraints.gridx = i;
			component.add(new JLabel(), constraints);
		}
	}

	public GridBagConstraints insertComponent(int row, int column, int width, double height){
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = (int)height;
		return constraints;
	}
	
	public GridBagConstraints insertComponent(int row, int column, int width, double height, int fill){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = (int)height;
		constraints.fill = fill;
		return constraints;
	}
	
	public GridBagConstraints insertComponent(int row, int column, int width, double height,int top, int left, int bottom, int right){
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(top, left, bottom, right);
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = (int)height;
		return constraints;
	}

	public GridBagConstraints insertComponent(int column, int width){
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = column;
		constraints.gridwidth = width;
		return constraints;
	}

	public void addExternalBorder(int top, int right, int bottom, int left){
		constraints.insets = new Insets(top,left,bottom,right);
	}
}