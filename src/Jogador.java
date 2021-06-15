import java.util.Scanner;

public class Jogador
{
    private Mapa mapa;
    private final char letra = 'X';
    
    public Jogador(Mapa mapa) 
    {
        this.mapa = mapa;
    }
    
    public boolean jogar(Scanner teclado) 
    {
        while (!this.mapa.verificarGanhador(this.letra)) 
        {
            System.out.println("Jogador ..");

            System.out.print("  linha: ");
            int l = teclado.nextInt();
            System.out.print("  coluna: ");
            int c = teclado.nextInt();

            if (l >= 0 && l <= 2 && c >= 0 && c <= 2) 
            {
                if (this.mapa.jogar(l, c, this.letra)) 
                    break;
                
                System.out.println(" posição inválida!");
            }
        }
        if (this.mapa.verificarGanhador(this.letra)) 
        {
            System.out.println(" ... Jogador GANHOU!");
            return true;
        }

        return false;
    }
}
