package npu.invManagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import npu.invManagement.modelclasses.Inventory;

//Data Gatherer on Product shipments and deliveries 
public class ProdInputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel prodIdLbl = new JLabel("Product Id: ");
	private JTextField prodIdTxt = new JTextField(5);
	private JLabel deliveryLbl = new JLabel("Delivery: ");
	private JLabel shipmentLbl = new JLabel("Shipment: ");
	private JTextField deliveryTxt = new JTextField(5);
	private JTextField shipmentTxt = new JTextField(5);
	private Inventory inv;
   

   public ProdInputPanel(Inventory inv) {
       this.inv = inv;
       
       add(prodIdLbl);
       add(prodIdTxt);
       add(deliveryLbl);
       add(deliveryTxt);
       deliveryTxt.addActionListener(this);

       add(shipmentLbl);
       add(shipmentTxt);
       shipmentTxt.addActionListener(this);
   }
   
	private int getProdId() {
		String prodIdStr;
		int prodId = -1;

		prodIdStr = prodIdTxt.getText();
		
		//if(prodIdStr.equals())
		prodId = Integer.parseInt(prodIdStr);
		
		

		return prodId;
	}
   
   private int getShipmentAmt() {
	   String numItemsStr;
	   int numItems=0;
	   
	   numItemsStr = shipmentTxt.getText();
	   try{
	   numItems = Integer.parseInt(numItemsStr);
	   }catch(NumberFormatException e){
		   JOptionPane.showMessageDialog(null, "Bad entry"+numItemsStr);
	   }
	   return numItems;
   }
   
	private int getDeliveryAmt() {
		String numItemsStr;
		int numItems = 0;

		numItemsStr = deliveryTxt.getText();
		numItems = Integer.parseInt(numItemsStr);

		return numItems;
	}

	private void shipProduct() {
		int prodId, numItems;

		prodId = getProdId();
		numItems = getShipmentAmt();
		
		inv.shipProduct(prodId, numItems);
	}

	private void deliverProduct() {
		int prodId, numItems;

		prodId = getProdId();
		numItems = getDeliveryAmt();
		inv.deliverProduct(prodId, numItems);
		
	}

   public void actionPerformed(ActionEvent event) {
	 //  String zz = "zzz";
       if (event.getSource() == deliveryTxt) {
           deliverProduct();
           deliveryTxt.setText("");
       } else if (event.getSource() == shipmentTxt) {
    	  
           shipProduct();
           shipmentTxt.setText("");
       }
   }

}
