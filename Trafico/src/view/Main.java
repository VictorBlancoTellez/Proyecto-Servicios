package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.QueryExp;

import controller.ConexionDB;
import controller.QuerysController;
import socket.Cliente;
import socket.Servidor;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ConexionDB cDb = new ConexionDB("Trafico");

		System.out.println("Introduzca un 1 si es Servidor , un 2 si es sensor y 3 si es pantalla");
		int iOpcion = Integer.parseInt(leer.readLine());
		if (iOpcion == 1) {
			Servidor.startServer();
			System.out.println("Servidor iniciado");
		} else if (iOpcion == 2) {
			String idSensor, sIp, sIpServer;
			int iDato;
			boolean bExiste = false;
			do {
				bExiste = true;
				System.out.println("Introduce el id del sensor");
				idSensor = leer.readLine();
				if (!QuerysController.existeSensor(idSensor)) {
					bExiste = false;
					System.out.println("El sensor indicado no existe en la base de datos\nLa lista de sensores es:\n"
							+ QuerysController.mostrarLista(QuerysController.listaSensores()));

				}
			} while (!bExiste);
			do {
				bExiste = true;
				System.out.println("Introduce el dato del sensor");
				iDato = Integer.parseInt(leer.readLine());
				if (!QuerysController.existeDato(iDato)) {
					bExiste = false;
					System.out.println("El dato indicado no existe en la base de datos\nLa lista de datos es:\n"
							+ QuerysController.mostrarListaInt(QuerysController.listarDatos()));
				}
			} while (!bExiste);

			System.out.println("Introduzca la IP de la pantalla");
			sIp = leer.readLine();
			System.out.println("Introduzca la IP del servidor");
			sIpServer = leer.readLine();
			do {
				Cliente.startClient(sIpServer, idSensor, sIp, iDato);
				System.out.println("Introduce el nuevo dato del sensor");
				iDato = Integer.parseInt(leer.readLine());
			} while (true);

		} else {
			Cliente.recibirObject();
		}
	}
}
