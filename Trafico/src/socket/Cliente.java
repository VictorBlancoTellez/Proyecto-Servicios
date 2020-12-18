package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente extends Conexion {
	public Cliente(String tipo) throws IOException {
		super(tipo);
		// TODO Auto-generated constructor stub
	}

	public Cliente() throws IOException {
		super("cliente");
	} // Se usa el constructor para cliente de Conexion

	public void startClient() // Método para iniciar el cliente
	{
		try {
			// Flujo de datos hacia el servidor
			salidaServidor = new DataOutputStream(cs.getOutputStream());

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			// Se enviarán dos mensajes
			for (int i = 0; i < 2; i++) {
				// Se escribe en el servidor usando su flujo de datos
				salidaServidor.writeUTF("Este es el mensaje número " + (i + 1) + "\n");
			}
			System.out.println("ANTES DE ENTRAR AL SITIO ESTE RARO");
			while ((mensajeCliente = entrada.readLine()) != null) // Mientras haya mensajes desde el cliente
			{
				System.out.println("ENTRO EN EL SITIO ESTE RARO");
				// Se muestra por pantalla el mensaje recibido
				System.out.println(mensajeCliente);
			}
			cs.close();// Fin de la conexión

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
