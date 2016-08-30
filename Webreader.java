import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import javax.swing.JOptionPane;

public class Webreader extends JEditorPane
{
	JEditorPane showPage(String newURL){	
		
			try{
				
				this.setEditable(false);
				this.setPage(newURL);
				return this;
				
			} 

			catch (IOException e) {

				JOptionPane dialog = new JOptionPane();
				dialog.showMessageDialog(this, "Attempted to read a bad URL: " + newURL);
				return this;

	  			}

			


		
		

	}

}
