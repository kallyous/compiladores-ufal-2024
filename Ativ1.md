# Atividade 01

https://classroom.google.com/c/Njg0OTUyODE0MDU3/a/NzAxOTE3ODU3Nzk5/details

Criar o pseudocódigo para a tabela de símbolos e para o analisador léxico para uma gramática formada por expressões aritméticas de somas e subtrações entre números inteiros de dígito único, na forma de escrita infixa (e.g. 9 + 4 - 2), para um compilador que traduza a expressão aritmética infixa para sua equivalente posfixa (e.g. 9 4 + 2 -).

Usar como referência os códigos de analisador léxico e de tabela de símbolos apresentados nas páginas [31-35] do livro [[Compiladores - Princípios, técnicas e Ferramentas.pdf]] (Livro do Dragão, 1ª Ed)

### Gramática

**Tokens:** + - 0 1 2 3 4 5 6 7 8 9
**Ñ Terminais:** - +
**Produções:** 
1. lista -> lista + digito | lista - digito | digito
2. digito -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
**Simb. Partida:** lista

### Tabela de Símbolos

`symtab.h`
```C++
#include <unordered_map>
#include <string>

enum class SymbolType {
    Operator,
    Parenthesis,
    Digit,
    Variable
};

enum class Category {
    Terminal,
    NonTerminal
};

struct SymbolInfo {
    SymbolType type;
    int value;
    Category category;
};

std::unordered_map<std::string, SymbolInfo> symbolTable = {
    {"+", {SymbolType::Operator, -1, Category::Terminal}},
    {"-", {SymbolType::Operator, -1, Category::Terminal}},
    {"*", {SymbolType::Operator, -1, Category::Terminal}},
    {"/", {SymbolType::Operator, -1, Category::Terminal}},
    {"(", {SymbolType::Parenthesis, -1, Category::Terminal}},
    {")", {SymbolType::Parenthesis, -1, Category::Terminal}},
    {"0", {SymbolType::Digit, 0, Category::Terminal}},
    {"1", {SymbolType::Digit, 1, Category::Terminal}},
    {"2", {SymbolType::Digit, 2, Category::Terminal}},
    {"3", {SymbolType::Digit, 3, Category::Terminal}},
    {"4", {SymbolType::Digit, 4, Category::Terminal}},
    {"5", {SymbolType::Digit, 5, Category::Terminal}},
    {"6", {SymbolType::Digit, 6, Category::Terminal}},
    {"7", {SymbolType::Digit, 7, Category::Terminal}},
    {"8", {SymbolType::Digit, 8, Category::Terminal}},
    {"9", {SymbolType::Digit, 9, Category::Terminal}},
    {"E", {SymbolType::Variable, -1, Category::NonTerminal}},
    {"T", {SymbolType::Variable, -1, Category::NonTerminal}},
    {"F", {SymbolType::Variable, -1, Category::NonTerminal}},
    {"N", {SymbolType::Variable, -1, Category::NonTerminal}},
    {"D", {SymbolType::Variable, -1, Category::NonTerminal}}
};
```

### Analisador Léxico

`lexanal.h`
```c++
#include "symtab.h"
#include <vector>
#include <cctype>
#include <iostream>

struct Token {
    std::string lexeme;
    SymbolInfo info;
};

std::vector<Token> tokenize(const std::string& input) {
    std::vector<Token> tokens;
    size_t i = 0;
    while (i < input.size()) {
        if (isspace(input[i])) {
            // Ignorar espaços em branco
            ++i;
            continue;
        }

        std::string lexeme;
        SymbolInfo info;

        if (isdigit(input[i])) {
            // Construir um número inteiro
            while (i < input.size() && isdigit(input[i])) {
                lexeme += input[i];
                ++i;
            }
            // O valor do token é o próprio número
            info = {SymbolType::Digit, std::stoi(lexeme), Category::Terminal};
        } else {
            lexeme += input[i];
            auto it = symbolTable.find(lexeme);
            if (it != symbolTable.end()) {
                info = it->second;
                ++i;
            } else {
                std::cerr << "LEX_ERR: símbolo desconhecido '"
                          << lexeme << "'\n";
                ++i;
                continue;
            }
        }

        tokens.push_back({lexeme, info});
    }
    return tokens;
}
```

### Código de Testes

`main.cpp`
```c++
int main() {
    std::string input = "7 + 3 * 2 - (8 / 4)";
    std::vector<Token> tokens = tokenize(input);

    for (const auto& token : tokens) {
        std::cout << "Lexeme: " << token.lexeme
                  << ", Type: " << static_cast<int>(token.info.type)
                  << ", Value: " << token.info.value
                  << ", Category: " << static_cast<int>(token.info.category)
                  << "\n";
    }

    return 0;
}
```