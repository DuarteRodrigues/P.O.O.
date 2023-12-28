package Projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTelefonica{
    private List<Contacto> contactos;

    public ListaTelefonica(){
        this.contactos = new ArrayList<>();
    }

    public void adicionarContacto(){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Nome do contacto: ");
            String nome = scanner.nextLine();

            System.out.println("Telefone do contacto: ");
            String telefone = scanner.nextLine();

            System.out.println("E-mail do contacto: ");
            String email = scanner.nextLine();

            Contacto aContacto = new Contacto(nome, telefone, email);
            contactos.add(aContacto);

            System.out.println("Contacto adicionado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao adicionar contacto:" + e.getMessage());
        }    
    }

    public void modificarContacto(String nomeAntigo){
        Scanner scanner = new Scanner(System.in);

        try{
            for (int i = 0; i < contactos.size(); i++){
                Contacto contacto = contactos.get(i);
                if(contacto.getNome().equals(nomeAntigo)){
                    System.out.println("Nome do novo contacto: ");
                    String novoNome = scanner.nextLine();

                    System.out.println("Nº de telefone do novo contacto: ");
                    String novoTelefone = scanner.nextLine();

                    System.out.println("Email do novo contacto: ");
                    String novoEmail = scanner.nextLine();

                    Contacto mContacto = new Contacto(novoNome, novoTelefone, novoEmail);
                    contactos.set(i, mContacto);

                    System.out.println("Contacto modificado com sucesso!");
                }
            }
            System.out.println("Contacto com o nome " + nomeAntigo + " não encontrado.");
        } catch (Exception e) {
            System.err.println("Erro na modifcação do contacto:" + e.getMessage());
        }
    }

    // Método para carregar os conteúdos do ficheiro CSV.
    public void carregarCSV(File fich){
        try(BufferedReader reader = new BufferedReader(new FileReader(fich.getName()))){
            contactos.clear();
            String linha = "";
            while ((linha = reader.readLine()) != null){
                String[] partes = linha.split(",");
                Contacto contacto = new Contacto(partes[0], partes[1], partes[2]);
                contactos.add(contacto);
            }
            System.out.println("Lista carregada do ficheiro com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar lista do arquivo CSV: " + e.getMessage());
        }
    }

    // Método para criar o ficheiro CSV caso este não exista.
    public void criarCSV(File fich){
        try {
            fich.createNewFile();
        } catch (IOException e) {
            System.err.println("Erro ao criar novo arquivo CSV: " + e.getMessage());
        }
    }

    // Método para guardar os dados presentes na lista do em memória para o ficheiro CSV. 
    public void salvarCSV(File fich){
        try (PrintWriter writer = new PrintWriter(new FileWriter(fich.getName()))){
            for (Contacto contacto : contactos) {
                writer.println(contacto.getNome()+","+contacto.getTelefone()+","+contacto.getEmail());
            }
            System.out.println("Lista guardada no ficheiro com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista em CSV:" + e.getMessage());
        }
    }

    // Método para verificar a existência do ficheiro com recorrência a outros métodos para carregar ou criar o ficheiro e os seus conteúdos
    public void verificarCSV(File fich){
        if(fich.exists()){
            carregarCSV(fich);
        } else {
            System.out.println("Ficheiro CSV não encontrado. A criar novo ficheiro.");
            criarCSV(fich);
        }
    }

    // Método para organizar a lista com base no Nome
    public void ordenarNome(){
        int n = contactos.size();

        for(int i = 1; i < n; i++){
            Contacto aux = contactos.get(i);
            int j = i - 1;

            while(j >= 0 && contactos.get(j).getNome().compareTo(aux.getNome()) > 0) {
                contactos.set(j + 1, contactos.get(j));
                j = j - 1;
            }
            contactos.set(j + 1, aux);
        }
    }

    // Método para organizar a lista com base no Número de Telefone
    public void ordenarTelefone(){
        int n = contactos.size();

        for(int i = 1; i < n; i++){
            Contacto aux = contactos.get(i);
            int j = i - 1;

            while(j >= 0 && contactos.get(j).getTelefone().compareTo(aux.getTelefone()) > 0) {
                contactos.set(j + 1, contactos.get(j));
                j = j - 1;
            }
            contactos.set(j + 1, aux);
        }
    }

    public static void mainOptions(){
        System.out.println("##########################################################");
        System.out.println("# 1 - Adicionar Contacto                                 #");
        System.out.println("# 2 - Modificar Contacto                                 #");
        System.out.println("# 3 - Apagar Contacto                                    #");
        System.out.println("# 4 - Listar Todos os Contactos                          #");
        System.out.println("##########################################################");
    }

    public static void main(String[] args) {

    String fileName = "lista-telefonica.CSV";
    int escolha = 10;

    File fich = new File(fileName);
    ListaTelefonica lista = new ListaTelefonica();
    Scanner scanner = new Scanner(System.in);


    try{
        lista.verificarCSV(fich);
        mainOptions();
        while(escolha > 0 || escolha <=4 || escolha != 0){
            System.out.println("Escolha uma opção:");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                lista.adicionarContacto();
                break;

                case 2:
                lista.modificarContacto(fileName);
                break;
            }
        }

    } catch (Exception e){
        lista.salvarCSV(fich);
        System.err.println("Erro na leitura do ficheiro: " + e.getMessage());
    }
    
    }
}