package com.edu.chapter07.dao;

import com.edu.chapter07.dto.MembershipStatusDTO;

public interface MembershipDAO {

	MembershipStatusDTO getStatusFor(String id);
	
}
