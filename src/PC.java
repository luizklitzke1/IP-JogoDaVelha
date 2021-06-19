public class PC {
    private final char letra = 'O';
    private Mapa mapa;

    //Define o mapa na criação
    public PC(Mapa mapa)
    {
        this.mapa = mapa;
    }

    public boolean jogar()
    {
        int l;
        int c;
        
        do
        {
            l = this.mapa.sortear(0, 3);
            c = this.mapa.sortear(0, 3);    
        }
        while(!this.mapa.jogar(l, c, this.letra));

        System.out.println("PC[" + l + "," + c + "]");

        if(this.mapa.verificarGanhador(this.letra))
        {
            System.out.println(" ... PC GANHOU!");
            return true;
        }

        return false;
    }
}
