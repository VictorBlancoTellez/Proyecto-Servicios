package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.EnviarDato;

public class Servidor {
	final static int PUERTO = 1111;

	public static void startServer() throws IOException, ClassNotFoundException {

		ServerSocket servidor = new ServerSocket(PUERTO);

		EnviarDato enviar;

		while (true) {

			Socket sc = servidor.accept();
			ObjectInputStream objInput = new ObjectInputStream(sc.getInputStream());
			enviar = (EnviarDato) objInput.readObject();

			try {
				Socket scReEnviar = new Socket(enviar.getsIp(), 1234);
				ObjectOutputStream objOutput = new ObjectOutputStream(scReEnviar.getOutputStream());
				System.out.println(enviar);
				objOutput.writeObject(enviar);
				objOutput.close();
				scReEnviar.close();
				sc.close();
			} catch (Exception e) {
				System.err
						.println("No se ha podido establecer la conexión con la pantalla indicada " + enviar.getsIp());
				sc.close();
			}

		}

	}

}