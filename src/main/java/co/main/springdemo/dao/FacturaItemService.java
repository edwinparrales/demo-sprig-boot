package co.main.springdemo.dao;


import co.main.springdemo.modelo.FacturaItem;
import co.main.springdemo.repositorio.FacturaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaItemService {
    @Autowired
    private FacturaItemRepository facturaItemRepository;


    public List<FacturaItem> listar() {
        List<FacturaItem> items = new ArrayList<>();

        try {

            items = facturaItemRepository.findAll();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return items;


    }


}
