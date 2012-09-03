# language: pt
Funcionalidade: Caixa Eletrônico
  Cenário: Retornar uma nota de mesmo valor
    Dado que informo um valor de saque de 10 reais
    Quando solicito que seja efetuado um saque
    Então o saque deve retornar 1 nota de 10 reais
    
  Cenário: Retornar erro para valor não múltiplo de 10
    Dado que informo um valor de saque de 15 reais
    Quando solicito que seja efetuado um saque
    Então o saque deve retornar 0 nota de 0 reais
    
    
  Cenário: Retornar mais de 1 nota de mesmo valor 
    Dado que informo um valor de saque de 40 reais
    Quando solicito que seja efetuado um saque
    Então o saque deve retornar 2 nota de 20 reais
    
  Cenário: Retornar 2 notas de valores diferentes  
    Dado que informo um valor de saque de 80 reais
    Quando solicito que seja efetuado um saque
    Então o saque deve retornar 1 nota de 20 reais
    E 1 nota de 10 reais
    E 1 nota de 50 reais