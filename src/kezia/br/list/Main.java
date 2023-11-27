package kezia.br.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar pessoas
        List<Pessoa> pessoas = new ArrayList<>();

        // Leitura de pessoas e seus sexos do console
        System.out.println("Digite as pessoas e seus sexos separados por vírgulas (Ex: João,M; Maria,F; ...):");
        String input = scanner.nextLine();

        // Dividir entrada em pares nome-sexo
        String[] pares = input.split(";");

        // Adicionar pessoas à lista
        for (String par : pares) {
            String[] partes = par.split(",");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                char sexo = partes[1].trim().toUpperCase().charAt(0);
                pessoas.add(new Pessoa(nome, sexo));
            }
        }

        // Usar expressões lambda para filtrar mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo() == 'F')
                .collect(Collectors.toList());

        // Imprimir lista de mulheres
        System.out.println("Lista de Mulheres:");
        mulheres.forEach(p -> System.out.println("Nome: " + p.getNome() + ", Sexo: " + p.getSexo()));
    }
}
