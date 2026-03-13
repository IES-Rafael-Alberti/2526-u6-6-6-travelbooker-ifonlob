package dominio

abstract class Reserva(val id : String = Reserva.generarId().toString(), val fechaCreacion = , val descripcion : String){

    companion object{
        private var contadorId = 0

        fun generarId() : Int{
            contadorId++
            return contadorId
        }
    }

    open val detalle : String
        get() = "$id $descripcion"

}