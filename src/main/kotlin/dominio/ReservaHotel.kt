package dominio

class ReservaHotel private constructor(id : String, fechaCreacion : Date, descripcion : String, val ubicacion : String, val numeroNoches : Int) : Reserva(id,fechaCreacion,descripcion){
    companion object{
        fun crearInstancia(id : String, fechaCreacion : Date, descripcion : String, ubicacion : String, numeroNoches : Int) = ReservaVueloid : String, fechaCreacion : Date, descripcion : String, ubicacion : String, numeroNoches : Int))
    }
    val detalle : String
        get() = "$id - $descripcion - $ubicacion($numeroNoches)"

    override fun toString(){
        println("Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nEn $ubicacion $numeroNoches noches." )
    }
}