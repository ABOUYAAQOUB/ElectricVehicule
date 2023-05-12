package com.ElecVehicule.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Consommation_Fact")
public class Consommation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "marque_id")
	private Marque marque ;
	
	@ManyToOne
	@JoinColumn(name = "locatite_id")
	private Localite localite ;
	
	@ManyToOne
	@JoinColumn(name = "dateDim_id")
	private DateDim dateDim ;
	
	@ManyToOne
	@JoinColumn(name = "caracteristique_id")
	private Caracteristique caracteristique ;
	
	private int electricRange;
	
	private float base_msrp;
	
	private String electriqueType;
	
	
	
	
	
	
}
