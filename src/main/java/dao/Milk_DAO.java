package dao;


import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import database.Connect;
import database.Hibernate;

import entities.Milk;

import entities.Storage;
import i_dao.I_Milk_DAO;
import jakarta.persistence.TypedQuery;

public class Milk_DAO implements I_Milk_DAO{

	List<Storage> listStorage = new ArrayList<>();
	Connect con = new Connect();
	Hibernate hibernate=new Hibernate("shopPT");
	/*
	 * public boolean themCTDonDatHang(SanPham s, CTDonDatHang c) {
		String sqlInsert ="DECLARE @NewSTT INT;\r\n"
				+ "SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;\r\n"
				+ "insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien])\r\n"
				+ "values (@NewSTT,?,?,?,?)";
		try {
			String checkSDTQuery = "SELECT 1\r\n"
					+ "FROM [dbo].[CTDonDatHang]\r\n"
					+ "where maDDH is null and maSP=?";
	        PreparedStatement checkSDTStatement = con.con().prepareStatement(checkSDTQuery);
	        checkSDTStatement.setNString(1, s.getMaSP());
	        ResultSet resultSet = checkSDTStatement.executeQuery();

	        if (resultSet.next()) {
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	            JOptionPane.showMessageDialog(null, "Sản phẩm đã có sẵn trong giỏ.", "Thông báo",
	                    JOptionPane.INFORMATION_MESSAGE);
	            return false;
	        }
			
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1, s.getMaSP());
			preparedStatement_Insert.setDouble(2, c.getDonGia());
			preparedStatement_Insert.setInt(3, c.getSoLuong());
			preparedStatement_Insert.setDouble(4, c.getDonGia()*c.getSoLuong());
			preparedStatement_Insert.executeUpdate();
			con.con().close();
			preparedStatement_Insert.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Sản phẩm đã có sẵn trong giỏ.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	 */
	
	@Override
	public boolean addMilk(Milk m,int storageId) {
		//public Milk(String name, Date expireDate, double price, String star)
		String sqlAdd="insert into Milk(milkId,name,expireDate,price,star,storageId) values (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlAdd);
			preparedStatement_Insert.setInt(1, getListMilk().size()+1);
			preparedStatement_Insert.setNString(2, m.getName());
			preparedStatement_Insert.setDate(3,m.getExpireDate());
			preparedStatement_Insert.setDouble(4,m.getPrice());
			preparedStatement_Insert.setNString(5,m.getStar());
			preparedStatement_Insert.setInt(6,storageId);
			
			preparedStatement_Insert.executeUpdate();
			con.con().close();
			preparedStatement_Insert.close();
			System.out.println("Đã thêm Milk thành công");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Milk> getListMilk() {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Milk> query = hibernate.getEntityManager().createQuery("SELECT m FROM Milk m", Milk.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			//herbinate.closeTransaction();
			return null;
		}
	}

	@Override
	public String getListMilk_ToString() {
		// TODO Auto-generated method stub
		String s="";
		for(Milk m: getListMilk())
		{
			s+=m.toString()+"\n";
		}
		return s;
	}

	@Override
	public boolean updateMilk(Milk m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMilk(int milkId) {
		try {
			hibernate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			
			if (findById(milkId) != null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("Có khóa chính trong cơ sở dữ liệu.");
				// return false;
				// Xóa
				hibernate.getEntityManager().remove(findById(milkId));	
				//Cách khác
				//hibernate.getEntityManager().createQuery("delete from Milk m where m.milkId= :milkId").setParameter("milkId", m.getMilkId()).executeUpdate();
				hibernate.getTransaction().commit();
				System.out.println("Xóa dữ liệu thành công! với "+milkId);
				return true;
			}		

		} catch (Exception e) {
			if (hibernate.getTransaction() != null && hibernate.getTransaction().isActive()) {
				hibernate.getTransaction().rollback();
				return false;
			}
			e.printStackTrace();
			System.out.println(e);
			//herbinate.closeTransaction();
		}
		return false;
	}

	@Override
	public Milk findById(int milkId) {
		// TODO Auto-generated method stub
		return hibernate.getEntityManager().find(Milk.class, milkId);
	}

}
