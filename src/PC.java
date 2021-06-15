public class PC
{
    private Mapa mapa;
    private final char letra = 'O';

    public PC(final Mapa mapa){
        this.mapa = mapa;
    }

    public boolean jogar(){
        int l;
        int c;
        
        do
        {
            l = this.mapa.sortear(0, 3);
            c = this.mapa.sortear(0, 3);    
        }
        while(!this.mapa.jogar(l, c, 'O'));

        System.ou.println("PC[" + l + "," + c + "]")

        if(this.mapa.ganhou('O'))
        {
            System.out.println(" ... PC GANHOU!");
            return true;
        }
    }
    return false;
}