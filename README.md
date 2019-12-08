[![Build Status](https://travis-ci.org/fpaus/Algo3-TP2.svg?branch=master)](https://travis-ci.org/fpaus/Algo3-TP2)
[![codecov](https://codecov.io/gh/fpaus/Algo3-TP2/branch/master/graph/badge.svg)](https://codecov.io/gh/fpaus/Algo3-TP2/)

Informe final: https://github.com/fpaus/Algo3-TP2/blob/master/Informe_Final_TP2_Algoritmos_y_Programacion_III__FIUBA_.pdf

<div>

<span class="c2"></span>

# [95.02 / 75.17] Trabajo Práctico 2        Segundo cuatrimestre 2019

* * *

<span class="c2"></span>

</div>

<span class="c2"> </span>

<span class="c2"></span>

<span class="c58 c54"></span>

<span class="c54 c58"></span>

<span class="c31">[75.07 / 95.02]</span>

<span class="c31">Algoritmos y programación III</span>

<span class="c23"></span>

<span class="c33">Trabajo práctico 2 (enunciado)</span>

<span class="c57 c83">Segundo cuatrimestre del año 2019</span>

<span class="c57 c54"></span>

<span class="c57 c54"></span>

<span class="c57 c54"></span>

<span class="c57 c54"></span>

<span class="c58 c54"></span>

* * *

<span class="c58 c54"></span>

<span class="c2"></span>

<span class="c47">Índice</span>

<span class="c33"></span>

<span class="c29">[1\. Objetivo](#h.4m2fbxhuqklj)</span><span class="c29">        </span><span class="c29">[3](#h.4m2fbxhuqklj)</span>

<span class="c29">[2\. Consigna general](#h.2et92p0)</span><span class="c29">        </span><span class="c29">[3](#h.2et92p0)</span>

<span class="c29">[3\. Especificación de la aplicación a desarrollar](#h.11q5e3paqh1p)</span><span class="c29">        </span><span class="c29">[3](#h.11q5e3paqh1p)</span>

<span class="c2">[3.1\. Entidades](#h.50nmxb46lv9n)</span><span class="c2">        </span><span class="c2">[3](#h.50nmxb46lv9n)</span>

<span class="c2">[3.2\. Flujo del programa](#h.v81htlbnlvgk)</span><span class="c2">        </span><span class="c2">[5](#h.v81htlbnlvgk)</span>

<span class="c2">[3.3\. Distancias](#h.5uguw7fm0j9k)</span><span class="c2">        </span><span class="c2">[5](#h.5uguw7fm0j9k)</span>

<span class="c29">[4\. Interfaz gráfica](#h.9124mafyxr6p)</span><span class="c29">        </span><span class="c29">[5](#h.9124mafyxr6p)</span>

<span class="c29">[5\. Herramientas](#h.35nkun2)</span><span class="c29">        </span><span class="c29">[5](#h.35nkun2)</span>

<span class="c29">[6\. Entregables](#h.od851yyz0p0c)</span><span class="c29">        </span><span class="c29">[6](#h.od851yyz0p0c)</span>

<span class="c29">[7\. Formas de entrega](#h.1ksv4uv)</span><span class="c29">        </span><span class="c29">[6](#h.1ksv4uv)</span>

<span class="c29">[8\. Evaluación](#h.44sinio)</span><span class="c29">        </span><span class="c29">[6](#h.44sinio)</span>

<span class="c29">[9\. Casos de prueba para cada entrega](#h.2jxsxqh)</span><span class="c29">        </span><span class="c29">[7](#h.2jxsxqh)</span>

<span class="c2">[Entrega 1 (jueves 7 de Noviembre)](#h.x9gp4q6cr2nv)</span><span class="c2">        </span><span class="c2">[7](#h.x9gp4q6cr2nv)</span>

<span class="c2">[Entrega 2(jueves 21 de noviembre)](#h.6xyib0pyant2)</span><span class="c2">        </span><span class="c2">[7](#h.6xyib0pyant2)</span>

<span class="c2">[Entrega 3 (jueves 28 de noviembre)](#h.b1xca0tuq21p)</span><span class="c2">        </span><span class="c2">[8](#h.b1xca0tuq21p)</span>

<span class="c2">[Entrega 4 - Final: (jueves 5 de diciembre)](#h.2xcytpi)</span><span class="c2">        </span><span class="c2">[8](#h.2xcytpi)</span>

<span class="c2">[Pre-entregas: (jueves 31 de octubre y 14 de noviembre)](#h.2iqp0ok8c2b6)</span><span class="c2">        </span><span class="c2">[8](#h.2iqp0ok8c2b6)</span>

<span class="c29">[10\. Informe](#h.2bn6wsx)</span><span class="c29">        </span><span class="c29">[8](#h.2bn6wsx)</span>

<span class="c2">[Supuestos](#h.26h3aunb8cu)</span><span class="c2">        </span><span class="c2">[9](#h.26h3aunb8cu)</span>

<span class="c2">[Diagramas de clases](#h.1zubvsmd2h8t)</span><span class="c2">        </span><span class="c2">[9](#h.1zubvsmd2h8t)</span>

<span class="c2">[Diagramas de secuencia](#h.r7v0qzg4snow)</span><span class="c2">        </span><span class="c2">[9](#h.r7v0qzg4snow)</span>

<span class="c2">[Diagrama de paquetes](#h.gav3mlqr44iz)</span><span class="c2">        </span><span class="c2">[9](#h.gav3mlqr44iz)</span>

<span class="c2">[Diagramas de estado](#h.1w76lx25ftpd)</span><span class="c2">        </span><span class="c2">[9](#h.1w76lx25ftpd)</span>

<span class="c2">[Detalles de implementación](#h.ipi71furdld3)</span><span class="c2">        </span><span class="c2">[9](#h.ipi71furdld3)</span>

<span class="c2">[Excepciones](#h.hjw80yvqig0f)</span><span class="c2">        </span><span class="c2">[9](#h.hjw80yvqig0f)</span>

<span class="c2"></span>

* * *

<span class="c2"></span>

# <span class="c47">1\. Objetivo</span>

<span class="c2">Desarrollar una aplicación de manera grupal aplicando todos los conceptos vistos en el curso, utilizando un lenguaje de tipado estático (Java) con un diseño del modelo orientado a objetos y trabajando con las técnicas de TDD e Integración Contínua.</span>

# <span class="c47">2\. Consigna general</span>

<span class="c37">Desarrollar la aplicación completa, incluyendo el</span> <span class="c36">modelo</span><span class="c2"> de clases e interfaz gráfica. La aplicación deberá ser acompañada por pruebas unitarias e integrales y documentación de diseño.</span>

# <span class="c47">3\. Especificación de la aplicación a desarrollar</span>

<span class="c2">La aplicación consiste en un videojuego por turnos, de dos jugadores conformado de un tablero y distintas unidades sobre él. El objetivo del juego es destruir todas las unidades enemigas y gana el jugador que lo consigue primero.</span>

<span class="c2">El jugador dispone de distintas entidades para acomodar en el tablero, pero tiene una cantidad limitada de puntos para usar (cada entidad tiene un coste distinto de puntos dependiendo de su nivel).</span>

<span class="c2"></span>

<span class="c2">El objetivo del juego es vencer al ejército enemigo (son entidades preestablecidas en el tablero que no pueden ser modificadas) acomodando las entidades aliadas en el tablero.</span>

## <span class="c16">3.1\. Entidades</span>

*   <span class="c29">Jugador:</span>

<span class="c36"></span> <span class="c2">Cada jugador dispone de 20 puntos para gastar en las entidades que quiera.</span>

<span class="c2"></span>

*   <span class="c29">Tablero :</span>

<span class="c37">Es el campo donde se posicionan las unidades antes de comenzar la partida. Es cuadrado de 20</span><span> casilleros de lado</span><span class="c37">.</span> <span>E</span><span class="c2">stará dividido en 2 sectores.</span>

<span class="c14 c54">- Sector aliado:</span>

<span class="c2">        Es el sector en el cual se pueden acomodar las piezas del jugador actual.</span>

<span class="c14 c54">-Sector enemigo:</span>

<span class="c2">        Es el sector en el cual se posicionan las piezas del jugador contrincante.</span>

<span class="c2"></span>

<span class="c37 c67">Cada jugador puede acomodar las piezas únicamente en su lado del tablero.</span>

<span class="c2"></span>

<span class="c14 c54">-Penalización por estar en territorio enemigo:</span>

<span class="c2">Tanto las unidades aliadas como enemigas sufrirán un 5% más de daño si están sobre territorio del otro bando.</span>

<span class="c2"></span>

*   <span class="c29">Unidades :</span>

<span class="c2"></span>

*   <span class="c2">Todas las unidades se pueden desplazar de a un casillero por turno</span>
*   <span class="c2">Se puede mover una entidad por turno.</span>

<span class="c29"></span>

<span class="c84">        </span><span class="c63"> </span>

<a id="t.2b6e5e9cd5932f84bd4281b2f3faf9a3edb594ef"></a><a id="t.0"></a>

<table class="c85">

<tbody>

<tr class="c1">

<td class="c80" colspan="2" rowspan="1">

<span class="c29">Soldado de infantería</span>

</td>

</tr>

<tr class="c1">

<td class="c50" colspan="1" rowspan="1">

<span class="c29">Costo</span>

</td>

<td class="c40" colspan="1" rowspan="1">

<span class="c2">1</span>

</td>

</tr>

<tr class="c1">

<td class="c50" colspan="1" rowspan="1">

<span class="c29">Atributos</span>

</td>

<td class="c40" colspan="1" rowspan="1">

<span class="c2">- Vida: 100</span>

<span class="c2">- Daño cuerpo a cuerpo: 10</span>

<span class="c2">- Daño a distancia: 0</span>

</td>

</tr>

<tr class="c1">

<td class="c50" colspan="1" rowspan="1">

<span class="c29">Comportamiento</span>

</td>

<td class="c40" colspan="1" rowspan="1">

<span class="c2">- Puede atacar a un enemigo a corta distancia.</span>

<span class="c37">- Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un</span> <span class="c36">Batallón</span><span class="c2"> y PUEDEN moverse los 3 al mismo tiempo en el mismo turno. [Esto significa que cada uno de los soldados se va a mover en la dirección solicitada. En caso que uno no pueda moverse al casillero, únicamente ese Soldado se quedará quieto, y los demás si se moverán]</span>

</td>

</tr>

</tbody>

</table>

<span class="c2"></span>

<span class="c37">                </span>

<a id="t.4e61bf2f3c9f64facbdae62c3ad4acefd7b156ef"></a><a id="t.1"></a>

<table class="c70">

<tbody>

<tr class="c1">

<td class="c78" colspan="2" rowspan="1">

<span class="c29">Jinete</span>

</td>

</tr>

<tr class="c1">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Costo</span>

</td>

<td class="c24" colspan="1" rowspan="1">

<span class="c37">3</span>

</td>

</tr>

<tr class="c1">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Atributos</span>

</td>

<td class="c24" colspan="1" rowspan="1">

<span class="c2">- Vida: 100</span>

<span class="c2">- Daño cuerpo a cuerpo: 5</span>

<span class="c2">- Daño a distancia: 15</span>

</td>

</tr>

<tr class="c61">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Comportamiento</span>

</td>

<td class="c24" colspan="1" rowspan="1">

<span class="c2">- Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media..</span>

<span class="c2">- Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada y únicamente puede atacar a enemigos en distancia corta.</span>

</td>

</tr>

</tbody>

</table>

<span class="c2"></span>

<span class="c29"></span>

<a id="t.50f8437bbcef0464c9a98ee47f48ee2a8867af55"></a><a id="t.2"></a>

<table class="c69">

<tbody>

<tr class="c1">

<td class="c73" colspan="2" rowspan="1">

<span class="c29">Curandero</span>

</td>

</tr>

<tr class="c1">

<td class="c20" colspan="1" rowspan="1">

<span class="c29">Costo</span>

</td>

<td class="c39" colspan="1" rowspan="1">

<span class="c2">2</span>

</td>

</tr>

<tr class="c1">

<td class="c20" colspan="1" rowspan="1">

<span class="c29">Atributos</span>

</td>

<td class="c39" colspan="1" rowspan="1">

<span class="c2">- Vida: 75</span>

<span class="c2">- Curación: 15</span>

</td>

</tr>

<tr class="c41">

<td class="c20" colspan="1" rowspan="1">

<span class="c29">Comportamiento</span>

</td>

<td class="c39" colspan="1" rowspan="1">

<span class="c2">- Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.</span>

</td>

</tr>

</tbody>

</table>

<span class="c29"></span>

<span class="c29"></span>

<a id="t.3748e7aded1a530b6a1bd5e0d4323ea5e29880eb"></a><a id="t.3"></a>

<table class="c69">

<tbody>

<tr class="c1">

<td class="c77" colspan="2" rowspan="1">

<span class="c29">Catapulta</span>

</td>

</tr>

<tr class="c1">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Costo</span>

</td>

<td class="c55" colspan="1" rowspan="1">

<span class="c37">5</span>

</td>

</tr>

<tr class="c1">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Atributos</span>

</td>

<td class="c55" colspan="1" rowspan="1">

<span class="c2">- Vida: 50</span>

<span class="c2">- Daño cuerpo a cuerpo: 0</span>

<span class="c2">- Daño a distancia: 20</span>

</td>

</tr>

<tr class="c61">

<td class="c53" colspan="1" rowspan="1">

<span class="c29">Comportamiento</span>

</td>

<td class="c55" colspan="1" rowspan="1">

<span class="c2">- No puede moverse en toda la partida.</span>

<span class="c2">- Ataca en una distancia lejana únicamente. [Puede dañar tanto a Enemigos como Aliados]</span>

<span class="c2">- Causa daño a la primera unidad enemiga alcanzada, y a todas las unidades directamente contiguas, y si a su vez la segunda unidad tiene otra unidad contigua, también causa el mismo daño (y así sucesivamente)</span>

</td>

</tr>

</tbody>

</table>

<span class="c2"></span>

## <span class="c16">3.2\. Flujo del programa</span>

*   <span class="c2">Fase inicial (una por cada jugador): Cada jugador selecciona su nombre y posiciona en su lado del tablero las entidades que desee y dura hasta que lo anuncia el jugador.</span>
*   <span class="c2">Fase de juego: Cuando ambos jugadores finalizaron su Fase inicial, se inicia ésta fase, la cual dura hasta que alguno de los jugadores gana. Consta de un turno por vez por usuario. El usuario que inicia es seleccionado de manera aleatoria.</span>

## <span class="c16">3.3\. Distancias</span>

*   <span class="c2">Distancia Cercana: consta de una distancia de 1 a 2 casilleros (en cualquier dirección)</span>
*   <span class="c2">Distancia Media: consta de una distancia de 3 a 5 (en cualquier dirección)</span>
*   <span class="c2">Distancia Lejana: consta de una distancia de 6 a Infinito (en cualquier dirección)</span>

# <span class="c47">4\. Interfaz gráfica</span>

<span class="c2"></span>

<span class="c37">La interacción entre el usuarios y la aplicación deberá ser mediante una interfaz gráfica intuitiva. Consistirá en una aplicación de escritorio utilizando</span> <span class="c36">JavaFX</span> <span class="c37">y se pondrá mucho énfasis y se evaluará como parte de la consigna su</span> <span class="c36">usabilidad</span><span class="c37">.</span>

# <span class="c47">5\. Herramientas</span>

1.  <span class="c36">JDK (Java Development Kit)</span><span class="c2">: Versión 1.7 o superior que incluya JavaFX.</span>
2.  <span class="c36">JUnit</span><span class="c2">: Framework de pruebas unitarias para Java.</span>
3.  <span class="c36">IDE (Entorno de desarrollo integrado)</span><span class="c2">: Su uso es opcional y cada integrante del grupo puede utilizar uno distinto o incluso el editor de texto que más le guste. Lo importante es que el repositorio de las entregas no contenga ningún archivo de ningún IDE y que la construcción y ejecución de la aplicación sea totalmente independiente del entorno de desarrollo. Algunos de los IDEs más populares son:</span>

1.  <span class="c56">[Eclipse](https://www.google.com/url?q=http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygen1a&sa=D&ust=1572498949685000)</span>
2.  <span class="c56">[IntelliJ](https://www.google.com/url?q=https://www.jetbrains.com/idea/download/&sa=D&ust=1572498949686000)</span>
3.  <span class="c56">[Netbeans](https://www.google.com/url?q=https://netbeans.org/downloads/&sa=D&ust=1572498949686000)</span>

1.  <span class="c36">Herramienta de construcción:</span><span class="c2">: Se deberán incluir todos los archivos XML necesarios para la compilación y construcción automatizada de la aplicación. El informe deberá contener instrucciones acerca de los comandos necesarios (preferentemente también en el archivo README.md del repositorio). Puede utilizarse Apache Ant con Ivy o Maven.</span>
2.  <span class="c36">Repositorio</span><span class="c2">: Todas las entregas deberán ser subidas a un repositorio único en GitHub para todo el grupo en donde quedarán registrados los aportes de cada miembro. El repositorio puede ser público o privado. En caso de ser privado debe agregarse al docente corrector como colaborador del repositorio.</span>
3.  <span class="c36">Git</span><span class="c2">: Herramienta de control de versiones</span>
4.  <span class="c36">Herramienta de integración contínua</span><span class="c37">: Deberá estar configurada de manera tal que cada</span> <span class="c14">commit</span> <span class="c2">dispare la compilación, construcción y ejecución de las pruebas unitarias automáticamente. Algunas de las más populares son:</span>

1.  <span class="c2">Travis-CI</span>
2.  <span class="c2">Jenkins</span>
3.  <span>Circle-</span><span class="c2">CI</span>

# <span class="c47">6\. Entregables</span>

<span class="c2">Para cada entrega se deberá subir lo siguiente al repositorio:</span>

<span class="c2"></span>

1.  <span class="c2">Código fuente de la aplicación completa, incluyendo también: código de la pruebas, archivos de recursos.</span>
2.  <span class="c2">Script para compilación y ejecución (Ant o Maven).</span>
3.  <span class="c2">Informe, acorde a lo especificado en este documento (en las primeras entregas se podrá incluir solamente un enlace a Overleaf o a Google Docs en donde confeccionen el informe e incluir el archivo PDF solamente en la entrega final).</span>

<span class="c2"></span>

<span class="c2">No se deberá incluir ningún archivo compilado (formato .class) ni tampoco aquellos propios de algún IDE (por ejemplo .idea). Tampoco se deberá incluir archivos de diagramas UML propios de alguna herramienta. Todos los diagramas deben ser exportados como imágenes de manera tal que sea transparente la herramienta que hayan utilizado para crearlos.</span>

<span class="c54 c57"></span>

# <span class="c47">7\. Formas de entrega</span>

<span class="c37">Habrá</span> <span class="c36 c71">4 entregas formales</span><span class="c36"> </span><span class="c37">que tendrán una calificación de</span> <span class="c36 c60">APROBADO</span> <span class="c36">o</span> <span class="c36 c62">NO APROBADO</span><span class="c36"> </span><span class="c2">en el momento de la entrega. Además se contará con una entrega 0 preliminar.</span>

<span class="c37">Aquél grupo que acumule 2 no aprobados, quedará automáticamente desaprobado con la consiguiente</span> <span class="c37 c62">pérdida de regularidad en la materia de</span> <span class="c36 c62">todos</span><span class="c37 c62"> los integrantes del grupo</span><span class="c37">.</span><span class="c37 c76"> </span><span class="c14 c22">En cada entrega se deberá incluir el informe actualizado (preferentemente impreso)</span><span class="c2 c76">.</span>

# <span class="c84">8\. Evaluación</span>

<span class="c2">El día del vencimiento de cada entrega, cada ayudante convocará a los integrantes de su grupo, solicitará el informe correspondiente e iniciará la corrección mediante una entrevista grupal.</span>

<span class="c19">Es imprescindible la presencia de todos los integrantes del grupo el día de cada corrección.</span>

<span class="c37">Se evaluará el trabajo grupal y a cada integrante en forma individual. El objetivo de esto es comprender la dinámica de trabajo del equipo y los roles que ha desempeñado cada integrante del grupo. Para que el alumno apruebe el trabajo práctico debe estar aprobado en los dos aspectos: grupal e individual (se revisarán los</span> <span class="c14">commits</span> <span class="c2">de cada integrante en el repositorio).</span>

<span class="c2">Dentro de los ítems a chequear el ayudante evaluará aspectos formales (como ser la forma de presentación del informe), aspectos funcionales: que se resuelva el problema planteado y aspectos operativos: que el TP funcione integrado.</span>

# <span class="c47">9\. Casos de prueba para cada entrega</span>

<span>Se sobreentiende que cada entrega consta de las</span><span class="c66"> pruebas + el código</span><span class="c2"> que hace pasar dichas pruebas).</span>

<span class="c2">Los alumnos del curso 2 que tengan correctores asignados el martes a la noche tendrán la entrega presencial los días martes.</span>

## <span class="c16">Entrega 1 (jueves 7 de Noviembre)</span>

*   <span class="c2">Pruebas entidades:</span>

*   <span class="c2">Una Unidad movible se puede mover en todas las direcciones.</span>
*   <span class="c2">Una Unidad movible no puede moverse a un casillero ocupado</span>
*   <span class="c2">Un Soldado de infantería aliado ataca a una pieza enemiga y se verifica que se resta la vida correspondiente.</span>
*   <span class="c2">Un Jinete aliado ataca a una pieza enemiga y se verifica que se resta la vida correspondiente.</span>
*   <span class="c2">Una catapulta aliada ataca a una pieza enemiga y se verifica que se resta la vida correspondiente.</span>
*   <span class="c2">Un Curandero aliado cura a una pieza aliada y se verifica que se suma la vida correspondiente.</span>

*   <span class="c2">Pruebas tablero:</span>

*   <span class="c2">Se coloca una pieza aliada en un casillero del sector aliado vacío con éxito.</span>
*   <span class="c2">Se verifica que no se puede colocar una pieza aliada en un casillero del sector aliado ocupado.</span>
*   <span class="c2">Se verifica que no se puede colocar una pieza aliada en un casillero del sector enemigo.</span>
*   <span class="c2">Correcta creación e inicialización del tablero.</span>

*   <span class="c2">Pruebas Jugador:</span>

*   <span class="c2">Se verifica que no puede tomar más entidades de lo que sus puntos le permiten.</span>
*   <span class="c2">Se verifica que el jugador que se queda sin entidades, es el perdedor.</span>

<span class="c2"></span>

## <span class="c16">Entrega 2 (jueves 21 de noviembre)</span>

*   <span class="c2">Pruebas entidades:</span>

*   <span class="c2">Soldado:</span>

*   <span class="c2">se verifica que 3 soldados contiguos pueden moverse al mismo tiempo en la misma dirección con una sola acción.</span>
*   <span class="c2">Teniendo 3 soldados contiguos, y un obstáculo (una entidad distinta a los otros dos soldados) obstruyendo a uno de los 3, se verifica que al mover el Batallón, se mueven 2 soldados y uno se queda quieto.</span>
*   <span class="c2">(En la situación anterior) Se verifica que el Batallón se disuelve, al quedar separados los 3 soldados.</span>
*   <span class="c2">habiendo 4 soldados contiguos, se verifica que al mover un Batallón se mueven únicamente 3.</span>

*   <span class="c2">Jinete:</span>

*   <span class="c2">Un jinete sin aliados en distancia corta y un enemigo en distancia corta, ataca con su espada al enemigo y se verifica que se realiza correctamente el ataque.</span>
*   <span class="c2">Un jinete sin aliados en distancia corta y un enemigo en distancia corta y otro enemigo en distancia media, trata de atacar al enemigo en distancia media y se verifica que no se puede realizar el ataque</span>

## <span class="c16">Entrega 3 (jueves 28 de noviembre)</span>

1.  <span>Interfaz gráfica inicial básica: comienzo del juego y visualización del tablero e interfaz de usuario básica.</span>
2.  <span class="c2">Modelo del manejo de turnos en el juego.</span>

## <span class="c16">Entrega 4 - Final: (jueves 5 de diciembre)</span>

<span class="c2"></span>

<span class="c59">Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo</span><span class="c2">.</span>

## <span class="c16">Pre-entregas: (jueves 31 de octubre y 14 de noviembre)</span>

<span class="c84">Las pre-entregas no son obligatorias, sirve para ir validando el avance así como resolver dudas que surjan durante el desarrollo del trabajo. Es recomendable que los equipos se presenten.</span>

<span class="c2"></span>

<span class="c2"></span>

<a id="t.23edd493e93a53329d6c8a14d645c814f9debe2f"></a><a id="t.4"></a>

<table class="c42">

<tbody>

<tr class="c1">

<td class="c81" colspan="1" rowspan="1">

<span class="c48">Tiempo total de desarrollo del trabajo práctico</span><span class="c16">:</span>

<span class="c16">4 semanas + 2 pre entregas</span>

</td>

</tr>

</tbody>

</table>

<span class="c2"></span>

# <span class="c47">10\. Informe</span>

<span class="c2">El informe deberá estar subdividido en las siguientes secciones:</span>

## <span class="c16">Supuestos</span>

<span class="c2">Documentar todos los supuestos hechos sobre el enunciado. Asegurarse de validar con los docentes.</span>

## <span class="c16">Diagramas de clases</span>

<span class="c2">Varios diagramas de clases, mostrando la relación estática entre las clases. Pueden agregar todo el texto necesario para aclarar y explicar su diseño de manera tal que logre el modelo logre comunicarse de manera efectiva.</span>

## <span class="c16">Diagramas de secuencia</span>

<span class="c2">Varios diagramas de secuencia, mostrando la relación dinámica entre distintos objetos planteando una gran cantidad de escenarios que contemplen las secuencias más interesantes del modelo.</span>

## <span class="c16">Diagrama de paquetes</span>

<span class="c2">Incluir un diagrama de paquetes UML para mostrar el acoplamiento de su trabajo.</span>

## <span class="c16">Diagramas de estado</span>

<span class="c2">Incluir diagramas de estados, mostrando tanto los estados como  las distintas transiciones para varias entidades del modelo.</span>

## <span class="c16">Detalles de implementación</span>

<span class="c2">Deben detallar/explicar qué estrategias utilizaron para resolver todos los puntos más conflictivos del trabajo práctico. Mencionar qué patrones de diseño fueron utilizados y por qué motivos.</span>

## <span class="c16">Excepciones</span>

<span class="c2">Explicar las excepciones creadas, con qué fin fueron creadas y cómo y dónde se las atrapa explicando qué acciones se toman al respecto una vez capturadas.</span>

<span class="c2"></span>

<div>

<span class="c2"></span>

</div>
