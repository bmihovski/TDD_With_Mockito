package com.edu.chapter03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceCatalogue {
	
	private List<Procedure> procs = new ArrayList<Procedure>();

	public void add(Procedure proc) {
		procs.add(proc);
	}

	public Procedure find(String id) {
		return procs.stream()
					.filter(e -> e.getId().equals(id))
					.findAny()
					.orElse(null);
	}

	public BigDecimal findPriceBy(String id) {
		final Procedure filteredProcedure = find(id);
		
		return filteredProcedure.getPrice();
	}

}
