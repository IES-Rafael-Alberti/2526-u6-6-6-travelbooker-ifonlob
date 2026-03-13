package presentacion

import dominio.Reserva
import dominio.ReservaHotel
import dominio.ReservaVuelo
import servicios.ReservaService

class ConsolaReserva(val app : ReservaService) {
    /* - Crear Reserva
        -Hotel
        - Vuelo
    * - Listar reservas
    * -Eliminar reservas
    * -Listar todas
    * - Buscar por ID
    * */

        fun mostrarMenuPrincipal(){
            println(buildString{
                appendLine("=== BIENVENIDO/A AL SISTEMA DE GESTIÓN DE RESERVAS ===\n")
                appendLine("Elija una opción:\n")
                appendLine("1. Crear nueva reserva\n")
                appendLine("2. Listar todas las reservas\n")
                appendLine("3. Eliminar una reserva\n")
                appendLine("4. Buscar una reserva\n")
            })

            val opcion = readlnOrNull() ?: ""
            if(!opcion.isEmpty()){
                when(opcion){
                    "1" -> mostrarMenuReserva()
                    "2" -> listarReservas()
                    "3" -> eliminarReserva()
                    "4" -> buscarReserva()
                    else -> "Selecciona una opción válida"
                }
            }
        }

        fun mostrarMenuReserva(){
            println("\n1. Crear reserva vuelo")
            println("\n2. Crear reserva hotel")

            val eleccion = readlnOrNull() ?: ""

            if(!eleccion.isEmpty()){
                when(eleccion){
                    "1" -> datosVuelo()

                    "2" -> datosHotel()
                }
            }
        }

        fun datosVuelo(){
            println("Escriba el destino a continuación:\n")
            val destinoEscrito = readln()
            println("Ahora escriba el origen:\n")
            val origenEscrito = readln()
            println("Por último escriba la hora del vuelo:\n")
            val horaEscrita = readln()
            app.crearVuelo(origenEscrito,destinoEscrito,horaEscrita)
            println("¡Se ha registrado correctamente tu reserva ")
        }

        fun datosHotel(){
            println("Escriba a continuación la ubicación del hotel:\n")
            val ubicacionEscrita = readln()
            println("Ahora escriba el número de noches:")
            val numeroNoches = readlnOrNull()?.toInt() ?: 1
        }

        fun listarReservas(){

        }

        fun  eliminarReserva(){

        }

        fun buscarReserva(){

        }
}
