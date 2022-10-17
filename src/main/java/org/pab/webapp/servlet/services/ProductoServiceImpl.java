package org.pab.webapp.servlet.services;

import org.pab.webapp.servlet.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    @Override

    public List<Producto> listar(){
        return Arrays.asList(
            new Producto(1,"cafe","bebida",300),
            new Producto(2,"Té","bebida",200),
            new Producto(3,"pan","comida",150),
            new Producto(4,"Oreo","comida",400));
    }
}
