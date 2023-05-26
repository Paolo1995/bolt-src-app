package org.simpleframework.xml.core;

/* loaded from: classes5.dex */
class Template {
    protected char[] buf;
    protected String cache;
    protected int count;

    public Template() {
        this(16);
    }

    public void append(char c8) {
        ensureCapacity(this.count + 1);
        char[] cArr = this.buf;
        int i8 = this.count;
        this.count = i8 + 1;
        cArr[i8] = c8;
    }

    public void clear() {
        this.cache = null;
        this.count = 0;
    }

    protected void ensureCapacity(int i8) {
        char[] cArr = this.buf;
        if (cArr.length < i8) {
            char[] cArr2 = new char[Math.max(i8, cArr.length * 2)];
            System.arraycopy(this.buf, 0, cArr2, 0, this.count);
            this.buf = cArr2;
        }
    }

    public int length() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public Template(int i8) {
        this.buf = new char[i8];
    }

    public void append(String str) {
        ensureCapacity(this.count + str.length());
        str.getChars(0, str.length(), this.buf, this.count);
        this.count += str.length();
    }

    public void append(Template template) {
        append(template.buf, 0, template.count);
    }

    public void append(char[] cArr, int i8, int i9) {
        ensureCapacity(this.count + i9);
        System.arraycopy(cArr, i8, this.buf, this.count, i9);
        this.count += i9;
    }

    public void append(String str, int i8, int i9) {
        ensureCapacity(this.count + i9);
        str.getChars(i8, i9, this.buf, this.count);
        this.count += i9;
    }

    public void append(Template template, int i8, int i9) {
        append(template.buf, i8, i9);
    }
}
