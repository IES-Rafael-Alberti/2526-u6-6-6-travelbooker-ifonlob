package dominio

import java.time.LocalDateTime

class ReservaHotel private constructor(id : String, fechaCreacion : LocalDateTime, descripcion : String, val ubicacion : String, val numeroNoches : Int) : Reserva(id,fechaCreacion,descripcion){
    companion object{
        fun crearInstancia(id : String, fechaCreacion : LocalDateTime, descripcion : String, ubicacion : String, numeroNoches : Int) = ReservaHotel(id,fechaCreacion,descripcion,ubicacion,numeroNoches)
    }
    override val detalle : String
        get() = "$id - $descripcion - $ubicacion($numeroNoches)"

    override fun toString(){
        println("Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nEn $ubicacion $numeroNoches noches." )
    }
}