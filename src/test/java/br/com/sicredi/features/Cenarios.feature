Feature:
  Validações base de CEP:
        https://viacep.com.br/ws/91060900/json/

   Scenario: Consulta CEP valido
      Given usuário insere um CEP válido
      When serviço é consultado
      Then é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge.

  Scenario: Consulta CEP inexistente
    Given usuário insere um CEP que não exista na base dos Correios
    When serviço é consultado cenario dois
    Then é retornada um atributo erro.

  Scenario: Consulta CEP com formato inválido
    Given usuário insere um CEP com formato inválido
    When serviço é consultado cenario tres
    Then retornado uma mensagem de erro

  Scenario: Consulta CEP por parte do nome do logradouro
    Given usuário insere nome da cidade e parte do nome do logradouro
    When serviço é consultado quatro
    Then retornado os CEPs com nome da logradouro
