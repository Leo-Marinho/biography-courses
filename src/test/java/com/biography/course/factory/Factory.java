package com.biography.course.factory;

import org.springframework.stereotype.Component;

@Component
public interface Factory<T> {

    T createDefault();

}
