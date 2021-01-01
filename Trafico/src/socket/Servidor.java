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
			Socket scReEnviar = new Socket(enviar.getsIp(), 1234);
			ObjectOutputStream objOutput = new ObjectOutputStream(sc.getOutputStream());
				
			objOutput.writeObject(enviar);
			objOutput.close();
			scReEnviar.close();
			sc.close();

		}

	}

}