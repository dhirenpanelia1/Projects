package npu.invManagement.modelclasses;


/* Simulate a class to read data from the database  */
public class InventoryDb {
	static public Inventory readInventory() {
		Inventory inv;
		
		inv = new Inventory();
		buildInventory(inv);
		return inv;
	}
	
	static public void buildInventory(Inventory inv) {
		ProductCnt prodCnt;
		
		prodCnt = new ProductCnt(1, "Microwave", 50);
		prodCnt.setOverStockedLimit(30);
		prodCnt.setUnderStockedLimit(10);
		inv.addProduct(prodCnt);
		
		prodCnt = new ProductCnt(2, "Plate Set", 110);
		prodCnt.setOverStockedLimit(120);
		prodCnt.setUnderStockedLimit(60);
		inv.addProduct(prodCnt);
	}

}
