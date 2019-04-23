package br.edu.utfpr.chemistsincontrol.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate value) {
        return (value == null ? null : Date.valueOf(value));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return (value == null ? null : value.toLocalDate());
    }
}
