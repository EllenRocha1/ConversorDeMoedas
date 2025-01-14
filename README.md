# Conversor de Moedas :moneybag:

Este é um projeto simples em Java que realiza conversões de moedas utilizando a API Exchange Rate. A aplicação permite que os usuários escolham entre diferentes pares de moedas para converter valores.
O projeto foi concebido para conclusão de um dos Challenges do programa OracleOne em parceria com a Alura.

## Funcionalidades

Conversão de moedas em tempo real utilizando dados da API Exchange Rate.

Menu interativo com as seguintes opções de conversão:

1. USD para EUR

2. EUR para GBP

3. USD para BRL

4. BRL para EUR

5. BRL para GBP

6. Sair 

## Estrutura do Projeto :package:

O projeto está organizado nos seguintes pacotes:

1. main

`Main.java:` Ponto de entrada da aplicação. Inicializa a interface do usuário.

2. api

`ExchangeRateClient.java:` Classe responsável por consumir a API Exchange Rate e obter a taxa de conversão entre duas moedas.

3. service

`CurrencyConverterService.java:` Contém a lógica de negócio para realizar a conversão de moedas usando a taxa fornecida pela API.

4. ui

`CurrencyConverterUI.java:` Interface de interação com o usuário, que exibe o menu e processa as entradas do usuário.

## Tecnologias Utilizadas :hammer_and_wrench:

**Java:** Linguagem principal do projeto.

**HTTP Client:** Para realizar requisições à API.

**Gson:** Biblioteca para manipulação de JSON.

**Dotenv:** Para carregar variáveis de ambiente a partir de um arquivo .env (utilizado para armazenar a chave da API).

## Configuração e Execução :wrench:

1. Clone o repositório:

`git clone https://github.com/seu-usuario/conversor-de-moedas.git`
`cd conversor-de-moedas`

2. Adicione a chave da API no arquivo .env

Crie um arquivo .env na raiz do projeto com o seguinte conteúdo:

`API_KEY=SUA_CHAVE_DA_API`

Substitua SUA_CHAVE_DA_API pela sua chave da API Exchange Rate.

3. Compile e execute o projeto:

Compile:

`javac -d out -cp "lib/*" src/**/*.java`

Execute:

`java -cp "out:lib/*" main.Main`

## Exemplo de Uso

Ao executar a aplicação, você verá o seguinte menu:

**=== Conversor de Moedas ===**
1. USD para EUR
2. EUR para GBP
3. USD para BRL
4. BRL para EUR
5. BRL para GBP
6. EUR para USD
7. Sair
Escolha uma opção:

Após escolher uma opção e inserir o valor, a aplicação exibirá a conversão com base na taxa mais recente fornecida pela API.

# Dependências :clipboard:

As seguintes bibliotecas são utilizadas no projeto:

- Gson: Para manipulação de JSON.

- dotenv-java: Para carregar variáveis de ambiente do arquivo .env.

## Adicionando as dependências

Certifique-se de que as dependências estão no diretório lib/ ou configuradas no seu gerenciador de dependências (como Maven ou Gradle).

## Melhorias Futuras :bulb:

- [ ] Adicionar suporte a mais pares de moedas.

- [ ] Criar interface gráfica.

- [ ] Cache de taxas de câmbio para reduzir o número de requisições à API.

# Licença :memo:

Este projeto está licenciado sob a MIT License.

