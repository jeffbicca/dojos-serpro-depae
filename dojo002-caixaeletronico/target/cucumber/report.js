$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('br/gov/serpro/dojo002/integration/caixaEletronico.feature');
formatter.feature({
  "id": "caixa-eletrônico",
  "description": "",
  "name": "Caixa Eletrônico",
  "keyword": "Funcionalidade",
  "line": 2,
  "comments": [
    {
      "value": "# language: pt",
      "line": 1
    }
  ]
});
formatter.scenario({
  "id": "caixa-eletrônico;retornar-uma-nota-de-mesmo-valor",
  "description": "",
  "name": "Retornar uma nota de mesmo valor",
  "keyword": "Cenário",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "que informo um valor de saque de 10 reais",
  "keyword": "Dado ",
  "line": 4
});
formatter.step({
  "name": "solicito que seja efetuado um saque",
  "keyword": "Quando ",
  "line": 5
});
formatter.step({
  "name": "o saque deve retornar 1 nota de 10 reais",
  "keyword": "Então ",
  "line": 6
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 33
    }
  ],
  "location": "CaixaEletronicoStepdefs.informo_o_valor_do_saque(Integer)"
});
formatter.result({
  "duration": 76372622,
  "status": "passed"
});
formatter.match({
  "location": "CaixaEletronicoStepdefs.solicito_que_seja_efetuado_um_saque()"
});
formatter.result({
  "duration": 12791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 22
    },
    {
      "val": "10",
      "offset": 32
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornar(Integer,Integer)"
});
formatter.result({
  "duration": 3276827,
  "status": "passed"
});
formatter.scenario({
  "id": "caixa-eletrônico;retornar-erro-para-valor-não-múltiplo-de-10",
  "description": "",
  "name": "Retornar erro para valor não múltiplo de 10",
  "keyword": "Cenário",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "que informo um valor de saque de 15 reais",
  "keyword": "Dado ",
  "line": 9
});
formatter.step({
  "name": "solicito que seja efetuado um saque",
  "keyword": "Quando ",
  "line": 10
});
formatter.step({
  "name": "o saque deve retornar 0 nota de 0 reais",
  "keyword": "Então ",
  "line": 11
});
formatter.match({
  "arguments": [
    {
      "val": "15",
      "offset": 33
    }
  ],
  "location": "CaixaEletronicoStepdefs.informo_o_valor_do_saque(Integer)"
});
formatter.result({
  "duration": 44100,
  "status": "passed"
});
formatter.match({
  "location": "CaixaEletronicoStepdefs.solicito_que_seja_efetuado_um_saque()"
});
formatter.result({
  "duration": 6812,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 22
    },
    {
      "val": "0",
      "offset": 32
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornar(Integer,Integer)"
});
formatter.result({
  "duration": 38550,
  "status": "passed"
});
formatter.scenario({
  "id": "caixa-eletrônico;retornar-mais-de-1-nota-de-mesmo-valor",
  "description": "",
  "name": "Retornar mais de 1 nota de mesmo valor",
  "keyword": "Cenário",
  "line": 14,
  "type": "scenario"
});
formatter.step({
  "name": "que informo um valor de saque de 40 reais",
  "keyword": "Dado ",
  "line": 15
});
formatter.step({
  "name": "solicito que seja efetuado um saque",
  "keyword": "Quando ",
  "line": 16
});
formatter.step({
  "name": "o saque deve retornar 2 nota de 20 reais",
  "keyword": "Então ",
  "line": 17
});
formatter.match({
  "arguments": [
    {
      "val": "40",
      "offset": 33
    }
  ],
  "location": "CaixaEletronicoStepdefs.informo_o_valor_do_saque(Integer)"
});
formatter.result({
  "duration": 38042,
  "status": "passed"
});
formatter.match({
  "location": "CaixaEletronicoStepdefs.solicito_que_seja_efetuado_um_saque()"
});
formatter.result({
  "duration": 7946,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 22
    },
    {
      "val": "20",
      "offset": 32
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornar(Integer,Integer)"
});
formatter.result({
  "duration": 52972,
  "status": "passed"
});
formatter.scenario({
  "id": "caixa-eletrônico;retornar-2-notas-de-valores-diferentes",
  "description": "",
  "name": "Retornar 2 notas de valores diferentes",
  "keyword": "Cenário",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "que informo um valor de saque de 80 reais",
  "keyword": "Dado ",
  "line": 20
});
formatter.step({
  "name": "solicito que seja efetuado um saque",
  "keyword": "Quando ",
  "line": 21
});
formatter.step({
  "name": "o saque deve retornar 1 nota de 20 reais",
  "keyword": "Então ",
  "line": 22
});
formatter.step({
  "name": "1 nota de 10 reais",
  "keyword": "E ",
  "line": 23
});
formatter.step({
  "name": "1 nota de 50 reais",
  "keyword": "E ",
  "line": 24
});
formatter.match({
  "arguments": [
    {
      "val": "80",
      "offset": 33
    }
  ],
  "location": "CaixaEletronicoStepdefs.informo_o_valor_do_saque(Integer)"
});
formatter.result({
  "duration": 49757,
  "status": "passed"
});
formatter.match({
  "location": "CaixaEletronicoStepdefs.solicito_que_seja_efetuado_um_saque()"
});
formatter.result({
  "duration": 9539,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 22
    },
    {
      "val": "20",
      "offset": 32
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornar(Integer,Integer)"
});
formatter.result({
  "duration": 51836,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 0
    },
    {
      "val": "10",
      "offset": 10
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornarE(Integer,Integer)"
});
formatter.result({
  "duration": 48306,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 0
    },
    {
      "val": "50",
      "offset": 10
    }
  ],
  "location": "CaixaEletronicoStepdefs.o_saque_deve_retornarE(Integer,Integer)"
});
formatter.result({
  "duration": 45676,
  "status": "passed"
});
formatter.uri('br/gov/serpro/dojo002/integration/calculadora.feature');
formatter.feature({
  "id": "caixa-eletrônico",
  "description": "",
  "name": "Caixa Eletrônico",
  "keyword": "Funcionalidade",
  "line": 2,
  "comments": [
    {
      "value": "# language: pt",
      "line": 1
    }
  ]
});
formatter.scenario({
  "id": "caixa-eletrônico;somar-dois-números",
  "description": "",
  "name": "Somar dois números",
  "keyword": "Cenário",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "que informo os números 1 e 2",
  "keyword": "Dado ",
  "line": 4
});
formatter.step({
  "name": "solicito que seja efetuada a \"soma\"",
  "keyword": "Quando ",
  "line": 5
});
formatter.step({
  "name": "a operação deve retornar 3",
  "keyword": "Então ",
  "line": 6
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 23
    },
    {
      "val": "2",
      "offset": 27
    }
  ],
  "location": "CalculadoraStepdefs.informo_o_numero(BigDecimal,BigDecimal)"
});
formatter.result({
  "duration": 692985,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "soma",
      "offset": 30
    }
  ],
  "location": "CalculadoraStepdefs.solicito_que_seja_efetuada_a(String)"
});
formatter.result({
  "duration": 505570,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 25
    }
  ],
  "location": "CalculadoraStepdefs.a_operacao_deve_retornar(BigDecimal)"
});
formatter.result({
  "duration": 687258,
  "status": "passed"
});
formatter.scenario({
  "id": "caixa-eletrônico;subtrair-dois-números",
  "description": "",
  "name": "Subtrair dois números",
  "keyword": "Cenário",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "que informo os números 3 e 3",
  "keyword": "Dado ",
  "line": 9
});
formatter.step({
  "name": "solicito que seja efetuada a \"subtração\"",
  "keyword": "Quando ",
  "line": 10
});
formatter.step({
  "name": "a operação deve retornar 0",
  "keyword": "Então ",
  "line": 11
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 23
    },
    {
      "val": "3",
      "offset": 27
    }
  ],
  "location": "CalculadoraStepdefs.informo_o_numero(BigDecimal,BigDecimal)"
});
formatter.result({
  "duration": 78319,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "subtração",
      "offset": 30
    }
  ],
  "location": "CalculadoraStepdefs.solicito_que_seja_efetuada_a(String)"
});
formatter.result({
  "duration": 34709,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 25
    }
  ],
  "location": "CalculadoraStepdefs.a_operacao_deve_retornar(BigDecimal)"
});
formatter.result({
  "duration": 35670,
  "status": "passed"
});
});