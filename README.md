# Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é validar as habilidades solicitadas para o processo seletivo Back-end.

<details>
<summary><b>Criar uma pessoa</b></summary>

#### Rota para criar pessoa. `POST` `/v1/pessoas`

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

Dados de saida: `Status code` `201`
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
</details>

<details>
<summary><b>Editar uma pessoa</b></summary>
#### Rota para editar as informações somente da pessoa. `PATH` `/v1/pessoas/:id`

Dados de entrada:
```json
{
	"nome": "Gregorio Santos",
	"dataNascimento": "01/01/2000"
}
```
Dados de saida: `Status code` `200`
```json
{
	"id": 1,
	"nome": "Gregorio Santos",
	"dataNascimento": "01/01/2000",
	"enderecos": null
}
```
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Pessoa com ID: 12 não encontrado."
}
```
</details>

<details>
<summary><b>Consulta uma pessoa</b></summary>
#### Rota para consulta uma pessoa. `GET` `/v1/pessoas/:id`


Dados de saida: `Status code` `200`
```json
{
	"id": 1,
	"nome": "Gregorio Santos",
	"dataNascimento": "01/01/2000",
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
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Pessoa com ID: 12 não encontrado."
}
```
</details>

<details>
<summary><b>Listar pessoas</b></summary>
#### Rota para listar pessoas. `GET` `/v1/pessoas/`

Dados de saida: `Stattus code` `200`
```json
[
	{
		"id": 1,
		"nome": "Gregorio Santos",
		"dataNascimento": "01/01/2000",
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
	},
	{
		"id": 2,
		"nome": "Gregorio",
		"dataNascimento": "01/01/1900",
		"enderecos": [
			{
				"id": 2,
				"logradouro": "Rua X",
				"cep": "41000-000",
				"numero": 100,
				"cidade": "Salvador",
				"principal": true
			}
		]
	}
]
```
</details>

<details>
<summary><b>Criar endereco para pessoas</b></summary>
#### Rota para criar endereço para pessoa. `POST` `/v1/pessoas/:id/enderecos`

Dados de entrada:
```json
	{
		"logradouro": "Rua Z",
		"cep": "41.230-355",
		"numero": 135,
		"cidade": "Salvador"
	}
```
Dados de saida: `Status code` `201`
```json
		{
			"id": 3,
			"logradouro": "Rua Z",
			"cep": "41.230-355",
			"numero": 135,
			"cidade": "Salvador",
			"principal": false
		}
```
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Pessoa com ID: 12 não encontrado."
}
```
</details>

<details>
<summary><b>Listar endereços da pessoas</b></summary>
#### Rota para listar endereços para pessoa. `GET` `/v1/pessoas/:id/enderecos`

Dados de saida: `Stattus code` `200`
```json
[
	{
		"id": 1,
		"logradouro": "Rua X",
		"cep": "41000-000",
		"numero": 100,
		"cidade": "Salvador",
		"principal": true
	},
	{
		"id": 3,
		"logradouro": "Rua Z",
		"cep": "41.230-355",
		"numero": 135,
		"cidade": "Salvador",
		"principal": false
	}
]
```
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Pessoa com ID: 12 não encontrado."
}
```
</details>

<details>
<summary><b>Editar endereco da pessoas</b></summary>
#### Rota para editar as informações do endereço da pessoa. `PATH` `/v1/pessoas/:id/enderecos/:id`

Dados de entrada: 
```json
{
		"logradouro":"Rua Coronel João",
		"cep":"41.230-344",
		"numero":135,
		"cidade": "Daqui Salvador",
		"principal": true
}
```
Dados de saida: `Stattus code` `200`
```json
{
	"id": 3,
	"logradouro": "Rua Coronel João Willy",
	"cep": "41.230-344",
	"numero": 135,
	"cidade": "Salvador",
	"principal": true
}
```
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Pessoa com ID: 12 não encontrado."
}
```
Dados de saida: `Status code` `404`
```json
{
	"titulo": "NOT FOUND",
	"status": 404,
	"menssagem": "Endereco com ID: 10 não encontrado."
}
```
</details>
