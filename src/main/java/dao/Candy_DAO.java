package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.Connect;
import database.Hibernate;
import entities.*;
import i_dao.I_Candy_DAO;
import jakarta.persistence.TypedQuery;

public class Candy_DAO implements I_Candy_DAO {
	List<Candy> listStorage = new ArrayList<>();
	Connect con = new Connect();
	Hibernate hibernate=new Hibernate("shopPT");
	public Candy_DAO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean addCandy(Candy c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Candy> getListCandy() {
		try {
			TypedQuery<Candy> query = hibernate.getEntityManager().createQuery("SELECT c FROM Candy c", Candy.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			//herbinate.closeTransaction();
			return null;
		}
	}
	@Override
	public String getListCandy_ToString() {
		String s="";
		for(Candy c: getListCandy())
		{
			s+=c.toString()+"\n";
		}
		return s;
	}
	@Override
	public boolean updateCandy(Candy c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteCandy(Candy c) {
		// TODO Auto-generated method stub
		return false;
	}
}
