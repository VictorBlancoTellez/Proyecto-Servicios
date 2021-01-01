package socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.QuerysController;
import model.EnviarDato;

public class Cliente {

	public static void startClient(String sIpServidor, String sSensor, String sIp, int iDato)
			throws UnknownHostException, IOException {

		Socket sc = new Socket(sIpServidor, Servidor.PUERTO);
		EnviarDato enviar = new EnviarDato();
		enviar.setIdSensor(sSensor);
		enviar.setsIp(sIp);
		enviar.setsDato(QuerysController.mensajeDato(iDato));

		ObjectOutputStream objOutput = new ObjectOutputStream(sc.getOutputStream());
		objOutput.writeObject(enviar);
		sc.close();
	}

	public static void recibirObject() throws IOException, ClassNotFoundException {
		ObjectInputStream objInput = null;
		ServerSocket server = new ServerSocket(1234);
		Socket sc;
		EnviarDato recibir;
		while (true) {
			sc = server.accept();
			try {
				objInput = new ObjectInputStream(sc.getInputStream());
			} catch (EOFException e) {
				e.getMessage();
			}

			recibir = (EnviarDato) objInput.readObject();
			System.out.println(recibir.getsDato());
		}
	}

}