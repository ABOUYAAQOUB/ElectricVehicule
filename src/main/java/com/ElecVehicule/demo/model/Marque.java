package com.ElecVehicule.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
@Entity
@Table(name = "Marque_Dim")
public class Marque implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String nom;
	private String model;
	private String model_annee;
	private float base_msrp;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "marque",targetEntity=Consommation.class,cascade = CascadeType.ALL)
	protected List<Consommation> Consommation;
	
}
