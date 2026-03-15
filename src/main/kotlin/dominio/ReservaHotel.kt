package dominio

class ReservaHotel private constructor(id : String, fechaCreacion : String,descripcion : String, val ubicacion : String, val numeroNoches : Int) : Reserva(id,fechaCreacion,descripcion){
    /**
     * Representa reserva de hotel.
     * Hereda propiedades comunes de Reserva (id, fecha, descripción).
     * Propiedades específicas: ubicación y número de noches.
     */
    companion object{
        /**
         * Establece la única forma de crear instancias
         * Constructor privado impide instanciación directa.
         *
         * @param ubicacion Ciudad/nombre hotel
         * @param numeroNoches Días de estancia
         * @return Nueva ReservaHotel con id/fecha automáticos
         */
        fun crearInstancia(ubicacion : String, numeroNoches : Int) = ReservaHotel(id = generarId(),fechaCreacion = generarFecha(),descripcion = "descripcion-test",ubicacion,numeroNoches)
    }
    /**
     * Detalle específico para hotel.
     * Formato: "id - descripción - ubicación(numeroNoches)"
     */
    override val detalle : String
        get() = "$id - $descripcion - $ubicacion($numeroNoches)"

    /**
     * Detalle específico para hotel.
     * Formato: "id - descripción - ubicación(numeroNoches)"
     */

    override fun toString() : String{
        return "Reserva de hotel con id $id creada el $fechaCreacion con descripción $(descripcion).\nEn $ubicacion $numeroNoches noches."
    }
}