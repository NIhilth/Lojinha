package classes;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Brasil", "Santa Catarina", "Jaraguá do Sul", "Centro", " Rua das Flores", "", 1780, 4560981, "Jubiscreide Cordeiro de Aparecida", "123.456.789-10", "jubis.CreideDah.Sirva@hormail.com", "(47) 98437-8896", "Feminino", 48, 1, "jubislaine");
        Gerente.listaGerentes.add(gerente);
        Funcionario.listaFuncionarios.add(gerente);
        Funcionario funcionario = new Funcionario("Brasil", "Santa Catarina", "Jaraguá do Sul", "Jardim São Luis", "Rua Adavilson Nunes Teixira", "Perto da loja do seu Zé", 590, 8761234, "Rodrigo Lopes dos Santos", "098.765.432-10", "rodrigowlontra@gmail.com", "(47) 91234-5678", "Masculino", 27, 2, "liroliroliro");
        Funcionario funcionario2 = new Funcionario("Brasil", "Santa Catarina", "Jaraguá do Sul", "Jardim São Luis", "Rua Afonso Mendes", "Quarto andar número 402", 102, 1352467, "Jamiro Augusto da Rocha", "976.019.896-34", "jairoAugust.rock@gmail.com", "(47) 98405-1029", "Masculino", 39, 3, "jamirotroxa");
        Funcionario.listaFuncionarios.add(funcionario);
        Funcionario.listaFuncionarios.add(funcionario2);
        Cliente cliente = new Cliente("Brasil", "Santa Catarina", "Jaraguá do Sul", "Jaraguá 99", "Rua Francisco Schmidt", null, 1100, 6783459, "Fernanda Baumgarden", "876.543.210-90", "fernandoBaumgarden@gmail.com", "(47) 90876-1167", "Feminino", 23, 1);
        Cliente.listaCLientes.add(cliente);
        Produto produto = new Produto("Ao leite", "Barra de chocolate", "Nestle", "Garoto: Chocolate ao Leite", 7.95, 1,100);
        Produto produto2 = new Produto("Saco de 10Kg", "Ração pra cachorro", "Pedegree", "Pedegree premium: sabor carne", 47.99,2, 50);
        Produto.listaProdutos.add(produto);
        Produto.listaProdutos.add(produto2);
        login();
    }

    private static void login() {
        System.out.println("----- CADASTRO ----- \nQual seu número de matrícula? \nDigite 0 para encerrar o programa");
        int numero = sc.nextInt();

        if (numero == 0) {
            System.exit(0);
        } else {
            System.out.println("Qual a sua senha?");
            String senha = sc.next();

            boolean checar = Funcionario.listaFuncionarios.get(0).checarFuncionario(numero, senha);

            if (checar) {
                Funcionario funcionario = Funcionario.listaFuncionarios.get(numero - 1);
                checar = funcionario instanceof Gerente;
                menuOperacoes(checar);
            } else {
                System.out.println("Número de matrícula ou Senha inválidos");
                login();
            }
        }
    }

    private static void menuOperacoes(boolean cargo) {

        System.out.println("----- MENU OPERAÇÕES ----- \n1 - Cadastrar cliente \n2 - Checar itens no estoque \n3 - Cadastrar produto \n4 - Vender \n5 - Comprar");

        if(cargo){
            System.out.println("6 - Cadastrar funcionário \n7 - Voltar");
        } else {
            System.out.println("6 - Voltar");
        }
        int opcao = sc.nextInt();

        if (opcao < 1 || opcao > 7) {
            System.out.println("Opção Inválida");
            menuOperacoes(cargo);
        } else {
            switch (opcao) {
                case 1:
                    interfaceCadastro(cargo, 1);
                    break;
                case 2:
                    checarProdutos(cargo);
                    break;
                case 3:
                    interfaceCadastroProduto(cargo);
                    break;
                case 4:
                    interfaceVender(cargo, 1);
                    break;
                case 5:
                    interfaceVender(cargo, 0);
                    break;
                case 6:
                    if(cargo){
                        interfaceCadastro(true, 0);
                    } else {
                        login();
                    }
                    break;
                case 7:
                    if(cargo){
                        login();
                    } else {
                        System.out.println("Opção Inválida");
                        menuOperacoes(true);
                    }
                    break;
            }
        }

    }

    private static void interfaceVender(boolean cargo, int opcao) {
        System.out.println("Qual o produto a ser " + ((opcao == 1)? "vendido": "comprado") +  " (Digite seu código)? \nDigite 0 para voltar");

        int numero = sc.nextInt();

        if(numero == 0){
            menuOperacoes(cargo);
        } else {
            boolean checar = Produto.listaProdutos.get(0).verProduto(numero);
            if(checar){

                System.out.println("Quantos serão " + ((opcao == 1)? " vendidos": "comprados") + "?");

                int quantidade = sc.nextInt();
                double preco = Produto.listaProdutos.get(numero - 1).getValor() * quantidade;
                Produto.listaProdutos.get(0).vender(numero, quantidade);
                int quantidadeNova = Produto.listaProdutos.get(numero - 1).getQuantidade();
                System.out.println(((opcao == 1)? "Venda": "Compra") +" completa! \nValor da venda: " + preco + "\nQuantidade do produto " + numero + " no estoque: " + quantidadeNova);
                menuOperacoes(cargo);
            } else {
                System.out.println("Código inválido!");
                interfaceVender(cargo, opcao);
            }
        }
    }

    private static void interfaceCadastroProduto(boolean cargo) {
         String modelo, descricao , marca , nome;
         double valor;
         int codigo, quantidade;

        System.out.println("Nome: ");
        nome = sc.next();

        System.out.println("Marca: ");
        marca = sc.next();

        System.out.println("Valor: ");
        valor = sc.nextDouble();

        System.out.println("Modelo: ");
        modelo = sc.next();

        System.out.println("Descrição: ");
        descricao = sc.next();

        System.out.println("Quantidade: ");
        quantidade = sc.nextInt();

        codigo = Produto.listaProdutos.size() + 1;

        Produto produto = new Produto( modelo, descricao, marca, nome, valor, codigo, quantidade);
        Produto.listaProdutos.add(produto);

        System.out.println("Cadastro executado com sucesso!");

        menuOperacoes(cargo);
    }

    private static void checarProdutos(boolean cargo) {
        String tudo = Produto.listaProdutos.get(0).mostrarTodos();

        System.out.println(tudo);

        menuOperacoes(cargo);
    }

    private static void interfaceCadastro(boolean cargo, int number) {
        String nome, cpf, email, telefone, genero, pais, estado, cidade, bairro, rua, complemento;
        int idade, numero, cep, escolha = 0;

        if(number == 0){
            System.out.println("Irá cadastrar um gerente? \n1 - Sim \n2 - Não");
            escolha = sc.nextInt();
        }

        System.out.println("Nome: ");
        nome = sc.next();

        System.out.println("CPF: ");
        cpf = sc.next();

        System.out.println("Idade: ");
        idade = sc.nextInt();

        System.out.println("Email: ");
        email = sc.next();

        System.out.println("Telefone: ");
        telefone = sc.next();

        System.out.println("Gênero: ");
        genero = sc.next();

        System.out.println("Endereço \nPaís:");
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

        System.out.println("Número da casa: ");
        numero = sc.nextInt();

        System.out.println("Complemento (se tiver):");
        complemento = sc.next();

        if(number == 1 ){
            int numeroCadastro = Cliente.listaCLientes.size() + 1;

            Cliente cliente = new Cliente(pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade, numeroCadastro);
            Cliente.listaCLientes.add(cliente);
        } else if(number == 0){
            System.out.println("Senha");
            String senha = sc.next();
            int matricula = Funcionario.listaFuncionarios.size() + 1;

            if(escolha == 1){
                Gerente gerente = new Gerente( pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade, matricula , senha);
                Funcionario.listaFuncionarios.add(gerente);
            } else if (escolha == 2){
                Funcionario funcionario = new Funcionario( pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade, matricula , senha);
                Funcionario.listaFuncionarios.add(funcionario);
            }
        }

        System.out.println("Cadastro executado com sucesso!");

        menuOperacoes(cargo);
    }

}
