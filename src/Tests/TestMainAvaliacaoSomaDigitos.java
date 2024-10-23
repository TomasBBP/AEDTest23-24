package Tests;
import aed.avaliacao.recurso.SomaDigitosRecursiva;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestMainAvaliacaoSomaDigitos {

    @Test
    public void somaDigitosRecursivaPositivos(){
        assertDoesNotThrow(()->{
            int[] numbers={111,22,33,44,55};
            assertEquals(3,SomaDigitosRecursiva.executar(numbers[0]));
            assertEquals(4,SomaDigitosRecursiva.executar(numbers[1]));
            assertEquals(6,SomaDigitosRecursiva.executar(numbers[2]));
            assertEquals(8,SomaDigitosRecursiva.executar(numbers[3]));
            assertEquals(10,SomaDigitosRecursiva.executar(numbers[4]));
        });
    }
    @Test
    public void somaDigitosRecursivaNegativos(){
        assertDoesNotThrow(()->{
            int[] numbers={1-2,-13-4,-2-4,-3-10,5-10};
            assertEquals(-1,SomaDigitosRecursiva.executar(numbers[0]));
            assertEquals(-2,SomaDigitosRecursiva.executar(numbers[1]));
            assertEquals(-6,SomaDigitosRecursiva.executar(numbers[2]));
            assertEquals(-4,SomaDigitosRecursiva.executar(numbers[3]));
            assertEquals(4,SomaDigitosRecursiva.executar(numbers[4]));
            //Found bug:negative numbers above 10 don't operate correctly.
        });
    }
}
