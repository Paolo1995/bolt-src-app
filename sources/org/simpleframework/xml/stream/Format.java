package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class Format {
    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format() {
        this(3);
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }

    public Format(int i8) {
        this(i8, (String) null, new IdentityStyle());
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(int i8, String str) {
        this(i8, str, new IdentityStyle());
    }

    public Format(Verbosity verbosity) {
        this(3, verbosity);
    }

    public Format(int i8, Verbosity verbosity) {
        this(i8, new IdentityStyle(), verbosity);
    }

    public Format(Style style) {
        this(3, style);
    }

    public Format(Style style, Verbosity verbosity) {
        this(3, style, verbosity);
    }

    public Format(int i8, Style style) {
        this(i8, (String) null, style);
    }

    public Format(int i8, Style style, Verbosity verbosity) {
        this(i8, null, style, verbosity);
    }

    public Format(int i8, String str, Style style) {
        this(i8, str, style, Verbosity.HIGH);
    }

    public Format(int i8, String str, Style style, Verbosity verbosity) {
        this.verbosity = verbosity;
        this.prolog = str;
        this.indent = i8;
        this.style = style;
    }
}
