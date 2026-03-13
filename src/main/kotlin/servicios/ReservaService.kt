package servicios

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo

class ReservaService(private val repositorio : IReservaRepository) {

    fun crearVuelo(descripcion: String,origen: String, destino: String, hora: String): Reserva {
        val reservaVuelo = ReservaVuelo.crearInstancia(origen, destino,destino,hora)
        return reservaVuelo
    }

    fun crearHotel(id : String, fechaCreacion : String, descripcion : String, ubicacion : String, numeroNoches : Int) : Reserva{
        val reservaHotel = ReservaHotel.crearInstancia(descripcion, ubicacion, numeroNoches)
        return reservaHotel
    }

    fun buscarPorId(id: String) : Reserva?{
        val reserva = repositorio.obtenerTodas().find{it.id == id}
        return reserva
    }

    fun añadirReserva(reserva: Reserva){
        repositorio.agregar(reserva)
    }
}