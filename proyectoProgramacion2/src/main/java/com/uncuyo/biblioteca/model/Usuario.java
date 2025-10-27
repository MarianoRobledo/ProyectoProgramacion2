package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.Min;

public class Usuario extends Persona {
    
    @Min(value = 0, message = "Legajo inválido")
    protected int legajo;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    
}
