package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import socket.Cliente;
import socket.Servidor;

public class Main {

	public static void main(String[] args) throws IOException {

		boolean bServidor;
		byte bOpcion;
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Pulse 1 para cliente, 2 para servidor");
		bOpcion = Byte.parseByte(leer.readLine());
		if (bOpcion == 1) {
			bServidor = false;
		} else {
			bServidor = true;
		}

		// Si te logeas como servidore haces esto
		if (bServidor) {
			Servidor serv = new Servidor();

			System.out.println("Iniciando servidor\n");
			serv.startServer();
		}
		// Si te logeas como cliente haces esto
		else {
			Cliente cli = new Cliente();

			System.out.println("Iniciando cliente\n");
			cli.startClient();
		}

	}

}
