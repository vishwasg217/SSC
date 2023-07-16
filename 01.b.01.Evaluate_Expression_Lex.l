/*
1.b. Write YACC program to evaluate arithmetic expression involving operators: +, -, *, and /

LEX Part
//lex
%{
#include<stdlib.h>
#include "y.tab.h"
extern int yyval;
%}
%%
[0-9]+ {yylval = atoi(yytext);return NUM;}
[\t] ;
\n return 0;
. return yytext[0];
%%


