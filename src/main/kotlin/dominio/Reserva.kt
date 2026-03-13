package dominio

import java.time.LocalDate
import java.time.ZoneId

abstract class Reserva(val id : String = Reserva.generarId().toString(), val fechaCreacion : String = Reserva.generarFecha(), val descripcion : String){
    init{
        val fechaRegex = """\d{4}-\d{2}-\d{2}""".toRegex()
        require(fechaRegex.containsMatchIn(fechaCreacion))
    }
    companion object{
        private var contadorId = 0

        fun generarId() : Int{
            contadorId++
            return contadorId
        }

        fun generarFecha() : String{
            val fechaAnsi =  LocalDate.now(ZoneId.systemDefault()).toString()
            return fechaAnsi
        }
    }

    open val detalle : String
        get() = "$id $descripcion"

}