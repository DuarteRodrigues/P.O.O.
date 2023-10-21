// Duarte Rodrigues - a22206488
// Licenciatura de Engenharia Informática e Aplicações - IPLuso

class Alunos{
    private String nome;
    private int idade;
    private String numMat;
    private String nomeCurso;

    public Alunos(String nome, int idade, String numMat, String nomeCurso){
        this.nome = nome;
        this.idade = idade;
        this.numMat = numMat;
        this.nomeCurso = nomeCurso;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getNumMat(){
        return numMat;
    }

    public String getNomeCurso(){
        return nomeCurso;
    }
}

class Vegetais{
    private double preco;
    private int quantidade;
    private String nome;

    public Vegetais(double preco, int quantidade, String nome) {
    this.preco = preco;
    this.quantidade = quantidade;
    this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }

}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}


public class Homework4{
    public static void main(String[] args){
        Alunos aluno1 = new Alunos("Duarte", 21, "a22206488", "LEIA");
        Alunos aluno2 = new Alunos("Rogério", 22, "a22201234", "GSI");

        Person person1 = new Person("Ean Craig", 11);
        Person person2 = new Person("Evan Ross", 12);

        Vegetais vegetal1 = new Vegetais(2.99, 5, "Tomate");
        Vegetais vegetal2 = new Vegetais(1.49, 10, "Cenoura");
        Vegetais vegetal3 = new Vegetais(0.99, 8, "Alface");

        Vegetais copiaVegetal1 = new Vegetais(vegetal1.getPreco(), vegetal1.getQuantidade(), vegetal1.getNome());

        System.out.println(aluno1.getNome() + " - " + aluno1.getIdade() + " anos.");
        System.out.println(aluno2.getNome() + " - " + aluno2.getIdade() + " anos.");

        System.out.println(person1.getName() + " is " + person1.getAge() + " years old.");
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old.\n");

        System.out.println("Cópia de Vegetal 1:");
        System.out.println("Nome: " + copiaVegetal1.getNome());
        System.out.println("Preço: " + copiaVegetal1.getPreco());
        System.out.println("Quantidade: " + copiaVegetal1.getQuantidade());

    }
}