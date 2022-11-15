package co.main.springdemo.dao;

import co.main.springdemo.modelo.Factura;
import co.main.springdemo.repositorio.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public Factura guardar(Factura factura){
        Factura facturaNueva = new Factura();
        try {
            facturaNueva = facturaRepository.save(factura);

        }catch ( Exception e){

        }
        return facturaNueva;
    }

    public List<Factura> listar(){
        List<Factura> facturas = new ArrayList<>();
        try {
            facturas = facturaRepository.findAll();
        }catch (Exception e){

        }

        return facturas;
    }

}
