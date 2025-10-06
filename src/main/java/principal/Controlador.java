
import java.util.ArrayList;

public class Controlador {

    private ArrayList<Voo> voos = new ArrayList<>();
    public final int NUMERO_DE_VOOS = 10;

    public Controlador() {
        for (int numero = 1; numero <= NUMERO_DE_VOOS; numero++) {
            String codigoVoo = "A" + numero;
            Voo voo = new Voo(codigoVoo);
            voos.add(voo);
        }
    }

    public Voo procurarVoo(String codigo) {
        for (Voo v : voos) {
            if (v.getCodigoVoo().equalsIgnoreCase(codigo)) {
                return v;
            }
        }
        return null;
    }

    public int verificarStatus(String codigo, int numAssento) {
        Voo v = procurarVoo(codigo);
        if (v == null) {
            return 3; //inexistente
        }
        Assento a = v.procurarAssento(numAssento);
        if (a == null) {
            return 2; //inexistente
        }
        if (!a.getDisponivel()) {
            return 1; //ocupado
        }
        return 0; //disponível
    }

    public int marcarVoo(String codigo, int numAssento) {
        Voo v = procurarVoo(codigo);
        if (v == null) {
            return 3;
        }
        Assento a = v.procurarAssento(numAssento);
        if (a != null) {
            if (a.getDisponivel()) {
                a.setDisponivel(false);
                return 4;
            }
        }
        return 0;
    }
}
