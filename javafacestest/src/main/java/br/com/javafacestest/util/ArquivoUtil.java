package br.com.javafacestest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil {

	private static ArquivoUtil instancia = null;
	private static final String ARQUIVO = "jsonDB.js";
	
	protected ArquivoUtil() {
		
	}

	@SuppressWarnings("resource")
	public String ler() throws IOException {

		try {
			
			FileReader ler = new FileReader(ARQUIVO);
			BufferedReader reader = new BufferedReader(ler);
			
			return reader.readLine();
			
		} catch (IOException e) {
			throw new IOException(e);
		}
	}

	public void gravar(String texto) throws IOException {

		try {
			
			File file = new File(ARQUIVO);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(texto);
			bw.close();
			
		} catch (IOException e) {
			throw new IOException(e);
		}

	}
	
	public static ArquivoUtil getInstancia(){
		if (instancia == null){
			instancia = new ArquivoUtil();
		}
		return instancia;
	}
	
}
