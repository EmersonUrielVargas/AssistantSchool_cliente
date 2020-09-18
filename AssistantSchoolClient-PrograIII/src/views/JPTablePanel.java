package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utils.Constants;

public class JPTablePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmObject;
	private JTable table;
	private JScrollPane scroll;
	
	public JPTablePanel(){
		this.setBackground(Color.WHITE);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Color.BLUE);
		dtmObject = new DefaultTableModel();
		dtmObject.setColumnIdentifiers(Constants.HEADERS_SUBJECT);
		
		table = new JTable();
		table.setPreferredSize(new Dimension(1000, 1000));
		table.setModel(dtmObject);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Constants.COLOR_DARK_BLUE);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(Constants.FONT_LOG_IN);
		table.setRowHeight(200);
		table.setBackground(Color.WHITE);
		table.setFont(Constants.FONT_LOG_IN);
		table.setFillsViewportHeight(true);
		table.setBorder(null);
		
		scroll = new JScrollPane(table);
		scroll.setForeground(Color.BLACK);
		scroll.setBorder(null);
		scroll.setSize(900, 50);
		this.add(scroll);
		
	}
	
	public void addElementToTable(Object[]vector){
		dtmObject.addRow(vector);
	}
	
}