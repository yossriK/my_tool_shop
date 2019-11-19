package ShopServer.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Provides data fields and methods to create a Java data-type, representing a shop in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Shop {
	/**
	* The shop's inventory
	*/
	private Inventory theInventory;
	/**
	* The shop's inventory
	*/
	private ArrayList <Supplier> supplierList;


	/**
	* A default constructor that constructs a shop object creating inventory and arraylist of suppliers
	*/
	public Shop() {	
		supplierList = new ArrayList<Supplier>();
		readSuppliers();
		theInventory = new Inventory(readItems());
	}

	/**
	 * Sets list of suppliers from a specified filename.
	 */
	private void readSuppliers() {

		try {
			FileReader fr = new FileReader("suppliers.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				supplierList.add(new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));	
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Sets inventory items from specified file name.
	 */
	private ArrayList<Item> readItems() {

		ArrayList<Item> items = new ArrayList<Item>();

		try {
			FileReader fr = new FileReader("items.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				int supplierId = Integer.parseInt(temp[4]);

				Supplier theSupplier = findSupplier(supplierId);
				if (theSupplier != null) {
					Item myItem = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
							Double.parseDouble(temp[3]), theSupplier);
					items.add(myItem);
					theSupplier.getItemList().add(myItem);
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
	/**
	 * Searches for supplier in shop by specified supplier ID and returns result.
	 * @param supplierId is the ID of supplier searched for
	 * @return the supplier.
	 */
	private Supplier findSupplier(int supplierId) {
		Supplier theSupplier = null;
		for (Supplier s : supplierList) {
			if (s.getSupId() == supplierId) {
				theSupplier = s;
				break;
			}

		}
		return theSupplier;
	}
	/**
	* Gets the shop's inventory.
	* @return inventory of shop
	*/
	public Inventory getTheInventory () {
		return theInventory;
	}
	/**
	* Sets the shop's inventory.
	* @param inventory is the inventory of shop
	*/
	public void setTheInventory (Inventory inventory) {
		theInventory = inventory;
	}
	/**
	* Gets the shop;s suppliers..
	* @return suppliers of shop
	*/
	public ArrayList<Supplier> getSupplierList (){
		return supplierList;
	}
	/**
	* Sets the shop's supplierList.
	* @param suppliers are the suppliers  of the shop
	*/
	public void setSupplierList (ArrayList <Supplier> suppliers){
		supplierList = suppliers;
	}
	
	/**
	 * returns store items in the inventory.
	 * @return string of all items in store.
	 */
	public String listAllItems() {
		return theInventory.toString();
		
	}
	/**
	 * Buys item from shop and checks quantity in order to make an order if needed.
	 * @param toolName is the tool to be bought
	 */
	public String buyItem (String name) {
		if (theInventory.manageItem(name) == null) 
			 return"Couldn't not decrease item quantity!";
			 else
				 return "Item quantity was decreased!";
	}

	/**
	 * returns store suppliers in the list of suppliers..
	 * @return string of all suppliers of the shop.
	 */
	public String listAllSuppliers() {
		String suppliers = "";
		for (Supplier s: supplierList) {
			suppliers += s.toString(); 
		}
		return suppliers;
		
	}
	/**
	 * Searches for tool in inventory by specified tool Name and returns result.
	 * @param toolName is the name of tool searched for
	 */
	public String getItem(String name) {
		Item theItem = theInventory.searchForItem(name);
		if (theItem == null)
			return "Item " + name + " could not be found!";
		    
		else
			return outputItem (theItem);
			
	}
	/**
	 * Searches for tool in inventory by specified tool ID and returns result.
	 * @param toolId is the ID of tool searched for
	 */
	public String getItem(int id) {
		Item theItem = theInventory.searchForItem(id);
		if (theItem == null)
			return "Item number " + id + " could not be found!";
		else
			return outputItem (theItem);
	}
	
	/**
	 * Returns a statement about the information of the item.
	 * @param theItem item to be used.
	 * @return String of item's information.
	 */
	private String outputItem (Item theItem){
		return "The item information is as follows: \0" + theItem.toString();
	}
	
	/**
	 * Checks quantity of specified tool.
	 * @param name  of tool to check quantity for
	 * @return String with results.
	 */
	public String getItemQuantity(String name) {
		int quantity = theInventory.getItemQuantity(name);
		if (quantity < 0)
			return "Item " + name + " could not be found!";
		    
		else
			return "The quantity of Item " + name + " is: " + quantity + "\n";
			
	}
	/**
	 * returns information about orders made by the shop.
	 * @return String of information of order made.
	 */
	public String printOrder() {
		return theInventory.printOrder();
	}




	


	

}
