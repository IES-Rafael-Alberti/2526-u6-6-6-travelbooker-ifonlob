package servicios

interface IReservaRepository<T : Reserva> {
    fun agregar(reserva: T)
    fun obtenerTodas(): List<T>
}