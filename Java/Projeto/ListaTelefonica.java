package Projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTelefonica{
    public static List<Contacto> contactos;

    public ListaTelefonica(){
        this.contactos = new ArrayList<>();
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

    // Método para organizar a lista com base no Nome.
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

    // Método para organizar a lista com base no Número de Telefone.
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

    // Método usado para listar as opções disponíveis para o utilizador.
    public static void Opcoes(){
        System.out.println("##########################################################");
        System.out.println("# 1 - Adicionar Contacto                                 #");
        System.out.println("# 2 - Modificar Contacto                                 #");
        System.out.println("# 3 - Apagar Contacto                                    #");
        System.out.println("# 4 - Ordenar p/ Nome                                    #");
        System.out.println("# 5 - Ordenar p/ Número de Telefone                      #");
        System.out.println("# 6 - Listar Todos os Contactos                          #");
        System.out.println("# 7 - Pesquisar Contacto                                 #");
        System.out.println("# 8 - Salvar no CSV                                      #");
        System.out.println("##########################################################");
    }

    // Método usado para listar os contactos da lista.
    public void listarContactos(){
        if(contactos.isEmpty()) {
            System.out.println("\nA Lista está vazia!");
        } else {
            System.out.printf("%-20s %-15s %-30s\n", "Nome", "Telefone", "E-Mail");
            for (Contacto contacto : contactos){
                System.out.printf("%-20s %-15s %-30s\n", contacto.getNome(), contacto.getTelefone(), contacto.getEmail());
            }
        }
    }

    public static boolean atributoExiste(String atributo){
        for (Contacto contacto : contactos){
            if(contacto.getNome().equals(atributo) || contacto.getTelefone().equals(atributo) || contacto.getEmail().equals(atributo)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    String fileName = "lista-telefonica.CSV";
    int escolha = 10;

    File fich = new File(fileName);
    ListaTelefonica lista = new ListaTelefonica();
    Scanner scanner = new Scanner(System.in);

    lista.verificarCSV(fich);
    lista.listarContactos();
    Opcoes();

    while(escolha != 0){
        System.out.println("Escolha uma opção:");
        escolha = scanner.nextInt();
            
        switch (escolha) {
            case 1:
                scanner.nextLine();
                try{

                    String nomeCompleto;
                    do{
                        System.out.println("Primeiro nome do contacto: ");
                        String nome = scanner.nextLine();

                        System.out.println("Apelido do contacto: ");
                        String apelido = scanner.nextLine();

                        nomeCompleto = nome + " " + apelido;

                        if(atributoExiste(nomeCompleto)) {
                            System.out.println("Esta pessoa já existe na lista.");
                        }
                        
                    } while(atributoExiste(nomeCompleto));
                   
                    String telefone;
                    do{
                        System.out.println("Telefone do contacto: ");
                        telefone = scanner.nextLine();

                        if(atributoExiste(telefone)) {
                            System.out.println("Este número de telefone já existe na lista.");
                        }

                    }while (atributoExiste(telefone));
                                       
                    String email;
                    do{
                        System.out.println("E-mail do contacto: ");
                        email = scanner.nextLine();

                        if(atributoExiste(email)){
                            System.out.println("O endereço de e-mail já se encontra na lista.");
                        }
                    } while(atributoExiste(email));

                    Contacto aContacto = new Contacto(nomeCompleto, telefone, email);
                    contactos.add(aContacto);

                    System.out.println("Contacto adicionado com sucesso!");
                } catch (Exception e) {
                    System.err.println("Erro ao adicionar contacto:" + e.getMessage());
                }   
                lista.listarContactos();
                Opcoes();
                break;
                    
            case 2:
                scanner.nextLine();
                lista.listarContactos();
                System.out.println("Indique o nome completo do contacto que deseja modificar: ");
                String mNomeAntigo;
                int mEscolha;
                String mNome;
                String mTelefone;
                String mEmail;
                
                do{
                    mNomeAntigo = scanner.nextLine();

                    if (!atributoExiste(mNomeAntigo)) {
                        System.out.println(mNomeAntigo + " não está na lista!");
                    }
                }while (!atributoExiste(mNomeAntigo));  

                try{
                    for (int i = 0; i < contactos.size(); i++){
                        Contacto contacto = contactos.get(i);
                        if(contacto.getNome().equals(mNomeAntigo)){
                            System.out.printf("%-20s %-15s %-30s\n", contacto.getNome(), contacto.getTelefone(), contacto.getEmail());
                            do{
                                System.out.println("##########################################################");
                                System.out.println("# indique o atributo que deseja alterar:                 #");
                                System.out.println("# 1 - Nome                                               #");
                                System.out.println("# 2 - Telefone                                           #");
                                System.out.println("# 3 - Email                                              #");
                                System.out.println("##########################################################");
                                mEscolha = scanner.nextInt();

                                if(mEscolha <1 || mEscolha >3){
                                    System.out.println("Escolha indisponível");
                                }
                                switch (mEscolha) {
                                    case 1:
                                        do{
                                            System.out.println("Novo Nome:");
                                            mNome = scanner.nextLine();
                                            if(atributoExiste(mNome)){
                                                System.out.println("O novo nome já se encontra na lista.");
                                            }
                                        } while (atributoExiste(mNome));    
                                        break;
                                
                                    case 2:
                                        do{
                                            System.out.println("Novo Número:");
                                            mTelefone = scanner.nextLine();
                                            if (atributoExiste(mTelefone)) {
                                                System.out.println("O novo número já se encontra na lista.");
                                            }
                                        } while(atributoExiste(mTelefone));
                                        break;

                                    case 3:
                                        do{
                                            System.out.println("Novo E-mail:");
                                            mEmail = scanner.nextLine();
                                            if (atributoExiste(mEmail)) {
                                                System.out.println("O novo e-mail já se encontra na lista.");
                                            }
                                        } while(atributoExiste(mEmail));
                                        break;
                                }
                            } while(mEscolha <1 || mEscolha >3);
                            System.out.println("Contacto modificado com sucesso!");
                        }
                    }
                    System.out.println("Contacto com o nome " + mNomeAntigo + " não encontrado.");
                } catch (Exception e) {
                    System.err.println("Erro na modifcação do contacto:" + e.getMessage());
                }
                lista.listarContactos();
                Opcoes();
                break;

            case 3:
                scanner.nextLine();
                lista.listarContactos();
                System.out.println("Indique o nome completo do contacto que deseja apagar: ");
                String aNomeAntigo;

                do{
                    aNomeAntigo = scanner.nextLine();

                    if (!atributoExiste(aNomeAntigo)) {
                        System.out.println(aNomeAntigo + " não está na lista!");
                    }
                }while (!atributoExiste(aNomeAntigo));
                try{
                    boolean removido = false;
                    for(Contacto contacto : contactos){
                        if(contacto.getNome().equals(aNomeAntigo)){
                            contactos.remove(contacto);
                            removido = true;
                            System.out.println("Contacto removido com sucesso!");
                            break;
                        }
                    }
                    if(!removido){
                        System.out.println("Contacto com o nome '" + aNomeAntigo + "' não encontrado.");
                    } 
                } catch (Exception e){
                    System.err.println("Erro ao remover o contacto: " + e.getMessage());
                }
                lista.listarContactos();
                Opcoes();
                break;

            case 4:
                lista.ordenarNome();
                lista.listarContactos();
                Opcoes();
                break;

            case 5:
                lista.ordenarTelefone();
                lista.listarContactos();
                Opcoes();
                break;

            case 6:
                lista.listarContactos();
                Opcoes();
                break;

            case 7:
                scanner.nextLine();
                lista.listarContactos();
                int pEscolha;
                String pNome;
                String pTelefone;
                String pEmail;
                do{
                    System.out.println("##########################################################");
                    System.out.println("# indique o atributo que deseja pesquisar:               #");
                    System.out.println("# 1 - Nome                                               #");
                    System.out.println("# 2 - Telefone                                           #");
                    System.out.println("# 3 - Email                                              #");
                    System.out.println("##########################################################");
                    pEscolha = scanner.nextInt();

                    if(pEscolha <1 || pEscolha>3){
                        System.out.println("Escolha Indisponível.");
                    } else{
                        switch(pEscolha) {
                            case 1:
                                do{
                                    System.out.println("Nome do Contacto:");
                                    pNome = scanner.nextLine();

                                    if (!atributoExiste(pNome)) {
                                        System.out.println(pNome + " não está na lista");
                                    }
                                }while(!atributoExiste(pNome));

                                for (int i = 0; i < contactos.size(); i++){
                                    Contacto contacto = contactos.get(i);
                                    if(contacto.getNome().equals(pNome)){
                                        System.out.printf("%-20s %-15s %-30s\n", contacto.getNome(), contacto.getTelefone(), contacto.getEmail());
                                    }
                                }    
                                break;

                            case 2:
                                do{
                                    System.out.println("Número do Contacto:");
                                    pTelefone = scanner.nextLine();

                                    if (!atributoExiste(pTelefone)) {
                                        System.out.println(pTelefone + " não está na lista");
                                    }
                                }while(!atributoExiste(pTelefone));

                                for (int i = 0; i < contactos.size(); i++){
                                    Contacto contacto = contactos.get(i);
                                    if(contacto.getTelefone().equals(pTelefone)){
                                        System.out.printf("%-20s %-15s %-30s\n", contacto.getNome(), contacto.getTelefone(), contacto.getEmail());
                                    }
                                }    
                                break;
                                
                            case 3:
                                do{
                                    System.out.println("E-mail do Contacto:");
                                    pEmail = scanner.nextLine();

                                    if (!atributoExiste(pEmail)) {
                                        System.out.println(pEmail + " não está na lista");
                                    }
                                }while(!atributoExiste(pEmail));

                                for (int i = 0; i < contactos.size(); i++){
                                    Contacto contacto = contactos.get(i);
                                    if(contacto.getEmail().equals(pEmail)){
                                        System.out.printf("%-20s %-15s %-30s\n", contacto.getNome(), contacto.getTelefone(), contacto.getEmail());
                                    }
                                }                                    
                                break;    
                        }
                    }

                } while (pEscolha <1 || pEscolha>3);

                break;    
            case 8:
                lista.salvarCSV(fich);
                lista.listarContactos();
                System.out.println("A lista foi guardada no ficheiro CSV.");
                Opcoes();
                break;

            case 0:
                System.out.println("Obrigado por utilizar a nossa aplicação!");
            }        
    
    }
    scanner.close();
    }
}