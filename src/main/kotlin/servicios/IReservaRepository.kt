package servicios

import dominio.Reserva

interface IReservaRepository {
    fun agregar(reserva: Reserva)
    fun obtenerTodas(): List<Reserva>
}