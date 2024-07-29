package com.ejemplo.microservicio2.test;

import com.ejemplo.microservicio2.entity.Cuenta;
import com.ejemplo.microservicio2.repository.CuentaRepository;
import com.ejemplo.microservicio2.service.CuentaService;
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
public class CuentaServiceTests {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @Test
    public void testCreateCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(BigDecimal.valueOf(1000));
        cuenta.setEstado(true);

        Mockito.when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        assertThat(cuentaService.createCuenta(cuenta)).isEqualTo(cuenta);
    }
}
