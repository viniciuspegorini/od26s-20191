package br.edu.utfpr.chemistsincontrol.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Classe criada para Desserializar os dados do tipo Data
@Configuration
public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{
	private static final DateTimeFormatter DEFAULT_FORMATTER = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			return LocalDate.parse(p.getValueAsString(), DEFAULT_FORMATTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
