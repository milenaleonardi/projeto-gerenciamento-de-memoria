package br.edu.up.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.entidades.Armazenamento;

public class ArmazenamentoPersistencia {

    static List<Armazenamento> objetos = new ArrayList<Armazenamento>();

    public static void incluir(Armazenamento armazenamento) {
        objetos.add(armazenamento);
    }

    public static Armazenamento procurar(Armazenamento armazenamento) {
        for(Armazenamento item: objetos) {
            if(item.getDispositivo().equals(armazenamento.getDispositivo())) {
                return item;
            }
        } return null;
    }

    public static void atualizar(Armazenamento armazenamento) {
        int i = 0;
        for(Armazenamento item: objetos) {
            if(item.getDispositivo().equals(armazenamento.getDispositivo())) {
                objetos.set(i, armazenamento);
            } i++;
        }
    }

}
