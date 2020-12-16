package view;

import java.io.IOException;

import socket.Cliente;
import socket.Servidor;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean bServidor = true;

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
