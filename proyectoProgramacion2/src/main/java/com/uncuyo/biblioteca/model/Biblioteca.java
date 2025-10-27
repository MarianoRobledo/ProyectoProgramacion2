package com.uncuyo.biblioteca.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Biblioteca {
    private Long id;

    @NotBlank(message = "El nombre de la biblioteca es obligatorio")
    @Size(max = 200, message = "Nombre demasiado largo")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 300, message = "Dirección demasiado larga")
    private String direccion;

    @Pattern(regexp = "^[0-9+()\\-\\s]{6,20}$", message = "Teléfono con formato inválido")
    private String telefono;

    @Email(message = "Email con formato inválido")
    @Size(max = 200, message = "Email demasiado largo")
    private String email;

    @Min(value = 1, message = "Administrador inválido")
    private Long administradorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getAdministradorId() { return administradorId; }
    public void setAdministradorId(Long administradorId) { this.administradorId = administradorId; }
}
