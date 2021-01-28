package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.ConexionDB;
import controller.QuerysController;
import socket.Cliente;
import socket.Servidor;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ConexionDB cDb = new ConexionDB("Trafico");
		String IPSERVER = "25.82.206.242", IDSENSOR = "Sensor1";

		System.out.println("Introduzca un 1 si es Servidor , un 2 si es sensor y 3 si es pantalla");
		int iOpcion = Integer.parseInt(leer.readLine());
		if (iOpcion == 1) {
			Servidor.startServer();
			System.out.println("Servidor iniciado");
		} else if (iOpcion == 2) {
			int iDato;
			do {
				System.out.println("Introduce el nuevo dato del sensor");
				iDato = Integer.parseInt(leer.readLine());
				if (!QuerysController.existeDato(iDato)) {
					System.out.println("El dato indicado no existe en la base de datos\nLa lista de datos es:\n"
							+ QuerysController.mostrarListaInt(QuerysController.listarDatos()));
				} else {
					Cliente.startClient(IPSERVER, IDSENSOR, iDato);
				}
			} while (true);

		} else {
			Cliente.recibirObject();
		}
	}
}
