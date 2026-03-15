package servicios

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo
/**
 * Clase que contiene la lógica de negocio. Depende de abstracción repositorio (DIP).
 * Crea reservas mediante métodos estáticos y las guarda en el repositorio de reservas.
 */
class ReservaService(private val repositorio : IReservaRepository) {
    /**
     * Crea reserva vuelo y la guarda en repositorio.
     *
     * @param origen Aeropuerto de salida
     * @param destino Aeropuerto de llegada
     * @param hora Formato HH:MM (validado por regex en dominio)
     * @return Instancia ReservaVuelo creada y guardada
     */
    fun crearVuelo(origen: String, destino: String, hora: String): Reserva {
        val reservaVuelo = ReservaVuelo.crearInstancia(origen, destino,hora)
        repositorio.agregar(reservaVuelo)
        return reservaVuelo
    }
    /**
     * Crea reserva hotel y la guarda en repositorio.
     *
     * @param ubicacion Ciudad/nombre del hotel
     * @param numeroNoches Duración de la estancia
     * @return Instancia ReservaHotel creada y guardada
     */
    fun crearHotel(ubicacion : String, numeroNoches : Int) : Reserva{
        val reservaHotel = ReservaHotel.crearInstancia(ubicacion, numeroNoches)
        repositorio.agregar(reservaHotel)
        return reservaHotel
    }
    /**
     * Obtiene lista completa de reservas almacenadas.
     *
     * @return Lista de todas las reservas.
     */
    fun obtenerReservas() = repositorio.obtenerTodas()

    /**
     * Busca reserva específica por su ID único.
     *
     * @param id Identificador de la reserva (generado automáticamente)
     * @return Reserva encontrada o null si no existe
     */
    fun buscarPorId(id: String) : Reserva?{
        val reserva = repositorio.obtenerTodas().find{it.id == id}
        return reserva
    }
}