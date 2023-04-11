package br.edu.up.entidades;

public class Armazenamento {
    private String dispositivo;
    private Double memoria;
    private Double ocupado;

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Double getMemoria() {
        return memoria;
    }

    public void setMemoria(Double memoria) {
        this.memoria = memoria;
    }

    public Double getOcupado() {
        return ocupado;
    }

    public void setOcupado(Double ocupado) {
        this.ocupado = ocupado;
    }
}