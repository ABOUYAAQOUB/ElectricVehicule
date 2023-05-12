package com.ElecVehicule.demo.model;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier.Generator;

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
@Table(name = "caracteristique_Dim")
public class Caracteristique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String electriqueType;
	private String cleanAlternative;
	private int electricRange;
	private String electricUtility;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "caracteristique",cascade = CascadeType.ALL)
	protected List<Consommation> Consommation;
}
