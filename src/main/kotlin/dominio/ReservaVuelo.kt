package dominio

class ReservaVuelo private constructor(id : String, fechaCreacion: String, descripcion : String,val origen : String, val destino : String, val horaVuelo : String) : Reserva(id,fechaCreacion,descripcion){
    init{
        val horaRegex = "^([01][0-9]|2[0-3]):[0-5][0-9]$".toRegex()
        require(horaRegex.containsMatchIn(horaVuelo))
    }
    companion object{
        fun crearInstancia(origen : String, destino : String, horaVuelo : String) = ReservaVuelo(id = generarId() , fechaCreacion = generarFecha(),descripcion = "descripcion-test", origen, destino, horaVuelo)
    }

    override val detalle : String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    override fun toString() : String{
        return "Reserva con id $id creada el $fechaCreacion con descripción (${descripcion}).\nOrigen: $origen Destino: $destino Hora vuelo: $horaVuelo"
    }

}