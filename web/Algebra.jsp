<%-- 
    Document   : Algebra
    Created on : 2/06/2020, 07:28:39 PM
    Author     : Keb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <title>Exámen Álgebra</title>
    <script>
        function resultado() {
            var p1, p2, p3, p4, p5, nota;


            if (document.getElementById('p13').checked == true) {
                p1 = 2
            } else {
                p1 = 0
            }
            if (document.getElementById('p22').checked == true) {
                p2 = 2
            } else {
                p2 = 0
            }

            if (document.getElementById('p34').checked == true) {
                p3 = 2
            } else {
                p3 = 0
            }

            if (document.getElementById('p43').checked == true) {
                p4 = 2
            } else {
                p4 = 0
            }
            if (document.getElementById('p51').checked == true) {
                p5 = 2
            } else {
                p5 = 0
            }
            alert(" Puntuación: " + nota);
            location.reload();
        }
    </script>
</head>

<body>
    <h2>Algebra</h2>
    <h5>Necesitas un mínimo de 8 para poder ser asesor</h5>
    <hr>
    <form style="font:normal 16px sans-serif">
        <p>Reduce la siguiente expresión<br><img src="monomios6 (2).jpg"></p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta1" id="p11" value="1">A) 2x </p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta1" id="p12" value="2">B) -7x^2+x</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta1" id="p13" value="3">C) x^2+4x+1</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta1" id="p14" value="4">D) 6x^2+6x-7</p>

        <p>Resuelve la ecuación de primer grado<br> <img src="primer-grado19 (2).jpg"></p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta2" id="p21">A) 9.51</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta2" id="p22">B) 0</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta2" id="p23">C) 2.78</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta2" id="p24">D) 3</p>
        <hr>

        <p>Resuelve la ecuación de segundo grado <br> <img src="segundo-grado9 (2).jpg"></p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta3" id="p31">A) x=0.24</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta3" id="p32">B) x=3.64</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta3" id="p33">C) x=-4 </p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta3" id="p34">D) x=-1 </p>

        <p>Obten el valor de las constantes del siguiente sistema<br><img src="problemas-sistemas5 (3).jpg"></p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta4" id="p41">A) (-5,1) (1,-7)</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta4" id="p42">B) (-11,6) (6,9)</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta4" id="p43">C) (10,2) (-2,-10)</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta4" id="p44">D) (8,3) (-13,8)</p>

        <p>Factoriza la siguiente expresión<br> <img src="factorcomun9.png"></p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta5" id="p51">A) 1/2x</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta5" id="p52">B) 2x+1</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta5" id="p53">C) 2x-1</p>
        <p onclick="this.style.color='#FFFFF'"><input type="radio" name="pregunta5" id="p54">D) 2-x/5</p>
        <hr>
        <p><input type="button" value="Finalizar Registro" onclick="resultado()" /></p>
    </form>
</body>

</html>