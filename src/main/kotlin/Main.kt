import datos.ReservaRespositoryImpl
import servicios.IReservaRepository
import presentacion.ConsolaReserva

fun main() {
    val repositorio: IReservaRepository = ReservaRepositoryImpl()
    val servicio = ReservaService(repositorio)
    val consola = ConsolaReserva(servicio)

    consola.ejecutar() // ← Lanza el programa
}