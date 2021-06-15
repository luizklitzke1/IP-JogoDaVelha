import java.util.Scanner;

public class JogoDaVelha {
    private Mapa jogoMapa;
    private PC jogoPC;
    private Jogador jogoJogador; 

    private JogoDaVelha()
    {
        Scanner teclado = new Scanner(System.in);

        this.jogoMapa = new Mapa();
        this.jogoPC = new PC(this.mapa);
        this.jogoJogador = new Jogador(this.mapa);

        char opcaoContinuar;

        do
        {
            //Chama uma rodada e espera acabar
            this.jogar(teclado);

            System.out.println("Deseja jogar novamente (s/n)? ");
            System.out.println("________________________");
            opcaoContinuar = teclado.next().charAt(0);
        }
        while (opcaoContinuar != 'n');

        System.out.println("--- FIM ---");
        teclado.close();
    }

    private void jogar(Scanner teclado)
    {
        this.jogoMapa.limpar(); //Começa o mapa limpo

        //Define quem vai começar, se sortear 1 o PC Começa;
        boolean PCJoga = (this.jogoMapa.sortear(0, 2) == 1);

        int jogada = 0;

        while (jogada < 9)
        {
            if (PCJoga)
                this.jogoPC.jogar();
            else
                this.jogoJogador.jogar(teclado);

            this.jogoMapa.desenhar(jogada);

            //Verifica se está na ultima jogada e ninguem ganhou ainda para empatar
            if (jogada == 8 && (!this.jogoMapa.verificarGanhador(this.jogoJogador.letra) && !this.jogoMapa.verificarGanhador(this.jogoPC.letra)))
                System.out.println(" ... EMPATOU!");

            PCJoga = !PCJoga;
        }
    }

    public static void main(String[] args) throws Exception {
        new JogoDaVelha();
    }
}
