package aws_test;

import dao.Storage_DAO;

public class AddStorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage_DAO storage_DAO=new Storage_DAO();
		//storage_DAO.addListToDynamo();
		System.out.println("Size of table: "+storage_DAO.getSizeTable());
		System.out.println("List Storage:");
		System.out.println(storage_DAO.getListFromDynamo_ToString());
	}

}
