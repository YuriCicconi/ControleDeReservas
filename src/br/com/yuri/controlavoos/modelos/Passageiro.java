package br.com.yuri.controlavoos.modelos;

import java.util.ArrayList;
import java.util.List;

public class Passageiro{
    private List<Voo> reservas;
    private String nome;
    private String cpf;

    public Passageiro(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.reservas = new ArrayList<>();
    }

    public void reservarVoo(Voo voo) {
        if (voo.getAssentosLivres() > 0) {
            this.reservas.add(voo);
            voo.ocuparAssento();
        } else {
            System.out.println("Esse voo não possui mais assentos livres.");
        }

    }

    public List<Voo> getReservas() {
        return new ArrayList<>(reservas);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Passageiro: " + this.getNome() +
                "Reservas: " + this.getReservas();
    }
}
