package com.example.service_log;

		import org.junit.jupiter.api.Test;
		import org.mockito.Mockito;
		import org.slf4j.Logger;
		import org.springframework.http.ResponseEntity;

		import static org.junit.jupiter.api.Assertions.assertEquals;
		import static org.junit.jupiter.api.Assertions.assertThrows;
		import static org.mockito.Mockito.*;

public class ServiceLogApplicationTests {

	@Test
	public void testLogRequest_validMessage() {
		Logger loggerMock = Mockito.mock(Logger.class);
		LogController controller = new LogController();

		String validMessage = "Test log message";

		ResponseEntity<Void> response = controller.logRequest(validMessage);

		// Check successful response status
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void testLogRequest_emptyMessage() {
		Logger loggerMock = Mockito.mock(Logger.class);
		LogController controller = new LogController();

		String emptyMessage = "";

		ResponseEntity<Void> response = controller.logRequest(emptyMessage);

		// Check error status
		assertEquals(400, response.getStatusCodeValue());
	}




}

