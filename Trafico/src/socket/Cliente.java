package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.QuerysController;
import model.EnviarDato;

public class Cliente {

	public static void startClient(String sIpServidor, String sSensor, int iDato)
			throws UnknownHostException, IOException {

		Socket sc = new Socket(sIpServidor, Servidor.PUERTOPANTALLA);
		EnviarDato enviar = new EnviarDato();
		enviar.setIdSensor(sSensor);
		enviar.setsDato(QuerysController.mensajeDato(iDato));

		ObjectOutputStream objOutput = new ObjectOutputStream(sc.getOutputStream());
		objOutput.writeObject(enviar);
		sc.close();
	}

	public static void recibirObject() throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(Servidor.PUERTOPANTALLA);
		Socket sc;
		EnviarDato recibir;
		while (true) {
			sc = server.accept();
			ObjectInputStream objInput = new ObjectInputStream(sc.getInputStream());
			recibir = (EnviarDato) objInput.readObject();
			System.out.println(recibir.getsDato());
		}
	}

}