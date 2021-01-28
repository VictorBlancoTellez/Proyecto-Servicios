package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controller.QuerysController;
import model.EnviarDato;

public class Servidor {
	final static int PUERTOSERVER = 1111;
	final static int PUERTOPANTALLA = 1234;

	public static void startServer() throws IOException, ClassNotFoundException {

		ServerSocket servidor = new ServerSocket(PUERTOSERVER);

		EnviarDato enviar;

		while (true) {

			Socket sc = servidor.accept();
			ObjectInputStream objInput = new ObjectInputStream(sc.getInputStream());
			enviar = (EnviarDato) objInput.readObject();

			try {
				String ipSensor = QuerysController.getIpByNombre(enviar.getIdSensor());
				System.out.println(enviar);
				Socket scReEnviar = new Socket(QuerysController.getIpByNombre(enviar.getIdSensor()), PUERTOPANTALLA);
				ObjectOutputStream objOutput = new ObjectOutputStream(scReEnviar.getOutputStream());
				objOutput.writeObject(enviar);
				objOutput.close();
				scReEnviar.close();
				sc.close();
			} catch (Exception e) {
				System.err.println("No se ha podido establecer la conexión con la pantalla indicada "
						+ QuerysController.getIpByNombre(enviar.getIdSensor()));
				sc.close();
			}

		}

	}

}