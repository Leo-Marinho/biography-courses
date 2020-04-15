#language:pt

  Funcionalidade: Curso

    Cenario: Buscar um curso

      Dado que exista um curso
      Quando realizar a busca pelo curso
      Então deve retornar o curso cadastrado

    Cenario: Cadastrar um curso

      Dado  que tenha um novo curso
      Quando cadastrar um novo curso
      Então deve retornar o curso criado

    Cenario: Deletar um curso

      Dado que remova um curso existente
      Quando listar todos os cursos
      Entao o tamanho da lista de cursos deve estar correto

    Cenario: Atualizar um curso

      Dado que atualize um curso existente
      Quando listar o curso atualizado
      Entao o curso deve conter novos valores