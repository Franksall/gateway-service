package com.example.gateway_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// --- ¡AÑADE ESTOS IMPORTS! ---
import org.springframework.boot.SpringApplication;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

@SpringBootTest
class GatewayServiceApplicationTests {

    @Test
    void contextLoads() {
        // Esta prueba ya la teníamos y pasa
    }

    // --- ¡AÑADE ESTA NUEVA PRUEBA! ---
    @Test
    void main() {
        // Esta prueba "cubre" el método main() para Jacoco

        // 1. Preparamos un mock para la llamada estática 'SpringApplication.run'
        try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {

            // 2. Llamamos al método main() real
            GatewayServiceApplication.main(new String[] {});

            // 3. Verificamos que 'SpringApplication.run' fue llamado 1 vez
            mocked.verify(() -> SpringApplication.run(GatewayServiceApplication.class, new String[] {}), times(1));
        }
    }

}