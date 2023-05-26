package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
abstract class Splitter {
    protected StringBuilder builder = new StringBuilder();
    protected int count;
    protected int off;
    protected char[] text;

    public Splitter(String str) {
        char[] charArray = str.toCharArray();
        this.text = charArray;
        this.count = charArray.length;
    }

    private boolean acronym() {
        int i8 = this.off;
        int i9 = 0;
        while (i8 < this.count && isUpper(this.text[i8])) {
            i9++;
            i8++;
        }
        if (i9 > 1) {
            if (i8 < this.count && isUpper(this.text[i8 - 1])) {
                i8--;
            }
            char[] cArr = this.text;
            int i10 = this.off;
            commit(cArr, i10, i8 - i10);
            this.off = i8;
        }
        if (i9 <= 1) {
            return false;
        }
        return true;
    }

    private boolean isDigit(char c8) {
        return Character.isDigit(c8);
    }

    private boolean isLetter(char c8) {
        return Character.isLetter(c8);
    }

    private boolean isSpecial(char c8) {
        return !Character.isLetterOrDigit(c8);
    }

    private boolean isUpper(char c8) {
        return Character.isUpperCase(c8);
    }

    private boolean number() {
        int i8 = this.off;
        int i9 = 0;
        while (i8 < this.count && isDigit(this.text[i8])) {
            i9++;
            i8++;
        }
        if (i9 > 0) {
            char[] cArr = this.text;
            int i10 = this.off;
            commit(cArr, i10, i8 - i10);
        }
        this.off = i8;
        if (i9 <= 0) {
            return false;
        }
        return true;
    }

    private void token() {
        int i8 = this.off;
        while (i8 < this.count) {
            char c8 = this.text[i8];
            if (!isLetter(c8) || (i8 > this.off && isUpper(c8))) {
                break;
            }
            i8++;
        }
        int i9 = this.off;
        if (i8 > i9) {
            parse(this.text, i9, i8 - i9);
            char[] cArr = this.text;
            int i10 = this.off;
            commit(cArr, i10, i8 - i10);
        }
        this.off = i8;
    }

    protected abstract void commit(char[] cArr, int i8, int i9);

    protected abstract void parse(char[] cArr, int i8, int i9);

    public String process() {
        while (this.off < this.count) {
            while (true) {
                int i8 = this.off;
                if (i8 >= this.count || !isSpecial(this.text[i8])) {
                    break;
                }
                this.off++;
            }
            if (!acronym()) {
                token();
                number();
            }
        }
        return this.builder.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public char toLower(char c8) {
        return Character.toLowerCase(c8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public char toUpper(char c8) {
        return Character.toUpperCase(c8);
    }
}
