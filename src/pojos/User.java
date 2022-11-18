package pojos;

import java.util.Date;
import javax.persistence.*; // import all JPA compliant annotations

/*
 * userId(PK), name, email, password, role(enum), confirmPassword, regAmount;
LocalDate/java.util.Date regDate;
byte[] image;
*/

@Entity //mandotary to inform hibernate whatever follows is pojo / entity : whose life cycle 
// has to be manage by Hibernate
@Table(name = "user_tbl")// optional
public class User {
	private Integer userId; //Hibernate mandates to add unique ID property : Serializable
	//(e.g. Integer, Long, int, long, String,...)
	private String name,email, password, confirmPassword;
	private Role role;
	private double regAmount;	
	private Date regDate;
	private byte[] image;
	
	//Mandatory : supply arg less / default ctor
	public User() {
	  System.out.println("In user Constructor");
	}
	
	//optional : can add parameterized ctor
	public User(String name, String email, String password, String confirmPassword, double regAmount, Role role,
			Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;		
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	
	//mandatory : all setters and getters
	@Id // mandatory : unique ID property : constraint : PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to tell Hib for automatic ID generation
	// constraint : auto increment
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(length = 20) //varchar size 20
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 20, unique = true) // unique constraint
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient // to tell Hibernate to skip this from persistence (no column)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Enumerated(EnumType.STRING) // to generate column as per enum name : varchar
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Column(name = "reg_amount")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Lob //large object : property type is byte[] : longblob / char[] : clob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", role=" + role + ", regAmount=" + regAmount + ", regDate="
				+ regDate + "]";
	}
	
}
