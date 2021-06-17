import java.util.Scanner;

public class Jogador
{
    private final char letra = 'X';
    private Mapa mapa;
    
    //Define o mapa na criação
    public Jogador(Mapa mapa) 
    {
        this.mapa = mapa;
    }
    
    public boolean jogar(Scanner teclado) 
    {
        int l;
        int c;

        do
        {
            System.out.println("Jogador ..");

            System.out.print("  linha: ");
            l = teclado.nextInt();
            
            System.out.print("  coluna: ");
            c = teclado.nextInt();

            if (l >= 0 && l <= 2 && c >= 0 && c <= 2) 
            {
                if (this.mapa.jogar(l, c, this.letra)) 
                    break;
                
                System.out.println(" posição inválida!");
            }
        }
        while(!this.mapa.jogar(l, c, this.letra));

        if (this.mapa.verificarGanhador(this.letra)) 
        {
            System.out.println(" ... Jogador GANHOU!");
            return true;
        }

        return false;
    }
}
