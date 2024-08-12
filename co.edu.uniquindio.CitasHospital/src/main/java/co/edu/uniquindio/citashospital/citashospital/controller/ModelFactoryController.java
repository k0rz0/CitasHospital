package co.edu.uniquindio.citashospital.citashospital.controller;

import co.edu.uniquindio.citashospital.citashospital.model.Hospital;

public class ModelFactoryController {
    private static ModelFactoryController modelFactory;

    private Hospital tiendaMascota = Hospital.builder().nombre("San juan").build();

    private ModelFactoryController(){
        inicializarDatos();
    }

    public static  ModelFactoryController getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactoryController();
        }
        return modelFactory;
    }
    private void inicializarDatos() {}
}
