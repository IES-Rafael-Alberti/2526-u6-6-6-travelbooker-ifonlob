package presentacion

import servicios.ReservaService
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
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
    private val t = Terminal()
    fun ejecutar() {
        var terminado : Boolean = false
        while (!terminado) {
            mostrarMenuPrincipal()
            t.println(white("\nPresiona Enter para continuar o X para salir..."))
            val resultado = readlnOrNull()?.trim()?.uppercase() ?: ""
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
        t.println(buildString {
                    appendLine(bold(blue("=== BIENVENIDO/A AL SISTEMA DE GESTIÓN DE RESERVAS ===\n")))
                    appendLine(cyan("Elija una opción:\n"))
                    appendLine(yellow("1.") + " Crear nueva reserva")
                    appendLine(yellow("2.") + " Listar todas las reservas")
                    appendLine(yellow("3.") + " Buscar una reserva por su ID")
                })

            val opcion = readlnOrNull() ?: ""
            if(!opcion.isEmpty()){
                when(opcion){
                    "1" -> mostrarMenuReserva()
                    "2" -> {
                        t.println(brightWhite("\n--- LISTADO DE RESERVAS ---"))
                        app.obtenerReservas().forEach {
                            t.println(green("  - ") + it.toString())
                        }
                    }
                    "3" -> {
                        t.print(magenta("Introduzca el ID de la reserva: "))
                        val idEscrito = readln()
                        val reservaPorID = app.buscarPorId(idEscrito)
                        if(reservaPorID != null){
                            t.println(brightWhite("Encontrada: ") + reservaPorID)
                        }
                        else{
                            t.println(red("No se ha encontrado ninguna reserva con el ID: $idEscrito"))
                        }
                    }
                    else -> t.println(red("Selecciona una opción válida"))
                }
            }
            else{
                t.println(red("Por favor, introduzca una opción."))
            }
        }
    /**
     * Submenú para elegir tipo de reserva (vuelo/hotel).
     */
    private fun mostrarMenuReserva(){
        t.println(cyan("\nSeleccione el tipo de reserva:"))
        t.println("1. Crear reserva " + brightBlue("vuelo"))
        t.println("2. Crear reserva " + brightMagenta("hotel"))

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
        t.print(cyan("Destino: "))
        val destinoEscrito = readlnOrNull()?.trim() ?: ""
        t.print(cyan("Origen: "))
        val origenEscrito = readlnOrNull()?.trim() ?: ""
        t.print(cyan("Hora (HH:MM): "))
        val horaEscrita = readlnOrNull()?.trim() ?: ""
        app.crearVuelo(origenEscrito,destinoEscrito,horaEscrita)
        t.println(green("¡Reserva de vuelo registrada correctamente!"))
        }
    /**
     * Captura datos de hotel desde consola y crea reserva.
     * Convierte noches a Int con valor por defecto.
     */
    private fun datosHotel(){
        t.print(cyan("Ubicación del hotel: "))
        val ubicacionEscrita = readlnOrNull()?.trim() ?: ""
        t.print(cyan("Número de noches: "))
        val numeroNoches = readlnOrNull()?.toIntOrNull() ?: 1
        app.crearHotel(ubicacionEscrita,numeroNoches)
        t.println(green("¡Reserva de hotel registrada correctamente!"))
        }
}
