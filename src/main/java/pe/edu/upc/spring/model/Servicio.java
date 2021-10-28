package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Service")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	
	@Column(name="nameService", length=60, nullable=false)
	private String nameService;
	
	@Column(name="typeService", length=60, nullable=false)
	private String typeService;
	
	@Column(name="cityService", length=60, nullable=false)
	private String cityService;
	
	@Column(name="addressService", length=60, nullable=false)
	private String addressService;
	
	
	@ManyToOne
	@JoinColumn(name="idAdmin", nullable=false)
	private Admin admin;


	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Servicio(int idService, String nameService, String typeService, String cityService, String addressService,
			Admin admin) {
		super();
		this.idService = idService;
		this.nameService = nameService;
		this.typeService = typeService;
		this.cityService = cityService;
		this.addressService = addressService;
		this.admin = admin;
	}


	public int getIdService() {
		return idService;
	}


	public void setIdService(int idService) {
		this.idService = idService;
	}


	public String getNameService() {
		return nameService;
	}


	public void setNameService(String nameService) {
		this.nameService = nameService;
	}


	public String getTypeService() {
		return typeService;
	}


	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}


	public String getCityService() {
		return cityService;
	}


	public void setCityService(String cityService) {
		this.cityService = cityService;
	}


	public String getAddressService() {
		return addressService;
	}


	public void setAddressService(String addressService) {
		this.addressService = addressService;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



		
		
}
