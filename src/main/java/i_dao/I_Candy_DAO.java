package i_dao;

import java.util.List;

import entities.*;

public interface I_Candy_DAO {
	public boolean addCandy(Candy c);
	public List<Candy> getListCandy();
	public String getListCandy_ToString();
	public boolean updateCandy(Candy c);
	public boolean deleteCandy(Candy c);
}
