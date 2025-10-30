import java.util.Map;

public class HtmlSelfClosingElement implements HtmlNode {
    private final String tagName;
    private final Map<String, String> attributes;

    public HtmlSelfClosingElement(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public String toHtmlString(int indentLevel) {
        String ind = HtmlUtils.indent(indentLevel);
        String attrs = HtmlUtils.formatAttributes(attributes);
        return String.format("%s<%s%s />%n", ind, tagName, attrs);
    }
}
