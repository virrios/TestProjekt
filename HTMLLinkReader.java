import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import javax.swing.JTable;

public class HTMLLinkReader extends JTable //behovs?
{
	
	
	JTable getHTMLLinks(String webpage){		
		
		
		String [][] stringMatrix = new String [50][2]; 
		String[] header = {"WEBBADRESS","BENAMNING"}; //column names

		try{

			
			//create table in the try to make sure an update will not overwrite current frame
			InputStream in=new URL(webpage).openConnection().getInputStream();	
			InputStreamReader reader= new InputStreamReader(in);
			
			HTMLDocument htmlDoc = new HTMLDocument();
			htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			
			new HTMLEditorKit().read(reader,htmlDoc,0);	//puts the website html in a document	
			
			int counter = 0; 
			
			for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.A); //make a A-tag iterator object (to get all A-tags)
			 	iterator.isValid(); iterator.next() ) {

				      AttributeSet attributes = iterator.getAttributes();
				      //get the A-tags HREF-attribute 
				      String srcString = (String) attributes.getAttribute(HTML.Attribute.HREF); 

				      //get the A-tags HREF-attributes value
				      int startOffset = iterator.getStartOffset();
				      int endOffset = iterator.getEndOffset();
				      int length = endOffset - startOffset;
				      String text = htmlDoc.getText(startOffset, length);
				      
				      //add to matrix (only the first 50)
				      if (counter < 50){ 
				      	stringMatrix[counter][0] = srcString;
				      	stringMatrix[counter][1] = text;
				      	counter += 1;
				      }
				    }
				    //if everything is OK the JTable is passed back to the actionEvent (and the scollpane).
				    setModel(new DefaultTableModel(stringMatrix, header)

						{//override so user can not change html links
						@Override
						public boolean isCellEditable(int row, int column) {
							//all cells false
							return false;
							}
						}//no semicolon here! 

				    	); 
				}


		catch (IOException e) {
			
		}
		catch (BadLocationException e) {
			
		}		


	return this; //returns the JTable object (which will not update unless the try is successfull)

	}
}