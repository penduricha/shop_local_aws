package main;

import java.sql.Date;

import dao.Storage_DAO;
import entities.*;
public class TestStorage {
	public static void main(String[] args) {
		Storage_DAO storage_DAO=new Storage_DAO();
		System.out.println("List Storage");
		System.out.println(storage_DAO.getListStorage_ToString());
		//Cập nhật Storage
		//public Storage(String name, Date foundDate, double incomeBudget, String address) 
		Storage storageUpdate=new Storage("Dutch",Date.valueOf("2000-10-11"),50,"Ams Street 50");
		storageUpdate.setStorageId(6);
		storage_DAO.updateStorage(storageUpdate);
		//xuất ra
		System.out.println("List Storage After Update");
		System.out.println(storage_DAO.getListStorage_ToString());
		
	}
}
