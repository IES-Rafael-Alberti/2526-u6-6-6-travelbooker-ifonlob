abstract class Reserva(val id : String, val fechaCreacion : Date,val descripcion : String){
    init{
        fechaCreacion = now()
    }
    val detalle : String
        get() = "$id $descripcion"

}