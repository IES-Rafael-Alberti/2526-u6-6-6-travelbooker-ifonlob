package dominio

import java.time.LocalDate
import java.time.ZoneId

abstract class Reserva(val id : String = generarId(), val fechaCreacion : String = generarFecha(), val descripcion : String){
    init{
        val fechaRegex = """\d{4}-\d{2}-\d{2}""".toRegex()
        require(fechaRegex.containsMatchIn(fechaCreacion))
    }
    companion object{
        private var contadorId = 0

        fun generarId() : String{
            contadorId++
            return contadorId.toString()
        }

        fun generarFecha() : String{
            val fechaAnsi =  LocalDate.now(ZoneId.systemDefault()).toString()
            return fechaAnsi
        }
    }

    open val detalle : String
        get() = "$id - $descripcion"

}