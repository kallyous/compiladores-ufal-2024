/**
Gramática para a lingaugem Power Puff Kittens
-1 + 3 * 2 - 2 * ( 1 + 1 ) + 10 \n
*/

grammar PowerPuffKittens;

prog: stats ;
// prog -> stats

stats: stat stats
     | ;
// stats -> stat stats
//        | ø

stat: expr NL ;
// stat -> expr NL

expr: term expr_i ;
// expr -> term expr'

expr_i: '+' term expr_i
      | '-' term expr_i 
      | ;
// expr' -> + term expr'
//        | - term expr
//        | ø

term: factor term_i ;
// term -> factor term'

term_i: '*' factor term_i
      | '/' factor term_i 
      | ;
// term -> * factor term'
//       | / factor term'
//       | ø

factor: INT
      | '(' expr ')' ;
// factor -> INT
//         | ( expr )

INT: ('-'|'+')? [0-9]+ ;  // Casa números inteiros.
NL : '\r'? '\n' ;         // Casa quebras de linha.
WS : [ \t] -> skip;       // Descarta espaços brancos.
