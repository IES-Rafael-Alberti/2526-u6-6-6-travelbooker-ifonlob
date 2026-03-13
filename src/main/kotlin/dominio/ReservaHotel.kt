package dominio

class ReservaHotel private constructor(id : String, fechaCreacion : String,descripcion : String, val ubicacion : String, val numeroNoches : Int) : Reserva(id,fechaCreacion,descripcion){

    companion object{
        fun crearInstancia(descripcion : String, ubicacion : String, numeroNoches : Int) = ReservaHotel(id = generarId(),fechaCreacion = generarFecha(),descripcion,ubicacion,numeroNoches)
    }
    override val detalle : String
        get() = "$id - $descripcion - $ubicacion($numeroNoches)"

    override fun toString() : String{
        return "Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nEn $ubicacion $numeroNoches noches."
    }
}