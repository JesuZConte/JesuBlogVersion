package com.nisum.blog.persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.StringTokenizer;

import com.nisum.blog.model.Author;

public class IAutorImpl implements IAutor {

	@Override
	public void create(Author author) {
		try {
			String content = author.toString();
			File file = new File("src/main/resources/authors.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	@Override
	public Author read(int id) {
		File directorio = new File("src/main/resources/");
		File archivo = new File(directorio, "authors.txt");
		Author nuevoAutor = new Author();
		if (directorio.exists()) {
			if (archivo.exists()) {
				try {
					BufferedReader lector = new BufferedReader(new FileReader(archivo));
					String line = lector.readLine();
					while (line != null) {
						buscarAutor(nuevoAutor, line, String.valueOf(id));
						line = lector.readLine();
					}
					lector.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}

		}
		return nuevoAutor;
	}
	

	@Override
	public boolean update(Author autor) {
		boolean actualizado = false;
		try {
		File directorio = new File("src/main/resources/");
		File archivo = new File(directorio, "authors.txt");
		File tempArchivo = File.createTempFile("authors", ".tmp", directorio);
		tempArchivo.deleteOnExit();
		if (directorio.exists()) {
			if (archivo.exists()) {
				BufferedReader lector = new BufferedReader(new FileReader(archivo));
				PrintWriter pencil = new PrintWriter(new FileWriter(tempArchivo));
					String line = lector.readLine();
					String newText;
					while (line != null) {
						StringTokenizer token = new StringTokenizer(line, ",");
						if (token.nextToken().equals(String.valueOf(autor.getId()))) {
							newText = line.replace(line, autor.toString());
							pencil.println(newText);
							actualizado = true;
							line = lector.readLine();
						} else {
							pencil.println(line);
							line = lector.readLine();
						}
					}
					pencil.close();
					lector.close();
					FileInputStream temp = new FileInputStream(tempArchivo);
					FileOutputStream nuevo = new FileOutputStream(archivo);
					FileChannel src = temp.getChannel();		
					FileChannel dest = nuevo.getChannel();
					dest.transferFrom(src, 0, src.size());
					temp.close();
					nuevo.close();
					src.close();
					dest.close();	
				} 
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualizado;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	
	private Author buscarAutor(Author autor, String line, String valor){
		StringTokenizer token = new StringTokenizer(line, ",");
		
		String primerValor = token.nextToken();
		if (primerValor.equals(valor)){
			
			autor.setId(Integer.parseInt(primerValor));
			autor.setName(token.nextToken());
			autor.setMail(token.nextToken());
		}
			
		return autor;
	}

}
