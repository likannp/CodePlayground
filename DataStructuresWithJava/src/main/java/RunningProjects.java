import java.util.Scanner;


public class RunningProjects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Numero_Aula01 number = new Numero_Aula01();

        while (true){
            System.out.println("encerar: 0 \nler valor: 1 \natribuir valor: 2");
            System.out.println("Qual sua opção?");
            int opc = scan.nextInt();

            if (opc == 0){
                break;
            } else if (opc == 1) {
                System.out.println(number.getValue());
            } else if (opc == 2) {
                System.out.println("Forneça o novo valor: ");
                float v = scan.nextFloat();
                number.setValue(v);
            }
            System.out.println("----FIM----");
        }
    }
}
