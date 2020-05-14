package com.objetosdos.spring.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.repositories.IDireccionRepository;
import com.objetosdos.spring.services.IDireccionService;

@Service
public class DireccionService implements IDireccionService {

	
@Autowired
private IDireccionRepository direccionRepository;	
	
}
