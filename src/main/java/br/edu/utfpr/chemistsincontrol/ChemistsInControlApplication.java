package br.edu.utfpr.chemistsincontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChemistsInControlApplication {

    public static void main(String[] args) {
    	System.out.println("Incializando o projeto");
        SpringApplication.run(ChemistsInControlApplication.class, args);
    }

}
