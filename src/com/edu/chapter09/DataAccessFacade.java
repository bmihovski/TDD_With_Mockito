package com.edu.chapter09;

import java.util.ArrayList;
import java.util.List;

public class DataAccessFacade {

	public static void register(String url, String userName, String password) {
		// get connection from
		
	}

	public static BaseObject retrieveObject(Long objectId) {
		// Stubbing actual db call and adding sleep to wait
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static List<Encounter> fecthEncountersFor(Long objectId) {
		return new ArrayList<Encounter>();
	}

	public static List<Encounter> findAllUnprocessedEncounters() {
		// TODO Auto-generated method stub
		return new ArrayList<Encounter>();
	}

	public static void addChargeFor(Encounter encounter, EncounterCharges aCharge) {
		// TODO Auto-generated method stub
		
	}

}
