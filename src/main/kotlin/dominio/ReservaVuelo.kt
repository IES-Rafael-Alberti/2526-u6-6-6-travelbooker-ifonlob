package dominio

class ReservaVuelo private constructor(id : String, fechaCreacion: String, descripcion: String,val origen : String, val destino : String, val horaVuelo : String) : Reserva(id,fechaCreacion,descripcion){
    init{

        val horaRegex = "^([01][0-9]|2[0-3]):[0-5][0-9]$".toRegex()
        val fechaRegex = """\d{4}-\d{2}-\d{2}""".toRegex()
        require(horaRegex.containsMatchIn(horaVuelo))
        require(fechaRegex.containsMatchIn((fechaCreacion)))
    }
    companion object{
        fun crearInstancia(id : String = Reserva.generarId().toString(), fechaCreacion : String, descripcion : String, origen : String, destino : String, horaVuelo : String) = ReservaVuelo(fechaCreacion ,descripcion, origen, destino, horaVuelo)
    }


    override val detalle : String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    override fun toString() : String{
        return "Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nOrigen: $origen Destino: $destino Hora vuelo: $horaVuelo"
    }

}