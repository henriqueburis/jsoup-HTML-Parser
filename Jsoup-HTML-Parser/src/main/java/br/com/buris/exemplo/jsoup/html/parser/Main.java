/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.buris.exemplo.jsoup.html.parser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Luiz Henrique Buris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Document doc;

        try {
            // passando http protocolo
            doc = Jsoup.connect("http://google.com").get();

            // pegando o titulo da paginas do google  como passdo acima.
            String title = doc.title();
            System.out.println("title : " + title);

            // pegando todos os links da pagina do google, assim vai ser criado uma lista de links que tera que ser varrida.
            Elements links = doc.select("a[href]");

            // neste laço serà feito a varredura dos href adcionado no elemento links do tipo elements.
            for (Element link : links) {

                // obter o valor do atributo href
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());

            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
