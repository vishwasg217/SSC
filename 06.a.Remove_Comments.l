/*
6.a. Write a LEX program to eliminate comment lines in a C program and copy the
resulting program into a separate file.
*/

%{
#include<stdio.h>
#include<stdlib.h>
%}
%%
\/\/.* ; // " \" used to espace the " / ", " ." means match everything and * means match 0 or more times.  
\/\*(.*\n)*.*\*\/ ; // 
%%
int main(){
yyin = fopen("f1.c", "r");
yyout= fopen("rd.c", "w");
yylex();
return 0;
}
/*
Output: 

>>> lex 06.a.Remove_Comments.l 
>>> gcc lex.yy.c -ll
>>> ./a.out input.6a.txt output.6a.txt
*/
