# Estudo do ANTLR 4

Estudando ANTLR4 através de um protótipo de linguagem de programação, com
o objetivo de aprender compiladores e o próprio ANTLR4.


## Meta

Compilar arquivos que obedecem à alguma gramatica de linguagem hipotética
simples para um código assembly MIPS simplificado (também hipotético).


## Anotações (a organizar)

### Obtenção do ANTLR

O ANTLR 4 é implementado em Java (então o JDK deve estar pronto no sistema), e
é distribuído em um `.jar` contendo todo o necessário para usar o ANTLR e suas
ferramentas.

* [Página de download do ANTLR](https://www.antlr.org/download.html)
* [Link direto pro .jar](https://www.antlr.org/download/antlr-4.13.2-complete.jar)


## Configurações

Assumo que o diretório atual é aquele que contém o arquivo de definição da gramática da nossa linguagem formal, um arquivo terminado em `.g4` .

### Configurar o ANTLR 4

Executar o ANTLR requer o seguinte:

```
java -jar "caminho/pro/antlr.jar" -cp "caminho/pro/antlr.jar" <arg1> ... <argn>
```

Pra simplificar o processo, o caminho pro `.jar` do ANTLR foi adicionado ao
`CLASSPATH` global, colocando o seguinte no final de `.bash_profile`:

```
# Adiciona o meu ANTLR em classpath
CLASSPATH=".:\
/home/kallyous/ANTLR/antlr-4.13.2-complete.jar:\
$CLASSPATH"

# Remove ocasionais : do final da stringo do CLASSPATH
CLASSPATH=$(echo "$CLASSPATH" | sed 's/:$//')

# Esporta variável de ambiente
export CLASSPATH
```

E também foi criado um script para chamar o ANTLR com o comando `antlr`,
visível na variável global `PATH` (dentro de `~/Scritps`), com o seguinte
script:

```bash
#!/bin/bash

# Caminho para o .jar do ANTLR 4
JAR_PATH="/home/kallyous/ANTLR/antlr-4.13.2-complete.jar"

# Executa o .jar, passando pra ele os argumentos fornecidos a este scritp
java -jar "$JAR_PATH" "$@"
```

Com isso feito, podemos executar o ANTLR contra a gramática definida em
`KittenLanguage.g4` assim:

```
antlr KittenLanguage.g4
```

Esse comando vai gerar arquivos font `.java` para compilar a lista de tokens,
o analisador léxico (lexer) e o analisador sintático (parse) para a gramática
definida em `mygram.g4`.

Agora é só compilar com
```
javac *.java
```
pois classpath já sabe encontrar o ANTLR.


### Configurar o Test Rig do ANTLR

De forma similar, o TestRig está contido no `.jar` do ANTLR e Java precisa
saber via `CLASSPATH` onde ele está. Como classpath foi configurado no passo
anterior, já podemos rodar com `java org.antlr.v4.gui.TestRig <arg1> ... <argn>`.

Então para simplificar, foi feito o script `grun`, também visível pela variável
global `PATH`, com o seguinte:
```
#!/bin/bash
java org.antlr.v4.gui.TestRig "$@"
```

Agora podemos usar o TestRin direto pelo comando `grun`.

Considerando que tenhamos partido de uma gramática definida no arquivo
`KittenLanguage.g4`, gerado os arquivos fontes com `antlr KittenLanguage.g4` e
em seguida compiladas as classes com `javac *.java`, podemos testar nosso
lexer com TestRig executando
```
grun KittenLanguage r -tokens
```

O TestRig vai nos colocar em um terminal para escrevermos sentenças a serem
processadas pelo lexer gerado pelo ANTLR.  
Escrever o desejado e entrar `Ctrl+D` ou equivalente para gerar um `EoF` ao
final, assim o stream de bytes vai pro lexer processar e nos dar o resultado.


### Configurar projeto ATNLR 4 em Python 3.6+

ANTLR 4 não funciona com versões mais antigas que Python 3.6 .

Para gerar código Python 3 (ao invés de Java) com o ANTLR4 a partir de um arquivo de gramática `KittenLanguage.g4`, usar:
```
antlr -Dlanguage=Python3 KittenLanguage.g4
```

Para usar o ANTLR4 no Python, é necessário instalar a dependência `antlr4-python3-runtime`
```
pipenv install antlr4-python3-runtime
```

No código, carregamos o módulo com
```
from antlr4 import *
```

TestRig é apenas para Java.  
É necessário escrever os próprios scripts em python.

[Ou adaptar destes scripts prontos fornecidos pelos criadores do ANTLR](https://github.com/antlr/antlr4/blob/master/doc/python-target.md)
