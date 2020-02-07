package com.kd.test.response;

import com.kd.test.model.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    T data;
    Response status;
}
