package servicios

import dominio.Reserva
/**
 * Interfaz repositorio. Abstracción para aplicar DIP.
 * La lógica negocio depende de esta interfaz, no de implementación concreta.
 */
interface IReservaRepository {
    /**
     * Almacena nueva reserva usando su ID como clave.
     *
     * @param reserva Instancia Reserva a guardar
     */
    fun agregar(reserva: Reserva)
    /**
     * Recupera todas las reservas almacenadas.
     *
     * @return Lista completa de reservas
     */
    fun obtenerTodas(): List<Reserva>
}