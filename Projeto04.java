import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Projeto04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> livros = new TreeSet<>();
        TreeMap<String, TreeSet<String>> autores = new TreeMap<>();
        TreeMap<String, Integer> anos = new TreeMap<>();

        System.out.println("Cadastro de livros (digite 'fim' no título para encerrar): ");

        while (true) {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            if (titulo.equalsIgnoreCase("fim")) break;

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("--------------------");

            livros.add(titulo);
            anos.put(titulo, ano);

            if (!autores.containsKey(autor)) {
                autores.put(autor, new TreeSet<>());
            }
            autores.get(autor).add(titulo);
        }

        System.out.println("\nTodos os livros:");
        for (String titulo : livros) {
            int ano = anos.get(titulo);
            System.out.println(titulo + " (" + ano + ")");
        }

        System.out.println("\nAutores e seus livros:");
        for (String autor : autores.keySet()) {
            System.out.println(autor + ":");
            for (String titulo : autores.get(autor)) {
                System.out.println("- " + titulo);
            }
        }
    }
}
