package br.edu.utfpr.chemistsincontrol.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Classe criada para serializar os dados do tipo Data
@Configuration
public class LocalDateSerializer extends JsonSerializer<LocalDate>{
	private static final DateTimeFormatter DEFAULT_FORMATTER = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void serialize(LocalDate date, JsonGenerator generator, SerializerProvider serializers) throws IOException {
		String str = (DEFAULT_FORMATTER == null) ? date.toString() : date.format(DEFAULT_FORMATTER);
		generator.writeString(str);
	}

}
