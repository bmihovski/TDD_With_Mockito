package com.edu.chapter07.dao;

import com.edu.chapter07.dto.MembershipStatusDto;

public interface MembershipDAO {

	MembershipStatusDto getStatusFor(String id);
	
}
