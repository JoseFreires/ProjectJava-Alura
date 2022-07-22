import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradorFigurinhas {

    /**
     * @throws Exception
     */
    public void cria(InputStream input, String nomeArquivo) throws Exception{

        // ler imagem
        // InputStream input = new URL("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@.jpg").openStream();
        // InputStream inputStream = new FileInputStream(new File("image/filme.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(input);
        // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"))

        // criar nova imagem/novo tamanho/transparente (em memória)
        int altura = imagemOriginal.getHeight();
        int largura = imagemOriginal.getWidth();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        //copiar imagem para nova imagem (em memória)
        Graphics graphics = novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.MONOSPACED , Font.BOLD, 44 );
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        // escrever na imagem
        graphics.drawString("Eita, a NASA.", 500, novaAltura - 100);

        // escrever  nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
