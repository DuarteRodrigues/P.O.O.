// Duarte Rodrigues - a22206488
// Licenciatura de Engenharia Informática e Aplicações - IPLuso

public class Aluno2oAno{
    private char Nome;
    private String Numero;
    private double NotaIP;

    // Constructor to initialize the students normal data
    public Aluno2oAno(String string, String Numero, double NotaIP){
        this.Nome = Nome;
        this.Numero = Numero;
        this.NotaIP = NotaIP;
    }

    public void displayInfo(){
        System.out.println("Nome: " + Nome);
        System.out.println("Numero: " + Numero);
        System.out.println("Nota: " + NotaIP);
    }

    public static void main(String[] args){
        //Create two objects
        Aluno2oAno Aluno1 = new Aluno2oAno("Duarte", "a22206488", 15.5);
        Aluno2oAno Aluno2 = new Aluno2oAno("Joca", "a22201234", 12.8);

        Aluno1.displayInfo();
        Aluno2.displayInfo();
    }


    
}
