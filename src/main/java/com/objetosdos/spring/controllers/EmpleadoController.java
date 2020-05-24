package com.objetosdos.spring.controllers;

import com.objetosdos.spring.helper.ViewRouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
        mAV.addObject("return", ViewRouteHelper.ROUTE);
        return mAV;
    }
}