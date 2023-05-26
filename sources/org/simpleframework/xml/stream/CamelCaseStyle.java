package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class CamelCaseStyle implements Style {
    private final Builder builder;
    private final Style style;

    public CamelCaseStyle() {
        this(true, false);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        return this.builder.getAttribute(str);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        return this.builder.getElement(str);
    }

    public void setAttribute(String str, String str2) {
        this.builder.setAttribute(str, str2);
    }

    public void setElement(String str, String str2) {
        this.builder.setElement(str, str2);
    }

    public CamelCaseStyle(boolean z7) {
        this(z7, false);
    }

    public CamelCaseStyle(boolean z7, boolean z8) {
        CamelCaseBuilder camelCaseBuilder = new CamelCaseBuilder(z7, z8);
        this.style = camelCaseBuilder;
        this.builder = new Builder(camelCaseBuilder);
    }
}
