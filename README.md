# Lab2-POO
# Nombres:
### Angel García 
### Lourdes Lemus

# Carnets:
### 26264
### 26305

# Análisis 
## 1. ¿Qué propiedades y métodos tendrá cada clase?
### Se utilizarán las clases: Parque, PuntoAcceso y Visitante.
- Parque: nombre, codigo, encargado, puntos y visitantes. Tendrá métodos para habilitar, consultar, modificar y cerrar puntos de acceso; registrar, buscar, modificar y eliminar visitantes; y realizar los cálculos solicitados para el reporte.
- PuntoAcceso: propiedades codigo, nombre, ubicacion, capacidad y estado. Tendrá constructor, getters y métodos para modificar la capacidad y el estado.
- Visitante: codigo, nombre, edad, atracciones y puntos. Tendrá constructor, getters y métodos para modificar su información.

## 2. ¿Qué tipo deben tener las propiedades y métodos de cada clase?
Las propiedades nombre, codigo, encargado y ubicacion serán String. La propiedad estado será de tipo Estado. La capacidad, edad, atracciones y puntos serán int.
#### puntos será PuntoAcceso[] y visitantes será ArrayList<Visitante>.

Los métodos devolverán PuntoAcceso o Visitante cuando busquen objetos, int para cantidades, double para el promedio de edad y void cuando solamente realicen una operación.

## 3. ¿Cuál de las propiedades identificadas debe implementarse utilizando un arreglo básico? ¿Qué tipo de objetos almacenará y cuál será su tamaño?
La propiedad puntos de la clase Parque se implementará mediante un arreglo básico de tipo PuntoAcceso[]. Este almacenará objetos PuntoAcceso y tendrá un tamaño fijo de 5 posiciones, debido a que el parque puede tener como máximo cinco puntos de acceso. Las posiciones que todavía no tengan un punto habilitado contendrán null.

## 4. ¿Cuál de las propiedades identificadas debe implementarse utilizando un ArrayList? ¿Qué tipo de objetos almacenará?
La propiedad visitantes de la clase Parque se implementará utilizando un ArrayList< Visitante >, el cual almacenará objetos de tipo Visitante. Se utiliza una estructura dinámica porque no se conoce previamente la cantidad de visitantes que ingresarán durante la jornada. El laboratorio establece que debe utilizarse directamente ArrayList y no List.

## 5. ¿Cuáles deben ser los modificadores de visibilidad de los miembros en cada clase?
Los atributos de las clases serán private para mantener el encapsulamiento y evitar que sean modificados directamente desde otras clases. Los constructores y métodos necesarios para consultar o modificar la información serán public, permitiendo un acceso controlado a los datos.

## 6. ¿Qué parámetros serán requeridos por los métodos en sus clases?
Los parámetros dependerán de la operación. Para habilitar un punto de acceso se necesitará su posición y un objeto PuntoAcceso; para consultar o cerrar un punto se necesitará la posición; y para modificarlo se necesitarán la posición, nueva capacidad y nuevo estado.

Para registrar un visitante se recibirá un objeto Visitante. Para buscar o eliminar se utilizará el código del visitante, y para modificar se necesitará el código junto con los nuevos datos del visitante.

## 7. ¿Cómo proveerá de valores iniciales a sus objetos? ¿Qué valores deberán validarse antes de modificar el estado de los objetos?
Los valores iniciales se proporcionarán mediante los constructores de las clases creadas.
En PuntoAcceso, la capacidad máxima por hora debe ser mayor que 0. En Visitante, la edad debe ser mayor que 0, mientras que las atracciones visitadas y los puntos acumulados deben ser mayores o iguales a 0.

Estas condiciones también deberán validarse al modificar los objetos. Si no se cumplen, se generará una IllegalArgumentException.


## 8. ¿Cómo determinará si una posición del arreglo contiene un punto de acceso o contiene null?
Primero se comprobará que la posición indicada se encuentre dentro de los límites del arreglo. Después, se verificará si el contenido de esa posición es diferente de null. Si contiene un objeto, significa que existe un punto de acceso habilitado; si contiene null, la posición está disponible.

Esta validación se realizará antes de intentar consultar, modificar o cerrar un punto de acceso para evitar utilizar una referencia null.

## 9. ¿Cómo realizará las operaciones de búsqueda, modificación y eliminación dentro del ArrayList?
Para buscar, se recorrerá el ArrayList comparando el código de cada visitante hasta encontrar una coincidencia.
Para modificar, primero se localizará al visitante por su código y luego se actualizarán sus datos, realizando nuevamente las validaciones correspondientes.
Para eliminar, se localizará al visitante por su código y se eliminará del ArrayList mediante remove(). Si el visitante no existe, se informará al usuario sin finalizar el programa.

## 10. ¿Qué situaciones del programa pueden producir excepciones? Identifique qué excepciones deberán manejarse y en qué partes del programa utilizará try-catch y finally.
Se manejará InputMismatchException cuando el usuario ingrese un dato incorrecto al solicitar un valor numérico, e IllegalArgumentException cuando se ingresen valores que no cumplan las validaciones establecidas. Los bloques try catch se utilizarán para controlar estas situaciones sin detener el programa, y se incluirá al menos un finally para ejecutar una acción final independientemente del resultado de la operación.