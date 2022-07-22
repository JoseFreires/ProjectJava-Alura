import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeConteudoIMDB implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String json){
        var parser = new JavaParse();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de coneudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String title = atributos.get("title");
            String urlImage = atributos.get("image");
            var conteudo = new Conteudo(title, urlImage);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
