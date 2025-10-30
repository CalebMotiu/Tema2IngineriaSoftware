import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlElement implements HtmlNode {
    private final String tagName;
    private final Map<String, String> attributes = new HashMap<>();
    private final List<HtmlNode> children = new ArrayList<>();
    private final boolean allowChildren;
    private boolean inline = false; 
    public HtmlElement(String tagName) {
        this(tagName, true);
    }

    public HtmlElement(String tagName, boolean allowChildren) {
        this.tagName = tagName;
        this.allowChildren = allowChildren;
    }

    public HtmlElement setInline(boolean inline) {
        this.inline = inline;
        return this;
    }

    public HtmlElement addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    public HtmlElement addChild(HtmlNode child) {
        if (!allowChildren) {
            throw new UnsupportedOperationException("Tagul <" + tagName + "> nu permite copii.");
        }
        children.add(child);
        return this;
    }

    public HtmlElement addText(String text) {
        return addChild(new HtmlText(text));
    }

    public List<HtmlNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toHtmlString(int indentLevel) {
        StringBuilder sb = new StringBuilder();
        String ind = HtmlUtils.indent(indentLevel);
        String attrs = HtmlUtils.formatAttributes(attributes);
        boolean hasChildren = !children.isEmpty();

        sb.append(ind).append("<").append(tagName).append(attrs).append(">");

        if (hasChildren) {
            sb.append("\n");
            for (HtmlNode child : children) {
                if (inline && child instanceof HtmlText) {
                    sb.append(HtmlUtils.indent(indentLevel + 1))
                      .append(((HtmlText) child).toHtmlString(0).trim())
                      .append("\n");
                } else {
                    sb.append(child.toHtmlString(indentLevel + 1));
                }
            }
            sb.append(ind);
        }

        sb.append("</").append(tagName).append(">\n");
        return sb.toString();
    }



}
