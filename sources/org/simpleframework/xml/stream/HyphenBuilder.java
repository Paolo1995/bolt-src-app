package org.simpleframework.xml.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class HyphenBuilder implements Style {

    /* loaded from: classes5.dex */
    private class Parser extends Splitter {
        @Override // org.simpleframework.xml.stream.Splitter
        protected void commit(char[] cArr, int i8, int i9) {
            this.builder.append(cArr, i8, i9);
            if (i8 + i9 < this.count) {
                this.builder.append('-');
            }
        }

        @Override // org.simpleframework.xml.stream.Splitter
        protected void parse(char[] cArr, int i8, int i9) {
            cArr[i8] = toLower(cArr[i8]);
        }

        private Parser(String str) {
            super(str);
        }
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        if (str == null) {
            return null;
        }
        return new Parser(str).process();
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        if (str == null) {
            return null;
        }
        return new Parser(str).process();
    }
}
