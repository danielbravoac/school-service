package com.danielbravoac.schoolservice.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {

    private final ApplicationContext applicationContext;

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, String... mapperQualifier) {
        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return source.stream()
                .map(e -> modelMapper.map(e, targetClass))
                .toList();
    }

    public <S, T> T map(S source, Class<T> targetClass, String... mapperQualifier) {
        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return modelMapper.map(source, targetClass);
    }

    private ModelMapper getModelMapper(String[] mapperQualifier) {
        if (mapperQualifier.length == 0 || mapperQualifier[0] == null || mapperQualifier[0].isEmpty()) {
            return applicationContext.getBean("modelMapper", ModelMapper.class);
        } else {
            return applicationContext.getBean(mapperQualifier[0], ModelMapper.class);
        }
    }

}
