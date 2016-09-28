package npu.invManagement.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import npu.invManagement.modelclasses.Inventory;
import npu.invManagement.modelclasses.ProductCnt;

public class OverstockedViewerPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private ArrayList<ProductCnt> overstockedList = new ArrayList<ProductCnt>();
	private Inventory inv;
	private JLabel titleLbl = new JLabel("Overstocked Products");
	private JList<String> overstockedListDisplay;
	private JScrollPane overStockedScrollPane;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();

	public OverstockedViewerPanel(Inventory inv) {
		this.inv = inv;
		inv.addObserver(this);
		/*  Find which products are currently overstocked.  This will be our
		 *  initial display.   
		 */
		addOverstockedProdsToListViewer();
		
		/* Our JList will display all the Strings in listModel so assign the
		 * listModel to our JList here.
		 */
		overstockedListDisplay = new JList<String>(listModel);
		
		overStockedScrollPane = new JScrollPane(overstockedListDisplay);
		overStockedScrollPane.setPreferredSize(new Dimension(250, 150));
		setLayout(new BorderLayout());
		add(titleLbl, "North");
		add(overStockedScrollPane, "Center");
	}
	
	public void addNewOverstockedProd(ProductCnt prod) {
		String displayStr = buildProdDisplayStr(prod);
		listModel.addElement(displayStr);
		overstockedList.add(prod);

	}

	public void removeProdFromOverstockedList(int prodIdx) {
		if (prodIdx >= 0) {
			listModel.removeElementAt(prodIdx);
			overstockedList.remove(prodIdx);
		}
	}
	
	
	
	/*  Could use a ListCellRenderer instead of storing Strings in the List.  But for
	 *  our purposes, I'm using a simpler to understand approach.  The index of the ProductCnt
	 *  object in overstockedProdList will be the same index in listModel.  This is the
	 *  idea of "parallel arrays". 
	 */
	private String buildProdDisplayStr(ProductCnt prod) {
		String displayStr;
		//inv.deliverProduct(prod.getProdId(), numItems);
		
		displayStr = prod.getName() + " " + prod.getNumItems() + " items, reduce to: " + (prod.getOverStockedLimit()-1);
		return displayStr;
	}
	
	/* This method will initialize the overstockedProdList and its
	 * parallel arrayn listModel.
	 */
	private void addOverstockedProdsToListViewer() {
		String displayStr;
		ArrayList<ProductCnt> overstockedProdList; 
		
		overstockedProdList = inv.currentOverstockedProducts();
		if (overstockedProdList == null) return;   /*  don't crash  */
		
		for (ProductCnt curProd: overstockedProdList) {
			displayStr = buildProdDisplayStr(curProd);
			listModel.addElement(displayStr);
			overstockedList.add(curProd);
			//listModel.set(curProd.getProdId(), displayStr);
		}
		
	}
	
	private void removeOverstockedProdsToListViewer() {
		String displayStr;
		ArrayList<ProductCnt> overstockedProdList; 
		
		overstockedProdList = inv.currentOverstockedProducts();
		if (overstockedProdList == null) return;   /*  don't crash  */
		
		for (ProductCnt curProd: overstockedProdList) {
			displayStr = buildProdDisplayStr(curProd);
			listModel.removeElement(displayStr);
			overstockedList.remove(curProd);
			//listModel.set(curProd.getProdId(), displayStr);
		}
		
	}
	
	private void updateaddoverstockedProdsToListviewer(){
		String displayStr;
		ArrayList<ProductCnt> updatedList;
		
		updatedList = inv.currentOverstockedProducts();
		if(updatedList == null) return;
		
		for(ProductCnt updatedProd: updatedList){
			displayStr = buildProdDisplayStr(updatedProd);
			
			for(int j = 0; j < listModel.size(); j++){
				
					listModel.setElementAt(displayStr, j);
					overstockedList.add(j, updatedProd);
						
			}if( !updatedProd.isOverstocked()){
				this.removeOverstockedProdsToListViewer();
				listModel.removeElement(displayStr);
			}
			
			
			}
		
	}
	private void updateList(ProductCnt prod){
		String displayStr = this.buildProdDisplayStr(prod);
		if(overstockedList.size() == 0)	{
			this.addOverstockedProdsToListViewer();
		}
		for(int i = 0 ; i < listModel.size() ; i ++){
			ProductCnt prodAtIndex = overstockedList.get(i) ;
			if(overstockedList.contains(prod)){
				if(prod.equals(prodAtIndex)){
					if(!prod.isOverstocked()){
						this.removeProdFromOverstockedList(i);
					}else{
						listModel.setElementAt(displayStr, i);
					}
				}
			}else{
				this.addNewOverstockedProd(prod);
			}
		}
	}


		@Override

	public void update(Observable o, Object arg) {
			ProductCnt prod ;
			if(o == this.inv){
				prod = (ProductCnt) arg ;
				this.updateList(prod);
			}
	}

}