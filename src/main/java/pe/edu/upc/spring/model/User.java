package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nameUsuario", length=60, nullable=false)
	private String nameUsuario;
	@Column(name="addressUsuario", length=60, nullable=false)
	private String addressUsuario;
	@Column(name="emailUsuario", length=60, nullable=false)
	private String emailUsuario;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int idUsuario, String nameUsuario, String addressUsuario, String emailUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nameUsuario = nameUsuario;
		this.addressUsuario = addressUsuario;
		this.emailUsuario = emailUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNameUsuario() {
		return nameUsuario;
	}
	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}
	public String getAddressUsuario() {
		return addressUsuario;
	}
	public void setAddressUsuario(String addressUsuario) {
		this.addressUsuario = addressUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

		
}
