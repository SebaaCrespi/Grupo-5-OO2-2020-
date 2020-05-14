package com.objetosdos.spring.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.repositories.ISucursalRepository;
import com.objetosdos.spring.services.ISucursalService;


@Service
public class SucursalService implements ISucursalService{
	
	@Autowired
	private ISucursalRepository sucursalRepository;

}
