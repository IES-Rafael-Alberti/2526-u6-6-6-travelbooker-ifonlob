package servicios

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo

class ReservaService(private val repositorio : IReservaRepository) {

    fun crearVuelo(descripcion: String, fechaCreacion : String,origen: String, destino: String, hora: String): Reserva {
        val reservaVuelo = ReservaVuelo.crearInstancia(descripcion, fechaCreacion, origen, destino,destino,hora)
        return reservaVuelo
    }

    fun crearHotel(id : String, fechaCreacion : String, descripcion : String, ubicacion : String, numeroNoches : Int) : Reserva{
        val reservaHotel = ReservaHotel.crearInstancia(id, fechaCreacion, descripcion, ubicacion, numeroNoches)
        return reservaHotel
    }
}