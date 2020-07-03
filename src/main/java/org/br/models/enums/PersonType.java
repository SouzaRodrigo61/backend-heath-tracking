package org.br.models.enums;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum PersonType {

    MASCULINO('M'),
    FEMININO('F'),
    INDEFINIDO('I');

    private final char personType;

    PersonType(char personType) {
        this.personType = personType;
    }

    public char getType() {
        return personType;
    }

    public static PersonType parse(String y) {
        if (y == null)
            return null;
        if ("M".equals(y))
            return MASCULINO;
        if ("F".equals(y))
            return FEMININO;
        if ("I".equals(y))
            return INDEFINIDO;
        throw new IllegalStateException("Invalid value: " + y);
    }

    @Converter(autoApply = true)
    public static class Mapper implements AttributeConverter<PersonType, String> {

        @Override
        public String convertToDatabaseColumn(PersonType x) {
            return String.valueOf(Objects.isNull(x) ? " " : x.getType());
        }

        @Override
        public PersonType convertToEntityAttribute(String y) {
            if (Objects.isNull(y))
                return null;
            if ("M".equals(y))
                return MASCULINO;
            if ("F".equals(y))
                return FEMININO;
            if ("I".equals(y))
                return INDEFINIDO;
            throw new IllegalStateException("Invalid value: " + y);
        }
    }

}
