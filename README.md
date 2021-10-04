EndPoints Exercicios - LabCoding
Endpoint findById
Acessar com a URL abaixo o metodo GET para retornar o pedido 
http://localhost:8080/findById/0

Endpoint save
Acessar com a URL abaixo o metodo POST para retornar o pedido salvo 
http://localhost:8080/save

Corpo da requisição:

{
    "email" : "Karina Padua", 
    "nomeCompleto" : "Karina Padua", 
    "address" : "Rua Um", 
    "idPedido" : 0001, 
    "descricao" : ["itena","itenB"],
    "qntdPedidos" : 1, 
    "precoUnitario" : [2.00, 5.00], 
    "precoTotal" : 7.00, 
    "formaPagamento" : "cartao", 
    "dataPedido" : "01/10/2021",
    "status" : "ativo", 
    "idTransacao" : 1, 
    "numeroCartao" : "12345", 
    "validadeCartao" : "12/2023", 
    "bandeira" : "Master"
}
Endpoint update
Acessar com a URL abaixo o metodo POST para atualizar o pedido
http://localhost:8080/update/0


Endpoint delete
Acessar com a URL abaixo o metodo POST para deletar o pedido
http://localhost:8080/delete/0


PaymentService
Endpoint findById
receba um id da transação e retorne um objeto DTO Payment
http://localhost:8080/pay/findById/0

Endpoint save
receba objeto DTO Payment e retorna a URL de chamada do pagamento salvo
http://localhost:8080/pay/save

Corpo da requisição:

{ 
    "idTransacao" : 1, 
    "numeroCartao" : "12345", 
    "validadeCartao" : "12/2023", 
    "bandeira" : "Master"
}

Endpoint update
receba o id do pagamento na url do Endpoint e um objeto DTO Payment com os atributos que serão atualizados
http://localhost:8080/pay/update/0

Corpo da requisição:

{
    "idTransacao" : 1, 
    "numeroCartao" : "12345", 
    "validadeCartao" : "12/2023", 
    "bandeira" : "Master"
}
Endpoint delete
receba o id na url do Endpoint e delete o pedido com o Id 
http://localhost:8080/pay/delete/0
