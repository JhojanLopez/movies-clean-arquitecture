package com.example.clean_arquitecture.infrastructure.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de ModelMapper para la aplicación.
 * 
 * Esta clase se encuentra en la capa de infraestructura, ya que configura
 * un componente específico de un framework (ModelMapper) que se utiliza
 * para mapear objetos entre diferentes capas de la aplicación.
 * 
 * Al exponer ModelMapper como un bean de Spring, permite su inyección
 * y uso en cualquier parte de la aplicación donde se requiera mapeo
 * de objetos, facilitando la conversión entre entidades de dominio
 * y entidades de infraestructura.
 * 
 * La configuración de ModelMapper está ajustada para omitir valores
 * nulos durante el mapeo, lo que ayuda a evitar la sobrescritura
 * de valores existentes con nulos.
 */
@Configuration
public class ModelMapperConfiguration {
    
    @Bean
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;
    }
}
