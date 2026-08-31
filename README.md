# Gerenciador de filmes

Este projeto surgiu na disciplina de java básico da faculdade, mas foi evoluindo conforme eu ia buscando aprender mais, ```ele tem intuito de 100% aprendizado``` e testes do que foi aprendido, ele traz diversas regras de POO em Java, além de uma tentativa de aprender a organizar as arquiteturas de pasta, camadas e classes do projeto.

Atualmente ele está dividido em ```controllers | enums | exceptions | interfaces | model | repositories | services``` e para visualização foi utilizada a biblioteca ```JOptionPane``` do ```javax.swing```.

> **Este projeto representa um pouco da minha evolução no aprendizado de Java e na construção de aplicações apenas com a linguagem base, sem uso de frameworks externos.**

---

## Sobre o projeto

**MovieCRUD** é uma aplicação de gerenciamento de filmes desenvolvida apenas em Java com foco em praticar operações simples de CRUD, porém conforme fui estudando quis usar ele como projeto base para aplicar o que eu ia aprendendo, como:

- Programação Orientada a Objetos (POO)
- Herança e polimorfismo
- Interfaces
- Collections
- `Generics`
- `Stream API`
- `Expressões Lambda`
- `Optional`
- Tratamento de exceções
- `JOptionPane`
- Enums
- `LocalDate` e `LocalDateTime`
- `Organização em camadas`
- Separação de responsabilidades
- `Repositórios em memória`
- Autenticação
- Controle de permissões

Não sei muito bem se consegui pontuar tudo que fui aprendendo de adicionando ao projeto em específico (algumas coisas estudadas não faziam sentido estar adicionando, então foram evitadas), porém o que tenho certeza é do quanto foi enriquecedor para mim fazer isso, e sinto que ainda tenho muito a melhorar e aprender cada vez mais.

---

## Objetivo

O principal objetivo deste projeto foi ```aprender e consolidar conceitos de Java na prática```. Ao invés de criar diversos projetos pequenos para cada novo conceito aprendido, optei por voltar ao mesmo projeto e tentar melhorar sua implementação, até pude notar pela primeira vez na prática como uma aplicação pode evoluir de algo simples para uma estrutura mais organizada conforme novos conhecimentos são adquiridos.

---

## Funcionalidades

### Usuários

- Cadastro de usuários
- Consulta de usuários
- Atualização de usuários
- Exclusão de usuários
- Busca de usuário por ID
- Busca por e-mail
- Autenticação por e-mail e senha
- Diferenciação entre tipos de usuário

### Administrador

- Acesso a funcionalidades administrativas
- Gerenciamento de usuários
- Gerenciamento de filmes
- Gerenciamento de chamados
- Controle de permissões

### Filmes

- Cadastro de filmes
- Listagem de filmes
- Busca por título
- Atualização de filmes
- Exclusão de filmes
- Controle de disponibilidade
- Controle de status do filme

### Empréstimos

- Empréstimo de filmes
- Devolução de filmes
- Controle de data do empréstimo
- Controle do prazo de devolução
- Consulta de empréstimos por usuário
- Controle de filmes disponíveis e emprestados

### Sistema de suporte

Os chamados possuem:

- Tipo
- Prioridade
- Status
- Solicitante
- Assunto
- Descrição
- Data de abertura
- Data de fechamento

Também é possível alterar o estado do chamado:

```text
OPEN → IN PROGRESS → RESOLVED → CLOSED
```

---

# Persistência

Atualmente o projeto ```não utiliza banco de dados```. Isso significa que os dados são perdidos quando a aplicação é encerrada, os dados são armazenados em memória utilizando estruturas como:

```java
ConcurrentHashMap<Long, Movie>
```

Como evoluções futuras planejo realizar algumas dessas:

- [ ] Persistência com banco de dados com PostgreSQL
- [ ] JPA/Hibernate
- [ ] Migração para Spring Boot
- [ ] API REST
- [ ] Testes unitários com JUnit
- [ ] Mockito
- [ ] Validação de dados
- [ ] Hash de senhas
- [ ] Logs
- [ ] Interface gráfica mais elaborada
- [ ] Documentação da API
- [ ] Docker
- [ ] CI/CD

Até o momento tenho uma aplicação como projeto que utiliza de boa parte dessas funcionalidades que eu talvez implementaria aqui, então por uma parte não vejo muito sentindo em adicioná-los nesse projeto de MovieCRUD, já que a intenção aqui foi focar apenas no básico, porém alguns dessas funções poderiam sim ser aplicadas a ele.
---

# Execução

## Pré-requisitos

Antes de executar o projeto, tenha instalado:

- **Java JDK 17 ou superior**
- Alguma IDE, como:
  - IntelliJ IDEA
  - Eclipse
  - VS Code

---

## Clonar o projeto

```bash
git clone https://github.com/kauabrandon/MovieCRUD.git
```

Entre na pasta:

```bash
cd MovieCRUD
```

---

## Executar

Abra o projeto na IDE e execute a classe:

```text
Main.java
```

Localizada em:

```text
src/unifacisa/project/library/controllers/Main.java
```

---

# Usuário administrador para testes

```text
E-mail: kaua@adm.com
Senha: admin
```

> Essas credenciais existem apenas para fins de desenvolvimento e demonstração.

---

## Sobre este projeto

Eu gostaria de ter feito os commits desde o inicio da aplicação, acabei negligenciando isso e o processo de evolução não pôde ser documentado parte por parte, porém o que vale é o conhecimento adquirido e daqui para frente estarei sempre documentando em outros projetos por aqui.

Projeto com foco apenas em aprendizado.

## Observação

O projeto está em inglês por nenhum motivo específico, apenas quis construir algo em inglês dessa vez para se tornar parte da prática.
