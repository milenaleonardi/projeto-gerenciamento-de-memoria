package br.edu.up.front;

import br.edu.up.entidades.Armazenamento;
import br.edu.up.negocio.ArmazenamentoNegocio;
import br.edu.up.persistencia.ArmazenamentoPersistencia;

public class Principal {
    public static void main(String[] args) {
        Armazenamento armazenamento;
        int opcao;
        Double valor;
        String unidade;

        do {
            System.out.println("\n\n1 - Criar objeto de armazenamento");
            System.out.println("2 - Gravar dados");
            System.out.println("3 - Apagar dados");
            System.out.println("4 - Verificar espaço disponível");
            System.out.println("5 - Sair");
            opcao = Console.readInt("Informe a opção: ");

            switch(opcao){
                case 1:
                    armazenamento  = new Armazenamento();
                    armazenamento.setDispositivo(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser criado: "));
                    if(ArmazenamentoPersistencia.procurar(armazenamento) == null) {
                        armazenamento.setMemoria(Console.readDouble("Informe o espaço de armazenamento em GB: "));
                        ArmazenamentoPersistencia.incluir(armazenamento);
                    } else {
                        System.out.println("\n\nObjeto de armazenamento já cadastrado.");
                    }
                    break;
                case 2:
                    armazenamento  = new Armazenamento();
                    armazenamento.setDispositivo(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
                    armazenamento = ArmazenamentoPersistencia.procurar(armazenamento);
                    if(armazenamento != null) {
                        valor = Console.readDouble("Informe o valor a ser gravado no objeto de armazenamento: ");
                        unidade = Console.readString("Ingforme a unidade de medida a ser utilizada na gravação: ");
                        armazenamento = ArmazenamentoNegocio.salvarDados(armazenamento, unidade, valor);
                        if(armazenamento != null) {
                            ArmazenamentoPersistencia.atualizar(armazenamento);
                            System.out.println("\n\nGravação realizada com sucesso.");
                        } else {
                            System.out.println("\n\nSem espaço disponível para gravar o arquivo");
                        }
                    } else {
                        System.out.println("\n\nObjeto de armazenamento não cadastrado.");
                    }
                    break;
                case 3:
                    armazenamento  = new Armazenamento();
                    armazenamento.setDispositivo(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
                    armazenamento = ArmazenamentoPersistencia.procurar(armazenamento);
                    if(armazenamento != null) {
                        valor = Console.readDouble("Informe o valor a ser removido do objeto: ");
                        unidade = Console.readString("Informe a unidade de medida a ser utilizada na remoção: ");
                        armazenamento = ArmazenamentoNegocio.removerDados(armazenamento, unidade, valor);
                        if(armazenamento != null) {
                            ArmazenamentoPersistencia.atualizar(armazenamento);
                            System.out.println("\n\nRemoção realizada.");
                        } else {
                            System.out.println("\n\nO valor informado é maior que o espaço disponível.");
                        }
                    } else {
                        System.out.println("\n\nObjeto de armazenamento não cadastrado.");
                    }
                    break;
                case 4:
                    armazenamento  = new Armazenamento();
                    armazenamento.setDispositivo(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
                    armazenamento = ArmazenamentoPersistencia.procurar(armazenamento);
                    if(armazenamento != null) {
                        System.out.println("Espaço total: " + armazenamento.getMemoria());
                        System.out.println("Espaço ocupado: " + armazenamento.getOcupado());
                    } else {
                        System.out.println("\n\nObjeto de armazenamento não cadastrado.");
                    }
                    break;
            }
        } while(opcao != 5);
    }
}
