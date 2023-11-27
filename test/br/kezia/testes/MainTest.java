package br.kezia.testes;

import kezia.br.list.Main;
import kezia.br.list.Pessoa;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class MainTest {

    @Before
    public void setUp() {
        // Certificar-se de que a lista de mulheres está vazia antes de cada teste
        Main.getMulheres().clear();
    }

    @Test
    public void testListaDeMulheres() {
        // Criar uma lista de pessoas para o teste
        List<Pessoa> pessoas = List.of(
                new Pessoa("João", 'M'),
                new Pessoa("Maria", 'F'),
                new Pessoa("Carlos", 'M'),
                new Pessoa("Ana", 'F')
        );

        // Configurar o System.in para fornecer entrada simulada
        String input = "João,M;Maria,F;Carlos,M;Ana,F";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Salvar a referência original do System.in
        InputStream originalSystemIn = System.in;

        try {
            // Redefinir a lista de pessoas lendo a entrada do console
            Main.main(new String[0]);

            // Obter a lista de mulheres usando o método estático
            List<Pessoa> mulheres = Main.getMulheres();

            // Verificar se todos na lista de mulheres são realmente mulheres
            for (Pessoa mulher : mulheres) {
                assertEquals('F', mulher.getSexo());
            }
        } finally {
            // Restaurar o System.in original
            System.setIn(originalSystemIn);
        }
    }
}
