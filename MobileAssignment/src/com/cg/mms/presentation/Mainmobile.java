package com.cg.mms.presentation;

import java.util.Scanner;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class Mainmobile {
	public static void main(String[] args) {
		
		
		
	  MobileService service=new MobileServiceImpl();
	  Scanner scanner=new Scanner(System.in);
	  
	  System.out.println("Enter mobile id");
	  Integer id=scanner.nextInt();
	  scanner.nextLine();
		System.out.println("Enter name of the mobile");
		String name=scanner.nextLine();
		System.out.println("Enter price of the mobile");
		Double price=scanner.nextDouble();
		System.out.println("Enter quantity");
		Integer quantity=scanner.nextInt();
		if(quantity<=0)
		{
			System.out.println("Quantity should be greater than zero");
			
		}else
		{
		
		Mobilemodel mobile=new Mobilemodel();
		mobile.setMobileId(id);
		mobile.setName(name);
		mobile.setPrice(price);
		mobile.setQuantity(quantity);
		
		try {
			int result=service.insertMobileDetails(mobile);
			System.out.println(result+"inserted");
		} catch (MobileException e) {
			System.out.println(e.getMessage());
		}
		
		
		}
		
		
		
		

	}

}


