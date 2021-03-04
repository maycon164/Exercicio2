package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {


	public String indentificaSO() {
		return System.getProperty("os.name");
	}

	public void listarProcessos(String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("ps -ef");
			} else {
				process = Runtime.getRuntime().exec("tasklist");
			}

			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			buffer.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void matarProcessoPID(int pid, String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("kill -9 "+pid);
			}else {
				process = Runtime.getRuntime().exec("taskkill /pid "+pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void matarProcessoNome(String nome, String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("pkill -f "+nome);
			}else {
				process = Runtime.getRuntime().exec("taskkill /im "+nome);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}