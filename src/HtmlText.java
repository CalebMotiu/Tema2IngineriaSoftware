public class HtmlText implements HtmlNode {
    private final String text;

    public HtmlText(String text) {
        this.text = text;
    }

    @Override
    public String toHtmlString(int indentLevel) {
        String ind = HtmlUtils.indent(indentLevel);
        return ind + HtmlUtils.escapeText(text) + "\n";
    }

    @Override
    public String toString() {
        return text;
    }
}
