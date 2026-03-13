package servicios

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo

class ReservaService(private val repositorio : IReservaRepository) {

    fun crearVuelo(origen: String, destino: String, hora: String): Reserva {
        val reservaVuelo = ReservaVuelo.crearInstancia(origen, destino,hora)
        repositorio.agregar(reservaVuelo)
        return reservaVuelo
    }

    fun crearHotel(ubicacion : String, numeroNoches : Int) : Reserva{
        val reservaHotel = ReservaHotel.crearInstancia(ubicacion, numeroNoches)
        repositorio.agregar(reservaHotel)
        return reservaHotel
    }

    fun obtenerReservas() = repositorio.obtenerTodas()

    fun buscarPorId(id: String) : Reserva?{
        val reserva = repositorio.obtenerTodas().find{it.id == id}
        return reserva
    }
}