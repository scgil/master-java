# Curso Java: Prueba
1. Clase Vehiculo
   
Vehiculo

Define la clase Vehiculo.

1.1.	Instalación

1.2. Descripción
La clase Vehiculo representa un Vehiculo y es una clase abstracta de la que heredan distintos vehículos que tendrán la información sobre la matrícula, la marca, el modelo, el color, el espacio recorrido, la hora de inicio de un viaje y la hora actual.

1.3. Funcionalidades

La clase Vehiculo tiene las siguientes funcionalidades:

Constructor: Crea una instancia de Vehiculo con una matrícula, marca, modelo, y color.

getMatricula (): Devuelve la matrícula de Vehiculo.

getMarca(): Devuelve la matrícula de Vehiculo.

getModelo(): Devuelve el modelo de Vehiculo.

getColor(): Devuelve el color de Vehiculo.

setColor(): Establece el color de Vehiculo.

getEspacioRecorrido(): Devuelve el espacio recorrido por Vehiculo.

incrementarEspacioRecorrido(in metros): Incrementa la cantidad de metros indicada.

iniciarViaje(): Establece la hora de inicio y la hora actual de viaje al mismo valor.

actualizarTiempoActual(): Actualiza la hora actual.

getTiempoDeViaje(): Devuelve la duración del viaje entre la hora actual y la hora de inicio. 

getVelocidad():  Devuelve la velocidad en metros por segundo.

1.4. Uso

Uso de la clase Vehiculo
Para utilizar la clase Vehiculo, primero debe instanciar un objeto pasando los argumentos adecuados al constructor. 

1.5. Contribuir

  1.	Fork it!
  2.	Crea tu feature branch: git checkout -b my-new-feature
  3.	Haz Commit de tus cambios: git commit -am 'Add some feature'
  4.	Push al branch: git push origin my-new-feature
  5.	Submit un pull request

1.6. Historia

•	Version 1.1 (2024-12-10) - lanzamiento inicial

1.7. Créditos y atribuciones

Developer – Sergio Castro

1.8. License

The MIT License (MIT)
Copyright (c) 2015 

2. Clase Coche
   
Coche
Define la clase Coche.

2.1 Instalación

2.2. Descripción
La clase Coche representa un Coche y hereda de la clase Vehiculo. Implementa la interfaz Conducible. Adicionalmente posee un número de ruedas, que es un valor constante.

2.3. Funcionalidades

La clase Coche tiene las siguientes funcionalidades:

Constructor: Crea una instancia de Coche con una matrícula, marca, modelo, y color.

getNumeroRuedas (): Devuelve las ruedas que tiene el vehículo.

arrancar(): Inicia el trayecto del coche en una hora determinada. Muestra información de la acción.

avanzar(int metros): Desplaza el coche en una cantidad de metros indicada, actualiza el espacio recorrido y la hora actual. Muestra información de la acción.

parar():  Detiene el coche. Actualiza la hora de parada. Muestra información de la acción.

2.4. Uso

Uso de la clase Coche

Para utilizar la clase Coche, primero debe instanciar un objeto pasando los argumentos adecuados al constructor. 

Coche miCoche = new Coche("1234ABC", "Opel", "Corsa", "Rojo");

miCoche.arrancar();

miCoche.avanzar(5);

miCoche.parar();

2.5. Contribuir

  1.	Fork it!
  2.	Crea tu feature branch: git checkout -b my-new-feature
  3.	Haz Commit de tus cambios: git commit -am 'Add some feature'
  4.	Push al branch: git push origin my-new-feature
  5.	Submit un pull request
      
2.6. Historia

•	Version 1.1 (2024-12-10) - lanzamiento inicial

2.7. Créditos y atribuciones

Developer – Sergio Castro

2.8. License

The MIT License (MIT)
Copyright (c) 2015

3. Clase Camión
   
Camión

Define la clase Camión.

3.1 Instalación

3.2. Descripción
La clase Camión representa un Camión y hereda de la clase Vehiculo. Implementa la interfaz Conducible. Adicionalmente posee un número de ruedas, que es un valor constante.

También un atributo tacómetro que almacena las velocidades recorridas.

3.3. Funcionalidades

La clase Camión tiene las siguientes funcionalidades:

Constructor: Crea una instancia de Camión con una matrícula, marca, modelo, y color.

getNumeroRuedas (): Devuelve las ruedas que tiene el vehículo.

insertarVelocidad(double velocidad): Inserta la velocidad en el tacómetro. 

arrancar(): Inicia el trayecto del camión en una hora determinada. Muestra información de la acción.

avanzar(int metros): Desplaza el camión en una cantidad de metros indicada, actualiza el espacio recorrido y la hora actual. Muestra información de la acción.

parar():  Detiene el camión. Actualiza la hora de parada. Muestra información de la acción.

3.4. Uso

Uso de la clase Camión

Para utilizar la clase Camion, primero debe instanciar un objeto pasando los argumentos adecuados al constructor. 

Camion miCamion = new Camion("1234ABC", "Iveco", "Cross", "Blanco");

miCamion.arrancar();

miCamion.avanzar(5);

miCamion.parar();

3.5. Contribuir

  1.	Fork it!
  2.	Crea tu feature branch: git checkout -b my-new-feature
  3.	Haz Commit de tus cambios: git commit -am 'Add some feature'
  4.	Push al branch: git push origin my-new-feature
  5.	Submit un pull request
      
3.6. Historia

•	Version 1.1 (2024-12-10) - lanzamiento inicial

3.7. Créditos y atribuciones

Developer – Sergio Castro

3.8. License

The MIT License (MIT)
Copyright (c) 2015
