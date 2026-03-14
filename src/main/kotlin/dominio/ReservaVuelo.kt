package dominio

/**
 * Representa reserva de vuelo.
 * Hereda propiedades comunes de Reserva (id, fecha, descripción).
 * Propiedades específicas: origen, destino, horaVuelo (con validación regex).
 */
class ReservaVuelo private constructor(id : String, fechaCreacion: String, descripcion : String,val origen : String, val destino : String, val horaVuelo : String) : Reserva(id,fechaCreacion,descripcion){
    init{
        val horaRegex = "^([01][0-9]|2[0-3]):[0-5][0-9]$".toRegex()
        require(horaRegex.containsMatchIn(horaVuelo))
    }
    companion object{
        /**
         * Factory method (única forma de crear instancia).
         * Constructor privado impide creación directa.
         *
         * @param origen Aeropuerto salida
         * @param destino Aeropuerto llegada
         * @param horaVuelo Hora formato HH:MM
         * @return Nueva ReservaVuelo validada
         */
        fun crearInstancia(origen : String, destino : String, horaVuelo : String) = ReservaVuelo(id = generarId() , fechaCreacion = generarFecha(),descripcion = "descripcion-test", origen, destino, horaVuelo)
    }
    /**
     * Detalle específico para vuelo.
     * Formato: "id - descripción - origen → destino [horaVuelo]"
     */

    override val detalle : String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    /**
     * Representación completa legible de reserva vuelo.
     */
    override fun toString() : String{
        return "Reserva de vuelo con id $id creada el $fechaCreacion con descripción (${descripcion}).\nOrigen: $origen Destino: $destino Hora vuelo: $horaVuelo"
    }

}