package i_dao;

import java.util.List;


import entities.*;

public interface I_Storage_DAO {
	public boolean addStorage(Storage s);
	public List<Storage> getListStorage();
	public String getListStorage_ToString();
	public boolean updateStorage(Storage s);
	//Thêm vào dynamo
	public boolean addToDynamo(Storage s);
	public void addListToDynamo();
	public Storage get_1_StorageFromDynamo(int storageId);
	public List<Storage> getListFromDynamo();
	public String getListFromDynamo_ToString();
	public int getSizeTable();
}
