package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.persistence.domain.Duck;
import com.example.demo.persistence.repo.DuckRepo;

@SpringBootTest
public class DuckServiceUnitTests {

	@InjectMocks
	private DuckService service;

	@Mock
	private DuckRepo repo;

	@Test
	public void getAllDucksTest() {
		List<Duck> pond = new ArrayList<>();
		pond.add(new Duck("Ducktor Doom", "Grey", "Latveria"));
		
		Mockito.when(repo.findAll()).thenReturn(pond);
		
		assertEquals(false, this.service.readDucks().isEmpty());

		Mockito.verify(repo, times(1)).findAll();
	}
}
