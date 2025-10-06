
import java.util.ArrayList;

public class Voo {

    public static final int NUMERO_DE_ASSENTOS = 30;
    private String codigoVoo;
    private ArrayList<Assento> assentos;

    public Voo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
        this.assentos = new ArrayList<>();

        for (int num = 1; num <= NUMERO_DE_ASSENTOS; num++) {
            assentos.add(new Assento(num));
        }
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public ArrayList getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }

    public Assento procurarAssento(int numero) {
        for (Assento a : assentos) {
            if (a.getNumero() == numero) {
                return a;
            }
        }
        return null;
    }
}
