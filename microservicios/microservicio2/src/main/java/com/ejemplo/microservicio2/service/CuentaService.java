package com.ejemplo.microservicio2.service;

import com.ejemplo.microservicio2.entity.Cuenta;
import com.ejemplo.microservicio2.exception.ResourceNotFoundException;
import com.ejemplo.microservicio2.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
    }

    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuentaDetails) {
        Cuenta cuenta = getCuentaById(id);
        cuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
        cuenta.setEstado(cuentaDetails.getEstado());
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        Cuenta cuenta = getCuentaById(id);
        cuentaRepository.delete(cuenta);
    }
}
