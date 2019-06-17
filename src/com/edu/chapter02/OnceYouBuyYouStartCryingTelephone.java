package com.edu.chapter02;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OnceYouBuyYouStartCryingTelephone {
	public static final int TWO_G = 2;
	public static final int THREE_G = 3;
	public static final int FOUR_G = 4;
	private Map<String, String> names = new HashMap<String, String>();
	private Map<String, Integer> types = new HashMap<String, Integer>();
	private Map<String, Date> cd = new HashMap<String, Date>();

	/**
	 * This method activates a connection for a customer and stores different
	 * information in following maps for future use names, types and cd. if the
	 * connection type is 2G then requests TRY for a valid 2G number. if portability
	 * is not an issue then TRY provides a valid number, that number is stored for
	 * the customer. Then we activate the connection. For 3G - user needs data plan
	 * , we don't ask TRY for 3G...we don't have permission for 3G data in many
	 * cities, so we will hack TRY database and assign an id. If TRY catches us then
	 * we will disconnect the data plan and deactivate the customer. Is there any
	 * legal consumer forum issue? For 4G- we don't have 4th generation spectrum. we
	 * will provide 3G with a wrapper of 4G
	 * 
	 * @param firstName
	 * @param prefix
	 * @param middleName
	 * @param lastName
	 * @param z
	 * @param gen
	 * @return
	 **/
	public String addConnection(String firstName, String prefix, String middleName, String lastName, Date z, int gen) {
		if (firstName == null || lastName == null || z == null)
			throw new RuntimeException();
		String r = "";
		if (prefix != null) {
			r = r + " " + prefix;
			if (firstName != null)
				r = r + " " + firstName;
			if (middleName != null)
				r = r + " " + middleName;
			if (lastName != null)
				r = r + lastName;
		} else {
			if (firstName != null)
				r = r + " " + firstName;
			if (middleName != null)
				r = r + " " + middleName;
			if (lastName != null)
				r = r + lastName;
		}
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String n = new String(array, Charset.forName("UTF-8"));
		names.put(n, r);
		cd.put(n, z);
		if (gen == TWO_G) {
			activate2GCon(n);
			types.put(n, TWO_G);
		} else if (gen == THREE_G) {
			activate2GCon(n);
			types.put(n, THREE_G);
		} else if (gen == FOUR_G) {
			activate2GCon(n);
			types.put(n, FOUR_G);
		} else {
			throw new IllegalStateException();
		}
		return n;
	}

	private void activate2GCon(String n) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method takes number as input and generates post paid bills
	 * 
	 * @param n
	 * @return
	 **/
	public String bill(String n) {
		Integer gen = types.get(n);
		if (gen == null) {
			throw new RuntimeException();
		}
		switch (gen.intValue()) {
		case TWO_G:
			return gen2GBill(n);
		case THREE_G:
			return gen3GBill(n);
		case FOUR_G:
			return gen4GBill(n);
		default:
			break;
		}
		return "";
	}

	private String gen4GBill(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	private String gen3GBill(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	private String gen2GBill(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	public void chargeIncomingSms(String num) {
		// code....
		// ....
	}
}
