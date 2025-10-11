package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Administrador;
import java.util.List;

public interface IABMAdministrador {
    Administrador agregarAdministrador(Administrador a);
    Administrador modificarAdministrador(Administrador a);
    void eliminarAdministrador(Long id);
    List<Administrador> consultarAdministradores();
}
