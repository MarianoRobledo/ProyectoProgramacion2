package com.uncuyo.biblioteca.abm;

import com.uncuyo.biblioteca.model.Editorial;
import java.util.List;

public interface IABMEditorial {
    Editorial agregarEditorial(Editorial e);
    Editorial modificarEditorial(Editorial e);
    void eliminarEditorial(Long id);
    List<Editorial> consultarEditoriales();
}
