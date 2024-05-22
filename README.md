<h1> Projeto conexao-respeito 🤝</h1>
[MS Content] |  [MS Involved](#id2)  |  [MS Bff](#id3)  |
<p>O projeto tem como objetivo principal auxiliar na educação de estudantes do ensino fundamental e ensino médio, assim como seus responsáveis, 
  sobre os impactos relacionados à prática do cyberbullying e as penalidades que podem ser aplicadas a casos de agressão desse tipo.
  Para isso, a equipe técnica irá desenvolver um aplicativo que permita a realização de denúncias de casos de cyberbullying. 
  Os professores terão acesso à lista de denúncias e irão contactar o responsável do aluno para que definam um período limitado de avaliação, com base na proporção do caso relatado e analisado.
  Durante o período estabelecido, serão atribuídas atividades com prazos individuais para o estudante e para os responsáveis no aplicativo. 
  Enquanto para o estudante o foco das atividades será a reeducação para não repetição do ato, para os responsáveis o foco será ensinar qual abordagem seguir e como monitorar essas situações.
</p>
<div align="center">
  <img src="https://github.com/Matheus-Braynner/conexao-respeito-back-end/assets/68668725/06aedf0a-3195-48f4-ad34-c10a32a30854" width="600px"/>
</div>

<details>
  <summary><a id="id1"><h2><strong>MS Involved</strong></h2></summary>

<p> O MS involved tem a responsabilidade de armazenar e gerenciar os dados de alunos, professores e responsáveis. O MS involved possui os seguintes endpoints:</p>
<h1> Diagrama ER</h1>
<div align="center">
  <img src="https://github.com/Matheus-Braynner/shop_style_virtual_commerce/assets/68668725/a8d0478d-e1f9-4bb0-9903-167611f9b969.png" width="600px"/>
</div>

```
*INVOLVED CONTROLLER:*

- POST - /v1/involved/teacher
- POST - /v1/involved/student
- GET - /v1/involved/student/{studentRegister}
- POST - /v1/involved/responsible
- POST - /v1/involved/auth/login
- GET - /v1/involved/student/educational-institution

*COMPLAINT CONTROLLER:*
- POST - /v1/complaint/{involvedCpf}
- GET - /v1/complaint/{complaintId}
```

<p><strong>Campos da tabela complaint:</strong></p>

```
ID, EDUCATIONAL_INSTITUTION, NAME_AGGRESSOR, PLACE_VIOLATION_OCCURRED, COMPLAINT_REASON
```

<p><strong>Campos da tabela responsible:</strong></p>

```
ID, FULLNAME, BIRTH_DATE, NAME_TUTORED_STUDENT, STUDENT_REGISTRATION, CPF, POSTAL_CODE, ADDRESS, CITY, NEIGHBORHOOD, PHONE_NUMBER, EDUCATIONAL_INSTITUTION, EMAIL, PASSWORD
```

<p><strong>Campos da tabela student:</strong></p>

```
ID, FULLNAME, BIRTH_DATE, NAME_RESPONSIBLE, RESPONSIBLE_ID, REGISTRATION, CPF, POSTAL_CODE, ADDRESS, CITY, NEIGHBORHOOD, PHONE_NUMBER, EDUCATIONAL_INSTITUTION, EMAIL, PASSWORD
```

<p><strong>Campos da tabela teacher:</strong></p>

```
ID, FULLNAME, EMAIL, PASSWORD, POSTAL_CODE, ADDRESS, CITY, NEIGHBORHOOD, PHONE_NUMBER, EDUCATIONAL_INSTITUTION, REGISTRATION, CPF, BIRTH_DATE
```

<p><strong>Observação:</strong></p>

<li>O campo ID de todas as tabelas deve ser gerado por auto incremento.</li>
<h2>Exemplo de um payload para cadastrar estudante:</h2>

```

 {
    "fullname": "Matheus",
    "email": "email@outlook.com",
    "password": "123456",
    "postalCode": "postalCode",
    "address": "address",
    "city": "city",
    "neighborhood": "neighborhood",
    "phoneNumber": "phoneNumber",
    "educationalInstitution": "educationalIntitution",
    "registration": "registration12",
    "cpf": "88127437069",
    "birthDate": "2020-03-12",
    "nameResponsible": "nameResponsible"
}

```


<p><strong>Validações necessárias:</strong></p>
<li>Os campos <code>fullname</code> e <code>nameResponsible</code> precisam ter no mínimo 3 caracteres.</li>
<li>O campo <code>cpf</code> precisa seguir o seguinte padrão (xxx-xxx-xxx.xx).</li>
<li>O campo <code>email</code> precisa estar no formato de um email válido e não deve permitir emails duplicados.</li>
<li>O campo <code>password</code> precisa ter no mínimo 6 caracteres e tem que ser salvo criptografado no banco.</li>
<li>O campo <code>birthdate</code> precisa ser salvo no banco como o tipo date e tem que estar no formato ISO-8601, entretanto na hora de serializar o objeto e enviar no payload do response esse campo precisa estar no formato dd/mm/aaaa.</li>
<li>O campo <code>phoneNumber</code> deve aceitar somente valores numéricos.</li>

<p></p>
<h2>Exemplo de um payload para cadastrar professor:</h2>

```
{
"fullname": "Matheus",
"email": "email@outlook.com",
"password": "123456",
"postalCode": "postalCode",
"address": "address",
"city": "city",
"neighborhood": "neighborhood",
"phoneNumber": "phoneNumber",
"educationalInstitution": "educationalIntitution",
"registration": "registration12",
"cpf": "88127437069",
"birthDate": "2020-03-12"
}
```

<p><strong>Validações necessárias:</strong></p>
<li>Os campos <code>fullname</code> e <code>registration</code> precisam ter no mínimo 3 caracteres.</li>
<li>O campo <code>cpf</code> precisa seguir o seguinte padrão (xxx-xxx-xxx.xx).</li>
<li>O campo <code>email</code> precisa estar no formato de um email válido e não deve permitir emails duplicados.</li>
<li>O campo <code>password</code> precisa ter no mínimo 6 caracteres e tem que ser salvo criptografado no banco.</li>
<li>O campo <code>birthDate</code> precisa ser salvo no banco como o tipo date e tem que estar no formato ISO-8601, entretanto na hora de serializar o objeto e enviar no payload do response esse campo precisa estar no formato dd/mm/aaaa.</li>
<li>O campo <code>phoneNumber</code> deve aceitar somente valores numéricos.</li>

<p></p>
<h2>Exemplo de um payload para cadastrar responsável:</h2>

```
{
"fullname": "João da Silva",
"birthDate": "1990-05-15",
"nameTutoredStudent": "Maria da Silva",
"studentRegistration": "ST12345",
"cpf": "123.456.789-10",
"postalCode": "12345-678",
"address": "Rua Principal, 123",
"city": "Cidade",
"neighborhood": "Bairro",
"phoneNumber": "123456789",
"educationalInstitution": "Instituição de Ensino",
"email": "joao.silva@example.com",
"password": "senha123"
}
```

<p><strong>Validações necessárias:</strong></p>
<li>Os campos <code>fullname</code>, <code>nameTutoredStudent</code> e <code>educationalInstitution</code> precisam ter no mínimo 3 caracteres.</li>
<li>O campo <code>cpf</code> precisa seguir o seguinte padrão (xxx.xxx.xxx-xx).</li>
<li>O campo <code>email</code> precisa estar no formato de um email válido e não deve permitir emails duplicados.</li>
<li>O campo <code>password</code> precisa ter no mínimo 6 caracteres.</li>
<li>O campo <code>birthDate</code> precisa ser salvo no banco como o tipo date e tem que estar no formato ISO-8601, entretanto na hora de serializar o objeto e enviar no payload do response esse campo precisa estar no formato dd/mm/aaaa.</li>
<li>O campo <code>phoneNumber</code> deve aceitar somente valores numéricos.</li>

<p></p>
<h2>Exemplo de um payload para cadastrar uma denuncia:</h2>

{
"educationalInstitution": "Nome da Instituição",
"nameAggressor": "Fulano de Tal",
"placeViolationOccurred": "Local da Violência",
"complaintReason": "Motivo da Denúncia"
}
```

{
"educationalInstitution": "Nome da Instituição",
"nameAggressor": "Fulano de Tal",
"placeViolationOccurred": "Local da Violência",
"complaintReason": "Motivo da Denúncia"
}

</details>
