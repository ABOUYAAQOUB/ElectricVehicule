package com.ElecVehicule.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Date_Dim")
public class DateDim implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	private int year;
	private int month;
	private int day;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "dateDim",targetEntity=Consommation.class,cascade = CascadeType.ALL)
	protected List<Consommation> Consommation;
}
