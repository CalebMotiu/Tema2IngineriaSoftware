import java.util.Map;
import java.util.StringJoiner;

public final class HtmlUtils {
    private HtmlUtils() {}

    public static String indent(int level) {
        return "    ".repeat(Math.max(0, level)); // 4 spații per nivel
    }

    public static String formatAttributes(Map<String, String> attrs) {
        if (attrs == null || attrs.isEmpty()) return "";
        StringJoiner sj = new StringJoiner(" ", " ", "");
        attrs.forEach((k, v) -> {
            if (v == null) sj.add(k);
            else sj.add(k + "=\"" + escapeAttr(v) + "\"");
        });
        return sj.toString();
    }

    public static String escapeText(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    public static String escapeAttr(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;");
    }
}
