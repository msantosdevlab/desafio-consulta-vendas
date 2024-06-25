
# Desafio Consulta Vendas
Este projeto fez parte do módulo "JPA, consultas SQL e JPQL" do curso "Java Spring Professional" da DevSuperior. O objetivo é implementar consultas em um sistema de vendas.

## Descrição do Sistema
O sistema gerencia vendas (Sale) e vendedores (Seller). Cada venda está associada a um vendedor, e um vendedor pode ter várias vendas.

## Funcionalidades Implementadas

### Relatório de Vendas
1. **Entrada (IN):**
   - Data inicial (opcional)
   - Data final (opcional)
   - Trecho do nome do vendedor (opcional)

2. **Saída (OUT):**
   - Uma listagem paginada contendo id, data, quantia vendida e nome do vendedor das vendas que se enquadrem nos dados informados.

### Sumário de Vendas por Vendedor
1. **Entrada (IN):**
   - Data inicial (opcional)
   - Data final (opcional)

2. **Saída (OUT):**
   - Uma listagem contendo nome do vendedor e soma de vendas deste vendedor no período informado.


## Desenvolvimento

### Tecnologias Utilizadas
- **Java:** Linguagem de programação utilizada para o desenvolvimento do projeto.
- **Spring Boot:** Framework que simplifica a criação de aplicações stand-alone, production-grade em Spring.
- **JPA:** Java Persistence API, utilizado para a persistência de dados.
- **SQL e JPQL:** Linguagens de consulta utilizadas para interagir com o banco de dados.

### Passos do Desenvolvimento
1. **Configuração do Projeto:**
   - Clonagem do repositório base.
   - Configuração do ambiente de desenvolvimento (IDE e banco de dados).

2. **Criação dos Models:**
   - Definição das entidades `Sale` e `Seller` com seus respectivos atributos e mapeamentos JPA.

3. **Desenvolvimento dos Repositórios:**
   - Criação dos repositórios `SaleRepository` e `SellerRepository` para interação com o banco de dados.

4. **Implementação dos Serviços:**
   - Desenvolvimento dos serviços para processamento das regras de negócio e consultas personalizadas.

5. **Criação dos Controladores:**
   - Implementação dos controladores REST para exposição das APIs de consulta.

6. **Tratamento de Datas:**
   - Implementação da lógica para considerar datas padrão (data atual e data de um ano atrás) quando não fornecidas nas consultas.

### Desafios Enfrentados
- **Paginação de Resultados:**
  - Implementação de paginação nas consultas para garantir a eficiência e escalabilidade das respostas.
- **Consulta Dinâmica:**
  - Desenvolvimento de lógica para permitir consultas dinâmicas baseadas nos parâmetros opcionais fornecidos pelo usuário.

### Testes e Validação
- **Testes Manuais com Postman:**
  - Validação das APIs utilizando a collection do Postman fornecida pelo curso.
- **Testes Automatizados:**
  - Implementação de testes automatizados para garantir a integridade das funcionalidades desenvolvidas.

### Como Executar o Projeto
1. Clone o repositório:
   ```sh
   git clone [https://github.com/devsuperior/desafio-consulta-vendas.git](https://github.com/msantosdevlab/desafio-consulta-vendas)
   ```
2. Importe o projeto na sua IDE.
3. Configure o banco de dados conforme as instruções do projeto.
4. Execute o projeto.

### Exemplos de Requisições
1. **Sumário de Vendas por Vendedor (Teste 1):**
   - `GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30`
   - Exemplo de retorno:
     ```json
     [
         {
             "sellerName": "Anakin",
             "total": 110571.0
         },
         {
             "sellerName": "Logan",
             "total": 83587.0
         },
         {
             "sellerName": "Loki Odinson",
             "total": 150597.0
         },
         {
             "sellerName": "Padme",
             "total": 135902.0
         },
         {
             "sellerName": "Thor Odinson",
             "total": 144896.0
         }
     ]
     ```

2. **Relatório de Vendas (Teste 2):**
   - `GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson`
   - Exemplo de retorno:
     ```json
     {
         "content": [
             {
                 "id": 9,
                 "date": "2022-05-22",
                 "amount": 19476.0,
                 "sellerName": "Loki Odinson"
             },
             {
                 "id": 10,
                 "date": "2022-05-18",
                 "amount": 20530.0,
                 "sellerName": "Thor Odinson"
             },
             {
                 "id": 12,
                 "date": "2022-05-06",
                 "amount": 21753.0,
                 "sellerName": "Loki Odinson"
             }
         ]
     }
     ```

## Autor
Este desafio foi desenvolvido como parte do curso "Java Spring Professional" da [DevSuperior](https://devsuperior.com.br).
