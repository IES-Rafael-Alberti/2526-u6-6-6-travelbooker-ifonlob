package datos

import dominio.Reserva
import servicios.IReservaRepository
/**
 * Implementación repositorio en memoria usando MutableMap.
 * Almacena reservas por ID único.
 * Implementa a la interfaz IReservaRepository para generar abstracción (DIP)
 */
class ReservaRepositoryImpl : IReservaRepository {

    /** Mapa reservas: clave=ID, valor=Reserva */
    private val reservas : MutableMap<String,Reserva> = mutableMapOf()
    /**
     * Guarda nueva reserva usando su ID como clave única.
     *
     * @param reserva Instancia Reserva a almacenar
     */
    override fun agregar(reserva: Reserva) {
        reservas[reserva.id] = reserva
    }
    /**
     * Devuelve lista con todas las reservas almacenadas.
     *
     * @return Lista completa de reservas
     */
    override fun obtenerTodas(): List<Reserva> {
        val listadoReservas : MutableList<Reserva> = mutableListOf()
        for(reserva in reservas.values){
            listadoReservas.add(reserva)
        }
        return listadoReservas
    }
}