import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.JTable;



public class ViewControl extends JFrame implements ActionListener
{

	
	private JLabel text = new JLabel();
	Container c = getContentPane();
	JTextField textField = new JTextField();
	
	Webreader editorPane = new Webreader();
	HTMLLinkReader linkReader = new HTMLLinkReader();
	String[] header = {"WEBBADRESS","BENAMNING"};
	JScrollPane scrollablePane1 = new JScrollPane();
	JScrollPane scrollablePane2 = new JScrollPane();


	ViewControl( ){
		
		
		c.setLayout(new BorderLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);


		textField.addActionListener(this);
		

		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();


		pane1.setLayout(new BorderLayout());
		pane2.setLayout(new BorderLayout());
		pane3.setLayout(new BorderLayout());
		

		c.add(pane1);
		c.add(pane2);
		c.add(pane3);


		pane1.add(textField, BorderLayout.NORTH);
		
		
		JEditorPane editorPaneTemp = new JEditorPane();
		editorPaneTemp.setEditable(false);

		scrollablePane1.getViewport().add(editorPaneTemp);
		pane2.add(scrollablePane1);
		
		JTable table = new JTable(50,2)
			{
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
				}
			};
			;





		scrollablePane2.getViewport().add(table);
		pane3.add(scrollablePane2);


		c.add(pane1, BorderLayout.NORTH);
		c.add(pane2, BorderLayout.CENTER);
		c.add(pane3, BorderLayout.EAST);
	
        
        setVisible(true);

	}


		

	@Override
	public void actionPerformed(ActionEvent e) {
		scrollablePane1.getViewport().add(editorPane.showPage(textField.getText()));
		scrollablePane2.getViewport().add(linkReader.getHTMLLinks(textField.getText()));
    	

		}
	
		
		}