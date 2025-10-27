package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public abstract class Persona {
    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 1, message = "DNI inválido")
    protected Integer dni;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$", message = "El nombre sólo puede contener letras y espacios")
    @Size(max = 100, message = "El nombre es demasiado largo")
    protected String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$", message = "El apellido sólo puede contener letras y espacios")
    @Size(max = 100, message = "El apellido es demasiado largo")
    protected String apellido;

    @Email(message = "Email con formato inválido")
    @Size(max = 200, message = "El email es demasiado largo")
    protected String email;

    @Pattern(regexp = "^[0-9+()\\-\\s]{6,20}$", message = "Teléfono con formato inválido")
    protected String telefono;

    // Fecha en formato ISO dd-MM-yyyy
    @Pattern(regexp = "^$|^\\d{2}-\\d{2}-\\d{4}$", message = "Fecha debe tener formato dd-MM-yyyy")
    protected String fechaNacimiento;

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
