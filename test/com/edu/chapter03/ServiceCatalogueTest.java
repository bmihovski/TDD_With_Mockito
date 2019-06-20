package com.edu.chapter03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ServiceCatalogueTest {
	ServiceCatalogue catalogue;
	@Before
	public void setup() {
		catalogue = new ServiceCatalogue();
	}
	
	
	@Test
	public void user_can_add_a_service_to_catalogue() {
		Procedure proc = new Procedure("1234", "Basic Oxygen Setup", null);
		
		catalogue.add(proc);
		assertNotNull(catalogue.find(proc.getId()));
		assertEquals(catalogue.find(proc.getId()), proc);
	}
	
	@Test
	public void catalogue_returns_null_for_an_unconfigured_procedure_id() throws Exception {
		Procedure proc = new Procedure("123", "Basic Oxygen Setup", null);
		
		catalogue.add(proc);
		
		assertNull(catalogue.find("324"));
	}
	
	@Test
	public void catalogue_returns_procedure_and_price_for_a_configured_procedure_id() {
		Procedure proc1 = new Procedure("1234", "Basic Oxygen Setup", BigDecimal.TEN);
		Procedure proc2 = new Procedure("6784", "Basic Oxygen Setup", BigDecimal.ONE);
		
		catalogue.add(proc1);
		catalogue.add(proc2);
		
		assertNotNull("Expected a procedure", catalogue.find("6784"));
		
		assertEquals(catalogue.findPriceBy(proc1.getId()), BigDecimal.TEN);
		assertEquals(catalogue.findPriceBy(proc2.getId()), BigDecimal.ONE);
	}
}
