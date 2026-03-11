package dominio

class ReservaVuelo private constructor(id : String, fechaCreacion : Date, descripcion : String, val origen : String, val destino : String, val horaVuelo : Int) : Reserva(id,fechaCreacion,descripcion){
    companion object{
        fun crearInstancia(id : String, fechaCreacion : Date, descripcion : String, origen : String, destino : String, horaVuelo : Int) = ReservaVuelo(id : String, fechaCreacion : Date, descripcion : String, origen : String, destino : String, horaVuelo : Int))
    }
    val detalle : String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    override fun toString(){
        println("Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nOrigen: $origen Destino: $destino Hora vuelo: $horaVuelo" )
    }
}