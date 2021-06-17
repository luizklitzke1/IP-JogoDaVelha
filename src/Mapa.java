public class Mapa {
    private char[][] mapa = new char[3][3];

    //Função dada pelo professor
    public int sortear(int inicio, int fim) 
    {
        return (int) ((Math.random() * fim) - inicio);
    }
    
    public void limpar()
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
                this.mapa[i][j] = ' ';
        }
    }

    public void desenhar(int jogada) 
    {
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + this.mapa[0][0] + " | " + this.mapa[0][1] + " | " + this.mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + this.mapa[1][0] + " | " + this.mapa[1][1] + " | " + this.mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + this.mapa[2][0] + " | " + this.mapa[2][1] + " | " + this.mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    public boolean jogar(int l, int c, char jogador)
    {
        //Evitar que saia do range da matriz
        if (l < 0 || l > 2 || c < 0 || c > 2) 
            return false;

        if (this.mapa[l][c] == ' ')
        {
            this.mapa[l][c] = jogador;

            return true;
        }

        return false;
    }

    public boolean verificarGanhador(char jogador)
    {
        //Verifica a diagonal principal
        if (this.mapa[0][0] == jogador && this.mapa[1][1] == jogador && this.mapa[2][2] == jogador)
            return true;

        //Verifica a diagonal secundaria
        if (this.mapa[0][2] == jogador && this.mapa[1][1] == jogador && this.mapa[2][0] == jogador)
            return true;  

        //Verifica as linhas
        for (int i = 0; i < 3; ++i)
        {
            if ((this.mapa[i][0] == jogador && this.mapa[i][1] == jogador && this.mapa[i][2] == jogador) || //Horizontal
                (this.mapa[0][i] == jogador && this.mapa[1][i] == jogador && this.mapa[2][i] == jogador)) //Vertical
                return true;
        }

        return false;
    }
    
}
