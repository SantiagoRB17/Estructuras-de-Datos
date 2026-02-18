import java.util.ArrayList;

public class PruebaCollections {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("R");
        lista.add("S");
        eliminarR(lista);
        System.out.println(lista);
    }
    public static void eliminarR(ArrayList<String> lista){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).startsWith("R")){
                lista.remove(i);
                i--;
            }
        }
    }
}