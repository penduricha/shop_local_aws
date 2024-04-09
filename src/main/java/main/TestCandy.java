package main;

import dao.Candy_DAO;

public class TestCandy {
	public static void main(String[] args) {
		Candy_DAO candy_DAO=new Candy_DAO();
		System.out.println("List Candy");
		System.out.println(candy_DAO.getListCandy_ToString());
	}
}
