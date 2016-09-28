package npu.invManagement.modelclasses;



public class ProductCnt {
	private int prodId;
	private String name;
	private int numItems;
	private int overStockedLimit;
	private int underStockedLimit;
	
	public ProductCnt(){
		
	}

	public ProductCnt(int prodId, String name, int numItems) {
		this.prodId = prodId;
		this.name = name;
		this.numItems = numItems;
	}

	public String getName() {
		return name;
	}

	public int getNumItems() {
		return numItems;
	}
	
	public int getOverStockedLimit() {
		return overStockedLimit;
	}

	public void setOverStockedLimit(int overStockedLimit) {
		this.overStockedLimit = overStockedLimit;
	}

	public int getUnderStockedLimit() {
		return underStockedLimit;
	}

	public void setUnderStockedLimit(int underStockedLimit) {
		this.underStockedLimit = underStockedLimit;
	}

	public int getProdId() {
		return prodId;
	}

	public boolean isOverstocked() {
		if (numItems >= overStockedLimit) {
			return true;
		}
		
		return false;
	}
	
	public boolean isUnderstocked() {
		if (numItems <= underStockedLimit) {
			return true;
		}
		
		return false;
	}

	public void addProducts(int numProds) {
		numItems = numItems + numProds;
	}

	public void removeProducts(int numProds) {
		numItems = numItems - numProds;
	}
	
	public boolean matchesId(int tstProdId) {
		return tstProdId == prodId;
	}

	@Override
	public boolean equals(Object otherObj) {
		if (this == otherObj) {
			return true;
		}
		
		if (otherObj == null || getClass() != otherObj.getClass()) {
			return false;
		}
		
		ProductCnt otherProd = (ProductCnt) otherObj;
		if (prodId != otherProd.prodId) {
			return false;
		}
		
		return true;
	}
	
	
}