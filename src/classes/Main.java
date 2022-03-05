package classes;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Brasil", "Santa Catarina", "JaraguÃ¡ do Sul", "Centro", " Rua das Flores", "", 1780, 4560981, "Jubiscreide Cordeiro de Aparecida", "123.456.789-10", "jubis.CreideDah.Sirva@hormail.com", "(47) 98437-8896", "Femenino", 48, 1, "jubislaine");
        Gerente.listaGerentes.add(gerente);
        //Funcionario funcionario = new Funcionario("Brasil", "Santa Catarina", "JaraguÃ¡ do Sul", "Jardim SÃ£o Luis", "Adavilson Nunes Teixira", "Perto da loja do seu ZÃ©", 590, 87612345, "Rodrigo Lopes dos Santos", "098.765.432-10");
        //Funcionario.listaFuncionarios.add(funcionario);
        // Cliente cliente = new Cliente();
        // Cliente.listaCLientes.add(cliente);
        login();
    }

    private static void login() {
        System.out.println("----- CADASTRO ----- \nQual seu nÃºmero de matrÃ­cula? \nDigite 0 para encerrar o programa");
        int numero = sc.nextInt();

        if (numero == 0) {
            System.exit(0);
        } else {

            boolean checar = Funcionario.listaFuncionarios.get(0).checarFuncionario(numero);


            if (checar) {
                menuOperacoes();
            } else {
                System.out.println("NÃºmero de matrÃ­cula invÃ¡lido");
                login();
            }
        }
    }


    private static void menuOperacoes() {

        System.out.println("----- MENU OPERAÃ‡Ã•ES ----- \n1 - Cadastrar cliente \n2 - Checar itens no estoque \n3 - Cadastrar produto \n4 - Voltar");
        int opcao = sc.nextInt();

        if (opcao < 1 || opcao > 4) {
            menuOperacoes();
        } else {
            switch (opcao) {
                case 1:
                    interfaceCadastro();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }
    }

    private static void interfaceCadastro() {
        String nome, cpf, email, telefone, genero, pais, estado, cidade, bairro, rua, complemento = "";
        int idade, numeroCadastro, numero, cep;
        System.out.println("Nome do cliente: ");
        nome = sc.next();

        System.out.println("CPF: ");
        cpf = sc.next();

        System.out.println("Idade: ");
        idade = sc.nextInt();

        System.out.println("Email: ");
        email = sc.next();

        System.out.println("Telefone: ");
        telefone = sc.next();

        System.out.println("GÃªnero: ");
        genero = sc.next();

        System.out.println("EndereÃ§o: \nPaÃ­s:");
        pais = sc.next();

        System.out.println("Estado: ");
        estado = sc.next();

        System.out.println("Cidade: ");
        cidade = sc.next();

        System.out.println("Bairro: ");
        bairro = sc.next();

        System.out.println("Rua: ");
        rua = sc.next();

        System.out.println("CEP: ");
        cep = sc.nextInt();

        System.out.println("Numero da casa: ");
        numero = sc.nextInt();

        System.out.println("Complemento (se tiver):");
        complemento = sc.next();

        numeroCadastro = Cliente.listaCLientes.size() + 1;

        Cliente cliente = new Cliente(pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade, numeroCadastro);
        Cliente.listaCLientes.add(cliente);

        System.out.println("Cadastro executado com sucesso!");

        menuOperacoes();
    }

}
