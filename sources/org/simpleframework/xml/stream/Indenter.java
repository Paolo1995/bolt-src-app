package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
class Indenter {
    private Cache cache;
    private int count;
    private int indent;
    private int index;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Cache {
        private int count;
        private String[] list;

        public Cache(int i8) {
            this.list = new String[i8];
        }

        private void resize(int i8) {
            String[] strArr = new String[i8];
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.list;
                if (i9 < strArr2.length) {
                    strArr[i9] = strArr2[i9];
                    i9++;
                } else {
                    this.list = strArr;
                    return;
                }
            }
        }

        public String get(int i8) {
            String[] strArr = this.list;
            if (i8 < strArr.length) {
                return strArr[i8];
            }
            return null;
        }

        public void set(int i8, String str) {
            if (i8 >= this.list.length) {
                resize(i8 * 2);
            }
            if (i8 > this.count) {
                this.count = i8;
            }
            this.list[i8] = str;
        }

        public int size() {
            return this.count;
        }
    }

    public Indenter() {
        this(new Format());
    }

    private String create() {
        int i8 = this.count;
        char[] cArr = new char[i8 + 1];
        if (i8 > 0) {
            cArr[0] = '\n';
            for (int i9 = 1; i9 <= this.count; i9++) {
                cArr[i9] = ' ';
            }
            return new String(cArr);
        }
        return "\n";
    }

    private String indent(int i8) {
        if (this.indent > 0) {
            String str = this.cache.get(i8);
            if (str == null) {
                str = create();
                this.cache.set(i8, str);
            }
            if (this.cache.size() > 0) {
                return str;
            }
            return "";
        }
        return "";
    }

    public String pop() {
        int i8 = this.index - 1;
        this.index = i8;
        String indent = indent(i8);
        int i9 = this.indent;
        if (i9 > 0) {
            this.count -= i9;
        }
        return indent;
    }

    public String push() {
        int i8 = this.index;
        this.index = i8 + 1;
        String indent = indent(i8);
        int i9 = this.indent;
        if (i9 > 0) {
            this.count += i9;
        }
        return indent;
    }

    public String top() {
        return indent(this.index);
    }

    public Indenter(Format format) {
        this(format, 16);
    }

    private Indenter(Format format, int i8) {
        this.indent = format.getIndent();
        this.cache = new Cache(i8);
    }
}
