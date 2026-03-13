import servicios.IReservaRepository
import presentacion.ConsolaReserva
import servicios.ReservaService
import datos.ReservaRepositoryImpl

fun main() {
    val repositorio: IReservaRepository = ReservaRepositoryImpl()
    val servicio = ReservaService(repositorio)
    val consola = ConsolaReserva(servicio)

    consola.ejecutar()
}