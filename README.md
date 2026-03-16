# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2425_PRO_u4u5u6_taskManager

**Agrupamiento de la actividad**: Individual 

---

### Descripción: **Ejercicio: Gestor de Reservas para una Agencia de Viajes**

En este ejercicio, crearás una plicación en la que aplicarás los conceptos de Programación Orientada a Objetos (POO) en Kotlin, incluyendo herencia, interfaces, clases abstractas, principios SOLID y arquitectura en capas. La aplicación simula un gestor de reservas para una agencia de viajes, permitiendo la creación y consulta de reservas de vuelo y de hotel. 

#### **Contexto y Objetivo**

Desarrolla una aplicación de consola en Kotlin que permita gestionar **reservas** en una agencia de viajes. Estas reservas se dividen en dos tipos: **Reserva de Vuelo** y **Reserva de Hotel**. Ambas derivan de una superclase o interfaz denominada **Reserva**.

La aplicación debe seguir una **arquitectura en capas**, separando claramente:
- **La capa de presentación (UI):** se encarga de la interacción con el usuario a través de la consola.
- **La capa de lógica de aplicación:** gestiona la lógica de negocio (creación, almacenamiento y manejo de reservas).
- **La capa de acceso a datos:** aunque en este ejercicio se puede utilizar un repositorio en memoria, se debe abstraer su acceso mediante interfaces, aplicando el principio de inversión de dependencias.

#### **Requerimientos Funcionales y No Funcionales**

1. **Arquitectura en Capas y Principio de Inversión de Dependencias**
  - La lógica de negocio debe depender de abstracciones (por ejemplo, interfaces de repositorios) y no de implementaciones concretas.
  - La comunicación entre la interfaz de usuario y la lógica de negocio debe estar claramente separada.

2. **Modelo de Dominio: Reserva, Reserva de Vuelo y Reserva de Hotel**
  - **Reserva (Superclase o Interfaz):**
    - Contendrá la lógica común a todas las reservas, aunque no se permitirá la creación de una instancia de la misma.
    - Posee un **id**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **fechaCreacion**. Se asigna automáticamente al crear la instancia. No puede ser nula y no se puede modificar.
    - Posee una **descripcion**. No puede ser nula (por ejemplo, descripción del itinerario o servicio).
    - Debe incluir una propiedad `detalle`, cuyo getter utilice la lógica común para concatenar el *id* y la descripción.
  - **Reserva de Vuelo:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **origen**, **destino** y **horaVuelo**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + origen + " -> " + destino [horaVuelo]`.
    - Su constructor es **privado**. Se debe disponer de un método de clase (companion object) llamado `creaInstancia` para generar una nueva instancia.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de vuelo.
  - **Reserva de Hotel:**
    - Hereda las propiedades de Reserva.
    - Posee atributos propios: **ubicacion** y **numeroNoches**.
    - La propiedad **detalle** se genera dinámicamente, por ejemplo:  
      `id + " - " + descripcion + " - " + ubicacion (numeroNoches)`.
    - Al igual que Reserva de Vuelo, su constructor es privado y se debe utilizar el método `creaInstancia` para crear instancias.
    - Sobreescribe `toString` para mostrar formateada toda la información de la reserva de hotel.

3. **Buenas Prácticas y Principios SOLID**
  - Utiliza el principio de **inversión de dependencias**: la lógica de negocio no debe depender de clases concretas para el almacenamiento de las reservas.
  - Documenta y comenta el código de forma clara, explicando las decisiones de diseño, especialmente aquellas que no están explícitamente indicadas en la descripción.
  - Separa los métodos estáticos (en Kotlin se implementan mediante *companion objects*) y asegúrate de que la creación de instancias se haga mediante el método `creaInstancia`.
  - Integra el uso de **clases genéricas** (por ejemplo, en la implementación del repositorio) y **expresiones regulares** para validar ciertos formatos de entrada (por ejemplo, el formato de la hora en la Reserva de Vuelo).

4. **Interfaz de Usuario (Consola)**
  - La aplicación debe interactuar con el usuario a través de la consola, mostrando un menú que permita:
    - Crear una nueva reserva (seleccionando entre Reserva de Vuelo o Reserva de Hotel).
    - Listar todas las reservas registradas, mostrando el detalle de cada reserva mediante polimorfismo.
  - La capa de presentación debe comunicarse con la lógica de negocio a través de interfaces o abstracciones.

5. **Lógica de Aplicación**
  - Implementa un servicio (por ejemplo, `ReservaService`) que gestione la creación, almacenamiento (en memoria) y consulta de reservas.
  - Este servicio debe depender de una interfaz de repositorio (por ejemplo, `IReservaRepository`), permitiendo cambiar la implementación del almacenamiento sin afectar la lógica de negocio. Es decir, debéis aplicar el ppio DIP e inyectar en esta clase `ReservaService` un repositorio a través de la abstracción `IReservaRepository`.

#### **Objetivos del Ejercicio**

- Demostrar la comprensión de los fundamentos de la Programación Orientada a Objetos mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas e interfaces.
- Crear y utilizar clases que hagan uso de genéricos.
- Aplicar principios SOLID, especialmente la inversión de dependencias.
- Emplear expresiones regulares para la validación de entradas.
- Integrar y utilizar librerías externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

#### **Trabajo a Realizar**

1. **Definición de Clases y Estructura del Proyecto**
  - Organiza el proyecto en paquetes (o módulos) que representen cada capa:
    - `presentacion` para la interfaz de usuario.
    - `servicios` (o `aplicacion`) para la lógica de negocio.
    - `datos` para la implementación del repositorio (en memoria).
    - `dominio` para definir las clases **Reserva**, **Reserva de Vuelo** y **Reserva de Hotel**.

2. **Implementación del Modelo de Dominio**
  - Define la superclase o interfaz `Reserva` que incluya:
    - Las propiedades comunes (`id`, `fechaCreacion`, `descripcion` y `detalle`).
    - La lógica compartida que consideres necesaria.
  - Implementa las clases `Reserva de Vuelo` y `Reserva de Hotel` siguiendo las especificaciones:
    - Campos inmutables (por ejemplo, `id` y `fechaCreacion` generados automáticamente).
    - Las propiedades específicas de cada una (`origen`, `destino`, `horaVuelo`) y (`ubicacion`, `numeroNoches`)
    - Constructores privados con el método `creaInstancia` en el *companion object*.
    - Propiedad `detalle` que concatene la información de forma dinámica.

3. **Desarrollo de la Lógica de Aplicación**
  - Implementa un servicio (`ReservaService`) que:
    - Utilice una interfaz de repositorio (`IReservaRepository`) para almacenar y recuperar reservas (`agregar` y `obtenerTodas`).
    - Permita la creación de nuevas reservas mediante métodos que invoquen `creaInstancia` de cada clase.
  - Aplica el principio de inversión de dependencias, de modo que el servicio dependa de la abstracción, no de una implementación concreta.

4. **Interfaz de Usuario (Consola)**
  - Desarrolla una interfaz de usuario en consola que muestre un menú con las siguientes opciones:
    - **Opción 1:** Crear nueva reserva (se debe preguntar al usuario si desea crear una Reserva de Vuelo o de Hotel, y solicitar los datos requeridos).
    - **Opción 2:** Listar todas las reservas registradas, mostrando el detalle (id y descripción) de cada reserva.
  - La capa de presentación debe comunicarse con el servicio para realizar las operaciones solicitadas.

5. **Documentación y Pruebas**
  - Comenta el código de forma clara, explicando las decisiones de diseño y la aplicación de los principios SOLID.
  - Realiza pruebas y depura la aplicación para asegurar su correcto funcionamiento.

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rúbrica**: Más adelante se enviará o mostrará la rúbrica de esta práctica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse, de manera clara y detallada en este fichero, README.md

    - Al final del documento, incluid un nuevo apartado, que se llame: "Entrega de la Práctica", dónde nos realicéis una pequeña introducción explicativa de vuestro tema, es decir, el problema que vais a solucionar y cómo lo habéis resuelto. Podéis incluir los subapartados que consideréis necesarios (estructura de carpetas, explicación y organización de clases, instrucciones de instalación, manual de usuario, ejemplos de funcionamiento, etc.)

    - **MUY IMPORTANTE!!** Incluir un subapartado ("Respuestas a las preguntas planteadas") dónde se resuelvan las preguntas de evaluación que os realizamos a continuación. De forma clara y detallada, incluyendo enlaces al código que justifica vuestra respuesta si es necesario.

# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, [**asegúrate de hacer referencia y enlazar al código relevante**](https://docs.github.com/es/get-started/writing-on-github/working-with-advanced-formatting/creating-a-permanent-link-to-a-code-snippet) en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.e, 4.f)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.h)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.a, 4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.g, 7.a, 7.b, 7.c, 7.i, 7.j)**: Describe sobre tu código cómo has implementado la herencia y/o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? Mostrando tu código, contesta qué principios has utilizado y qué beneficio has obtenido.

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.i)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

#### **Criterio global 10: Expresiones Regulares**
- **(6.g)**: Muestra ejemplos de tu código donde hayas utilizado las expresiones regulares. ¿Qué beneficio has obtenido?


# Entrega de la Práctica

**Introducción explicativa:**

En esta práctica he implementado un Gestor de Reservas para Agencia de Viajes siguiendo 
arquitectura en capas y principios SOLID, especialmente DIP (Inversión de Dependencias).

**Problema resuelto:** Gestionar reservas de vuelos y hoteles con validaciones, almacenamiento en 
memoria y UI de consola, permitiendo crear reservas y listar/buscar mediante polimorfismo.

Solución elegida:
- Modelo dominio: herencia `Reserva` (abstracta) -> `ReservaVuelo`/`ReservaHotel`
- Capas separadas: Presentación -> Lógica -> Datos
- Inyección de dependencias: `ReservaService` depende de una abstracción de `IReservaRepository`

## Respuestas a las preguntas planteadas

### Criterio global 1: Instancia objetos y hacer uso de ellos

Con el fin de recoger los datos de las reservas y poder operar con ellas, me he creado una estructura de dominio en la que se encuentra la superclase `Reserva` (abstracta) junto con dos subclases
`ReservaHotel` y `ReservaVuelo`. Estas subclases al tener el constructor privado solamente se pueden instanciar 
a través del método de la clase (estático) `crearInstancia()` del companion object, el cual usa `ReservaService` para poder crear instancias de las subclases
de `Reserva`.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/34756544ee4adbd438e312e6247dec5c2824e63e/src/main/kotlin/dominio/ReservaHotel.kt#L3-L7

Asimismo, en el main del programa me he creado una instancia de `ReservaRepositoryImpl`, 
una abstracción de la interfaz `IReservaRespository` que le paso a través del constructor a la instancia de `ReservaService`.
Por último, me he creado una instancia de la propia consola `ConsolaReserva` que se encarga de manejar la entrada y salida de datos por parte del usuario.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/34756544ee4adbd438e312e6247dec5c2824e63e/src/main/kotlin/Main.kt#L6-L12

De la misma forma, al crear instancias de `ReservaVuelo` o `ReservaHotel` utilizo el método estático pasándole los parámetros concretos
de la subclase a los métodos instanciadores en `ReservaService`, la cual internamente a través del método de clase llama al constructor dentro del companion pasándole los parámetros comunes calculados (como id o fechaCreacion)
o por defecto como descripcion.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/34756544ee4adbd438e312e6247dec5c2824e63e/src/main/kotlin/dominio/ReservaVuelo.kt#L8-L11

### Criterio global 2: Crear y llamar métodos estáticos

A lo largo del desarrollo del proyecto he definido diversos métodos estáticos en el companion object, el objeto predefinido por excelencia
en Kotlin en el cual podemos declarar nuestras propiedades y métodos estáticos.
En primer lugar, para cumplir con lo especificado en las indicaciones de la práctica, tanto
para crear instancias de `ReservaVuelo` como de `ReservaHotel` he tenido que implementar un método estático `crearInstancia()` 
el cual me ha permitido instanciar directamente haciendo mención al nombre de la clase, en vez del propio objeto.
Cabe destacar que he decidido hacerlo de esta forma puesto que la práctica especificaba que el constructor de ambas
tenía que ser privado y que la única forma de poder crear una instancia tenía que ser a través de un método estático como en este caso:

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/ecbcc805c875b57ed8ec3d0818c7e63f3f8b0e91/src/main/kotlin/dominio/ReservaHotel.kt#L3-L7

Asimismo, he empleado los métodos estáticos `generarId()` y `generarFecha()` en la clase padre `Reserva` dado que
la práctica dejaba claro que tanto como la propiedad `id` como la `fechaCreacion` 

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/ecbcc805c875b57ed8ec3d0818c7e63f3f8b0e91/src/main/kotlin/dominio/Reserva.kt#L11-L23

tenían que generarse de forma automática, por lo que en el caso del `id` , a través de su método de clase y su propiedad estática `contadorId` que cuenta cuantas reservas 
se han llevado a cabo, me ha permitido asignarle un id acorde cuando se crea la instancia a través de la llamada al constructor de la clase dentro
del método estático que crea las instancias respectivas. (En el caso de fechaCreacion es el mismo procedimiento)

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/ecbcc805c875b57ed8ec3d0818c7e63f3f8b0e91/src/main/kotlin/dominio/ReservaHotel.kt#L6

### Criterio global 3: Uso de entornos

Para el desarrollo del proyecto he utilizado IntelliJ IDEA Ultimate Edition, creando el proyecto como Kotlin/JVM y organizando desde 
el principio las clases por paquetes correspondientes a cada capa (presentacion, servicios, dominio, datos).

El proceso de creación fue crear cada clase y paquete de forma independiente y para la compilación continua usaba el atajo `Alt+Enter`.

La ejecución la hacía sobre el `Main.kt`, probando primero crear reservas para verificar las validaciones regex, luego listar para comprobar el polimorfismo de `detalle`, y finalmente buscar por ID para testear el repositorio.

Para debugging ponía breakpoints en `ReservaService.crearVuelo()` , pudiendo ver los parámetros de entrada y probar expresiones como `reserva.detalle` directamente en el debugger.

Finalmente he utilizado el Git integrado que me ha permitido realizar los commits de forma intuitiva y veloz.

### Criterio global 4: Definir clases y su contenido

En mi código, para representar las reservas he utilizado una estructura jerárquica de herencia que consiste en lo siguiente:

La clase padre `Reserva` (abstracta) la cual se encarga de establecer el "molde" de los diferentes tipos de reservas
que se van a modelar en el proyecto, ya que en ella se definen las propiedades comunes que toda reserva tiene que tener,
así como la validación del formato de la fecha con una expresión regular, y los métodos estáticos que se encargan de generar
el `id` y la `fechaCreacion` de forma automática.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/5181b1cd164f2eba2b102ae66012501853934a82/src/main/kotlin/dominio/Reserva.kt#L6-L28

Por otra parte, las subclases que heredan y se especializan de `Reserva`, como lo son `ReservaHotel` y `ReservaVuelo` poseen un constructor
privado que recibe los parámetros comunes y define las propiedades específicas de cada reserva, permitiendo crear instancias
a través de su método estático en el companion object.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/5181b1cd164f2eba2b102ae66012501853934a82/src/main/kotlin/dominio/ReservaHotel.kt#L3-L14

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/5181b1cd164f2eba2b102ae66012501853934a82/src/main/kotlin/dominio/ReservaVuelo.kt#L3-L19

Asimismo, en cuanto a los modificadores usados son los siguientes:
- `private constructor`: Control creación
- `val`: Inmutabilidad (id/fecha no cambian)
- `open/override`: Polimorfismo en `detalle`
- `init { require() }`: Validación inmediata en el bloque init

Esta estructura de herencia me ha permitido modelar con precisión un sistema de gestión de reservas el cual
permite extensibilidad y una validación robusta para cualquier tipo de reserva que se quiera añadir al gestor, ahorrándonos tiempo y facilitándonos el trabajo.

### Criterio global 5: Herencia y uso de clases abstractas e interfaces

En mi proyecto he implementado herencia haciendo que la clase `Reserva` sea una clase abstracta que define las propiedades comunes como `id`, `fechaCreacion` y `descripcion`,
junto con la propiedad calculada `detalle` que las subclases `ReservaHotel` y `ReservaVuelo` sobrescriben para mostrar su información específica. 
Esto me ha permitido tratar todas las reservas de forma polimórfica, por ejemplo al listarlas con reservas.forEach { println(it.detalle) } donde cada tipo muestra su formato correcto.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/982f350e24b2301c3576e65590357ecb987c314f/src/main/kotlin/dominio/Reserva.kt#L10-L46

Respecto a interfaces, he creado `IReservaRepository` que define `agregar()` y `obtenerTodas()`, la cual implementa `ReservaRepositoryImpl`. 
La elegí para aplicar DIP , de forma que `ReservaService` recibe la interfaz por constructor y no depende de la implementación concreta, permitiéndome 
cambiar fácilmente memoria por base de datos solo modificando el main.

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/982f350e24b2301c3576e65590357ecb987c314f/src/main/kotlin/servicios/IReservaRepository.kt#L8-L21

### Criterio global 6: Diseño de jerarquía de clases

En mi proyecto la jerarquía de clases es la siguiente:  `Reserva` (abstracta) de la que heredan `ReservaHotel` y `ReservaVuelo`, ambas con constructor privado
y creación solo mediante `crearInstancia()` del companion object, mientras que `ReservaService` depende de la interfaz `IReservaRepository` implementada por `ReservaRepositoryImpl.`

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/Reserva.kt#L10

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/ReservaHotel.kt#L3

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/ReservaVuelo.kt#L8

De la misma forma, he utilizado herencia por especialización porque tanto `ReservaHotel` como `ReservaVuelo` son tipos específicos de `Reserva`
, heredando propiedades comunes `(id, fechaCreacion)` pero añadiendo sus propias (ubicacion/numeroNoches vs origen/destino/horaVuelo) y sobrescribiendo 
`detalle` para mostrar información personalizada.

Para probar y depurar fui ejecutando paso a paso desde IntelliJ: 
primero creé reservas verificando que se generara id correcto y pasara la validación regex de hora, 
luego comprobé el polimorfismo en `detalle`, puse breakpoints en `ReservaService` con Debug para seguir el flujo hasta el repositorio, 
y probé casos límite como hora inválida "25:00" que lanzaba IllegalArgumentException correctamente, asegurándome que toda la jerarquía funcionara sin problemas.

### Criterio global 7: Librerías de clases

Para mejorar la experiencia de usuario y la legibilidad de la interfaz de consola, he incorporado la librería externa Mordant.

La elegí porque trabajar con texto en blanco en consola dificulta que el usuario diferencie entre mensajes de éxito, errores o resaltados.
Por lo que, Mordant permite aplicar colores y estilos en Kotlin sin lidiar con códigos ANSI complejos manualmente.

La incorporé añadiendo la dependencia com.github.ajalt.mordant:mordant:2.4.0 en el build.gradle.kts e instanciando un objeto Terminal en la consola.

El uso de esta librería externa me ha permitido que la aplicación tenga una jerarquía visual clara, ya que
por ejemplo, los errores aparecen en rojo, los éxitos en verde y los menús en colores cian/azul, mejorando notablemente la usabilidad.

### Criterio global 8: Documentado

Algunos ejemplos de documentación de mi código son los siguientes:

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/Reserva.kt#L11-L38

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/ReservaVuelo.kt#L14-L22

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/presentacion/ConsolaReserva.kt#L96-L99

Para documentar las clases y métodos he utilizado el lenguaje de documentación por excelencia en Kotlin, el KDoc 
el cual me ha permitido explicar de forma concisa y clara el objetivo de un método o clase junto con su estructura interna
, qué parámetros recibe y lo que devuelve con total exactitud.

Por lo tanto, a la hora de debugguear o realizar una labor de mantenimiento del codigo , la documentación
facilita ese trabajo, ya que aporta gran claridad al código, facilitando su manipulación

### Criterio global 9: Genéricos

En este proyecto, la creación de clases genéricas propias (como por ejemplo un repositorio genérico IRepository<T>) no era la opción más recomendable ni estrictamente necesaria por el diseño de la jerarquía de clases. 
Al tener una clase abstracta base `Reserva` de la cual heredan todas las demás (`ReservaVuelo`, `ReservaHotel`), el polimorfismo nos permitía manejar todos los objetos desde una única interfaz `IReservaRepository`
sin necesidad de utilizar genéricos.

### Criterio global 10: Expresiones Regulares

A lo largo del desarrollo del proyecto he hecho uso de dos expresiones regulares con el objetivo
de validar ciertos datos de entrada, como en el siguiente caso:

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/Reserva.kt#L15-L18

En el ejemplo se puede observar como empleé una expresión regular (`fechaRegex`) con el
fin de comprobar que `fechaCreacion` se genera en el formato ANSI, en donde en caso contrarios, gracias al require del bloque init (que se ejecuta cada vez que se crea una instancia)
lanzará una excepción.

De la misma forma, he usado otra expresión regular como se observa a continuación:

https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-ifonlob/blob/d009839225f6931b7ffb83ee4114f309cdf9fd35/src/main/kotlin/dominio/ReservaVuelo.kt#L9-L12

En este caso la he utilizado de la misma forma en el bloque de inicialización de la instancia ya que es necesario comprobar que
el formato es el adecuado antes de asignarle el valor a la propiedad. Por lo que la hora del vuelo solo será válida si cumple con el formato
requerido en la expresión regular.
