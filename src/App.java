import java.util.List;
import java.net.URL;
import java.io.InputStream;



public class App {
    public static void main(String[] args) throws Exception {

        // Conexão HTTP e buscar dados de API
        String url = "https://api.nasa.gov/planetary/apod?api_key=kteptv3dSLfNZgnctiXBmXkp14u9FGziTDHNskG3&start_date=2022-01-01&end_date=2022-01-05";
        
        var http = new clientHTTP();
        String json = http.buscaDados(url);
        
        ExtratorDeConteudo extrator = new ExtratorDeConteudoNASA();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        //Exibir dados
        for (int i = 0;  i < 5; i++) {

            Conteudo conteudo = conteudos.get(i);
             
            InputStream input = new URL(conteudo.getUrlImage()).openStream();

            String nomeArquivo = "images/" + conteudo.getTitle() + ".png";

            var gerador = new GeradorFigurinhas();
            gerador.cria(input, nomeArquivo);

            System.out.println(conteudo.getTitle());
        }
    }
}
