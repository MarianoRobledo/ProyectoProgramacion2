package com.uncuyo.biblioteca.model;

public class Cliente extends Persona {
    private Long id;
    private Long personaId;
    private Integer legajo;
    private Integer reservedBooks = 0;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPersonaId() { return personaId; }
    public void setPersonaId(Long personaId) { this.personaId = personaId; }
    public Integer getLegajo() { return legajo; }
    public void setLegajo(Integer legajo) { this.legajo = legajo; }
    public Integer getReservedBooks() { return reservedBooks; }
    public void setReservedBooks(Integer reservedBooks) { this.reservedBooks = reservedBooks; }
}
