package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* loaded from: classes5.dex */
class TemplateEngine {
    private Filter filter;
    private int off;
    private Template source = new Template();
    private Template name = new Template();
    private Template text = new Template();

    public TemplateEngine(Filter filter) {
        this.filter = filter;
    }

    private void name() {
        while (true) {
            int i8 = this.off;
            Template template = this.source;
            if (i8 >= template.count) {
                break;
            }
            char[] cArr = template.buf;
            this.off = i8 + 1;
            char c8 = cArr[i8];
            if (c8 == '}') {
                replace();
                break;
            }
            this.name.append(c8);
        }
        if (this.name.length() > 0) {
            this.text.append("${");
            this.text.append(this.name);
        }
    }

    private void parse() {
        while (true) {
            int i8 = this.off;
            Template template = this.source;
            int i9 = template.count;
            if (i8 < i9) {
                char[] cArr = template.buf;
                int i10 = i8 + 1;
                this.off = i10;
                char c8 = cArr[i8];
                if (c8 == '$' && i10 < i9) {
                    int i11 = i10 + 1;
                    this.off = i11;
                    if (cArr[i10] == '{') {
                        name();
                    } else {
                        this.off = i11 - 1;
                    }
                }
                this.text.append(c8);
            } else {
                return;
            }
        }
    }

    private void replace() {
        if (this.name.length() > 0) {
            replace(this.name);
        }
        this.name.clear();
    }

    public void clear() {
        this.name.clear();
        this.text.clear();
        this.source.clear();
        this.off = 0;
    }

    public String process(String str) {
        if (str.indexOf(36) < 0) {
            return str;
        }
        try {
            this.source.append(str);
            parse();
            return this.text.toString();
        } finally {
            clear();
        }
    }

    private void replace(Template template) {
        replace(template.toString());
    }

    private void replace(String str) {
        String replace = this.filter.replace(str);
        if (replace == null) {
            this.text.append("${");
            this.text.append(str);
            this.text.append("}");
            return;
        }
        this.text.append(replace);
    }
}
