package dao;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import database.AWS_Connect;
import database.Connect;
import database.Hibernate;

import entities.Storage;
import i_dao.I_Storage_DAO;
import jakarta.persistence.TypedQuery;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

public class Storage_DAO implements I_Storage_DAO{
	
	List<Storage> listStorage = new ArrayList<>();
	Connect con = new Connect();
	//Thông tin aws
	String accessKey="AKIA5FTZEKGZ4FSAM7GJ";
	String secretKey="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";
	String region="ap-southeast-1";
	String bucketName="buckettqn";
	String tableName="Storage";
	//Kết nối
	AWS_Connect aws_Connect=new AWS_Connect(accessKey, region, secretKey, bucketName, tableName);
	/*
	@PersistenceContext
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("project_ms");
	private final EntityManager entityManager;
	private final EntityTransaction transaction;*/
	Hibernate hibernate=new Hibernate("shopPT");
	public Storage_DAO()
	{
		
	}

	@Override
	public boolean addStorage(Storage s) {
		try {
			hibernate.getTransaction().begin();
			// Kiểm tra xem khóa chính đã tồn tại hay chưa
			if (hibernate.getEntityManager().find(Storage.class, s.getStorageId()) != null) {
				// Nếu ID đã tồn tại, không thêm vào cơ sở dữ liệu
				System.out.println("Khóa chính đã tồn tại trong cơ sở dữ liệu.");
				// return false;
			}
			// Nếu khóa chính chưa tồn tại, thực hiện thêm vào cơ sở dữ liệu
			hibernate.getEntityManager().persist(s);
			hibernate.getTransaction().commit();
			System.out.println("Thêm dữ liệu Storage thành công! với "+s.getStorageId());
			return true;
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
	public List<Storage> getListStorage() {
		try {
			TypedQuery<Storage> query = hibernate.getEntityManager().createQuery("SELECT s FROM Storage s", Storage.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			//herbinate.closeTransaction();
			return null;
		}
	}
	/*
	 * Nếu viết lấy theo field thì ntn
	 * public List<Storage> getListStorage() {
	    try {
	        TypedQuery<Storage> query = hibernate.getEntityManager().createQuery("SELECT s FROM Storage s WHERE s.storageId = :storageId", Storage.class);
	        query.setParameter("storageId", 1);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, e.getMessage());
	        //herbinate.closeTransaction();
	        return null;
	    }
	}
	 */
	@Override
	public String getListStorage_ToString() {
		String s="";
		for(Storage st: getListStorage())
		{
			s+=st.toString()+"\n";
		}
		return s;
	}

	@Override
	public boolean updateStorage(Storage s) {
		try {
			hibernate.getTransaction().begin();
			// Lấy đối tượng từ cơ sở dữ liệu
			Storage storageFind = hibernate.getEntityManager().find(Storage.class, s.getStorageId());
			// Thực hiện các thay đổi trên đối tượng
			if (storageFind != null) {
				//public Storage(String name, Date foundDate, double incomeBudget, String address) 
				storageFind.setName(s.getName());
				storageFind.setFoundDate(s.getFoundDate());
				storageFind.setIncomeBudget(s.getIncomeBudget());
				storageFind.setAddress(s.getAddress());
				
				hibernate.getEntityManager().merge(storageFind);
				hibernate.getTransaction().commit();
				System.out.println("Cập nhật Storage thành công với id là: "+s.getStorageId());
				return true;
			} else {
				System.out.println("Không tìm thấy.");
				return false;
			}

		} catch (Exception e) {
			if (hibernate.getTransaction().isActive()) {
				hibernate.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println(e);
		} finally {
			//entityManager.close();
		}
		return false;
	}
	/*
	 * try {
            Item item = new Item().withPrimaryKey("student_id", student.getStudent_id())
                    .withString("name", student.getName())
                    .withBoolean("gender", student.isGender())
                    .withInt("age", student.getAge());
            PutItemSpec putItemSpec = new PutItemSpec().withItem(item)
                    .withReturnValues(ReturnValue.ALL_OLD); // Trả về giá trị cũ nếu có
            aws_Connect.getTable().putItem(putItemSpec);
            System.out.println("Đã thêm sinh viên " + student.getName() + " vào bảng DynamoDB");
            return 1;
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm sinh viên vào bảng DynamoDB: " + e.getMessage());
            return 0;
        }
	 */
	@Override
	public boolean addToDynamo(Storage s) {
		// TODO Auto-generated method stub
		//public Storage(String name, Date foundDate, double incomeBudget, String address) 
		try {
            Item item = new Item().withPrimaryKey("storageId",s.getStorageId())
                    .withString("name",s.getName())
                    .withInt("dayFoundDate",s.getFoundDate().toLocalDate().getDayOfMonth())
                    .withInt("monthFoundDate",s.getFoundDate().toLocalDate().getMonthValue())
                    .withInt("yearFoundDate",s.getFoundDate().toLocalDate().getYear())
                    .withString("address",s.getAddress())
            		.withDouble("incomeBudget",s.getIncomeBudget());
            PutItemSpec putItemSpec = new PutItemSpec().withItem(item)
                    .withReturnValues(ReturnValue.ALL_OLD); 
            // Trả về giá trị cũ nếu có
            aws_Connect.getTable().putItem(putItemSpec);
            System.out.println("Đã thêm vào bảng DynamoDB với "+s.getStorageId());
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm sinh viên vào bảng DynamoDB: " + e.getMessage());
            return false;
        }
	}

	@Override
	public void addListToDynamo() {
		for(Storage s: getListStorage())
		{
			addToDynamo(s);
		}
	}
	/*
	 * public Student get_1_StudentFromDynamoDB(String student_id) {
		// TODO Auto-generated method stub
		Item item = aws_Connect.getTable().getItem("student_id", student_id);
		if (item != null) {
            String name = item.getString("name");
            boolean gender = item.getBoolean("gender");
            int age = item.getInt("age");
            return new Student(student_id, name, gender, age);
            
        } else {
            System.out.println("Không tìm thấy sinh viên ");
            return null;
        }	
	}
	 */
	@Override
	public Storage get_1_StorageFromDynamo(int storageId) {
		// TODO Auto-generated method stub
		//public Storage(String name, Date foundDate, double incomeBudget, String address) 
		try {
			Item item = aws_Connect.getTable().getItem("storageId",storageId);
			
			if (item != null) {
	            String name=item.getString("name");
	            int dayFoundDate=item.getInt("dayFoundDate");
	            int monthFoundDate=item.getInt("monthFoundDate");
	            int yearFoundDate=item.getInt("yearFoundDate");
	            double incomeBudget=item.getDouble("incomeBudget");
	            String address=item.getString("address");
	            LocalDate localDateFoundDate=LocalDate.of(yearFoundDate,monthFoundDate,dayFoundDate);
	            Date foundDate=Date.valueOf(localDateFoundDate);
	            Storage storage=new  Storage(name,foundDate, incomeBudget,address);
	            storage.setStorageId(storageId);
	            return storage;
	            
	        } else {
	            System.out.println("Không tìm kho ");
	            return null;
	        }	
		}catch(DynamoDbException e)
		{
			e.printStackTrace();
			System.out.println(e);
			return null;
		}		
	}
	/*
	 * for(long i=1;i<=getSize_Table();i++)
		{
			Student student=get_1_StudentFromDynamoDB("sv"+i);
			System.out.println(i);
			if (student != null) {
	            listStudent.add(student);
	        }
		}
        return listStudent;
	 */
	@Override
	public List<Storage> getListFromDynamo() {
		// TODO Auto-generated method stub
		for(int i=1;i<=getSizeTable();i++)
		{
			Storage storage=get_1_StorageFromDynamo(i);
			if (storage != null) {
	            listStorage.add(storage);
	        }
		}
		return listStorage;
	}

	@Override
	public int getSizeTable() {
		// TODO Auto-generated method stub
		return (int) aws_Connect.getTableSize();
	}

	@Override
	public String getListFromDynamo_ToString() {
		String s="";
		for(Storage st: getListFromDynamo())
		{
			s+=st.toString()+"\n";
		}
		return s;
	}

	
}
