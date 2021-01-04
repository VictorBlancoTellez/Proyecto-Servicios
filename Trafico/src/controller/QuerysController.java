package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuerysController {

	public static boolean existeSensor(String sensor) {
		boolean bExiste = false;
		int iContador = 0;
		List<String> listaSensores = listaSensores();

		while (!bExiste && iContador < listaSensores.size()) {
			if (sensor.equals(listaSensores.get(iContador))) {
				bExiste = true;
			}
			iContador++;
		}

		return bExiste;
	}

	public static boolean existePantalla(String pantalla) {
		boolean bExiste = false;
		int iContador = 0;
		List<String> listaPantallas = listaPantallas();

		while (!bExiste && iContador < listaPantallas.size()) {
			if (pantalla.equals(listaPantallas.get(iContador))) {
				bExiste = true;
			}
			iContador++;
		}

		return bExiste;
	}

	public static List<String> listaSensores() {

		List<String> lSensores = new ArrayList<String>();
		String sql = "SELECT ID FROM Sensor";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sID = rs.getString(1);

				lSensores.add(sID);
			}
			stm.close();
		} catch (SQLException e) {

		}
		return lSensores;
	}

	public static String mostrarLista(List<String> lista) {
		String sResultado = "";

		for (int i = 0; i < lista.size(); i++) {
			sResultado += lista.get(0) + "\n";
		}

		return sResultado;
	}

	public static String mostrarListaInt(List<Integer> lista) {
		String sResultado = "";

		for (int i = 0; i < lista.size(); i++) {
			sResultado += lista.get(0) + "\n";
		}

		return sResultado;
	}

	public static List<Integer> listarDatos() {
		List<Integer> listaDatos = new ArrayList<Integer>();
		String sql = "Select ID FROM monsajes";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				listaDatos.add(id);
			}
			stm.close();
		} catch (Exception e) {

		}
		return listaDatos;
	}

	public static List<String> listaPantallas() {

		List<String> lPantalla = new ArrayList<String>();
		String sql = "SELECT ID FROM Pantalla";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sID = rs.getString(1);

				lPantalla.add(sID);
			}
			stm.close();
		} catch (SQLException e) {

		}
		return lPantalla;
	}

	public static boolean existeDato(int iDato) {
		boolean bExiste = false;
		int iContador = 0;
		List<Integer> listaDatos = listarDatos();

		while (!bExiste && iContador < listaDatos.size()) {
			if (iDato == (listaDatos.get(iContador))) {
				bExiste = true;
			}
			iContador++;
		}

		return bExiste;
	}

	public static String mensajeDato(int iDato) {
		String sMensaje = "";
		if (existeDato(iDato)) {

			String sql = "SELECT Mensaje FROM mensajes WHERE ID = " + iDato;
			Statement stm = null;

			try {
				stm = ConexionDB.getConnection().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					sMensaje = rs.getString(1);

				}
				stm.close();
			} catch (SQLException e) {
				System.out.println("Algo va mal");
			}
		} else {
			sMensaje = "No existe";
		}

		return sMensaje;
	}

}
