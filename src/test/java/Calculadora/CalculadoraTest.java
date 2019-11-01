package Calculadora;

import calculadora.Calculadora;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    Calculadora calc;

    @Before // Se ejecuta al principio de cada test
    public void before() {
        calc = new Calculadora();
    }

    @After
    public void after(){
        // Se ejecuta al finalizar cada test
    }

    @Test
    public void testSum(){
        int resultado = calc.add(2,3);
        int esperado = 5;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAnsSum(){
        calc.add(2,3);
        int resultado = calc.ans();
        int esperado = 5;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testdividir(){
        calc.dividir(5, 2);
        int resultado = calc.ans();
        int esperado = 2;
        assertEquals(esperado, resultado);
    }

    @Test(expected = ArithmeticException.class)
    public void tesDivPorCero(){
        calc.dividir(5,0);
    }
}