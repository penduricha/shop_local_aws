package main;



import dao.*;
import entities.*;
public class TestMilk {
	public static void main(String[] args) {
		Milk_DAO milk_DAO=new Milk_DAO();
		//Storage_DAO storage_DAO=new Storage_DAO();
		System.out.println("List Milk");
		System.out.println(milk_DAO.getListMilk_ToString());
		//Thêm 1 Milk
		//public Milk(String name, Date expireDate, double price, String star)
		/*
		Milk milkAdd=new Milk("Chocolate",Date.valueOf("2024-10-12"), 10, Star.THREE.toString());
		if(milk_DAO.addMilk(milkAdd, 3))
		{
			System.out.println("Thêm thành công.");
		}
		System.out.println("List Milk after adding");
		System.out.println(milk_DAO.getListMilk_ToString());*/
		//Milk milkDelete=new Milk();
		//milkDelete.setMilkId(13);	
		if(milk_DAO.deleteMilk(12))
		{
			System.out.println("Xóa thành công.");
			System.out.println("List Milk after deleteting");
			System.out.println(milk_DAO.getListMilk_ToString());
		}
		
	}
}
