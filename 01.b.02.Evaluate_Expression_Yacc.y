/*
1.b. Write YACC program to evaluate arithmetic expression involving operators: +, -, *, and /

YACC Part
//yacc 
%{
#include<stdio.h>
%}
%token NUM
%left '+' '-'
%left '*' '/'
%%
expr: e {printf("Result: %d\n", $1); return 0;}
e : e '+' e {$$ = $1 + $3;}
| e '-' e {$$ = $1 - $3;}
| e '*' e {$$ = $1 * $3;}
| e '/' e {$$ = $1 / $3;}
|'('e')' {$$ =  $2;}
| NUM {$$ = $1;}
;
%%
main(){
printf("type the expression\n");
yyparse();
printf("valid expression\n");
}
yyerror(){
printf("Invalid expression\n");
exit(0);
}



/*
Output:
>>> lex 01.b.01.Evaluate_Expression_Lex.l 
>>> yacc -d 01.b.02.Evaluate_Expression_Yacc.y 
>>> gcc lex.yy.c y.tab.c -ll -ly
>>> ./a.out 
2+3*8
Result=26
*/

