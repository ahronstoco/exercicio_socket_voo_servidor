
import java.net.*;
import java.io.*;

public class Servidor {

    Controlador controlador = new Controlador();

    public int calcularCodigoStatus(String msg) {
        String[] processoEcodigoEAssento = msg.split(";");
        if (processoEcodigoEAssento.length != 0) {
            String processo = processoEcodigoEAssento[0].trim();
            String voo = processoEcodigoEAssento[1].trim();
            int assento = Integer.parseInt(processoEcodigoEAssento[2].trim());
            if (processo.equals("C")) {
                return controlador.verificarStatus(voo, assento);
            } else {
                if (processo.equals("M")) {
                    return controlador.marcarVoo(voo, assento);
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }

    public void rodarServidor() {
        try {
            ServerSocket serversocket = new ServerSocket(4444);
            System.out.println("Servidor iniciado.");
            String texto = "";

            while (!texto.equalsIgnoreCase("quit")) {
                Socket socketClient = serversocket.accept();

                PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);

                BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

                texto = in.readLine();
                System.out.println("Informação recebida:" + texto);

                if (!texto.equalsIgnoreCase("quit")) {

                    int codigoStatus = calcularCodigoStatus(texto);

                    out.println(Integer.toString(codigoStatus));
                    out.flush();
                }
                socketClient.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        System.out.println("Servidor finalizado.");
    }
}
