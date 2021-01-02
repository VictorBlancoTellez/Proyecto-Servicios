package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.ConexionDB;
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
			System.out.println("Introduce el id del sensor");
			String idSensor = leer.readLine();
			System.out.println("Introduce el dato del sensor");
			int iDato = Integer.parseInt(leer.readLine());
			System.out.println("Introduzca la IP de la pantalla");
			String sIp = leer.readLine();
			System.out.println("Introduzca la IP del servidor");
			String sIpServer = leer.readLine();
			do {
				Cliente.startClient(sIpServer, idSensor, sIp, iDato);
				System.out.println("Introduce el nuevo dato del sensor");
				iDato = Integer.parseInt(leer.readLine());
			} while (true);

		} else {
			Cliente.recibirObject();
		}

//		Cliente.startClient("127.0.0.1", "ads", "127.0.0.1", 1);
//
//		boolean bServidor;
//		byte bOpcion;
//		String sUsuario = "";
//
//		System.out.println("Introduzca su id de pantalla o sensor");
//		sUsuario = leer.readLine();
//		if (QuerysController.existePantalla(sUsuario)) {
//			UsuariosEsperando.listaPantallasEsperando.add(sUsuario);
//
//		} else if (QuerysController.existeSensor(sUsuario)) {
//			if (UsuariosEsperando.listaPantallasEsperando.size() > 0) {
//				System.out.println("Introduzca el ID de la pantalla a la que quiere conectarse");
//				String sPantallaConexion = leer.readLine();
//				if (QuerysController.existePantalla(sPantallaConexion)) {
//
//					System.out.println("Tu te has conectado a la pantalla: " + sPantallaConexion);
//
//				} else {
//					System.out.println("No existe una pantalla con ese ID");
//				}
//			} else {
//				System.out.println("No hay ninguna pantalla esperando conexion");
//			}
//
//		} else {
//			System.out.println("Elija un usuario que exista");
//		}
//
//	}
	}
}
