package br.com.yuri.controlavoos.modelos;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Passageiro> passageiros;
    private List<Voo> voos;

    public Sistema(List<Passageiro> passageiros, List<Voo> voos) {
        this.passageiros = passageiros;
        this.voos = voos;
    }

    public Sistema() {
        this.passageiros = new ArrayList<>();
        this.voos = new ArrayList<>();
    }


    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public List<Voo> exibirVoosDisponiveis() {
        List<Voo> voosDisponiveis = new ArrayList<>();
        for (Voo voo : voos) {
            if (voo.getAssentosLivres() > 0) {
                voosDisponiveis.add(voo);
            }
        }
        return voosDisponiveis;
    }

    public void adicionarVoo(Voo v) {
        this.voos.add(v);
    }

    public void adicionarPassageiro(Passageiro p) {
        this.passageiros.add(p);
    }

    @Override
    public String toString() {
        return "Passageiros cadastrados: " + this.getPassageiros() + " | " +
                "Voos: " + this.getVoos();
    }
}
