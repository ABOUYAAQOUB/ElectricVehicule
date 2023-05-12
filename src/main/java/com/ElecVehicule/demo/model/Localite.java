package com.ElecVehicule.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Localite_Dim")
public class Localite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String state;
	private String County;
	private String city;
	private String codepostal;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "localite",targetEntity=Consommation.class,cascade = CascadeType.ALL)
	protected List<Consommation> Consommation;
	
}
