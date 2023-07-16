/*
2. Develop, Implement and Execute a program using YACC tool to recognize all strings
ending with b preceded by n a’s using the grammar a
n b (note: input n value)

//yacc
%{
#include<stdio.h>
%}
%token A B
%%
str: s '\n'
s : x B
;
x : x A
| A
;
%%
main(){
	printf("Type a string\n");
	if(!yyparse()){
		printf("valid");
	}
}
int yyerror(){
	printf("Invalid");
	exit(0);
}

/*
Output:

>>> lex 02.01.Recognize_AnB_Lex.l 
>>> yacc -d 02.02.Recognize_AnB_Yacc.y 
>>> gcc lex.yy.c y.tab.c -ll -ly
>>> ./a.out 
Enter n value
5
aaaaab
Valid String
*/

