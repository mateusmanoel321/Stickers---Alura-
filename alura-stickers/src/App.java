import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e buscar os Top Filmes do site escolhido
       //  String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
         //ExtratorDeConteudo extrator =  new ExtratorDeConteudoDoIMDB();


      // String url = "https://api.nasa.gov/planetary/apod?api_key=QRAP4yzWgXBE9tES926C3KMcd2vTJFoJI1yybnju&start_date=2022-06-12&end_date=2022-06-14";
       // ExtratorDeConteudo extrator =  new ExtratorDeConteudoDaNasa();

       String url = "http://localhost:8080/linguagens";
       ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();



       var http = new ClienteHttp();
       String json = http.buscaDados(url);
       
        // exibir e manipular dados
       
       List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 2; i++) {
            Conteudo conteudo = conteudos.get(i);
           
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());

        }
    }

}
