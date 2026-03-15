package presentacion

import servicios.ReservaService
/**
 * Interfaz de usuario en consola.
 * Recibe ReservaService por inyección de dependencias (DIP).
 * Maneja entrada/salida y navegación menús.
 */
class ConsolaReserva(private val app : ReservaService) {
    /**
     * Ejecuta bucle principal.
     * Sale con 'X' tras cada operación.
     */
    fun ejecutar() {
        var terminado : Boolean = false
        while (!terminado) {
            mostrarMenuPrincipal()
            println("\nPresiona Enter para continuar o X para salir...")
            val resultado = readln().trim().uppercase()
            if(resultado == "X"){
                terminado = true
            }
        }
    }
    /**
     * Muestra menú principal y ejecuta opción seleccionada.
     * Opciones: crear, listar, buscar reservas.
     */
    private fun mostrarMenuPrincipal(){
            println(buildString{
                appendLine("=== BIENVENIDO/A AL SISTEMA DE GESTIÓN DE RESERVAS ===\n")
                appendLine("Elija una opción:\n")
                appendLine("1. Crear nueva reserva\n")
                appendLine("2. Listar todas las reservas\n")
                appendLine("3. Buscar una reserva por su ID\n")
            })

            val opcion = readlnOrNull() ?: ""
            if(!opcion.isEmpty()){
                when(opcion){
                    "1" -> mostrarMenuReserva()
                    "2" -> {
                        app.obtenerReservas().forEach {
                            println("- $it")
                        }
                    }
                    "3" -> {
                        println("Introduzca el ID de la reserva a continuación:\n")
                        val idEscrito = readln()
                        val reservaPorID = app.buscarPorId(idEscrito)
                        if(reservaPorID != null){
                            println(reservaPorID)
                        }
                        else{
                            println("No se ha encontrado ninguna reserva con ese ID")
                        }
                    }
                    else -> println("Selecciona una opción válida")
                }
            }
            else{
                println("Por favor, introduzca una opción.")
            }
        }
    /**
     * Submenú para elegir tipo de reserva (vuelo/hotel).
     */
    private fun mostrarMenuReserva(){
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
    /**
     * Captura datos de vuelo desde consola y crea reserva.
     * Llama servicio que valida y guarda.
     */
    private fun datosVuelo(){
            println("Escriba el destino a continuación:\n")
            val destinoEscrito = readln()
            println("Ahora escriba el origen:\n")
            val origenEscrito = readln()
            println("Por último escriba la hora del vuelo:\n")
            val horaEscrita = readln()
            app.crearVuelo(origenEscrito,destinoEscrito,horaEscrita)
            println("¡Se ha registrado correctamente tu reserva!")
        }
    /**
     * Captura datos de hotel desde consola y crea reserva.
     * Convierte noches a Int con valor por defecto.
     */
    private fun datosHotel(){
            println("Escriba a continuación la ubicación del hotel:\n")
            val ubicacionEscrita = readln()
            println("Ahora escriba el número de noches:")
            val numeroNoches = readlnOrNull()?.toInt() ?: 1
            app.crearHotel(ubicacionEscrita,numeroNoches)
            println("¡Se ha registrado correctamente tu reserva!")
        }
}
