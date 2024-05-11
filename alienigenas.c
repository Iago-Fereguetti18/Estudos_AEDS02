#include <stdio.h>
#include "string.h"
#include <stdlib.h>

/*
Desde o Gerador de Improbabilidade Infinita, muitos nem questionam sobre a vida em outros planetas, 
e se aprofundam em questionamentos mais improváveis, como, por exemplo, 
será que seres de outros planetas usam os mesmos caracteres que a gente para escrever? 
E se isto for verdade, será que usam as mesmas vogais que a gente?
Pensando nisto, muitos cientistas projetaram vários tipos de alfabetos alienígenas, 
usando as letras do nosso alfabeto, além dos dígitos, de 0 a 9, com as suas respectivas vogais. 
Baseados nisto, estes pedem a sua ajuda para identificar vogais em alfabetos alienígenas e fazer contagens a respeito.

Escreva um programa que, dado uma sequência de vogais, em um determinado alfabeto alienígena, contabilize, 
em um texto escrito com o mesmo alfabeto, quantas vogais o mesmo possui.

Entrada
Haverá diversos casos de teste. Cada caso de teste é formado por duas linhas. 
A primeira linha informa uma palavra, formada por todas as vogais alienígenas de um determinado planeta. 
A segunda linha contém uma frase formada por letras do mesmo alfabeto. 
A entrada termina com fim de arquivo.

Saída
Para cada caso de teste, imprima a quantidade de vogais alienígenas correspondente.


ENTRADAS - EXEMPLO
aeiou
o rato roeu a roupa do rei de roma
4310
t3st3 p4r4 c0d1f1c4r
kwy
the quick brown fox jumps over the lazy dog
*/


// funcao para contar vogais do idioma
int contador(char alfabeto[10], char input[50])
{
    int count = 0;
    char letra;
    for (size_t i = 0; alfabeto[i] != '\0'; i++)
    {
        for (size_t j = 0; input[j] != '\0'; j++)
        {
            if (alfabeto[i] == input[j])
            {
                count++;
            }
        }
    }

    return count;
}

int main()
{
    // ler inputs
    char alfabeto[100];
    char input[500];
    int count = 0;
    int x = 0;
    while (scanf(" %[^\r\n]%*c", alfabeto) != EOF)
    {
        scanf(" %[^\r\n]%*c", input);
        int count = contador(alfabeto, input);
        printf("%d: %d\n", x, count);
        x++;
    }

    return 0;
}