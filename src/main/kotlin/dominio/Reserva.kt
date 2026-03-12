package dominio

import java.time.LocalDateTime

abstract class Reserva(val id : String, var fechaCreacion : String, val descripcion : String){
    open val detalle : String
        get() = "$id $descripcion"

}