package com.edu.chapter09;

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

}
