package com.edu.chapter02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.edu.chapter02.PhoneConnection.ConnectionType;

public class OnceYouBuyYouStartCryingTelephone {
	private static final String SPACE = " ";
	private Map<String, Date> cd = new HashMap<String, Date>();
	private Map<ConnectionType, PhoneConnection> connectionForATypeMap = new HashMap<ConnectionType, PhoneConnection>();
	private Map<String, ConnectionType> connectionTypeForNumberMap = new HashMap<String, ConnectionType>();

	public OnceYouBuyYouStartCryingTelephone() {
		initialize();
	}

	private void initialize() {
		connectionForATypeMap.put(ConnectionType.TWO_G, new TwoGConnection());
		connectionForATypeMap.put(ConnectionType.THREE_G, new ThreeGConnection());
		connectionForATypeMap.put(ConnectionType.FOUR_G, new FourGConnection());
	}

	public String addConnection(PersonName personName, Date z, ConnectionType connectionType) {
		if (personName.getFirstName() == null || personName.getLastName() == null || z == null)
			throw new RuntimeException();
		
		
		Random random = new Random();
		String number = String.valueOf(random.nextInt(1000));
		connectionTypeForNumberMap.put(number, connectionType);
		cd.put(number, z);
		PhoneConnection connection = connectionForATypeMap.get(connectionType);
		if (connection == null) {
			throw new IllegalStateException();
		}
		connection.activate(personName, number);
		return number;
	}

	protected String buildName(PersonName name) {
		StringBuilder personName = new StringBuilder();
		if (name.getFirstName() != null) {
			personName.append(name.getFirstName()).append(SPACE);
		}

		if (name.getMiddleName() != null) {
			personName.append(name.getMiddleName()).append(SPACE);
		}
		if (name.getLastName() != null) {
			personName.append(name.getLastName());
		}
		return personName.toString();
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

		PhoneConnection connection = connectionForATypeMap.get(connectionType);

		return connection.generateBillFor(number);
	}

	public void chargeIncomingSms(String num) {
		// code....
		// ....
	}
}
