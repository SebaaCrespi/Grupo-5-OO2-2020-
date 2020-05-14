package com.objetosdos.spring.controllers;

import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.EmpleadoModel;
import com.objetosdos.spring.models.GerenteModel;
import com.objetosdos.spring.services.IEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    private IEmpleadoService empleadoService;
    
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
        return mAV;
    }
    /*@GetMapping("/new")
    public ModelAndView newEmpleado(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_NEW);
        mAV.addObject("empleado", new EmpleadoModel());
        return mAV;
    }
    @PostMapping("/create")
    public RedirectView createEmpleado(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
        empleadoService.insertOrUpdate(empleadoModel);
		return new RedirectView(ViewRouteHelper.EMPLEADO_ROOT);
    }*/
}