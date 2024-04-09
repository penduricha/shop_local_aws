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
@Table(name = "Milk")
public class Milk {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milkId")
	private int milkId;
	@Column(name = "name", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String name;
	@Column(name = "expireDate", length = 100, nullable = false)
	private Date expireDate;
	@Column(name = "price", length = 100, nullable = false)
	private double price;
	@Column(name = "star", length = 100, columnDefinition = "nvarchar(25)",nullable = false)
	private String star;
	//n-1 với Storage
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storageId")
	private Storage storage;
	public int getMilkId() {
		return milkId;
	}
	public void setMilkId(int milkId) {
		this.milkId = milkId;
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
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(milkId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return milkId == other.milkId;
	}
	public Milk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Milk(String name, Date expireDate, double price, String star) {
		super();
		this.name = name;
		this.expireDate = expireDate;
		this.price = price;
		this.star = star;
	}
	@Override
	public String toString() {
		return "Milk [milkId=" + milkId + ", name=" + name + ", expireDate=" + expireDate + ", price=" + price
				+ ", star=" + star + "]";
	}
	
}
