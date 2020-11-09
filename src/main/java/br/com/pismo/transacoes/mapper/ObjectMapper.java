package br.com.pismo.transacoes.mapper;

import org.modelmapper.ModelMapper;

public class ObjectMapper {

    private ModelMapper modelMapper;

    private ModelMapper getInstanceModelMapper() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public <T> T convert(final Object sourceOrder , final Class sourceDestino) {
        return (T) getInstanceModelMapper().map(sourceOrder, sourceDestino);
    }
}
