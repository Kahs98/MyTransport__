package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(int idAdmin) {
		super();
		this.idAdmin = idAdmin;
	}


	public int getIdAdmin() {
		return idAdmin;
	}


	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}


	
		
}
