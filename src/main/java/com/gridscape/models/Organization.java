package com.gridscape.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer organizationId;
	
	private String organizationName;
	
	private String organizationContactNumber;
	
	private String organizationEmail;
	
	private String organizationAddress;

}
