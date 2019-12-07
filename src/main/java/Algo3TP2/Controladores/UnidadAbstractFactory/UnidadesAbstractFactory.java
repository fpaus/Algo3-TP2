package Algo3TP2.Controladores.UnidadAbstractFactory;

public class UnidadesAbstractFactory {

    public static UnidadFactory getFactory(String tipoDeFabrica){

        if (tipoDeFabrica.equalsIgnoreCase("EquipoAzul")){
            return new UnidadEquipoAzulFactory();
        }else if (tipoDeFabrica.equalsIgnoreCase("EquipoRojo")){
            return new UnidadEquipoRojoFactory();
        }

        return null;
    }
}
