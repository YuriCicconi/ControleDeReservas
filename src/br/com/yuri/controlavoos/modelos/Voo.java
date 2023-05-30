package br.com.yuri.controlavoos.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Voo{
    private String numeroDoVoo;
    private String origem;
    private String destino;
    private int assentosLivres;

    double x = Math.random() * 150;
    int random = (int) x;

    public Voo(String numeroDoVoo, String origem, String destino) {
        this.numeroDoVoo = numeroDoVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosLivres = random;
    }

    public String getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }


    public int getAssentosLivres() {
        return assentosLivres;
    }

    protected void ocuparAssento() {
        this.assentosLivres--;

    }

    public String consultarDisponibilidade(Voo v) {
        if (v.assentosLivres > 0) {
            return "Temos " + assentosLivres + " assentos disponíveis";
        }

        return "Não há mais nenhum assento disponível";
    }

    @Override
    public String toString() {
        return "Voo: " + this.getNumeroDoVoo() + " | " +
                "Origem: " + this.getOrigem() + " | " +
                "Destino: " + this.getDestino() + " | " +
                "Assentos livres: " + this.getAssentosLivres() + " | ";
    }
}
