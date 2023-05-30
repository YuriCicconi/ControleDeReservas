package br.com.yuri.controlavoos.teste;

import br.com.yuri.controlavoos.modelos.Passageiro;
import br.com.yuri.controlavoos.modelos.Sistema;
import br.com.yuri.controlavoos.modelos.Voo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        boolean outroMenu = false;


        Sistema sistema = new Sistema();
        Voo v1 = new Voo("111", "São Paulo", "Paris");
        sistema.adicionarVoo(v1);
        Voo v2 = new Voo("222", "Madrid", "Londres");
        sistema.adicionarVoo(v2);
        Voo v3 = new Voo("333", "Rio de Janeiro", "Recife");
        sistema.adicionarVoo(v3);




        String menu = """
                1- Cadastro
                2- Sair
                """;


        System.out.println(menu);

        while (!sair) {
            System.out.println("Selecione a opção desejada: ");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Informe o nome do passageiro: ");
                    String nome = sc.next();

                    System.out.println("Informe o CPF do passageiro: ");
                    String cpf = sc.next();

                    Passageiro novoPasageiro = new Passageiro(nome, cpf);

                    sistema.adicionarPassageiro(novoPasageiro);

                    sair = true;
                    outroMenu = true;
                }
                case 2 -> sair = true;
            }
        }

        menu = """
                1- Cadastrar novo usuário
                2- Verificar voos disponíveis
                3- Reservar voo
                4- Consultar reservas
                5- Sair
                """;


        while (outroMenu) {
            System.out.println(menu);
            System.out.println("Selecione a opção desejada: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Informe o nome do passageiro: ");
                    String nome = sc.next();

                    System.out.println("Informe o CPF do passageiro: ");
                    String cpf = sc.next();

                    Passageiro novoPasageiro = new Passageiro(nome, cpf);
                    sistema.adicionarPassageiro(novoPasageiro);
                }
                case 2 -> System.out.println(sistema.exibirVoosDisponiveis());
                case 3 -> {
                    System.out.println("Informe o nome do passageiro: ");
                    String nome = sc.next();

                    System.out.println("Informe o cpf do passageiro: ");
                    String cpf = sc.next();

                    System.out.println("Informe o voo que deseja reservar: ");
                    String numeroVoo = sc.next();

                    for (Passageiro passageiro : sistema.getPassageiros()) {
                        if (passageiro.getCpf().equals(cpf)) {
                            for (Voo voo : sistema.getVoos()) {
                                if (voo.getNumeroDoVoo().equals(numeroVoo)) {
                                    passageiro.reservarVoo(voo);
                                }
                            }
                        } else {
                            Passageiro novoPassageiro = new Passageiro(nome, cpf);
                            sistema.adicionarPassageiro(novoPassageiro);

                            for (Voo voo : sistema.getVoos()) {
                                if (voo.getNumeroDoVoo().equals(numeroVoo)) {
                                    novoPassageiro.reservarVoo(voo);
                                }
                            }
                        }
                    }

                }
                case 4 -> {
                    System.out.println("Informe o cpf do passageiro: ");
                    String cpf = sc.next();
                    for (Passageiro passageiro : sistema.getPassageiros()) {
                        if (passageiro.getCpf().equals(cpf)) {
                            System.out.println(passageiro.getReservas());
                        }
                    }
                }
                case 5 -> outroMenu = false;
            }
        }

        System.out.println(sistema.getPassageiros().get(0).getReservas());

    }
}