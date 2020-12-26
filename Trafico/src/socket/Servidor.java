package socket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Servidor {

	private Socket socket;
	private ServerSocket serverSocket;
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	Scanner escaner = new Scanner(System.in);
	final String COMANDO_TERMINACION = "salir()";

	public void levantarConexion(int puerto) {
		try {
			mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
			System.out.println("estoy antes del accept");
			socket = serverSocket.accept();
			mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
		} catch (Exception e) {
			mostrarTexto("Error en levantarConexion(): " + e.getMessage());
			System.exit(0);
		}
	}

//Prueba
	public void flujos() {
		try {
			bufferDeEntrada = new DataInputStream(socket.getInputStream());
			bufferDeSalida = new DataOutputStream(socket.getOutputStream());
			bufferDeSalida.flush();
		} catch (IOException e) {
			mostrarTexto("Error en la apertura de flujos");
		}
	}

	public void recibirDatos() {
		String st = "";
		try {
			do {
				st = (String) bufferDeEntrada.readUTF();
				if(st.equals("cambio()")) {
					System.out.println("me cambio");
				}
				mostrarTexto("\n[Cliente] => " + st);
				System.out.print("\n[Usted] => ");
			} while (!st.equals(COMANDO_TERMINACION));
		} catch (IOException e) {
			cerrarConexion();
		}
	}

	public void enviar(String s) {
		try {
			bufferDeSalida.writeUTF(s);
			bufferDeSalida.flush();
		} catch (IOException e) {
			mostrarTexto("Error en enviar(): " + e.getMessage());
		}
	}

	public static void mostrarTexto(String s) {
		System.out.print(s);
	}

	public void escribirDatos() {
		while (true) {
			System.out.print("[Usted] => ");
			enviar(escaner.nextLine());
		}
	}

	public void cerrarConexion() {
		try {
			bufferDeEntrada.close();
			bufferDeSalida.close();
			socket.close();
		} catch (IOException e) {
			mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
		} finally {
			mostrarTexto("Conversación finalizada....");
			System.exit(0);

		}
	}
	
	public class Server implements Runnable{
		
		private Socket socket;

		private int puerto;
		
		public Server(int puerto, Socket socket) {
			setPuerto(puerto);
			setSocket(socket);
		}
		
		
		
		public int getPuerto() {
			return puerto;
		}



		public void setPuerto(int puerto) {
			this.puerto = puerto;
		}



		public Socket getSocket() {
			return socket;
		}



		public void setSocket(Socket socket) {
			this.socket = socket;
		}



		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					System.out.println("me he metido dento del hilo");
					levantarConexion(puerto);
					flujos();
					recibirDatos();
				} finally {
					cerrarConexion();
				}
			}
		}
		
	}
	
	private void a() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
		String puerto = sc.nextLine();
		if (puerto.length() <= 0)
			puerto = "5050";
		serverSocket = new ServerSocket(Integer.parseInt(puerto));
		while (true) {
			System.out.println("Estoy dentro de la funcions");
			Thread a = new Thread(new Server(Integer.parseInt(puerto),socket));
			a.start();
			Thread b = new Thread(new Server(Integer.parseInt(puerto),socket));
			b.start();
			//s.ejecutarConexion(Integer.parseInt(puerto));
			this.escribirDatos();
		}
	}

//	public void ejecutarConexion(int puerto) {
//		Thread hilo = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						levantarConexion(puerto);
//						flujos();
//						recibirDatos();
//					} finally {
//						cerrarConexion();
//					}
//				}
//			}
//		});
//		hilo.start();
//	}

	public static void main(String[] args) throws IOException {
		Servidor s = new Servidor();
		s.a();

	}
}