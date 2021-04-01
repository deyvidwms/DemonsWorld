
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class DemonsWorld_Projeto {

    public static void menu(){
        System.out.println(
                 "##============MENU============##\n"
                +"|| 1 - Jogar                  ||\n"
                +"|| 2 - Intruções              ||\n"
                +"|| 3 - Sair                   ||\n"
                +"||Digite a opção desejada:    ||\n"
                +"##============================##");
    }
    
    public static void Instrucao(){
        System.out.println("##=========================INSTRUÇÕES=========================##\n"
                         + "|| -> Estrutura                                               ||\n"
                         + "||  O jogo é bem simples, o usuário, irá basicamente escolher ||\n"
                         + "|| a classe do personagem, depois irá aparecer a fase, o nome ||\n"
                         + "|| do oponente, a barra de life dele, e a do usuário e em     ||\n"
                         + "|| seguida aparecerar as opções (1 - Atacar, 2 - Usar Item).  ||\n"
                         + "||  O usuário, terá que, basicamente, vencer os inimigos, até ||\n"
                         + "|| chegar no último inimigo (o Mr. relliM).                   ||\n"
                         + "||                                                            ||\n"
                         + "|| -> Classes                                                 ||\n"
                         + "||  Guerreiro, um personagem forte, que começará a partida    ||\n"
                         + "|| com 120 de HP, para ter uma certa vantagem em relação aos  ||\n"
                         + "|| inimigos.                                                  ||\n"
                         + "||  Mago, outro personagem forte, o mesmo, diferente do       ||\n"
                         + "|| Guerreiro, não começa com 120 de HP, ele possui uma Hab.   ||\n"
                         + "|| Especial, a qual poderá ser usada no ultimo chefe!         ||\n"
                         + "|| Para descobri-la?! Basta jogar!                            ||\n"
                         + "##============================================================##");
    }
    
    public static void Historia(){
        System.out.println("##============================HISTÓRIA============================##\n"
                         + "||  No continente de Vesmércia, existia um reino, tal reino, era  ||\n"
                         + "|| afastado dos demais, por razões geográficas. Esse reino, era   ||\n"
                         + "|| conhecido por ser um dos reinos mais pacíficos, dentre os      ||\n"
                         + "|| outros reinos.                                                 ||\n"
                         + "||  O rei, DYROS, governava a vários anos, era bastante repeitado ||\n"
                         + "|| por todos. O rei, tinha um ajudante e amigo muito poderoso,    ||\n"
                         + "|| chamado Mr. relliM. O Mr. relliM, tinha muita influência no    ||\n"
                         + "|| reino.                                                         ||\n"
                         + "||  O poderoso Mr. relliM, traiu o Rei e a todos, transformando o ||\n"
                         + "|| Rei em pedra e assumindo o controle do reino. A princesa, Link ||\n"
                         + "|| no entanto, conseguiu escapar e pediu ajuda a um dos Herois,   ||\n"
                         + "|| por meio de um Falcão mensageiro. No entando, ela foi pega de  ||\n"
                         + "|| surpresa, e foi levada para o Castelo, onde foi aprisionada    ||\n"
                         + "|| com seu pai, o Rei!                                            ||\n"
                         + "||                                                                ||\n"
                         + "||  O mundo está em perigo, só você pode ajudar...                ||\n"
                         + "##================================================================##");
    }
    
    public static void classe1(){
        System.out.println(
                  "##==========CLASSES==========##\n"
                + "|| 1 - Guerreiro             ||\n"
                + "|| 2 - Mago                  ||\n"
                + "|| Digite a opção desejada:  ||\n"
                + "##===========================##");
    }
    
    public static void itens(int p[]){
        System.out.println(""
                          +"##==========ITENS=========##\n"
                          +"|| 1 - Poção P: "+p[0]+"         ||\n"
                          +"|| 2 - Poção M: "+p[1]+"         ||\n"
                          +"|| 3 - Poção G: "+p[2]+"         ||\n"
                          +"|| 4 - Poção F: "+p[3]+"         ||\n"
                          +"|| 5 - Voltar             ||\n"
                          +"|| Qual você escolhe?     ||\n"
                          +"##========================##");        
    }
    
    public static void menuBatalha(){
        System.out.println("##=======BATALHA========##\n"
                         + "|| 1 - Lançar o dado    ||\n"
                         + "|| 2 - Itens            ||\n"
                         + "|| Digite uma opção:    ||\n"
                         + "##======================##");
    }
   
    public static void fase(int opcaoClasse, int vida, int vidaI, int vidaM, int p[],int auxF, int auxM){
        Random ran = new Random();
        vidaI = 25;
        while(vida > 0 && vidaI > 0){
            
            System.out.println("[///////////////////////////////////////////////////FASE 1///////////////////////////////////////////////////////]\n"
                        + "Inimigo: Guarda do Mr. relliM!");
            //vida inimiga    
            
                System.out.print("Vida do inimigo: [");
                for (int i = 0; i < vidaI; i++){
                    System.out.print("|");
                }
                System.out.println("] "+vidaI);
            //vida do jogador    

                System.out.print("sua vida: [");
                for(int i = 0; i<vida ;i++){
                    System.out.print("|");
                }
                System.out.println("] "+vida);
                
                while(true){
                    try{
                        Scanner s = new Scanner(System.in);
                        menuBatalha();
                        int opcaoBatalha = s.nextInt();
                        if(opcaoBatalha == 1){ //<- INICIO ATACAR
                            
                            int atq = ran.nextInt(20) + 1;
                            System.out.println("O poder do inimigo é: "+atq);

                            int atk = ran.nextInt(20) + 1;
                            System.out.println("O seu poder é: "+atk);

                            vidaI = vidaI - atk;
                            vida = vida - atq;

                            if (vida > 0 && vidaI <= 0){
                                System.out.println("Você Venceu!");

                                int num = ran.nextInt(100)+1;
                                if (num == 1 && num <= 30){
                                    System.out.println("Você conseguiu poção P!");
                                    p[0] += 1;
                                } else if (num >= 31 && num <= 50){
                                    System.out.println("Você conseguiu poção M!");
                                    p[1] += 1;
                                } else if (num >= 51 && num <= 65){
                                    System.out.println("Você conseguiu poção G!");
                                    p[2] += 1;
                                } else if (num >= 66 && num <= 70){
                                    System.out.println("Você conseguiu poção F!");
                                    p[3] += 1;
                                } else {
                                    System.out.println("Você não conseguiu nada!");
                                }

                                fase2(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 2
                                
                            }else if (vida <= 0 && vidaI > 0){
                                System.out.println("Você Perdeu!");
                                break;
                            }else if (vida <= 0 && vidaI <= 0){
                                System.out.println("Você desviou no ultimo momento,"
                                        + " conseguindo escapar com um pouco"
                                        + " de vida ainda!");
                                vida = 5;
                                fase2(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 2
                            }                            
                            
                        }else if(opcaoBatalha == 2){ //<- INICIO USAR ITEM
                            
                            try{
                                itens(p);
                                int opcaoI = s.nextInt();
                                
                                while(opcaoI < 1 || opcaoI > 5){
                                    System.err.println("Digite um valor válido!");
                                    opcaoI = s.nextInt();
                                }
                                
                                if(opcaoI == 1){
                                    if(p[0] > 0){
                                        vida += 20;
                                        p[0] -= 1;
                                        if (vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção P!");
                                    }
                                    
                                }else if(opcaoI == 2){
                                    if(p[1] > 0){
                                        vida += 35;
                                        p[1] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção M!");
                                    }
                                    
                                }else if(opcaoI == 3){
                                    if(p[2] > 0){
                                        vida += 40;
                                        p[2] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção G!");
                                    }
                                    
                                }else if(opcaoI == 4){
                                    if(p[3] > 0){
                                        if(opcaoClasse == 1){
                                            vida = 120;
                                            p[3] -= 1;
                                        }else if(opcaoClasse == 2){
                                            vida = vidaM;
                                            p[3] -= 1;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção F!");
                                    }
                                    
                                } //<- FIM USAR ITEM
                                
                                break;
                            }catch(InputMismatchException e){
                                System.err.println("Digite um numero!");
                            }
                            
                            
                        }else if(opcaoBatalha > 2 || opcaoBatalha < 1){
                                System.err.println("Digite um opção válida!");
                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um numero!");
                    }
                    
                }
                
        } // FIM DE WHILE
        
    }
    
    public static void fase2(int opcaoClasse, int vida, int vidaI, int vidaM, int p[],int auxF, int auxM){
        Random ran = new Random();
        vidaI = 50;
        while(vida > 0 && vidaI > 0){
            
            System.out.println("[///////////////////////////////////////////////////FASE 2///////////////////////////////////////////////////////]\n"
                        + "Inimigo: Drogo Kan");
            //vida inimiga    

                System.out.print("Vida do inimigo: [");
                for (int i = 0; i < vidaI; i++){
                    System.out.print("|");
                }
                System.out.println("] "+vidaI);
            //vida do jogador    

                System.out.print("sua vida: [");
                for(int i = 0; i<vida ;i++){
                    System.out.print("|");
                }
                System.out.println("] "+vida);
                
                while(true){
                    try{
                        Scanner s = new Scanner(System.in);
                        menuBatalha();
                        int opcaoBatalha = s.nextInt();
                        if(opcaoBatalha == 1){ //<- INICIO ATACAR
                            
                            int atq = ran.nextInt(20) + 1;
                            System.out.println("O poder do inimigo é: "+atq);

                            int atk = ran.nextInt(20) + 1;
                            System.out.println("O seu poder é: "+atk);

                            vidaI = vidaI - atk;
                            vida = vida - atq;

                            if (vida > 0 && vidaI <= 0){
                                System.out.println("Você Venceu!");

                                int num = ran.nextInt(100)+1;
                                if (num == 1 && num <= 30){
                                    System.out.println("Você conseguiu poção P!");
                                    p[0] += 1;
                                } else if (num >= 31 && num <= 50){
                                    System.out.println("Você conseguiu poção M!");
                                    p[1] += 1;
                                } else if (num >= 51 && num <= 65){
                                    System.out.println("Você conseguiu poção G!");
                                    p[2] += 1;
                                } else if (num >= 66 && num <= 70){
                                    System.out.println("Você conseguiu poção F!");
                                    p[3] += 1;
                                } else {
                                    System.out.println("Você não conseguiu nada!");
                                }

                                fase3(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 3
                                
                            }else if (vida <= 0 && vidaI > 0){
                                System.out.println("Você Perdeu!");
                                break;
                            }else if (vida <= 0 && vidaI <= 0){
                                System.out.println("Com muita sorte você"
                                        + "conseguiu sobreviver...");
                                vida = 10;
                                fase3(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 3
                            } 
                                                        
                            
                        }else if(opcaoBatalha == 2){ //<- INICIO USAR ITEM
                            
                            try{
                                itens(p);
                                int opcaoI = s.nextInt();
                                
                                while(opcaoI < 1 || opcaoI > 5){
                                    System.err.println("Digite um valor válido!");
                                    opcaoI = s.nextInt();
                                }
                                
                                if(opcaoI == 1){
                                    if(p[0] > 0){
                                        vida += 20;
                                        p[0] -= 1;
                                        if (vida > vidaM && opcaoClasse == 1){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 2){
                                            vida = 120;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção P!");
                                    }
                                    
                                }else if(opcaoI == 2){
                                    if(p[1] > 0){
                                        vida += 35;
                                        p[1] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if (vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção M!");
                                    }
                                    
                                }else if(opcaoI == 3){
                                    if(p[2] > 0){
                                        vida += 40;
                                        p[2] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção G!");
                                    }
                                    
                                }else if(opcaoI == 4){
                                    if(p[3] > 0){
                                        if(opcaoClasse == 1){
                                            p[3] -= 1;
                                            vida = 120;
                                        }else if(opcaoClasse == 2){
                                            p[3] -= 1;
                                            vida = vidaM;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção F!");
                                    }
                                    
                                } //<- FIM USAR ITEM
                                
                                break;
                            }catch(InputMismatchException e){
                                System.err.println("Digite um numero!");
                            }
                            
                            
                        }else if(opcaoBatalha > 2 || opcaoBatalha < 1){
                                System.err.println("Digite um opção válida!");

                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um numero!");
                    }
                    
                }
                
        } // FIM DE WHILE
        
    }

    public static void fase3(int opcaoClasse, int vida, int vidaI, int vidaM, int p[],int auxF, int auxM){
        Random ran = new Random();
        vidaI = 75;
        while(vida > 0 && vidaI > 0){
            
            System.out.println("[///////////////////////////////////////////////////FASE 3///////////////////////////////////////////////////////]\n"
                        + "Inimigo: Ciclope!");
            //vida inimiga    

                System.out.print("Vida do inimigo: [");
                for (int i = 0; i < vidaI; i++){
                    System.out.print("|");
                }
                System.out.println("] "+vidaI);
            //vida do jogador    

                System.out.print("sua vida: [");
                for(int i = 0; i<vida ;i++){
                    System.out.print("|");
                }
                System.out.println("] "+vida);
                
                while(true){
                    try{
                        Scanner s = new Scanner(System.in);
                        menuBatalha();
                        int opcaoBatalha = s.nextInt();
                        if(opcaoBatalha == 1){ //<- INICIO ATACAR
                            
                            int atq = ran.nextInt(20) + 1;
                            System.out.println("O poder do inimigo é: "+atq);

                            int atk = ran.nextInt(20) + 1;
                            System.out.println("O seu poder é: "+atk);

                            vidaI = vidaI - atk;
                            vida = vida - atq;

                            if (vida > 0 && vidaI <= 0){
                                System.out.println("Você Venceu!");

                                int num = ran.nextInt(100)+1;
                                if (num == 1 && num <= 30){
                                    System.out.println("Você conseguiu poção P!");
                                    p[0] += 1;
                                } else if (num >= 31 && num <= 50){
                                    System.out.println("Você conseguiu poção M!");
                                    p[1] += 1;
                                } else if (num >= 51 && num <= 65){
                                    System.out.println("Você conseguiu poção G!");
                                    p[2] += 1;
                                } else if (num >= 66 && num <= 70){
                                    System.out.println("Você conseguiu poção F!");
                                    p[3] += 1;
                                } else {
                                    System.out.println("Você não conseguiu nada!");
                                }
    
                            fase4(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 4
                            }else if (vida <= 0 && vidaI > 0){
                                System.out.println("Você Perdeu!");
                                break;
                            }else if (vida <= 0 && vidaI <= 0){
                                System.out.println("Você foi abençoado pela esperança das pessoas da vila!\n"
                                        + "Conseguindo assim, sobreviver a essa batalha!");
                                vida = 10;
                                fase4(opcaoClasse, vida,vidaI, vidaM, p, auxF, auxM); // <- CHAMADA DA FASE 4
                            } 
                             
                        }else if(opcaoBatalha == 2){ //<- INICIO USAR ITEM
                            
                            try{
                                itens(p);
                                int opcaoI = s.nextInt();
                                
                                while(opcaoI < 1 || opcaoI > 5){
                                    System.err.println("Digite um valor válido!");
                                    opcaoI = s.nextInt();
                                }
                                
                                if(opcaoI == 1){
                                    if(p[0] > 0){
                                        vida += 20;
                                        p[0] -= 1;
                                        if (vida > vidaM){
                                            vida = vidaM;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção P!");
                                    }
                                    
                                }else if(opcaoI == 2){
                                    if(p[1] > 0){
                                        vida += 35;
                                        p[1] -= 1;
                                        if(vida > vidaM){
                                            vida = vidaM;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção M!");
                                    }
                                    
                                }else if(opcaoI == 3){
                                    if(p[2] > 0){
                                        vida += 40;
                                        p[2] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção G!");
                                    }
                                    
                                }else if(opcaoI == 4){
                                    if(p[3] > 0){
                                        if(opcaoClasse == 1){
                                            p[3] -= 1;
                                            vida = 120;
                                        }else if(opcaoClasse == 2){
                                            p[3] -= 1;
                                            vida = vidaM;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção F!");
                                    }
                                    
                                } //<- FIM USAR ITEM
                                
                                break;
                            }catch(InputMismatchException e){
                                System.err.println("Digite um numero!");
                            }
                            
                            
                        }else if(opcaoBatalha > 2 || opcaoBatalha < 1){
                                System.err.println("Digite um opção válida!");
                            
                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um numero!");
                    }
                    
                }
                
        } // FIM DE WHILE
        
    }

    public static void fase4(int opcaoClasse, int vida, int vidaI, int vidaM, int p[], int auxF, int auxM){
        Random ran = new Random();
        vidaI = 100;
        while(vida > 0 && vidaI > 0){
            
            System.out.println("[////////////////////////////////////////////////FINAL STAGE/////////////////////////////////////////////////////]\n"
                        + "Inimigo: Mr. relliM!");
            //vida inimiga    

                System.out.print("Vida do inimigo: [");
                for (int i = 0; i < vidaI; i++){
                    System.out.print("|");
                }
                System.out.println("] "+vidaI);
            //vida do jogador    

                System.out.print("sua vida: [");
                for(int i = 0; i<vida ;i++){
                    System.out.print("|");
                }
                System.out.println("] "+vida);
                
                while(true){
                    try{
                        Scanner s = new Scanner(System.in);
                        menuBatalha();
                        int opcaoBatalha = s.nextInt();
                        if(opcaoBatalha == 1){ //<- INICIO ATACAR
                            
                            int atq = ran.nextInt(20) + 1;
                            System.out.println("O poder do inimigo é: "+atq);

                            int atk = ran.nextInt(20) + 1;
                            System.out.println("O seu poder é: "+atk);

                            vidaI = vidaI - atk;
                            vida = vida - atq;
                            
                            if(vida < 50 && auxF == 1){
                                while(true){
                                    try{
                                        s = new Scanner(System.in);
                                        System.out.println("##==========================##\n"
                                                     + "|| Usar habilidade secreta? ||\n"
                                                     + "|| 1 - Sim          2 - Não ||\n"
                                                     + "##==========================##");
                                        int opcaoHab = s.nextInt();
                                        while(opcaoHab < 1 || opcaoHab > 2){
                                            System.err.println("Digite uma opção Válida!");
                                            opcaoHab = s.nextInt();
                                        }
                                        if(opcaoHab == 1){
                                            auxF -= 1;
                                            vidaI /= 2;
                                        }else if(opcaoHab == 2){
                                            
                                        }
                                    break;
                                    }catch(InputMismatchException e){
                                        System.err.println("Digite um numero!");
                                    }
                                }
                            }else if(vida <= 0 && vidaI <= 0){
                                System.out.println("O grande Mr. relliM, acabou sobrevivendo a batalha!\n"
                                        + "Será que foi tudo em vão?!\n"
                                        + "Você vai deixar assim, ou vai tentar novamente?!");
                                while(true){
                                    try{
                                        s = new Scanner(System.in);
                                        System.out.println(""
                                            + "##======CONTINUAR?======##\n"
                                            + "|| 1 - Sim      2 - Não ||\n"
                                            + "##======================##");
                                        int opcaoCont = s.nextInt();
                                        while(opcaoCont < 1 || opcaoCont > 2){
                                            System.err.println("Digite uma opção válida!");
                                            opcaoCont = s.nextInt();
                                        }
                                        if(opcaoCont == 1){
                                            vida = 120;
                                            fase(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM);
                                        }else if(opcaoCont == 2){
                                            System.out.println(""
                                                    + "##============##\n"
                                                    + "|| GAME OVER! ||\n"
                                                    + "##============##");
                                            break;
                                        }
                                        break;
                                    }catch(InputMismatchException e){
                                        System.err.println("Digite um número!");
                                    }
                                    
                                }
                            }else if (vida > 0 && vidaI <= 0){
                                System.out.println(""
                                        + "##=================================================##\n"
                                        + "|| Você Venceu!                                    ||\n"
                                        + "|| Parabéns, você derrotou o poderoso Mr. relliM!  ||\n"
                                        + "|| A princesa e o Rei foram libertados!            ||\n"
                                        + "|| Agora o reino está em paz!                      ||\n"
                                        + "##=================================================##");
                                System.out.println(""
                                        + "##============##\n"
                                        + "|| GAME OVER! ||\n"
                                        + "##============##");
                                
                                if(auxM == 1){
                                    while(true){
                                        try{
                                        s = new Scanner(System.in);    

                                        System.out.println("Digite seu nome, Poderoso(a) Mago(a):");
                                        String nome = s.nextLine();
                                        System.out.println("Agora digite a data de hoje:\n"
                                                + "Com'/', por favor...\n"
                                                + "(formato: DD/MM/AAAA)");
                                        String data = s.nextLine();
                                        Jogadores(nome, data);
                                        break;    

                                        }catch(IOException e){
                                            System.err.println("Erro!");
                                        }
                                    }
                                    
                                    while(true){
                                        try{
                                            s = new Scanner(System.in);
                                            System.out.println(""
                                                + "##===========================================##\n"
                                                + "||Deseja saber quem foram seus antepessados? ||\n"
                                                + "|| 1 - Sim                         2 - Não   ||\n"
                                                + "##===========================================##");
                                            int opcao = s.nextInt();
                                            while(opcao < 1 || opcao > 2){
                                                System.err.println("Digite uma opção válida!");
                                                opcao = s.nextInt();
                                            }
                                            if(opcao == 1){
                                                Ler();
                                                break;
                                            }else if(opcao == 2){
                                                break;
                                            }
                                            break;
                                        }catch(InputMismatchException e){
                                            System.err.println("Digite um número!");
                                        }catch(IOException e){
                                            System.err.println("Erro!");
                                        }
                                    }
                                    
                                }else if(auxM == 0){
                                    while(true){
                                        try{
                                        s = new Scanner(System.in);    

                                        System.out.println("Digite seu nome, Nobre(a) Guerreiro(a):");
                                        String nome = s.nextLine();
                                        System.out.println("Agora digite a data de hoje:\n"
                                                + "Com'/', por favor...\n"
                                                + "(formato: DD/MM/AAAA)");
                                        String data = s.nextLine();
                                        Jogadores(nome, data);
                                        break;    

                                        }catch(IOException e){
                                            System.err.println("Erro!");
                                        }
                                    }
                                    
                                    while(true){
                                        try{
                                            s = new Scanner(System.in);
                                            System.out.println(""
                                                + "##===========================================##\n"
                                                + "||Deseja saber quem foram seus antepessados? ||\n"
                                                + "|| 1 - Sim                         2 - Não   ||\n"
                                                + "##===========================================##");
                                            int opcao = s.nextInt();
                                            while(opcao < 1 || opcao > 2){
                                                System.err.println("Digite uma opção válida!");
                                                opcao = s.nextInt();
                                            }
                                            if(opcao == 1){
                                                Ler();
                                                break;
                                            }else if(opcao == 2){
                                                break;
                                            }
                                            break;
                                        }catch(InputMismatchException e){
                                            System.err.println("Digite um número!");
                                        }catch(IOException e){
                                            System.err.println("Erro!");
                                        }
                                    }       
                                    
                                }
                                
                            }else if(vida <= 0 && vidaI > 0){
                                System.out.println("Voce perdeu!");
                                break;
                            }                            
                            
                        }else if(opcaoBatalha == 2){ //<- INICIO USAR ITEM
                            
                            try{
                                itens(p);
                                int opcaoI = s.nextInt();
                                
                                while(opcaoI < 1 || opcaoI > 5){
                                    System.err.println("Digite um valor válido!");
                                    opcaoI = s.nextInt();
                                }
                                
                                if(opcaoI == 1){
                                    if(p[0] > 0){
                                        vida += 20;
                                        p[0] -= 1;
                                        if (vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if (vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                        
                                    }else{
                                        System.out.println("Você não tem poção P!");
                                    }
                                    
                                }else if(opcaoI == 2){
                                    if(p[1] > 0){
                                        vida += 35;
                                        p[1] -= 1;
                                        if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }else if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção M!");
                                    }
                                    
                                }else if(opcaoI == 3){
                                    if(p[2] > 0){
                                        vida += 40;
                                        p[2] -= 1;
                                        if(vida > 120 && opcaoClasse == 1){
                                            vida = 120;
                                        }else if(vida > vidaM && opcaoClasse == 2){
                                            vida = vidaM;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção G!");
                                    }
                                    
                                }else if(opcaoI == 4){
                                    if(p[3] > 0){
                                        if(opcaoClasse == 1){
                                            p[3] -= 1;
                                            vida = 120;
                                        }else if(opcaoClasse == 2){
                                            p[3] -= 1;
                                            vida = vidaM;
                                        }
                                    }else{
                                        System.out.println("Você não tem poção F!");
                                    }
                                    
                                } //<- FIM USAR ITEM
                                
                                break;
                            }catch(InputMismatchException e){
                                System.err.println("Digite um numero!");
                            }
                            
                            
                        }else if(opcaoBatalha > 2 || opcaoBatalha < 1){
                            System.err.println("Digite um opção válida!");
                            
                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um numero!");
                    }
                    
                }
                
        } // FIM DE WHILE
        
    }
 
    public static void Jogadores(String Nome, String Data)throws IOException{
        FileWriter wr = new FileWriter ("Nome_Dos_Jogadores.txt", true);
        wr.write(Nome);
        wr.write(" "+Data);
        wr.write("\n");
        wr.close();
    }
    
    public static void Ler()throws IOException{
        String nome = "Nome_Dos_Jogadores.txt";
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);
        
        String linha = lerArq.readLine();
        
        while (linha != null) {
            System.out.println(linha);
 
            linha = lerArq.readLine();
            
        }        
        arq.close();
    }
    
    public static void main(String[] args){
    
        Scanner s = new Scanner(System.in);
        Random ran = new Random();
        //VAR AUXILIARES
        int auxF = 0, auxM = 0;
        int aux = 0;
        
        //OPCOES
        int opcaoMenu, opcaoClasse = 0;
        
        //VIDAS INIMIGO & PLAYER
        int vida = 100, vidaM = 100;
        int vidaI = 25;
        
        //POCOES    
        int [] p = new int[4];//<- P = 20, M = 35, G = 40, F = Todo o Life
        
//===============INICIO===============\\
    
        while(true){
            
            try{
                s = new Scanner(System.in);
                
                menu();
                opcaoMenu = s.nextInt();
                
                //if(opcaoMenu > 3 || opcaoMenu < 1){
                    while(opcaoMenu > 3 || opcaoMenu < 1){
                        System.err.println("Digite uma valor válido!");
                        opcaoMenu = s.nextInt();
                    }
                //}
                
                break;
            }catch(InputMismatchException e){
                System.err.println("Digite um número!");
            }
            
        } // <- FIM WHILE TRY CATCH


        while(opcaoMenu != 3){

            if (opcaoMenu == 1){
                Historia();    
                while(true){

                    try{
                        s = new Scanner(System.in);   

                        classe1();
                        opcaoClasse = s.nextInt();

                        while(opcaoClasse < 1 || opcaoClasse > 2){
                            System.err.println("Digite um valor válido!");
                            opcaoClasse = s.nextInt();
                        }

                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um número!");
                    }

                }
                    
            break;     
            }else if(opcaoMenu == 2){ //<- INSTRUÇÕES
                Instrucao();
                while(true){
                    try{
                        s = new Scanner(System.in);
                        System.out.println("##================================##\n"
                                 + "|| Deseja voltar pro jogo ou não? ||\n"
                                 + "||  1 - Sim             2 - Não   ||\n"
                                 + "##================================##");
                        int opcaoIns = s.nextInt();
                        while(opcaoIns < 1 || opcaoIns > 2){
                            System.err.println("Digite uma opção válida!");
                            opcaoIns = s.nextInt();
                        }
                        if(opcaoIns == 1){
                            opcaoMenu = 1;
                        }else if (opcaoIns == 2){
                            System.out.println("Saindo...");
                            opcaoMenu = 3;
                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um número!");
                    }
                    
                }
            }else if(opcaoMenu == 3){ //<- SAIR DO JOGO
                System.out.println("Você Saiu do Jogo");
                break;
            }else{ // <- CASO DIGITE ERRADO
                while(true){
                    try{
                        s = new Scanner(System.in);
                        while(opcaoMenu > 2 || opcaoMenu < 1){
                            System.err.println("Digite uma opção válida!");
                            opcaoMenu = s.nextInt();
                        }
                        break;
                    }catch(InputMismatchException e){
                        System.err.println("Digite um numero!");
                    }
                }
            }
            
            
        }// <- FIM WHILE TRY CATCH  
        
        if (opcaoClasse == 1){
            vida = 120;
            fase(opcaoClasse,vida, vidaI, vidaM, p, auxF, auxM);

        }else if (opcaoClasse == 2){
            auxF = 1;
            auxM = 1;
            fase(opcaoClasse, vida, vidaI, vidaM, p, auxF, auxM);
            
        }
    
    }
    
}
