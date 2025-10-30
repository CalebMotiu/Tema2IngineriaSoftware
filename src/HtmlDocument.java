import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
    private final List<HtmlNode> children = new ArrayList<>();

    public HtmlDocument addChild(HtmlNode node) {
        children.add(node);
        return this;
    }

    public String toHtmlString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n");
        sb.append("<html>\n");
        for (HtmlNode n : children) {
            sb.append(n.toHtmlString(1));
        }
        sb.append("</html>\n");
        return sb.toString();
    }

    public void writeToFile(Path path) throws IOException {
        Files.writeString(path, toHtmlString());
    }

    public void printToConsole() {
        System.out.println(toHtmlString());
    }
}
