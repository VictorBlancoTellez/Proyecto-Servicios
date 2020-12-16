package socket;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
	public Cliente() throws IOException {
		super("cliente");
	}

	public void startClient() {
		try {

			salidaServidor = new DataOutputStream(socket.getOutputStream());

			for (int i = 0; i < 2; i++) {

				salidaServidor.writeUTF("Este es el mensaje n�mero " + (i + 1) + "\n");
			}

			socket.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}