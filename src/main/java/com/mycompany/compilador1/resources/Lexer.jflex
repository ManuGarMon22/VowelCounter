/* SECTION 1: user code */
package com.mycompany.compilador1.resource;

import java.util.ArrayList;


/* SECTION 2: config */

%%

%class Lexer
%unicode
%line
%column
%int
%public

L= [a-zA-Z]+
N=[0-9]+
spaces=[ ,\t,\r,\n]+

%{
    private int oneV = 0;
    private int twoV = 0;
    private int threeV = 0;
    private int fourV = 0;
    private int fiveV = 0;
    private ArrayList<String> dataNum = new ArrayList<>();

    private void countWords(String lexWord) {
        switch(lexWord.length() - lexWord.replaceAll("[aeiouAEIOU]", "").length()) {
            case 1:
                oneV++;
                break;
            case 2:
                twoV++;
                break;
            case 3:
                threeV++;
                break;
            case 4:
                fourV++;
                break;
            case 5:
                fiveV++;
                break;
            default:
                
                break;
        }
    }

    private void saveDataNum(int line, int column, int value) {
        this.dataNum.add("numero "+value+" en fila "+line +" columna "+column);
    }

    // GETTERS AND SETTERS
    public int[] getVowelNumbers() {
        return new int[] {oneV,twoV,threeV,fourV,fiveV};
    }

    public ArrayList<String> getNumberInfo() {
        return this.dataNum;
    }
%}


%%

/* SECTION 3: lexical rules */
{N}     {saveDataNum(yyline,yycolumn,Integer.valueOf(yytext()));}
{L}+    {countWords(yytext());}
[^]     {}
