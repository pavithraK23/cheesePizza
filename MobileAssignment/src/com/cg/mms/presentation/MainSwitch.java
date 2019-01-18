package com.cg.mms.presentation;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.mms.exception.MobileException;

public class MainSwitch {
	
	@SuppressWarnings({ "static-access", "resource" })
	public static void main(String[] args) throws MobileException {
		
		PropertyConfigurator.configure("resources/log4j.properties");

		int choice;
		Scanner scanner = null;

		do {
		
		System.out.println("******Mobile Management System*******");

		System.out.println("1.Insert mobile details");
		System.out.println("2.Add purchase details");
		System.out.println("3.View all mobiles");
		System.out.println("4.Delete mobile based on mobile Id");
		System.out.println("5.Search mobiles based on price range");
		System.out.println("0.Exit");
		scanner = new Scanner(System.in);

		System.out.println("Enter  your choice");
		choice = scanner.nextInt();
       
		switch (choice) {
		case 1:
			  Mainmobile mobile=new Mainmobile();
			   mobile.main(null);

			break;
		case 2:
			  PurchaseUpdate purchase = new PurchaseUpdate();
			   purchase.main(null);

			break;
		case 3:
			 SelectAllmobile allMobiles=new SelectAllmobile();
			   allMobiles.main(null);

			break;
		case 4:
			  DeleteId id=new DeleteId();
			  id.main(null);

			break;
		case 5: 
			    Mobilerange range=new Mobilerange();
			    range.main(null);

			break;
		case 0:
			     System.out.println("You are exited from the mobile management system");
			break;
		default:
			System.out.println("You have entered wrong input");
			System.out.println("please select valid choice");
			break;
		}
		}while(choice!=0);

	}

}
