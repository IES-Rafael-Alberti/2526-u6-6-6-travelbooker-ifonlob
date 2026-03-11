package dominio

import java.time.LocalDateTime

class ReservaVuelo private constructor(id : String, fechaCreacion : LocalDateTime, descripcion : String, val origen : String, val destino : String, val horaVuelo : Int) : Reserva(id,fechaCreacion,descripcion){
    companion object{
        fun crearInstancia(id : String, fechaCreacion : LocalDateTime, descripcion : String, origen : String, destino : String, horaVuelo : Int) = ReservaVuelo(id,fechaCreacion ,descripcion, origen, destino, horaVuelo)
    }
    override val detalle : String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"

    override fun toString() : String{
        return "Reserva con id $id creada el $fechaCreacion con descripción $(descripcion).\nOrigen: $origen Destino: $destino Hora vuelo: $horaVuelo"
    }
}