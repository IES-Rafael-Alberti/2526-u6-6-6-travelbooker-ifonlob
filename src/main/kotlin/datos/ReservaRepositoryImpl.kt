package datos

import dominio.Reserva
import servicios.IReservaRepository

class ReservaRepositoryImpl : IReservaRepository {
    private val reservas : MutableMap<String,Reserva> = mutableMapOf()

    override fun agregar(reserva: Reserva) {
        reservas[reserva.id] = reserva
    }

    override fun obtenerTodas(): List<Reserva> {
        val listadoReservas : MutableList<Reserva> = mutableListOf()
        for(reserva in reservas.values){
            listadoReservas.add(reserva)
        }
        return listadoReservas
    }
}