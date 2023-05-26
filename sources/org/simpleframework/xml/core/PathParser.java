package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class PathParser implements Expression {
    protected boolean attribute;
    protected String cache;
    protected int count;
    protected char[] data;
    protected String location;
    protected int off;
    protected String path;
    protected int start;
    protected Style style;
    protected Type type;
    protected Cache<String> attributes = new ConcurrentCache();
    protected Cache<String> elements = new ConcurrentCache();
    protected List<Integer> indexes = new ArrayList();
    protected List<String> prefixes = new ArrayList();
    protected List<String> names = new ArrayList();
    protected StringBuilder builder = new StringBuilder();

    public PathParser(String str, Type type, Format format) throws Exception {
        this.style = format.getStyle();
        this.type = type;
        this.path = str;
        parse(str);
    }

    private void align() throws Exception {
        if (this.names.size() > this.indexes.size()) {
            this.indexes.add(1);
        }
    }

    private void attribute() throws Exception {
        char c8;
        int i8 = this.off + 1;
        this.off = i8;
        do {
            int i9 = this.off;
            if (i9 >= this.count) {
                if (i9 > i8) {
                    this.attribute = true;
                    attribute(i8, i9 - i8);
                    return;
                }
                throw new PathException("Attribute reference in '%s' for %s is empty", this.path, this.type);
            }
            char[] cArr = this.data;
            this.off = i9 + 1;
            c8 = cArr[i9];
        } while (isValid(c8));
        throw new PathException("Illegal character '%s' in attribute for '%s' in %s", Character.valueOf(c8), this.path, this.type);
    }

    private void build() {
        int size = this.names.size();
        int i8 = size - 1;
        for (int i9 = 0; i9 < size; i9++) {
            String str = this.prefixes.get(i9);
            String str2 = this.names.get(i9);
            int intValue = this.indexes.get(i9).intValue();
            if (i9 > 0) {
                this.builder.append('/');
            }
            if (this.attribute && i9 == i8) {
                this.builder.append('@');
                this.builder.append(str2);
            } else {
                if (str != null) {
                    this.builder.append(str);
                    this.builder.append(':');
                }
                this.builder.append(str2);
                this.builder.append('[');
                this.builder.append(intValue);
                this.builder.append(']');
            }
        }
        this.location = this.builder.toString();
    }

    private void element() throws Exception {
        int i8 = this.off;
        int i9 = 0;
        while (true) {
            int i10 = this.off;
            if (i10 >= this.count) {
                break;
            }
            char[] cArr = this.data;
            this.off = i10 + 1;
            char c8 = cArr[i10];
            if (isValid(c8)) {
                i9++;
            } else if (c8 == '@') {
                this.off--;
            } else if (c8 == '[') {
                index();
            } else if (c8 != '/') {
                throw new PathException("Illegal character '%s' in element for '%s' in %s", Character.valueOf(c8), this.path, this.type);
            }
        }
        element(i8, i9);
    }

    private void index() throws Exception {
        int i8;
        if (this.data[this.off - 1] == '[') {
            i8 = 0;
            while (true) {
                int i9 = this.off;
                if (i9 >= this.count) {
                    break;
                }
                char[] cArr = this.data;
                this.off = i9 + 1;
                char c8 = cArr[i9];
                if (!isDigit(c8)) {
                    break;
                }
                i8 = ((i8 * 10) + c8) - 48;
            }
        } else {
            i8 = 0;
        }
        char[] cArr2 = this.data;
        int i10 = this.off;
        this.off = i10 + 1;
        if (cArr2[i10 - 1] == ']') {
            this.indexes.add(Integer.valueOf(i8));
            return;
        }
        throw new PathException("Invalid index for path '%s' in %s", this.path, this.type);
    }

    private boolean isDigit(char c8) {
        return Character.isDigit(c8);
    }

    private boolean isLetter(char c8) {
        return Character.isLetterOrDigit(c8);
    }

    private boolean isSpecial(char c8) {
        return c8 == '_' || c8 == '-' || c8 == ':';
    }

    private boolean isValid(char c8) {
        if (!isLetter(c8) && !isSpecial(c8)) {
            return false;
        }
        return true;
    }

    private void parse(String str) throws Exception {
        if (str != null) {
            int length = str.length();
            this.count = length;
            char[] cArr = new char[length];
            this.data = cArr;
            str.getChars(0, length, cArr, 0);
        }
        path();
    }

    private void path() throws Exception {
        char c8 = this.data[this.off];
        if (c8 != '/') {
            if (c8 == '.') {
                skip();
            }
            while (this.off < this.count) {
                if (!this.attribute) {
                    segment();
                } else {
                    throw new PathException("Path '%s' in %s references an invalid attribute", this.path, this.type);
                }
            }
            truncate();
            build();
            return;
        }
        throw new PathException("Path '%s' in %s references document root", this.path, this.type);
    }

    private void segment() throws Exception {
        char c8 = this.data[this.off];
        if (c8 != '/') {
            if (c8 == '@') {
                attribute();
            } else {
                element();
            }
            align();
            return;
        }
        throw new PathException("Invalid path expression '%s' in %s", this.path, this.type);
    }

    private void skip() throws Exception {
        char[] cArr = this.data;
        if (cArr.length > 1) {
            int i8 = this.off;
            if (cArr[i8 + 1] == '/') {
                this.off = i8 + 1;
            } else {
                throw new PathException("Path '%s' in %s has an illegal syntax", this.path, this.type);
            }
        }
        int i9 = this.off + 1;
        this.off = i9;
        this.start = i9;
    }

    private void truncate() throws Exception {
        int i8 = this.off;
        int i9 = i8 - 1;
        char[] cArr = this.data;
        if (i9 >= cArr.length) {
            this.off = i8 - 1;
        } else if (cArr[i8 - 1] == '/') {
            this.off = i8 - 1;
        }
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getAttribute(String str) {
        if (!isEmpty(this.location)) {
            String fetch = this.attributes.fetch(str);
            if (fetch == null && (fetch = getAttributePath(this.location, str)) != null) {
                this.attributes.cache(str, fetch);
            }
            return fetch;
        }
        return this.style.getAttribute(str);
    }

    protected String getAttributePath(String str, String str2) {
        String attribute = this.style.getAttribute(str2);
        if (isEmpty(str)) {
            return attribute;
        }
        return str + "/@" + attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getElement(String str) {
        if (!isEmpty(this.location)) {
            String fetch = this.elements.fetch(str);
            if (fetch == null && (fetch = getElementPath(this.location, str)) != null) {
                this.elements.cache(str, fetch);
            }
            return fetch;
        }
        return this.style.getElement(str);
    }

    protected String getElementPath(String str, String str2) {
        String element = this.style.getElement(str2);
        if (isEmpty(element)) {
            return str;
        }
        if (isEmpty(str)) {
            return element;
        }
        return str + "/" + element + "[1]";
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getFirst() {
        return this.names.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public int getIndex() {
        return this.indexes.get(0).intValue();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getLast() {
        return this.names.get(this.names.size() - 1);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPath() {
        return this.location;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPrefix() {
        return this.prefixes.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isEmpty() {
        return isEmpty(this.location);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isPath() {
        if (this.names.size() > 1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.names.iterator();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String toString() {
        int i8 = this.off;
        int i9 = this.start;
        int i10 = i8 - i9;
        if (this.cache == null) {
            this.cache = new String(this.data, i9, i10);
        }
        return this.cache;
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i8) {
        return getPath(i8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PathSection implements Expression {
        private int begin;
        private List<String> cache = new ArrayList();
        private int end;
        private String path;
        private String section;

        public PathSection(int i8, int i9) {
            this.begin = i8;
            this.end = i9;
        }

        private String getCanonicalPath() {
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.begin) {
                i9 = PathParser.this.location.indexOf(47, i9 + 1);
                i8++;
            }
            int i10 = i9;
            while (i8 <= this.end) {
                i10 = PathParser.this.location.indexOf(47, i10 + 1);
                if (i10 == -1) {
                    i10 = PathParser.this.location.length();
                }
                i8++;
            }
            return PathParser.this.location.substring(i9 + 1, i10);
        }

        private String getFragment() {
            int i8 = PathParser.this.start;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 > this.end) {
                    break;
                }
                PathParser pathParser = PathParser.this;
                if (i8 >= pathParser.count) {
                    i8++;
                    break;
                }
                int i11 = i8 + 1;
                if (pathParser.data[i8] == '/' && (i9 = i9 + 1) == this.begin) {
                    i8 = i11;
                    i10 = i8;
                } else {
                    i8 = i11;
                }
            }
            return new String(PathParser.this.data, i10, (i8 - 1) - i10);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getAttribute(String str) {
            String path = getPath();
            if (path != null) {
                return PathParser.this.getAttributePath(path, str);
            }
            return str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getElement(String str) {
            String path = getPath();
            if (path != null) {
                return PathParser.this.getElementPath(path, str);
            }
            return str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getFirst() {
            return PathParser.this.names.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public int getIndex() {
            return PathParser.this.indexes.get(this.begin).intValue();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getLast() {
            return PathParser.this.names.get(this.end);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPath() {
            if (this.section == null) {
                this.section = getCanonicalPath();
            }
            return this.section;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPrefix() {
            return PathParser.this.prefixes.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isAttribute() {
            PathParser pathParser = PathParser.this;
            if (!pathParser.attribute || this.end < pathParser.names.size() - 1) {
                return false;
            }
            return true;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isEmpty() {
            if (this.begin == this.end) {
                return true;
            }
            return false;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isPath() {
            if (this.end - this.begin >= 1) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            if (this.cache.isEmpty()) {
                for (int i8 = this.begin; i8 <= this.end; i8++) {
                    String str = PathParser.this.names.get(i8);
                    if (str != null) {
                        this.cache.add(str);
                    }
                }
            }
            return this.cache.iterator();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String toString() {
            if (this.path == null) {
                this.path = getFragment();
            }
            return this.path;
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i8) {
            return getPath(i8, 0);
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i8, int i9) {
            return new PathSection(this.begin + i8, this.end - i9);
        }
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i8, int i9) {
        int size = (this.names.size() - 1) - i9;
        if (size >= i8) {
            return new PathSection(i8, size);
        }
        return new PathSection(i8, i8);
    }

    private void attribute(int i8, int i9) {
        String str = new String(this.data, i8, i9);
        if (i9 > 0) {
            attribute(str);
        }
    }

    private void element(int i8, int i9) {
        String str = new String(this.data, i8, i9);
        if (i9 > 0) {
            element(str);
        }
    }

    private void attribute(String str) {
        String attribute = this.style.getAttribute(str);
        this.prefixes.add(null);
        this.names.add(attribute);
    }

    private void element(String str) {
        String str2;
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            str2 = null;
        }
        String element = this.style.getElement(str);
        this.prefixes.add(str2);
        this.names.add(element);
    }
}
