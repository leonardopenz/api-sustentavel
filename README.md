# 🌱 API de Ações Sustentáveis

Uma API REST desenvolvida com **Spring Boot** para cadastrar, consultar, atualizar e remover ações sustentáveis promovidas por **pessoas físicas**, **ONGs** ou **empresas**. As ações podem ser doações, mutirões, reciclagens, plantio de árvores, entre outras iniciativas voltadas à sustentabilidade.

---

## 🚀 Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Bean Validation
- ModelMapper
- PostgreSQL 
- Git 

---

## 📌 Funcionalidades

- ✅ Cadastrar nova ação sustentável
- ✅ Consultar todas as ações cadastradas
- ✅ Consultar ação por ID
- ✅ Filtrar ações por categoria (ex: `/acoes/categoria?tipo=DOACAO`)
- ✅ Atualizar informações de uma ação
- ✅ Remover ação por ID
- ✅ Validação dos dados de entrada
- ✅ Tratamento de exceções com mensagens amigáveis
- ✅ Controle de versão via Git

---

## 🔗 Exemplos de Endpoints

- `GET /acoes` – Lista todas as ações
- `GET /acoes/{id}` – Busca ação por ID
- `GET /acoes/categoria?tipo=PLANTIO` – Filtra ações por categoria
- `POST /acoes` – Cria uma nova ação
- `PUT /acoes/{id}` – Atualiza uma ação existente
- `DELETE /acoes/{id}` – Remove uma ação

---

## 👤 Autor

**Leonardo Penz**  
📧 leonardopenz.ti@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/leonardo-penz/)
