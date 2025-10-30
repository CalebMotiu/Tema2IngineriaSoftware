import java.nio.file.Path;
import java.util.Map;

public class ExampleMain {
    public static void main(String[] args) throws Exception {
        HtmlDocument doc = new HtmlDocument();

        HtmlElement head = new HtmlElement("head");
        HtmlNode  metaCharset = new HtmlSelfClosingElement("meta", Map.of("charset", "utf-8"));
        head.addChild(metaCharset);
        head.addChild(new HtmlElement("title").addText("Exemplu Document"));

        HtmlElement body = new HtmlElement("body");
        HtmlElement header = new HtmlElement("header").addChild(new HtmlElement("h1").addText("Titlul meu"));
        body.addChild(header);

        HtmlElement p = new HtmlElement("p").addText("Acesta este un paragraf cu ");
        HtmlElement strong = new HtmlElement("strong").setInline(true).addText("text îngroșat");
        p.addChild(strong);
        p.addText(" și continuă aici.");

        HtmlSelfClosingElement img = new HtmlSelfClosingElement("img",
                Map.of("src", "images/picture.jpg", "alt", "descriere"));

        HtmlSelfClosingElement input = new HtmlSelfClosingElement("input", Map.of("type", "text", "name", "nume"));

        body.addChild(p);
        body.addChild(img);
        body.addChild(new HtmlSelfClosingElement("br", Map.of()));
        body.addChild(input);

        doc.addChild(head);
        doc.addChild(body);

        doc.printToConsole();

        Path out = Path.of("exemplu.html");
        doc.writeToFile(out);
        System.out.println("Scris în: " + out.toAbsolutePath());
    }
}
