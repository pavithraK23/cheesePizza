package com.cg.mms.presentation;

import java.util.Scanner;

import com.cg.mms.exception.MobileException;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class DeleteId {

public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter mobile id for the deletion");
		Integer id=scanner.nextInt();
		
		MobileService service =new MobileServiceImpl();
		int result;
		try {
			result = service.DeleteId(id);
			System.out.println(result+" Deleted");
		} catch (MobileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
