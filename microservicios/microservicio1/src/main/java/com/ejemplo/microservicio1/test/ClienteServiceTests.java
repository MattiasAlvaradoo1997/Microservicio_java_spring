package com.ejemplo.microservicio1.test;

import com.ejemplo.microservicio1.entity.Cliente;
import com.ejemplo.microservicio1.repository.ClienteRepository;
import com.ejemplo.microservicio1.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClienteServiceTests {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Jose Lema");
        cliente.setContrasena("1234");
        cliente.setEstado(true);

        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        assertThat(clienteService.createCliente(cliente)).isEqualTo(cliente);
    }
}
