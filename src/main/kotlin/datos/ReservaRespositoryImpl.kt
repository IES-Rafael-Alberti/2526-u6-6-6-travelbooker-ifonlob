package datos

import dominio.Reserva
import servicios.IReservaRepository

class ReservaRespositoryImpl : IReservaRepository {
    private val reservas : MutableList<Reserva> = mutableListOf()

    override fun agregar(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun obtenerTodas(): List<Reserva> {
        val listadoReservas : MutableList<Reserva> = mutableListOf()
        reservas.forEach{
            listadoReservas.add(it)
        }
        return listadoReservas
    }
}