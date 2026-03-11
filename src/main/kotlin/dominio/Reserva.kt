package dominio

import java.time.LocalDateTime

abstract class Reserva(val id : String, var fechaCreacion : LocalDateTime, val descripcion : String){
    init{
        fechaCreacion = LocalDateTime.now()
    }
    open val detalle : String
        get() = "$id $descripcion"

}