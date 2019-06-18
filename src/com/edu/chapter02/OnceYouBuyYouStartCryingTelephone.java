package com.edu.chapter02;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.edu.chapter02.PhoneConnection.ConnectionType;

public class OnceYouBuyYouStartCryingTelephone {
	private Map<String, Integer> types = new HashMap<String, Integer>();
	private Map<String, Date> cd = new HashMap<String, Date>();
	private Map<ConnectionType, PhoneConnection> connectionForATypeMap =
			new HashMap<ConnectionType, PhoneConnection>();
	private Map<String, ConnectionType> connectionTypeForNumberMap = 
			new HashMap<String, ConnectionType>();
	
	public OnceYouBuyYouStartCryingTelephone() {
		initialize();
	}

	private void initialize() {
		connectionForATypeMap.put(ConnectionType.TWO_G, new TwoGConnection());
		connectionForATypeMap.put(ConnectionType.THREE_G, new ThreeGConnection());
		connectionForATypeMap.put(ConnectionType.FOUR_G, new FourGConnection());
	}

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
	public String addConnection(String firstName, String prefix, String middleName, String lastName, Date z, ConnectionType connectionType) {
		if (firstName == null || lastName == null || z == null)
			throw new RuntimeException();
		String personName = "";
		if (prefix != null) {
			personName = personName + " " + prefix;
			if (firstName != null)
				personName = personName + " " + firstName;
			if (middleName != null)
				personName = personName + " " + middleName;
			if (lastName != null)
				personName = personName + lastName;
		} else {
			if (firstName != null)
				personName = personName + " " + firstName;
			if (middleName != null)
				personName = personName + " " + middleName;
			if (lastName != null)
				personName = personName + lastName;
		}
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String number = new String(array, Charset.forName("UTF-8"));
	    connectionTypeForNumberMap.put(number, connectionType);
		cd.put(number, z);
		PhoneConnection connection =
				connectionForATypeMap.get(connectionType);
		if (connection == null) {
		throw new IllegalStateException();
		}
		connection.activate(personName, number);
		return number;
	}

	/**
	 * This method takes number as input and generates post paid bills
	 * 
	 * @param n
	 * @return
	 **/
	public String bill(String number) {
		ConnectionType connectionType = connectionTypeForNumberMap.get(number);
		if (connectionType == null) {
			throw new RuntimeException();
		}
		
		PhoneConnection connection =
				connectionForATypeMap.get(connectionType); 
		
		return connection.generateBillFor(number);
	}

	public void chargeIncomingSms(String num) {
		// code....
		// ....
	}
}
