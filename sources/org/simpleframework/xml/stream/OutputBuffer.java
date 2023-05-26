package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes5.dex */
class OutputBuffer {
    private StringBuilder text = new StringBuilder();

    public void append(char c8) {
        this.text.append(c8);
    }

    public void clear() {
        this.text.setLength(0);
    }

    public void write(Writer writer) throws IOException {
        writer.append((CharSequence) this.text);
    }

    public void append(String str) {
        this.text.append(str);
    }

    public void append(char[] cArr) {
        this.text.append(cArr, 0, cArr.length);
    }

    public void append(char[] cArr, int i8, int i9) {
        this.text.append(cArr, i8, i9);
    }

    public void append(String str, int i8, int i9) {
        this.text.append((CharSequence) str, i8, i9);
    }
}
