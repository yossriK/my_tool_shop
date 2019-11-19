package ShopClient.ClientController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ShopClient.view.GUI2;




/**
 * Provides data fields and methods to create a Java data-type, representing a GUI controller in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */

public class GUIController {
	private GUI2 mainGui;
	private PrintWriter out;
	
	/**
	 * Creates a gui controller object , which assigns a gui and a print writer to its fields, and creates action listeners to the buttons of the gui.
	 * @param aGUI gui to be assigned to the gui in the controller.
	 * @param out print writer to write into the socket.
	 */
	public GUIController(GUI2 aGUI, PrintWriter out){
		this.out = out;
		this.mainGui = aGUI;
		mainGui.addBuyListener(new BuyListener());
		mainGui.addlistAllItemsListener(new ListAllItemsListener());
		mainGui.addlistAllSuppliersListener(new ListAllSuppliersListener());
		mainGui.addSearchIDListener(new SearchByIDListener());
		mainGui.addSearchByNameListener(new SearchByNameListener());
		mainGui.addItemQuantityListener(new ItemQuantityListener());
		mainGui.addPrintOrderListener(new PrintOrderListener());
	}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a button in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class BuyListener implements ActionListener{
		private JTextField BUY;
		/**
		 * Creates a text field that takes input from user and prints it out to the socket with a unique indicator.
		 */
		@Override
		public void actionPerformed(ActionEvent e1) {
			BUY = new JTextField();
			Object[] message = {"Enter tool name: ", BUY};
			
			int option = JOptionPane.showConfirmDialog(null, message, "Buy an item",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION)
			{
				out.println("BUY" +BUY.getText());
		}	
	}
}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a list all items in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class ListAllItemsListener implements ActionListener {
		/**
		 * prints an indicator to the socket.
		 */
		@Override
		public void actionPerformed(ActionEvent e2) {	
				out.println("LISTITEMS");
		}
	}

	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a list all suppliers in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class ListAllSuppliersListener implements ActionListener {
		/**
		 * prints an indicator to the socket.
		 */
		@Override
		public void actionPerformed(ActionEvent e2) {			
			out.println("LISTSUPPLIERS");
		}
	}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a search by id in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class SearchByIDListener implements ActionListener{
		
		/**
		 * Creates a text field that takes input from user and prints it out to the socket with a unique indicator.
		 */
		@Override
		public void actionPerformed(ActionEvent e1) {
			JTextField itemID = new JTextField();
			Object[] message = {"Enter tool Id: ", itemID};
			
			int option = JOptionPane.showConfirmDialog(null, message, "Search an item by Id",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION)
			{
				out.println("SEARCHID" +itemID.getText()) ;
				
				
		}
		
	}
}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a search by name in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class SearchByNameListener implements ActionListener{
		/**
		 * Creates a text field that takes input from user and prints it out to the socket with a unique indicator.
		 */
		@Override
		public void actionPerformed(ActionEvent e1) {
			JTextField itemName = new JTextField();
			Object[] message = {"Enter tool Name: ", itemName};
			
			int option = JOptionPane.showConfirmDialog(null, message, "Search an item by Name",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION)
			{
				out.println("SEARCHNAME"+itemName.getText());
				 

		}
		
	}
}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for a getting item quantity in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class ItemQuantityListener implements ActionListener {
		/**
		 * Creates a text field that takes input from user and prints it out to the socket with a unique indicator.
		 */
		@Override
		public void actionPerformed(ActionEvent e1) {
			JTextField itemName = new JTextField();
			Object[] message = {"Enter name of the item: ", itemName};
			
			int option = JOptionPane.showConfirmDialog(null, message, "Get item Quantity",JOptionPane.OK_CANCEL_OPTION);
			
			if(option == JOptionPane.OK_OPTION)
			{
				out.println("QUANTITY"+ itemName.getText());


		}
		
	}


}
	/**
	 * Provides data fields and methods to create a Java data-type, representing a listener for printing orders in a java application that is an inner class of the GUIController class.
	 *
	 * @author Y. Attia
	 * @author H. Muhamad
	 * @author Y. Khalil
	 * @version 1.0
	 * @since April 4th, 2019
	 */
	class PrintOrderListener implements ActionListener {
		/**
		 * prints an indicator to the socket.
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			out.println("PRINT");
		}
	}
	/**
	 * prints out a message on a joption pane window.
	 * @param message
	 */
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	/**
	 * printing out the string passed to the text area of the gui.
	 * @param text
	 */
	public void printOnTextArea(String text) {
		mainGui.clear();
		mainGui.getTextArea().setText(text);
		
	}


	

}
