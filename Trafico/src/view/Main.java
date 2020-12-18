package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import socket.Cliente;
import socket.Servidor;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

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
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		if (bServidor) {
			Servidor serv = new Servidor();

			System.out.println("Iniciando servidor\n");

			Process p = JavaProcess.exec(Servidor.class, jvmArgs, argsM);

		}
		// Si te logeas como cliente haces esto
		else {
			Cliente cli = new Cliente();

			System.out.println("Iniciando cliente\n");
			Process p = JavaProcess.exec(Cliente.class, jvmArgs, argsM);
		}

	}

}
