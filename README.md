
# Laboratorio 01

## Instrucciones

1. Para iniciar, debe crear un *Fork* del repositorio:

![fork button](images/fork.png)

2. Vaya la pestaña de **actions** de su repositorio. Si ve un botón verde, haga clic en él para poder ejecutar las pruebas en el futuro.

![actions tab](images/actions.png)

3. Clone el nuevo repositorio en su computadora y ábralo en IntelliJ.

4. Construya/compile la aplicación en IntelliJ.

5. Ejecute las pruebas unitarias.

6. No se preocupe si todas o la mayoría de las pruebas fallan. Al terminar el laboratorio, todas las pruebas deberían funcionar.
___

## Introducción

- Todos los ejercicios deben compilar para poder ser probados. Si por lo menos uno de los ejercicios no compila, la nota sera de **cero** puntos.
- Si el código original de un ejercicio no se modifica o la intención de su resolución no es clara, la nota del ejercicicio será de **cero puntos**, aún si hay pruebas que sí pasen para dicho ejercicio.
- NO agregue nuevos métodos `main()`, de lo contrario ninguna prueba podrá ejecutarse.
- NO cambie la firma de los métodos existentes (no agrege más parámetros ni cambie el nombre), estos son utilizados para probar su código.
- NO haga cambios en las pruebas, esto resulta en un **cero inmediato**.
- Puede agregar nuevas clases y/o archivos, como sea necesario.
- En la pestaña de **Actions** podrá ver como las pruebas se ejecutan con su código implementado (si hace `git push` de un nuevo commit previamente).
___

## Ejercicio 1

1. Abra la clase **Main**, diríjase al método `main()` de la clase. Describa qué es lo que se intenta hacer con el código.
2. Abra la clase **SortingTester**, ¿qué se intenta hacer con el código de esa clase?
   1. ¿Qué paradigma de programación se utiliza para obtener un promedio de las diferentes duraciones?
   2. ¿Qué cambios haría si también quisiera obtener la sumatoria de todas las duraciones utilizando Streams? Implemente los cambios en el código
3. Regrese a la clase **Main** e intente ejecutar la aplicación. ¿Qué sucedió? ¿Por qué?
___

## Ejercicio 2

1. Diríjase a la interfaz **ArrayGenerator**.
   1. ¿Qué tipo de interfaz es esta? ¿Por qué?
2. Regrese a la clase **Main**.
3. Borre la definición de `null` que tiene asignada `sortedArrayGenerator` y reemplácela por una expresión lambda.
   1. La expresión lambda debe representar una función que retorne un arreglo de `Integer` del tamaño de `length`.
   2. El arreglo generado debe estar ordenado ascendentemente.
   3. ¿Cómo implementa `sortedArrayGenerator` la interfaz **ArrayGenerator**?
   4. ¿Por qué `sortedArrayGenerator.generate()` retorna un arreglo de tipo `Integer` si esto no está definido en **ArrayGenerator**?
4. Borre la definición de `null` que tiene asignada `invertedArrayGenerator` y reemplácela por una expresión lambda.
   1. La expresión lambda debe representar una función que retorne un arreglo de `Integer` del tamaño de `length`.
   2. El arreglo generado debe estar ordenado descendentemente.
5. Borre la definición de `null` que tiene asignada `randomArrayGenerator` y reemplácela por una expresión lambda.
   1. La expresión lambda debe representar una función que retorne un arreglo de `Integer` del tamaño de `length`.
   2. El arreglo generado no debe seguir ningún orden.
6. ¿Cuál es la complejidad de tiempo y espacio de cada implementación de **ArrayGenerator**?
7. Ejecute las pruebas unitarias. ¿Cuántas pruebas son exitosas ahora?
8. Cree un nuevo `commit` con sus cambios y haga `push` a su repositorio remoto en GitHub.
___

## Ejercicio 3

1. Diríjase a la interfaz **QuickSort**.
   1. ¿Qué tipo de interfaz es esta?
   2. ¿En qué se diferencia de **ArrayGenerator**?
2. Cree una nueva clase llamada **ed.lab.Main.SortingAlgorithms**.
3. Esta clase no debe heredar ni implementar ninguna interfaz.
4. Defina los siguientes métodos en esta clase:
   1. `void highPivotQuickSort(T[] array)`: ordena un arreglo utilizando el algoritmo quick sort, seleccionando el último elemento como pivote.
   2. `void lowPivotQuickSort(T[] array)`: ordena un arreglo utilizando el algoritmo quick sort, seleccionando el primer elemento como pivote.
   3. `void randomPivotQuickSort(T[] array)`: ordena un arreglo utilizando el algoritmo quick sort, seleccionando un elemento aleatorio como pivote.
   4. Los métodos deben ser **_estáticos_** y limitar el tipo de dato del arreglo a tipos que hereden de `Comparable`.
5. ¿Cuál es la complejidad de tiempo en el peor de los casos para cada función?
6. ¿Cuál es la complejidad de tiempo en el mejor de los casos para cada función?
7. ¿Cuál es la complejidad de tiempo promedio para cada función?
___

## Ejercicio 4

1. Ahora que ha implementado las funciones en **ed.lab.Main.SortingAlgorithms**, diríjase a la clase **Main**.
2. Borre la definición de `null` que tiene asignada `highPivotQuickSort` y reemplácela por la referencia del método correspondiente en **ed.lab.Main.SortingAlgorithms**.
3. Borre la definición de `null` que tiene asignada `lowPivotQuickSort` y reemplácela por la referencia del método correspondiente en **ed.lab.Main.SortingAlgorithms**.
4. Borre la definición de `null` que tiene asignada `randomPivotQuickSort` y reemplácela por la referencia del método correspondiente en **ed.lab.Main.SortingAlgorithms**.
5. Ejecute la aplicación. ¿Qué se imprime en pantalla?
6. Si todos los arreglos son ordenados utilizando el mismo algoritmo, ¿por qué los promedios de tiempo son diferentes? ¿Cuál tuvo mejores tiempos de ejecución?
7. Cree un nuevo `commit` y haga `push` a su repositorio remoto.
___

## Ejercicio 5

1. Cree una nueva branch (o rama) de su repositorio, nómbrela `feature/string-arrays`
2. En esta nueva branch, haga los cambios necesarios al código para que el código utilice arreglos `String` en lugar de `Integer`.
3. ¿En qué clases realizó los cambios?
4. ¿Cuál fue el beneficio de utilizar `Comparable`?
5. Cree un nuevo `commit` y haga `push` a su repositorio remoto.
___

## Ejercicio 6.

1. Escriba sus conclusiones del laboratorio.
