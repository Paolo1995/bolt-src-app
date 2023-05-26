package org.simpleframework.xml.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CamelCaseBuilder implements Style {
    protected final boolean attribute;
    protected final boolean element;

    /* loaded from: classes5.dex */
    private class Attribute extends Splitter {
        private boolean capital;

        @Override // org.simpleframework.xml.stream.Splitter
        protected void commit(char[] cArr, int i8, int i9) {
            this.builder.append(cArr, i8, i9);
        }

        @Override // org.simpleframework.xml.stream.Splitter
        protected void parse(char[] cArr, int i8, int i9) {
            if (CamelCaseBuilder.this.attribute || this.capital) {
                cArr[i8] = toUpper(cArr[i8]);
            }
            this.capital = true;
        }

        private Attribute(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    private class Element extends Attribute {
        private boolean capital;

        @Override // org.simpleframework.xml.stream.CamelCaseBuilder.Attribute, org.simpleframework.xml.stream.Splitter
        protected void parse(char[] cArr, int i8, int i9) {
            if (CamelCaseBuilder.this.element || this.capital) {
                cArr[i8] = toUpper(cArr[i8]);
            }
            this.capital = true;
        }

        private Element(String str) {
            super(str);
        }
    }

    public CamelCaseBuilder(boolean z7, boolean z8) {
        this.attribute = z8;
        this.element = z7;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        if (str == null) {
            return null;
        }
        return new Attribute(str).process();
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        if (str == null) {
            return null;
        }
        return new Element(str).process();
    }
}
