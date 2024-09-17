package com.danielbravoac.schoolservice.controller.dto.response;

import org.springframework.beans.factory.annotation.Value;

public interface StudentProjection {
    @Value("#{target.firstName+' '+target.lastName}")
    String getFullName();

    String getDni();

    Byte getAge();
}
