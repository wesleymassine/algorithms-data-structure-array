# Authorizer APP #
Authorize APP is an application written in Go for creating accounts and transactions.

Thank you for analyzing my code. This application was lovingly developed with Golang. I hope you like it! If something is not clear to you or I have failed to do something important, please feel free to extend the challenge! I hope to learn from you.

IMPORTANT: All personal information has been removed.

Now get a good coffee and good analysis :)

## How to Run the Application
To use the API it is necessary to have the [Docker](https://docs.docker.com/get-docker/) installed.

After the installation, just use the command below [seguinte comando](https://docs.docker.com/compose/reference/up/)

```bash
docker-compose up --build
```
This way the API will be available to be used on the port [5000](http://localhost:5000)

Other alternatives to run the application are:
Use the executable in the root folder: ./authorizer_app
Or the command: go run authorizer_app
If you have any problems, please talk to me.

## Usage
- Make sure you have Go 1.15+ installed:

```bash
go version  # go version go1.15.4 linux/amd64
```
## Package
I sought to make the most of the native resources of the lineage. I used only the gorilla/mux package to route HTTP requests and URL matching to build web servers with Go (github.com/gorilla/mux) v1.8.0.

## Api Interface
* 1. Account creation 
    * URL: http://localhost:5000/accounts
    * METHOD: POST 
    * REPONSE: CREATED (201)
    * PAYLOAD: (JSON)

    ```Input: Creates the account with available-limit and active-card set.
    {
        "account":{
            "active-card":true,
            "available-limit":100
        }
    }
    ```
    ```Output:
    {
        "account":{
            "active-card":true,
            "available-limit":100
        },
    "violations":[]
    }
    ```
* GET
    * URL: http://localhost:5000/accounts
    * METHOD: GET 
    * REPONSE: CREATED (200)
    * PAYLOAD: (JSON)

    ```Output:
    { 
        "account":{
            "active-card":true,
            "available-limit":100
        },
    "violations":[]
    }
    ```

* 2. Transaction authorization 
    * URL: http://localhost:5000/transactions
    * METHOD: POST 
    * REPONSE: CREATED (201)
    * PAYLOAD: (JSON)

     ```Input: Tries to authorize a transaction for a particular merchant, amount and time given the account's 
     state and last authorized transactions
    {
        "transaction":{
            "merchant":"Burger King",
            "amount":20,
        }
    }
    ```

    ```Output: The account's current state + any business logic violations.
    {
        "account":{
            "active-card":true,
            "available-limit":100
        },
        "violations":[]
    }
    ```

* 3.Business rules 
You should implement the following rules, keeping in mind new rules will appear in the future: 

    ● No transaction should be accepted without a properly initialized account: ```account-not-initialized```
    ● No transaction should be accepted when the card is not active: ```card-not-active``` 
    ● The transaction amount should not exceed available limit: ```insufficient-limit``` 
    ● There should not be more than 3 transactions on a 2 minute interval: ```high-frequency-small-interval```
    ● There should not be more than 1 similar transactions (same amount and merchant) in a 2 minutes interval: ```doubled-transaction``` 

* Examples 
Given there is an account with active-card: true and available-limit: 100: 

* input 
    {"transaction": {"merchant": "Burger King", "amount": 20, "time": "2019-02-13T10:00:00.000Z"}} 

* output 
    {"account": {"active-card": true, "available-limit": 80}, "violations": []} 

* Given there is an account with active-card: true, available-limit: 80 and 3 transaction occurred in the last 2 minutes: 
* input 
{"transaction": {"merchant": "Habbib's", "amount": 90, "time": "2019-02-13T10:01:00.000Z"}} 

* output 
{"account": {"active-card": true, "available-limit": 80}, "violations": ["insufficient-limit", "high-frequency-small-interval"]} 

## Types of violations expected ##
```output
    account-already-initialized
    account-not-initialized
    card-not-active
    insufficient-limit
    high-frequency-small-interval
    doubled-transaction
```

### Executing requests with Postman
Please use the link below or import the authorize-app.postman_collection.json file from the root folder into postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/bfa3671453b5f86f9692)

## Design decisions
The choice of MVC architecture was made because of the focus on the business rule through the model that represents the application data and the business rules that govern the access and modification of data. The model maintains the persistent state of the business and provides the controller with the ability to access the functionalities of the application encapsulated by the model itself.

The application does not depend on any external base to function. I used temporary files in json format for GET requests

## Files and packages structures
    .
    ├── cli                         # Src main file with all source code
        ├── controllers             # Controllers temporary file storage in json format
        ├── file                    # File temporary file storage in json format
        ├── models                  # modela the data and behavior behind the business process
        ├── repositories            # Repositories persistence of data
        ├── router                  # Router manages HTTP requests
        ├── utils                   # Utils generic and auxiliary functions
    ├── .env                        # File for environment variable settings
    ├── authorizer_app              # Authorizer_app application executable file
    ├── docker-compose.yaml
    ├── Dockfile
    ├── go.mod
    ├── go.sum
    ├── go.main
    └── readme.md

## Testing
For the tests, Golang's native library was used.

Execute the tests with the command below:


## Licença
[MIT](https://choosealicense.com/licenses/mit/)

## Referências ##
* https://golang.org/

# Algorithms and data structure with array

(EN)

This repository contains my studies on algorithms and data structure with questions,
classic problems and challenges that are part of the fundamentals of computer science.

In this package, the solutions are implemented in the `Java` programming language using` Arrays and Matrix`.

The proposed problems are with the questions and details for solution commented at the beginning of each class.java file.

# Index
Categorized index
Find maximum and minimum
Make larger number
Next larger palindrome
Least difference in array
Print matrix spiral
Move zeros to the right
Find repetition multiple sorted arrays
Largest sum sub array
Search in a sorted matrix
Kth largest in sorted matrix
Largest palindrome iterative
Reverse words of sentence
Rotate array k times
Merge in single array
Rotate a string to make another
Maximum product subarray
Maximum sum sub matrix
Expand the array
Sort to bring anagrams closer
Two missing numbers
Maximize stock profit simple
Sum of array except current element
Maximum arithmetic sequence

(PT)

Este repositório contém meus estudos sobre algoritmos e estrutura de dados com questões,
problemas e desafios clássicos que fazem parte dos fundamentos da ciência da computação.

Neste pacote as soluções são implementadas na linguagem de programação `Java` usando` Arrays and Matriz`.

Os problemas propostos estão com as perguntas e detalhes para solução comentadas no início de cada arquivo class.java.

# Indice
Índice categorizado
Encontre o máximo e o mínimo
Faça um número maior
Próximo palíndromo maior
Menor diferença na array
Espiral de array de impressão
Mova zeros para a direita
Encontrar várias matrizes classificadas de repetição
Maior submatriz de soma
Pesquisa em um array classificado
Kº maior no array classificada
Maior palíndromo iterativo
Palavras reversas da frase
Girar array k vezes
Mesclar em um única array
Gire uma corda para fazer outra
Submatriz de produto máximo
Submatriz de soma máxima
Expanda o array
Classifique para aproximar os anagramas
Dois números faltando
Maximize o lucro do estoque de forma simples
Soma do array exceto elemento atual
Sequência aritmética máxima
