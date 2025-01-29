import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class binary_search {
    public static void main(String[] args) {
        int baixo =0;
        int item =3;
        List<Integer> lista = Stream.of(1, 3, 5, 7, 9).collect(Collectors.toList());
        int alto = lista.size()-1;

        while (baixo <= alto) {
            var meio=  (baixo+alto)/2;
            int chute = lista.get(meio);
            if (chute==item){
                System.out.println("chute: "+chute);
                System.out.println("Item encontrado no índice: " + meio);
                return;
            } else if (chute>item) {
                System.out.println("Chute:" +chute+" -> alto");
                alto = meio -1;
            }else {
                baixo=meio+1;
                System.out.println("Chute:" +chute+" -> baixo");
            }
            System.out.println("Item não encontrado na lista.");
        }
    }
}
