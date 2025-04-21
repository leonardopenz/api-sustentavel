# 🌱 API de Ações Sustentáveis

Uma API REST desenvolvida com **Spring Boot** para cadastrar, consultar, atualizar e remover ações sustentáveis promovidas por **pessoas físicas**, **ONGs** ou **empresas**. As ações podem ser doações, mutirões, reciclagens, plantio de árvores, entre outras iniciativas voltadas à sustentabilidade.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Bean Validation (Jakarta)
- ModelMapper
- H2 / PostgreSQL (configurável)
- Git (controle de versão)

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



## 🔗 Exemplos de Endpoints

- `GET /acoes` – Lista todas as ações
- `GET /acoes/{id}` – Busca ação por ID
- `GET /acoes/categoria?tipo=PLANTIO` – Filtra ações por categoria
- `POST /acoes` – Cria uma nova ação
- `PUT /acoes/{id}` – Atualiza uma ação existente
- `DELETE /acoes/{id}` – Remove uma ação

---

## ✨ Contribuições

Contribuições são bem-vindas!  
Se você tiver sugestões de melhorias, encontrar bugs ou quiser adicionar novos recursos, fique à vontade para abrir uma *issue* ou enviar um *pull request*.

1. Fork o projeto
2. Crie uma branch para sua feature: `git checkout -b minha-feature`
3. Faça o commit das suas alterações: `git commit -m 'feat: minha nova feature'`
4. Faça o push para a sua branch: `git push origin minha-feature`
5. Abra um Pull Request

---

## 👤 Autor

**Leonardo Penz**  
📧 leonardopenz.ti@gmail.com  
🔗 [GitHub](https://github.com/leonardopenz)  
🔗 [LinkedIn](https://www.linkedin.com/in/leonardo-penz/)
