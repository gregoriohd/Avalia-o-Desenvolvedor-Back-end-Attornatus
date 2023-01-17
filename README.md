#Avaliação Desenvolvedor Back-end Attornatus


#### `POST` `/v1/pessoas`
Essa é a rota que será utilizada para cadastrar uma nova pessoa.

Dados de entrada:
```json
	{
		"nome": "Gregorio",
		"dataNascimento": "01/01/1900",
		"enderecos": [
			{
				"logradouro": "Rua X",
				"cep": "41000-000",
				"numero": 100,
				"cidade": "Salvador",
				"principal": true
			}
		]
	}
```

Dados de saida:
```json
{
	"id": 1,
	"nome": "Gregorio",
	"dataNascimento": "01/01/1900",
	"enderecos": [
		{
			"id": 1,
			"logradouro": "Rua X",
			"cep": "41000-000",
			"numero": 100,
			"cidade": "Salvador",
			"principal": true
		}
	]
}
```

#### `PATH` `/v1/pessoas/:id`
Essa é a rota que permite atualizar as informações somente da pessoa.

Dados de Entrada:
```json
{
	"nome": "Gregorio Santos",
	"dataNascimento": "01/01/2000"
}
```
Dados de saida:
```json
{
	"id": 1,
	"nome": "Gregorio Santos",
	"dataNascimento": "01/01/2000",
	"enderecos": null
}
```
  
