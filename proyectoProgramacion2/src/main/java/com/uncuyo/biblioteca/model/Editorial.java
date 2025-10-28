package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Editorial {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 200, message = "El nombre es demasiado largo")
    private String nombre;

    @Size(max = 100, message = "País demasiado largo")
    private String pais;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 300, message = "Dirección demasiado larga")
    private String direccion;

    @Pattern(regexp = "^[0-9+()\\-\\s]{6,20}$", message = "Teléfono con formato inválido")
    private String telefono;

    @Email(message = "Email con formato inválido")
    @Size(max = 200, message = "El email es demasiado largo")
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
