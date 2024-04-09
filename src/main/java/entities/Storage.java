package entities;

import java.sql.Date;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Storage")
public class Storage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storageId")
	private int storageId;
	@Column(name = "name", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String name;
	@Column(name = "foundDate", length = 100, nullable = false)
	private Date foundDate;
	@Column(name = "incomeBudget", length = 100, nullable = false)
	private double incomeBudget;
	@Column(name = "address", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String address;
	//1-n với Milk
	@OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
	private List<Milk> listMilk=new ArrayList<>();
	@OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
	private List<Candy> listCandy=new ArrayList<>();
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}
	public double getIncomeBudget() {
		return incomeBudget;
	}
	public void setIncomeBudget(double incomeBudget) {
		this.incomeBudget = incomeBudget;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Milk> getListMilk() {
		return listMilk;
	}
	public void setListMilk(List<Milk> listMilk) {
		this.listMilk = listMilk;
	}
	public List<Candy> getListCandy() {
		return listCandy;
	}
	public void setListCandy(List<Candy> listCandy) {
		this.listCandy = listCandy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(storageId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storage other = (Storage) obj;
		return storageId == other.storageId;
	}
	public Storage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Storage(String name, Date foundDate, double incomeBudget, String address) {
		super();
		this.name = name;
		this.foundDate = foundDate;
		this.incomeBudget = incomeBudget;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Storage [storageId=" + storageId + ", name=" + name + ", foundDate=" + foundDate + ", incomeBudget="
				+ incomeBudget + ", address=" + address + "]";
	}
	
	
}
