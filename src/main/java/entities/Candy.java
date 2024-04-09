package entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Candy")
public class Candy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candyId")
	private int candyId;
	@Column(name = "name", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String name;
	@Column(name = "expireDate", length = 100, nullable = false)
	private Date expireDate;
	@Column(name = "price", length = 100, nullable = false)
	private double price;
	@Column(name = "sweat", length = 100, nullable = false)
	private boolean sweat;
	//n-1 với Storage
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storageId")
	private Storage storage;
	public int getCandyId() {
		return candyId;
	}
	public void setCandyId(int candyId) {
		this.candyId = candyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSweat() {
		return sweat;
	}
	public void setSweat(boolean sweat) {
		this.sweat = sweat;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(candyId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return candyId == other.candyId;
	}
	public Candy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candy(String name, Date expireDate, double price, boolean sweat) {
		super();
		this.name = name;
		this.expireDate = expireDate;
		this.price = price;
		this.sweat = sweat;
	}
	@Override
	public String toString() {
		return "Candy [candyId=" + candyId + ", name=" + name + ", expireDate=" + expireDate + ", price=" + price
				+ ", sweat=" + sweat + "]";
	}
	
}
