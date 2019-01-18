package com.cg.mms.presentation;

import java.util.Scanner;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Purchasemodel;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class PurchaseUpdate {


	public static void main(String[] args) {
		
		
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter customer name:");
		String cName=scanner.nextLine();
		
		System.out.println("Enter mail id:");
		String mailId=scanner.nextLine();
		
		System.out.println("Enter phone number:");
		Long phoneNumber=scanner.nextLong();
		
       System.out.println("Enter mobile id:");
       Integer mobileId=scanner.nextInt();
       
       Purchasemodel purchase=new Purchasemodel();
       purchase.setcName(cName);
       purchase.setMailId(mailId);
       purchase.setMobile_id(mobileId);
       purchase.setPhoneNumber(phoneNumber);
       
       MobileService service=new MobileServiceImpl();
       boolean validateFlag=service.validateFields(purchase);
       System.out.println(validateFlag);
       
       if(validateFlag) {
    	   
    	   try {
			int Quantity= service.UpdatemobileQuantity(purchase);
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
       
    	   
       
       
      
       
	}

}


