package logica;

import baseDatos.PropietarioBD;
import clases.Propietario;

public class PropietarioLogica {
    private PropietarioBD propietarioBD;

    public PropietarioLogica() {
        this.propietarioBD = new PropietarioBD();
    }

    public boolean existePropietario(String cedula) {
        return propietarioBD.existePropietario(cedula);
    }

    public int obtenerIdPorCedula(String cedula) {
        return propietarioBD.obtenerIdPorCedula(cedula);
    }

    public int agregarPropietarioConId(Propietario propietario) {
        if (!existePropietario(propietario.getCedula())) {
            return propietarioBD.agregarPropietarioConId(propietario);
        } else {
            throw new IllegalStateException("El propietario con cédula " + propietario.getCedula() + " ya existe.");
        }
    }
}