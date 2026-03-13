package servicios

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo

class ReservaService(private val repositorio : IReservaRepository) {

    fun crearVuelo(origen: String, destino: String, hora: String): Reserva {
        val reservaVuelo = ReservaVuelo.crearInstancia(origen, destino,hora)
        return reservaVuelo
    }

    fun crearHotel(id : String, fechaCreacion : String, descripcion : String, ubicacion : String, numeroNoches : Int) : Reserva{
        val reservaHotel = ReservaHotel.crearInstancia(ubicacion, numeroNoches)
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