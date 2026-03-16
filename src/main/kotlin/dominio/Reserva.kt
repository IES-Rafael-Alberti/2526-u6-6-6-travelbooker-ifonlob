package dominio

import java.time.LocalDate
import java.time.ZoneId
/**
 * Superclase abstracta base para todas las reservas.
 * Define propiedades comunes (id, fechaCreacion, descripcion) y lógica compartida.
 * No se puede instanciar directamente.
 */
abstract class Reserva(val id : String = generarId(), val fechaCreacion : String = generarFecha(), val descripcion : String){
    /**
     * Valida formato fecha inmediatamente tras construcción.
     * yyyy-MM-dd (ej: 2026-03-14)
     * */
    init{
        val fechaRegex = """\d{4}-\d{2}-\d{2}""".toRegex()
        require(fechaRegex.containsMatchIn(fechaCreacion))
    }
    companion object{
        /** Contador autoincremental global para IDs únicos */
        private var contadorId = 0
        /**
         * Genera nuevo ID autoincremental (1, 2, 3...).
         * @return String con siguiente ID
         */
        fun generarId() : String{
            contadorId++
            return contadorId.toString()
        }
        /**
         * Obtiene fecha actual en formato yyyy-MM-dd.
         * @return String con fecha sistema
         */
        fun generarFecha() : String{
            val fechaAnsi =  LocalDate.now(ZoneId.systemDefault()).toString()
            return fechaAnsi
        }
    }
    /**
     * Propiedad calculada (sobrescrita en subclases).
     * Formato base: "id - descripcion"
     */
    open val detalle : String
        get() = "$id - $descripcion"

}