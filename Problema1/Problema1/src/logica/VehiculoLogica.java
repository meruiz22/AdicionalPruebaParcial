package logica;

import baseDatos.VehiculoBD;
import clases.Vehiculo;

public class VehiculoLogica {
    private VehiculoBD vehiculoBD;

    public VehiculoLogica() {
        this.vehiculoBD = new VehiculoBD();
    }

    public boolean existeVehiculo(String placa) {
        return vehiculoBD.existeVehiculo(placa);
    }

    public int obtenerIdPorPlaca(String placa) {
        return vehiculoBD.obtenerIdPorPlaca(placa);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (!existeVehiculo(vehiculo.getPlaca())) {
            vehiculoBD.agregarVehiculo(vehiculo);
        } else {
            throw new IllegalStateException("El vehículo con placa " + vehiculo.getPlaca() + " ya existe.");
        }
    }
}