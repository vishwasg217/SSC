/*
6.b. Write YACC program to recognize valid identifier, operators and keywords in the
given text (C program) file.

//YACC
%{
#include<stdio.h>
#include<stdlib.h>
int id = 0,dig =0,key=0,op=0;
%}
%token DIGIT ID KEY OP
%%
input:
 DIGIT input {dig++;}
|ID input {id++;}
|KEY input {key++;}
|OP input {op++;}
|DIGIT {dig++;}
|ID {id++;}
|KEY {key++;}
|OP {op++;}
;
%%
#include<stdio.h>
extern int yylex();
extern int yyparse();
extern FILE *yyin;
main(){
	FILE *myfile  = fopen("input.c","r");
	if(!myfile){
		printf("Can't open file");
		return -1;
	}
	yyin = myfile;
	do{
		yyparse();
	}while(!feof(yyin));
	printf("numbers = %d\nKeywords=%d\nIdentifiers = %d\nOperators=%d\n",dig,key,id,op);
} 
void yyerror(){
	printf("error");
	exit(-1);
}

/*
Output:

>>> lex 06.b.01.Identifier_Lex.l 
>>> yacc -d 06.b.02.Identifier_Yacc.y 
>>> gcc lex.yy.c y.tab.c -ll -ly
>>> ./a.out input.6b.txt 
void is Keyword
main is Identifier


int is Keyword
a is Identifier
= is Operator
5 is Number

if is Keyword
a is Identifier
> is Operator
3 is Number


printf is Identifier
d is Identifier
a is Identifier



Numbers = 2
Keywords = 3
Identifiers = 6
Operators = 2

>>> cat input.6b.txt 
void main()
{
	int a = 5;
	if(a > 3)
	{
		printf("%d", a);
	}
}

*/
