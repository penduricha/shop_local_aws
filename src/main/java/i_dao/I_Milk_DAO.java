package i_dao;

import java.util.List;

import entities.Milk;

public interface I_Milk_DAO {
	public boolean addMilk(Milk m,int storageId);
	public Milk findById(int milkId);
	public List<Milk> getListMilk();
	public String getListMilk_ToString();
	public boolean updateMilk(Milk m);
	public boolean deleteMilk(int milkId);

}
