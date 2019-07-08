package com.edu.chapter09;

public class EncounterCharges extends BaseObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncounterCharges(Long objectId) {
		super(objectId);
	}
	
	private Encounter encounter;
	private String description;
	private double charge;
	
	public Encounter getEncounter() {
		return encounter;
	}
	public String getDescription() {
		return description;
	}
	public double getCharge() {
		return charge;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	
}
