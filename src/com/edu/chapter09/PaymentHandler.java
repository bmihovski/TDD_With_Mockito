package com.edu.chapter09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentHandler extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentHandler(Long objectId) {
		super(objectId);
	}
	
	public PaymentHandler(Long objectId, boolean isInit) {
		super(objectId, isInit);
	}
	
	public Map<Patient, Double> calculateDue() {
		HashMap<Patient, List<Encounter>> hashMap =
				new HashMap<Patient, List<Encounter>>();
		for (Encounter enc : getEncounters()) {
			if (enc.getFinancialSummary().getAmmountDue() > 0) {
				if (hashMap.containsKey(enc.getPatient())) {
					hashMap.get(enc.getPatient()).add(enc);
				} else {
					List<Encounter> encs = new ArrayList<Encounter>();
					encs.add(enc);
					hashMap.put(enc.getPatient(), encs);
				}
			}
		}
		
		Map<Patient, Double> map = new HashMap<Patient, Double>();
		
		for (Patient pat : hashMap.keySet()) {
			double due = 0.00;
			for (Encounter enc : hashMap.get(pat)) {
				due += enc.getFinancialSummary().getAmmountDue();
			}
			map.put(pat, due);
		}
		
		return null;
	}

	private List<Encounter> getEncounters() {
		return DataAccessFacade.findAllUnprocessedEncounters();
	}

}
