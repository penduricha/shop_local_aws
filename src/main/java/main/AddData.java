package main;

import java.sql.Date;
import dao.*;
import entities.*;
public class AddData {

	public static void main(String[] args) {
		Storage_DAO storage_DAO=new Storage_DAO();
		Milk_DAO milk_DAO=new Milk_DAO();
		Candy_DAO candy_DAO=new Candy_DAO();
		/*
		// TODO Auto-generated method stub
		//public Storage(String name, Date foundDate, double incomeBudget, String address)
		Storage storage1=new Storage("LongThanh",Date.valueOf("2002-10-11"),50, "Highway 51 519");
		Storage storage2=new Storage("Vinamilk",Date.valueOf("2002-11-11"),50, "Highway 51 510");
		//public Milk(String name, Date expireDate, double price, String star)
		Milk milk1=new Milk("LTH",Date.valueOf("2024-10-10"),10,Star.ONE.toString());
		Milk milk2=new Milk("Dutch",Date.valueOf("2024-10-10"),10,Star.TWO.toString());
		Milk milk3=new Milk("Milo",Date.valueOf("2024-10-10"),10,Star.THREE.toString());
		Milk milk4=new Milk("Ger",Date.valueOf("2024-10-10"),10,Star.ONE.toString());
		//public Candy(String name, Date expireDate, double price, boolean sweat)
		Candy candy1=new Candy("Dagona", Date.valueOf("2025-10-10"),20, false);
		Candy candy2=new Candy("Kitkat", Date.valueOf("2025-10-10"),20, true);
		Candy candy3=new Candy("Dagona", Date.valueOf("2025-10-10"),20, false);
		Candy candy4=new Candy("Saxa", Date.valueOf("2025-10-10"),20, true);
		//set milk and storage
		storage1.getListMilk().add(milk1);
		storage1.getListMilk().add(milk2);
		milk1.setStorage(storage1);
		milk2.setStorage(storage1);
		storage2.getListMilk().add(milk3);
		storage2.getListMilk().add(milk4);
		milk3.setStorage(storage2);
		milk4.setStorage(storage2);
		//set candy and storage
		storage1.getListCandy().add(candy1);
		storage1.getListCandy().add(candy2);
		candy1.setStorage(storage1);
		candy2.setStorage(storage1);
		storage2.getListCandy().add(candy3);
		storage2.getListCandy().add(candy4);
		candy3.setStorage(storage2);
		candy4.setStorage(storage2);
		//Thêm
		storage_DAO.addStorage(storage1);
		storage_DAO.addStorage(storage2);*/
		//xuất ra
		System.out.println("List Storage");
		System.out.println(storage_DAO.getListStorage_ToString());
		System.out.println("List Candy");
		System.out.println(candy_DAO.getListCandy_ToString());
		System.out.println("List Milk");
		System.out.println(milk_DAO.getListMilk_ToString());
		
	}

}
