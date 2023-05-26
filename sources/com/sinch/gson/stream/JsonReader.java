package com.sinch.gson.stream;

import com.sinch.gson.internal.JsonReaderInternalAccess;
import com.sinch.gson.internal.bind.JsonTreeReader;
import j$.util.Spliterator;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes3.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private final char[] buffer = new char[Spliterator.IMMUTABLE];
    public int peeked = 0;
    private boolean lenient = false;
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private String[] pathNames = new String[32];
    private int[] pathIndices = new int[32];
    private int stackSize = 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.sinch.gson.stream.JsonReader.1
            @Override // com.sinch.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                int i8;
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i9 = jsonReader.peeked;
                if (i9 == 0) {
                    i9 = jsonReader.doPeek();
                }
                if (i9 == 13) {
                    i8 = 9;
                } else if (i9 == 12) {
                    i8 = 8;
                } else if (i9 != 14) {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                } else {
                    i8 = 10;
                }
                jsonReader.peeked = i8;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i8 = this.pos - 1;
        this.pos = i8;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i8 + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i9 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i9 >= cArr2.length) {
                this.pos += cArr2.length;
                return;
            } else if (this.buffer[this.pos + i9] != cArr2[i9]) {
                return;
            } else {
                i9++;
            }
        }
    }

    private boolean fillBuffer(int i8) throws IOException {
        int i9;
        int i10;
        char[] cArr = this.buffer;
        int i11 = this.lineStart;
        int i12 = this.pos;
        this.lineStart = i11 - i12;
        int i13 = this.limit;
        if (i13 != i12) {
            int i14 = i13 - i12;
            this.limit = i14;
            System.arraycopy(cArr, i12, cArr, 0, i14);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i15 = this.limit;
            int read = reader.read(cArr, i15, cArr.length - i15);
            if (read == -1) {
                return false;
            }
            i9 = this.limit + read;
            this.limit = i9;
            if (this.lineNumber == 0 && (i10 = this.lineStart) == 0 && i9 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i10 + 1;
                i8++;
                continue;
            }
        } while (i9 < i8);
        return true;
    }

    private boolean isLiteral(char c8) throws IOException {
        if (c8 == '\t' || c8 == '\n' || c8 == '\f' || c8 == '\r' || c8 == ' ') {
            return false;
        }
        if (c8 != '#') {
            if (c8 == ',') {
                return false;
            }
            if (c8 != '/' && c8 != '=') {
                if (c8 == '{' || c8 == '}' || c8 == ':') {
                    return false;
                }
                if (c8 != ';') {
                    switch (c8) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (skipTo("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        checkLenient();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int nextNonWhitespace(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.buffer
        L2:
            int r1 = r7.pos
        L4:
            int r2 = r7.limit
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r7.pos = r1
            boolean r1 = r7.fillBuffer(r3)
            if (r1 != 0) goto L30
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.locationString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L30:
            int r1 = r7.pos
            int r2 = r7.limit
        L34:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L44
            int r1 = r7.lineNumber
            int r1 = r1 + r3
            r7.lineNumber = r1
            r7.lineStart = r4
            goto La4
        L44:
            r5 = 32
            if (r1 == r5) goto La4
            r5 = 13
            if (r1 == r5) goto La4
            r5 = 9
            if (r1 != r5) goto L51
            goto La4
        L51:
            r5 = 47
            if (r1 != r5) goto L95
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L6a
            int r4 = r4 + (-1)
            r7.pos = r4
            boolean r2 = r7.fillBuffer(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L6a
            return r1
        L6a:
            r7.checkLenient()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L7d
            if (r3 == r5) goto L78
            return r1
        L78:
            int r2 = r2 + 1
            r7.pos = r2
            goto L9e
        L7d:
            int r2 = r2 + 1
            r7.pos = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.skipTo(r1)
            if (r1 == 0) goto L8e
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L4
        L8e:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.syntaxError(r8)
            throw r8
        L95:
            r2 = 35
            r7.pos = r4
            if (r1 != r2) goto La3
            r7.checkLenient()
        L9e:
            r7.skipToEndOfLine()
            goto L2
        La3:
            return r1
        La4:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.gson.stream.JsonReader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(char c8) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = new StringBuilder();
        do {
            int i8 = this.pos;
            int i9 = this.limit;
            int i10 = i8;
            while (i8 < i9) {
                int i11 = i8 + 1;
                char c9 = cArr[i8];
                if (c9 == c8) {
                    this.pos = i11;
                    sb.append(cArr, i10, (i11 - i10) - 1);
                    return sb.toString();
                } else if (c9 == '\\') {
                    this.pos = i11;
                    sb.append(cArr, i10, (i11 - i10) - 1);
                    sb.append(readEscapeCharacter());
                    i10 = this.pos;
                    i9 = this.limit;
                    i8 = i10;
                } else {
                    if (c9 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i11;
                    }
                    i8 = i11;
                }
            }
            sb.append(cArr, i10, i8 - i10);
            this.pos = i8;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.pos
            int r3 = r3 + r2
            int r4 = r5.limit
            if (r3 >= r4) goto L4c
            char[] r4 = r5.buffer
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L48;
                case 93: goto L5a;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.checkLenient()
            goto L5a
        L4c:
            char[] r3 = r5.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r5.fillBuffer(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r0 = r2
            goto L76
        L5c:
            if (r1 != 0) goto L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L63:
            char[] r3 = r5.buffer
            int r4 = r5.pos
            r1.append(r3, r4, r2)
            int r3 = r5.pos
            int r3 = r3 + r2
            r5.pos = r3
            r2 = 1
            boolean r2 = r5.fillBuffer(r2)
            if (r2 != 0) goto L2
        L76:
            if (r1 != 0) goto L82
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.buffer
            int r3 = r5.pos
            r1.<init>(r2, r3, r0)
            goto L8d
        L82:
            char[] r2 = r5.buffer
            int r3 = r5.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L8d:
            int r2 = r5.pos
            int r2 = r2 + r0
            r5.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        int i8;
        String str;
        String str2;
        char c8 = this.buffer[this.pos];
        if (c8 == 't' || c8 == 'T') {
            i8 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c8 == 'f' || c8 == 'F') {
            i8 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c8 != 'n' && c8 != 'N') {
            return 0;
        } else {
            i8 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i9 = 1; i9 < length; i9++) {
            if (this.pos + i9 >= this.limit && !fillBuffer(i9 + 1)) {
                return 0;
            }
            char c9 = this.buffer[this.pos + i9];
            if (c9 != str.charAt(i9) && c9 != str2.charAt(i9)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i8;
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
        if (isLiteral(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        if (r9 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a1, code lost:
        if (r10 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a3, code lost:
        if (r12 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a5, code lost:
        if (r12 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a8, code lost:
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a9, code lost:
        r18.peekedLong = r10;
        r18.pos += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b2, code lost:
        r18.peeked = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b4, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b5, code lost:
        if (r9 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b8, code lost:
        if (r9 == 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bb, code lost:
        if (r9 != 7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00be, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c0, code lost:
        r18.peekedNumberLength = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c5, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int peekNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.gson.stream.JsonReader.peekNumber():int");
    }

    private void push(int i8) {
        int i9 = this.stackSize;
        int[] iArr = this.stack;
        if (i9 == iArr.length) {
            int i10 = i9 * 2;
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            String[] strArr = new String[i10];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i11 = this.stackSize;
        this.stackSize = i11 + 1;
        iArr4[i11] = i8;
    }

    private char readEscapeCharacter() throws IOException {
        int i8;
        int i9;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 + 1;
            this.pos = i11;
            char c8 = cArr[i10];
            if (c8 == '\n') {
                this.lineNumber++;
                this.lineStart = i11;
            } else if (c8 != '\"' && c8 != '\'' && c8 != '/' && c8 != '\\') {
                if (c8 != 'b') {
                    if (c8 != 'f') {
                        if (c8 != 'n') {
                            if (c8 != 'r') {
                                if (c8 != 't') {
                                    if (c8 == 'u') {
                                        if (i11 + 4 <= this.limit || fillBuffer(4)) {
                                            char c9 = 0;
                                            int i12 = this.pos;
                                            int i13 = i12 + 4;
                                            while (i12 < i13) {
                                                char c10 = this.buffer[i12];
                                                char c11 = (char) (c9 << 4);
                                                if (c10 < '0' || c10 > '9') {
                                                    if (c10 >= 'a' && c10 <= 'f') {
                                                        i8 = c10 - 'a';
                                                    } else if (c10 < 'A' || c10 > 'F') {
                                                        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                                    } else {
                                                        i8 = c10 - 'A';
                                                    }
                                                    i9 = i8 + 10;
                                                } else {
                                                    i9 = c10 - '0';
                                                }
                                                c9 = (char) (c11 + i9);
                                                i12++;
                                            }
                                            this.pos += 4;
                                            return c9;
                                        }
                                        throw syntaxError("Unterminated escape sequence");
                                    }
                                    throw syntaxError("Invalid escape sequence");
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            return c8;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c8) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i8 = this.pos;
            int i9 = this.limit;
            while (true) {
                if (i8 < i9) {
                    int i10 = i8 + 1;
                    char c9 = cArr[i8];
                    if (c9 == c8) {
                        this.pos = i10;
                        return;
                    } else if (c9 == '\\') {
                        this.pos = i10;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c9 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i10;
                        }
                        i8 = i10;
                    }
                } else {
                    this.pos = i8;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !fillBuffer(str.length())) {
                return false;
            }
            char[] cArr = this.buffer;
            int i8 = this.pos;
            if (cArr[i8] != '\n') {
                for (int i9 = 0; i9 < str.length(); i9++) {
                    if (this.buffer[this.pos + i9] != str.charAt(i9)) {
                        break;
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i8 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c8;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 + 1;
            this.pos = i9;
            c8 = cArr[i8];
            if (c8 == '\n') {
                this.lineNumber++;
                this.lineStart = i9;
                return;
            }
        } while (c8 != '\r');
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i8 = 0;
            while (true) {
                int i9 = this.pos + i8;
                if (i9 < this.limit) {
                    char c8 = this.buffer[i9];
                    if (c8 != '\t' && c8 != '\n' && c8 != '\f' && c8 != '\r' && c8 != ' ') {
                        if (c8 != '#') {
                            if (c8 != ',') {
                                if (c8 != '/' && c8 != '=') {
                                    if (c8 != '{' && c8 != '}' && c8 != ':') {
                                        if (c8 != ';') {
                                            switch (c8) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i8++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.pos = i9;
                }
            }
            checkLenient();
            this.pos += i8;
            return;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int i8;
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i9 = this.stackSize - 1;
        int i10 = iArr[i9];
        if (i10 == 1) {
            iArr[i9] = 2;
        } else if (i10 != 2) {
            if (i10 == 3 || i10 == 5) {
                iArr[i9] = 4;
                if (i10 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
                int nextNonWhitespace2 = nextNonWhitespace(true);
                if (nextNonWhitespace2 == 34) {
                    i8 = 13;
                } else if (nextNonWhitespace2 == 39) {
                    checkLenient();
                    i8 = 12;
                } else if (nextNonWhitespace2 == 125) {
                    if (i10 != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                } else {
                    checkLenient();
                    this.pos--;
                    if (!isLiteral((char) nextNonWhitespace2)) {
                        throw syntaxError("Expected name");
                    }
                    i8 = 14;
                }
            } else if (i10 == 4) {
                iArr[i9] = 5;
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 != 58) {
                    if (nextNonWhitespace3 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i11 = this.pos;
                        if (cArr[i11] == '>') {
                            this.pos = i11 + 1;
                        }
                    }
                }
            } else if (i10 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i10 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    i8 = 17;
                } else {
                    checkLenient();
                    this.pos--;
                }
            } else if (i10 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.peeked = i8;
            return i8;
        } else {
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 44) {
                if (nextNonWhitespace4 != 59) {
                    if (nextNonWhitespace4 == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 != 34) {
            if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.peeked = 8;
                return 8;
            }
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 == 123) {
                        this.peeked = 1;
                        return 1;
                    }
                    this.pos--;
                    int peekKeyword = peekKeyword();
                    if (peekKeyword != 0) {
                        return peekKeyword;
                    }
                    int peekNumber = peekNumber();
                    if (peekNumber != 0) {
                        return peekNumber;
                    }
                    if (!isLiteral(this.buffer[this.pos])) {
                        throw syntaxError("Expected value");
                    }
                    checkLenient();
                    i8 = 10;
                } else if (i10 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i10 == 1 || i10 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        }
        i8 = 9;
        this.peeked = i8;
        return i8;
    }

    public void endArray() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i9 = this.stackSize - 1;
        this.stackSize = i9;
        int[] iArr = this.pathIndices;
        int i10 = i9 - 1;
        iArr[i10] = iArr[i10] + 1;
        this.peeked = 0;
    }

    public void endObject() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i9 = this.stackSize - 1;
        this.stackSize = i9;
        this.pathNames[i9] = null;
        int[] iArr = this.pathIndices;
        int i10 = i9 - 1;
        iArr[i10] = iArr[i10] + 1;
        this.peeked = 0;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i8 = this.stackSize;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.stack[i9];
            if (i10 == 1 || i10 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i9]);
                sb.append(']');
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                sb.append('.');
                String str = this.pathNames[i9];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        return (i8 == 2 || i8 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return true;
        } else if (i8 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        String nextQuotedValue;
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return this.peekedLong;
        }
        if (i8 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i8 == 8 || i8 == 9) {
                nextQuotedValue = nextQuotedValue(i8 == 8 ? '\'' : '\"');
            } else if (i8 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i8 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = nextQuotedValue;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 15) {
            long j8 = this.peekedLong;
            int i9 = (int) j8;
            if (j8 == i9) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr[i10] = iArr[i10] + 1;
                return i9;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i8 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i8 != 8 && i8 != 9 && i8 != 10) {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        } else {
            if (i8 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i8 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i11 = this.stackSize - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i12 = (int) parseDouble;
        if (i12 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i13 = this.stackSize - 1;
        iArr3[i13] = iArr3[i13] + 1;
        return i12;
    }

    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return this.peekedLong;
        }
        if (i8 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i8 != 8 && i8 != 9 && i8 != 10) {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        } else {
            if (i8 == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i8 == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j8 = (long) parseDouble;
        if (j8 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return j8;
    }

    public String nextName() throws IOException {
        char c8;
        String nextQuotedValue;
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else {
            if (i8 == 12) {
                c8 = '\'';
            } else if (i8 != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            } else {
                c8 = '\"';
            }
            nextQuotedValue = nextQuotedValue(c8);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        char c8;
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        if (i8 == 10) {
            str = nextUnquotedValue();
        } else {
            if (i8 == 8) {
                c8 = '\'';
            } else if (i8 == 9) {
                c8 = '\"';
            } else if (i8 == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i8 == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i8 != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            } else {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            str = nextQuotedValue(c8);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr[i9] = iArr[i9] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i8 = this.peeked;
        if (i8 == 0) {
            i8 = doPeek();
        }
        switch (i8) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z7) {
        this.lenient = z7;
    }

    public void skipValue() throws IOException {
        char c8;
        int i8 = 0;
        do {
            int i9 = this.peeked;
            if (i9 == 0) {
                i9 = doPeek();
            }
            if (i9 == 3) {
                push(1);
            } else if (i9 == 1) {
                push(3);
            } else {
                if (i9 == 4 || i9 == 2) {
                    this.stackSize--;
                    i8--;
                } else if (i9 == 14 || i9 == 10) {
                    skipUnquotedValue();
                } else {
                    if (i9 == 8 || i9 == 12) {
                        c8 = '\'';
                    } else if (i9 == 9 || i9 == 13) {
                        c8 = '\"';
                    } else if (i9 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    skipQuotedValue(c8);
                }
                this.peeked = 0;
            }
            i8++;
            this.peeked = 0;
        } while (i8 != 0);
        int[] iArr = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr[i10] = iArr[i10] + 1;
        this.pathNames[i10] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
