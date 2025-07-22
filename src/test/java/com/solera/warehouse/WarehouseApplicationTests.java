package com.solera.warehouse;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.warehouse.model.Vehicle;

@SpringBootTest
class WarehouseApplicationTests {
	Vehicle vehicle = new Vehicle(1, "Toyota Camry", "Toyota", "2023", "Blue", "123456789", null, null);

	@Test
	void createAVehicle(){
		assertInstanceOf(Vehicle.class, vehicle);
	}

}
