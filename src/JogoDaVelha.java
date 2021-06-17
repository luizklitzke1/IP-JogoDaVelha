import java.util.Scanner;

public class JogoDaVelha {
    private Mapa jogoMapa;
    private PC jogoPC;
    private Jogador jogoJogador; 

    private JogoDaVelha()
    {
        Scanner teclado = new Scanner(System.in);

        this.jogoMapa = new Mapa();
        this.jogoPC = new PC(this.jogoMapa);
        this.jogoJogador = new Jogador(this.jogoMapa);

        char continuar;

        do
        {
            //Chama uma rodada e espera acabar
            this.jogar(teclado);

            System.out.println("________________________");
            System.out.println("Deseja jogar novamente (s/n)? ");

            continuar = teclado.next().charAt(0);
        }
        while (continuar != 'n');

        System.out.println("--- FIM ---");

        teclado.close();
    }

    private void jogar(Scanner teclado)
    {
        this.jogoMapa.limpar(); //Começa o mapa limpo

        //Define quem vai começar, se sortear 1 o PC Começa;
        boolean PCJoga = (this.jogoMapa.sortear(0, 2) == 1);

        boolean empate = true;
        
        int jogada = 0;

        this.jogoMapa.desenhar(jogada);

        while (jogada < 9)
        {
            ++jogada;

            if (PCJoga)
            {
                //Verifica se o PC ganha
                if(this.jogoPC.jogar())
                {
                    empate = false;
                    break;
                }
            }
            else
            {
                //Verifica se o Jogador ganha
                if (this.jogoJogador.jogar(teclado))
                {
                    empate = false;
                    break;
                }
            }
            
            this.jogoMapa.desenhar(jogada);

            PCJoga = !PCJoga;
        }

        this.jogoMapa.desenhar(jogada);

        if (empate)
            System.out.println(" ... EMPATOU!");
    }

    public static void main(String[] args) throws Exception 
    {
        new JogoDaVelha();
    }
}
