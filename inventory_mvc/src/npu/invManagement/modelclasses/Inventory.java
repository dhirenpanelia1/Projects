package npu.invManagement.modelclasses;

import java.util.ArrayList;
import java.util.Observable;

public class Inventory extends Observable {
	private ArrayList<ProductCnt> inv;
	
	public Inventory() {
		/* instantiate an empty list */
		inv = new ArrayList<ProductCnt>();
 	}
	
	/*  Add a product whose inventory we need to keep track of  */
	public void addProduct(ProductCnt prodCnt) {   
		inv.add(prodCnt);
	}
	
	/*  A product delivery means we will have more of this product  */
	public void deliverProduct(int prodId, int numItems) {
		
		ProductCnt prod;
		prod = findProdCnt(prodId);
		if(prod != null){
			prod.addProducts(numItems);
		}
		setChanged();
		notifyObservers(prod);
		System.out.println(prod.getProdId()+" : "+prod.getNumItems());
	}
	
	/*  A product shipment means we will have less of this product  */
	public void shipProduct(int prodId, int numItems) {
		ProductCnt prod;
		prod = findProdCnt(prodId);
		if(prod != null){
			prod.removeProducts(numItems);
		}
		setChanged();
		notifyObservers(prod);
		System.out.println(prod.getProdId()+" : "+prod.getNumItems());
	}
	
	public ArrayList<ProductCnt> currentOverstockedProducts() {
		/*  create a new (empty) ArrayList  */
		/*  find which products are currently overstocked and add them to the ArrayList  */
		ArrayList<ProductCnt> newinv = new ArrayList<ProductCnt>();
		//System.out.println("Inside arrayList");
		for(int i = 0; i < inv.size(); i++)
			if(inv.get(i).isOverstocked()){
				newinv.add(inv.get(i)); 
			}
		
		return newinv;
	}
	
	public ArrayList<ProductCnt> currentUnderStockedProducts() {
		/*  create a new (empty) ArrayList  */
		/*  find which products are currently understocked and add them to the ArrayList  */
		ArrayList<ProductCnt> newinv = new ArrayList<ProductCnt>();
		for(int i = 0; i < inv.size(); i++)
		if(inv.get(i).isUnderstocked()){
			newinv.add(inv.get(i)); 
		}
		
		return newinv;
	}
	
	private ProductCnt findProdCnt(int prodId){
		 for (ProductCnt curProd: inv){
			 if (curProd.matchesId(prodId)) {
				 return curProd;
			 }
		 }
		 return null; /* didn't find */
	} 


}
