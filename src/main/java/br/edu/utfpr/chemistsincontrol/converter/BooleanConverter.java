package br.edu.utfpr.chemistsincontrol.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean value) {
        return (Boolean.TRUE.equals(value) ? 1 : 0);
    }

    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        if (value == 1) {
            return true;
        } else return false;
    }

}
