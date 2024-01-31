package com.bancom.demo.mapper;

import java.util.List;

public interface GenericMapper<D, E> {
	
	public D toDto(E e);
	
	public E toEntity(D d);
	
}
