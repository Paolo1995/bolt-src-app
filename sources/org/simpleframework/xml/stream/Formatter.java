package org.simpleframework.xml.stream;

import j$.util.Spliterator;
import java.io.BufferedWriter;
import java.io.Writer;

/* loaded from: classes5.dex */
class Formatter {
    private OutputBuffer buffer = new OutputBuffer();
    private Indenter indenter;
    private Tag last;
    private String prolog;
    private Writer result;
    private static final char[] NAMESPACE = {'x', 'm', 'l', 'n', 's'};
    private static final char[] LESS = {'&', 'l', 't', ';'};
    private static final char[] GREATER = {'&', 'g', 't', ';'};
    private static final char[] DOUBLE = {'&', 'q', 'u', 'o', 't', ';'};
    private static final char[] SINGLE = {'&', 'a', 'p', 'o', 's', ';'};
    private static final char[] AND = {'&', 'a', 'm', 'p', ';'};
    private static final char[] OPEN = {'<', '!', '-', '-', ' '};
    private static final char[] CLOSE = {' ', '-', '-', '>'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Tag {
        COMMENT,
        START,
        TEXT,
        END
    }

    public Formatter(Writer writer, Format format) {
        this.result = new BufferedWriter(writer, Spliterator.IMMUTABLE);
        this.indenter = new Indenter(format);
        this.prolog = format.getProlog();
    }

    private void append(char c8) throws Exception {
        this.buffer.append(c8);
    }

    private void data(String str) throws Exception {
        write("<![CDATA[");
        write(str);
        write("]]>");
    }

    private void escape(String str) throws Exception {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            escape(str.charAt(i8));
        }
    }

    private boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    private boolean isText(char c8) {
        if (c8 == '\t' || c8 == '\n' || c8 == '\r' || c8 == ' ') {
            return true;
        }
        return c8 > ' ' && c8 <= '~' && c8 != 247;
    }

    private char[] symbol(char c8) {
        if (c8 != '\"') {
            if (c8 != '<') {
                if (c8 != '>') {
                    if (c8 != '&') {
                        if (c8 != '\'') {
                            return null;
                        }
                        return SINGLE;
                    }
                    return AND;
                }
                return GREATER;
            }
            return LESS;
        }
        return DOUBLE;
    }

    private String unicode(char c8) {
        return Integer.toString(c8);
    }

    private void write(char c8) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(c8);
    }

    public void flush() throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.flush();
    }

    public void writeAttribute(String str, String str2, String str3) throws Exception {
        if (this.last == Tag.START) {
            write(' ');
            write(str, str3);
            write('=');
            write('\"');
            escape(str2);
            write('\"');
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeComment(String str) throws Exception {
        String pVar = this.indenter.top();
        if (this.last == Tag.START) {
            append('>');
        }
        if (pVar != null) {
            append(pVar);
            append(OPEN);
            append(str);
            append(CLOSE);
        }
        this.last = Tag.COMMENT;
    }

    public void writeEnd(String str, String str2) throws Exception {
        String pop = this.indenter.pop();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag == tag2) {
            write('/');
            write('>');
        } else {
            if (tag != Tag.TEXT) {
                write(pop);
            }
            if (this.last != tag2) {
                write('<');
                write('/');
                write(str, str2);
                write('>');
            }
        }
        this.last = Tag.END;
    }

    public void writeNamespace(String str, String str2) throws Exception {
        if (this.last == Tag.START) {
            write(' ');
            write(NAMESPACE);
            if (!isEmpty(str2)) {
                write(':');
                write(str2);
            }
            write('=');
            write('\"');
            escape(str);
            write('\"');
            return;
        }
        throw new NodeException("Start element required");
    }

    public void writeProlog() throws Exception {
        String str = this.prolog;
        if (str != null) {
            write(str);
            write("\n");
        }
    }

    public void writeStart(String str, String str2) throws Exception {
        String push = this.indenter.push();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag == tag2) {
            append('>');
        }
        flush();
        append(push);
        append('<');
        if (!isEmpty(str2)) {
            append(str2);
            append(':');
        }
        append(str);
        this.last = tag2;
    }

    public void writeText(String str) throws Exception {
        writeText(str, Mode.ESCAPE);
    }

    private void append(char[] cArr) throws Exception {
        this.buffer.append(cArr);
    }

    public void writeText(String str, Mode mode) throws Exception {
        if (this.last == Tag.START) {
            write('>');
        }
        if (mode == Mode.DATA) {
            data(str);
        } else {
            escape(str);
        }
        this.last = Tag.TEXT;
    }

    private void append(String str) throws Exception {
        this.buffer.append(str);
    }

    private void escape(char c8) throws Exception {
        char[] symbol = symbol(c8);
        if (symbol != null) {
            write(symbol);
        } else {
            write(c8);
        }
    }

    private void write(char[] cArr) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(cArr);
    }

    private void write(String str) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(str);
    }

    private void write(String str, String str2) throws Exception {
        this.buffer.write(this.result);
        this.buffer.clear();
        if (!isEmpty(str2)) {
            this.result.write(str2);
            this.result.write(58);
        }
        this.result.write(str);
    }
}
