package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Conexion {
	private static int PUERTO = 1234;
	public Servidor() throws IOException {
		super("servidor");
	}

	public void startServer() throws IOException {
		while (true) {
			 BufferedReader entrada;
		        DataOutputStream salida;
		        Socket socket;
		        ServerSocket serverSocket;
		         
		        try {
		            serverSocket = new ServerSocket(PUERTO);
		 
		            System.out.println("Esperando una conexi�n...");
		 
		            socket = serverSocket.accept();
		 
		            System.out.println("Un cliente se ha conectado...");
		 
		            // Para los canales de entrada y salida de datos
		 
		            entrada = new BufferedReader(new InputStreamReader(
		                    socket.getInputStream()));
		 
		            salida = new DataOutputStream(socket.getOutputStream());
		 
		            System.out.println("Confirmando conexion al cliente....");
		 
		            salida.writeUTF("Conexi�n exitosa...");
		 
		            // Para recibir el mensaje
		 
		            String mensajeRecibido = entrada.readLine();
		 
		            System.out.println(mensajeRecibido);
		 
		            salida.writeUTF("Se recibio tu mensaje.");
		 
		            salida.writeUTF("Gracias por conectarte.");
		 
		            System.out.println("Cerrando conexi�n...");
		 
		            // Cerrando la conex�n
		            serverSocket.close();
		 
		        } catch (IOException e) {
		            System.out.println("Error de entrada/salida."  + e.getMessage());
		        }
		 
		    }
	}
}