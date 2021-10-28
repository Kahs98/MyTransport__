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
@Table(name="Vehiculo")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehicle;
	
	@Column(name="nameVehicle", length=60, nullable=false)
	private String nameVehicle;
	
	@Column(name="typeVehicle", length=60, nullable=false)
	private String typeVehicle;
	
	@Column(name="descriptionVehicle", length=60, nullable=false)
	private String descriptionVehicle;
	
	
	@ManyToOne
	@JoinColumn(name="idUser", nullable=false)
	private User user;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int idVehicle, String nameVehicle, String typeVehicle, String descriptionVehicle, User user) {
		super();
		this.idVehicle = idVehicle;
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.descriptionVehicle = descriptionVehicle;
		this.user = user;
	}

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getNameVehicle() {
		return nameVehicle;
	}

	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getDescriptionVehicle() {
		return descriptionVehicle;
	}

	public void setDescriptionVehicle(String descriptionVehicle) {
		this.descriptionVehicle = descriptionVehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
