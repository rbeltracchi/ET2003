insert into usuario (nombre,apellido,email,contraseña,telefono,progreso,alumno_111mil) values (
	"Ramiro",
    "Hernandez",
    "ramiro@hotmail.com",
    "ramiro",
    "2494591664",
    0,
    true
);

insert into modulo (nombre, descripcion) values ("Introducción", "Breve introducción al mundo de la programación");

insert into modulo (nombre, descripcion) values ("Técnicas de Programación", "Componentes claves de la programación");

insert into modulo (nombre, descripcion) values ("POO: Programación Orientada a Objetos ", "Conceptos fundamentales de este paradigma de programación");

insert into modulo (nombre, descripcion) values ("BBDD: Base de Datos ", "Fundamentos del almacenado de datos");


/*---------------------------------------Temas--------------------------------------*/

insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Historia",
	"Primeros conceptos, evolución de las computadoras. ¿Qué es el Software? Contexto de la Industria IT",
	"    Las computadoras son máquinas capaces de efectuar una secuencia de operaciones mediante un programa, de tal manera que se realice un procesamiento sobre un conjunto de datos de entrada, obteniéndose otro conjunto de datos de salida. Tipos de computadoras: se clasifican de acuerdo al principio de operaciones en Analógicas y Digitales:\n\n    • Evolución de las computadoras: Uno de los primeros dispositivos para contar fue el ábaco, que se remonta a los Griegos y Romanos. No se lo puede llamar computadora por carecer de programas. La primera computadora fue la máquina analítica creada por Charles Babbage, profesor atemático de la Universidad de Cambridge en el siglo XIX. La idea que tuvo Charles Babbage sobre un computador nació debido a que la elaboración de las tablas matemáticas era un proceso tedioso y propenso a errores.\n\n    • Software: es el conjunto de los programas de computo, procedimientos, reglas, documentación y datos asociados, que forman parte de las operaciones de un sistema de computación.", 
	1
);

insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Lenguajes de programación" ,
	"Existen varios tipos de lenguajes de programación ",
	"    Un programa informático es una secuencia de instrucciones, escritas para realizar una tarea específica  en una computadora. Esta secuencia las escribe un programador en lo que se conoce como un lenguaje de programación. Hay distintos tipos; Por un lado tenemos el LENGUAJE MAQUINA.\n\n    Fue el primer lenguaje utilizado en la programación, pero dejó de utilizarse por su complejidad al momento de entenderlo y programarlo, ya que todas las instrucciones se basan en cadenas de 2 valores, el cero y el uno.\n\n    Con el tiempo fue sustituido por otros lenguajes más fáciles de aprender y utilizar, y que además reducen la posibilidad de cometer errores. El lenguaje máquina es el único lenguaje que puede ejecutar una computadora, es específico en cada arquitectura, es un código que es interpretado directamente por el microprocesador, está compuesto por un conjunto de instrucciones ejecutadas en secuencia que representan acciones que la máquina podrá tomar.\n\n    Por otro lado tenemos el lenguaje ASSEMBLER. Es un lenguaje de programación de bajo nivel. Consiste en un conjunto de mnemónicos que representan instrucciones básicas para los computadores, microprocesadores, microcontroladores y otros circuitos integrados programables. Implementa una representación simbólica de los códigos de máquina binarios. Y por ultimo tenemos los lenguajes de ALTO NIVEL. Estos son independientes del hardware de la computadora, haciéndolos portables. Son más fáciles de entender por el programador, ya que expresa los algoritmos de una forma adecuada a la capacidad cognitiva humana. Un lenguaje de alto nivel permite al programador escribir las instrucciones de un programa utilizando palabras o expresiones sintácticas muy similares al inglés. Permite crear programas complejos con mayor rapidez y con menor código. Hoy en día existen muchos lenguajes de este tipo. (Java, C, C++, etc)", 
	1
);

insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Construcción de Programas",
	"Existen diferentes pasos para la construcción de un Programa",
	"El Proceso para el desarrollo de software, también denominado ciclo de vida del desarrollo de software es una estructura aplicada al desarrollo de un producto de software. Hay varios modelos a seguir para el establecimiento de un proceso para el desarrollo de software, cada uno de los cuales describe un enfoque diferente para diferentes actividades que tienen lugar durante el proceso. Algunos autores consideran un modelo de ciclo de vida un término más general que un determinado proceso para el desarrollo de software. Por ejemplo, hay varios procesos de desarrollo de software específicos que se ajustan a un modelo de ciclo de vida de espiral.Análisis del Problema\n\n    Planificación: La importante tarea a la hora de crear un producto de software es obtener los requisitos o el análisis de los requisitos. Los clientes suelen tener una idea más bien abstracta del resultado final, pero no sobre las funciones que debería cumplir el software.\n\n    Una vez que se hayan recopilado los requisitos del cliente, se debe realizar un análisis del ámbito del desarrollo. Este documento se conoce como especificación funcional.\n\n    Implementación, pruebas y documentación: La implementación es parte del proceso en el que los ingenieros de software programan el código para el proyecto de trabajo que está en relación de las demanda del software, en esta etapa se realizan las pruebas de caja blanca y caja negra.\n\n    Las pruebas de software son parte esencial del proceso de desarrollo del software. Esta parte del proceso tiene la función de detectar los errores de software lo antes posible.\n\n    La documentación del diseño interno del software con el objetivo de facilitar su mejora y su mantenimiento se realiza a lo largo del proyecto. Esto puede incluir la documentación de un API, tanto interior como exterior. Prácticamente es como una receta de cocina.\n\n    Despliegue y mantenimiento: El despliegue comienza cuando el código ha sido suficientemente probado, ha sido aprobado para su liberación y ha sido distribuido en el entorno de producción.\n\n    Entrenamiento y soporte para el software es de suma importancia y algo que muchos desarrolladores de software descuidan. Los usuarios, por naturaleza, se oponen al cambio porque conlleva una cierta inseguridad, es por ello que es fundamental instruir de forma adecuada a los futuros usuarios del software.\n\n    El mantenimiento o mejora de un software con problemas recientemente desplegado, puede requerir más tiempo que el desarrollo inicial del software. Es posible que haya que incorporar código que no se ajusta al diseño original con el objetivo de solucionar un problema o ampliar la funcionalidad para un cliente. Si los costes de mantenimiento son muy elevados puede que sea oportuno rediseñar el sistema para poder contener los costes de mantenimiento.",
	/*"\n    Los pasos para la construcción de un Programa son:\n\n    • Definición del problema: determinar la información inicial para la elaboración del mismo\n\n    • Análisis del Problema: datos de entrada,  de salida,  métodos y formulas.\n\n    • Diseño del Algoritmo: usar las herramientas de representación de algoritmos\n\n    • Codificación: escribir la solución del problema en instrucciones detalladas en un lenguaje reconocible por la computadora. Conocido como Código Fuente\n\n    • Prueba y Depuración: se toman escenarios posibles, validos o inválidos y se corre la secuencia del algoritmo para ver si cumple con los resultados esperados. ",*/
    1
);
/*lito*/
insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Algoritmos ",
    " Un algoritmo es un método para resolver un problema ",
    "\n\n    Un algoritmo es un método para resolver un problema, que consiste en la realización de un conjunto de pasos lógicamente ordenados tal que, partiendo de ciertos datos de entrada, permite obtener ciertos resultados que conforman la solución del problema. Un algoritmo debe :\n\n    • Ser preciso\n\n    • Debe estar específicamente definido\n\n    • Ser finito\n\n    • Ser correcto\n\n    • Ser independiente  del lenguaje y del medio.",
    2
);

insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Diagramas de flujo ",
	" En esta unidad veremos qué son y cómo se construyen los diagramas de flujo ",
	"\n    El diagrama de flujo o flujograma o diagrama de actividades es la representación gráfica del algoritmo o proceso. Se utiliza en disciplinas como programación, economía, procesos industriales y psicología cognitiva.\n    En Lenguaje Unificado de Modelado (UML), es un diagrama de actividades que representa los flujos de trabajo paso a paso de negocio y operacionales de los componentes en un sistema. Un diagrama de actividades muestra el flujo de control general.\n    En SysML el diagrama ha sido extendido para indicar flujos entre pasos que mueven elementos físicos (p. ej., gasolina) o energía (p. ej., presión). Los cambios adicionales permiten al diagrama soportar mejor flujos de comportamiento y datos continuos.\n    Estos diagramas utilizan símbolos con significados definidos que representan los pasos del algoritmo, y representan el flujo de ejecución mediante flechas que conectan los puntos de inicio y de fin del proceso.",
	2
);

insert into tema (nombre, descripcion, teoria, fk_id_modulo) values (
	"Variables",
	"Definición de una variable",
	"\n    En programación, una variable está formada por un espacio en el sistema de almacenaje (memoria principal de un ordenador) y un nombre simbólico (un identificador) que está asociado a dicho espacio.\n     Ese espacio contiene una cantidad de información conocida o desconocida, es decir un valor. El valor de una variable en computación no es necesariamente parte de una ecuación o fórmula como en matemáticas.\n     En computación una variable puede ser utilizada en un proceso repetitivo: puede asignársele un valor en un sitio, ser luego utilizada en otro, más adelante reasignársele un nuevo valor para más tarde utilizarla de la misma manera.",
	2
);

/*-----------------------------------EJERCICIOS---------------------------------------*/

insert into ejercicio (enunciado, imagen, solucion, puntaje, opcion1, opcion2, opcion3, fk_id_tema) values (
	"La primer Computadora fue…:",
	"/images/exercises/ej1.jpg",
	2,
	10, 
	"Un dispositivo similar al Ábaco para contar y programar ",
	"Una máquina analítica creada por Charles Babbage, profesor de la Universidad de Cambridge en el siglo XIX ",
	"Una máquina magnética, creada en 1850 capaz de procesar gran cantidad de información ",
	1
);

insert into ejercicio (enunciado, imagen, solucion, puntaje, opcion1, opcion2, opcion3, fk_id_tema) values (
	"El Software es: ",
    "/images/exercises/ej2.jpg",
	2,
	10,
	"Un tipo de computadora de las primitivas que ayuda a procesar  y crear información",
	"El conjunto de los programas de computo, procedimiento, reglas, documentación y datos\n asociados, que forman parte de las operaciones de un sistema de computación ",
	" Un método que ayuda a aprender de algoritmos y técnicas de programación",
	1
);

insert into ejercicio (enunciado, imagen, solucion, puntaje, opcion1, opcion2, opcion3, fk_id_tema) values (
	"¿Cómo se define una Computadora?","/images/exercises/ejercicioSinImagen.jpg",
	3, 
	10, 
	" Es una máquina capaz de crear secuencias ordenadas de manera que puedan ejecutar órdenes",
	"Es una máquina capaz de almacenar algoritmos digitales y devolver soluciones reales" ,
	"Es una máquina capaz de efectuar una secuencia de operaciones mediante un programa, de tal manera, que se realice un procesamiento sobre un conjunto de datos de entrada, obteniéndose otro conjunto de datos de salida",
	1
);

insert into ejercicio (enunciado, imagen, solucion, puntaje, opcion1, opcion2, opcion3, fk_id_tema) values (
	"¿Qué es un Algoritmo","/images/exercises/ej4.jpg",
	2,
	10,
	"Una sucesión de órdenes aleatorias ",
	"Un método para resolver un problema, que consiste en la realización de un conjunto de pasos lógicamente ordenados tal que, partiendo de ciertos datos de entrada, permite obtener ciertos resultados que conforman la solución del problema ",
	" Un método e instrucciones para programar dispositivos ",
	4
);

insert into ejercicio (enunciado, imagen, solucion, puntaje, opcion1, opcion2, opcion3, fk_id_tema) values (
	"¿Cuál de estos Algoritmos devuelve el Área del Rectángulo? ",
	"/images/exercises/ej5.jpg",
	2,
	10,
	"Opción 1 ",
	"Opción 2",
	" Opción 3",
	4
);