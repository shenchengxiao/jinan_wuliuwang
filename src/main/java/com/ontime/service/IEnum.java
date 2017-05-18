package com.ontime.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ontime.enums.EnumResponseConverter;


/**
 * 实现描述：枚举类接口
 */
@JsonSerialize(converter = EnumResponseConverter.class)
public interface IEnum<T> {

    T getValue();

    String getTitle();

}
