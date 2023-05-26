package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader {

    /* renamed from: s  reason: collision with root package name */
    private static final ByteString f9617s = ByteString.f("'\\");

    /* renamed from: t  reason: collision with root package name */
    private static final ByteString f9618t = ByteString.f("\"\\");

    /* renamed from: u  reason: collision with root package name */
    private static final ByteString f9619u = ByteString.f("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: v  reason: collision with root package name */
    private static final ByteString f9620v = ByteString.f("\n\r");

    /* renamed from: w  reason: collision with root package name */
    private static final ByteString f9621w = ByteString.f("*/");

    /* renamed from: m  reason: collision with root package name */
    private final BufferedSource f9622m;

    /* renamed from: n  reason: collision with root package name */
    private final Buffer f9623n;

    /* renamed from: o  reason: collision with root package name */
    private int f9624o = 0;

    /* renamed from: p  reason: collision with root package name */
    private long f9625p;

    /* renamed from: q  reason: collision with root package name */
    private int f9626q;

    /* renamed from: r  reason: collision with root package name */
    private String f9627r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f9622m = bufferedSource;
            this.f9623n = bufferedSource.s();
            F(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private int C0() throws IOException {
        int i8;
        String str;
        String str2;
        byte m8 = this.f9623n.m(0L);
        if (m8 != 116 && m8 != 84) {
            if (m8 != 102 && m8 != 70) {
                if (m8 != 110 && m8 != 78) {
                    return 0;
                }
                i8 = 7;
                str = "null";
                str2 = "NULL";
            } else {
                i8 = 6;
                str = "false";
                str2 = "FALSE";
            }
        } else {
            i8 = 5;
            str = "true";
            str2 = "TRUE";
        }
        int length = str.length();
        int i9 = 1;
        while (i9 < length) {
            int i10 = i9 + 1;
            if (!this.f9622m.f(i10)) {
                return 0;
            }
            byte m9 = this.f9623n.m(i9);
            if (m9 != str.charAt(i9) && m9 != str2.charAt(i9)) {
                return 0;
            }
            i9 = i10;
        }
        if (this.f9622m.f(length + 1) && f0(this.f9623n.m(length))) {
            return 0;
        }
        this.f9623n.skip(length);
        this.f9624o = i8;
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
        if (f0(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009f, code lost:
        r16.f9625p = r8;
        r16.f9623n.skip(r5);
        r16.f9624o = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ac, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b2, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
        r16.f9626q = r5;
        r16.f9624o = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bd, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int D0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.D0():int");
    }

    private char G0() throws IOException {
        int i8;
        int i9;
        if (this.f9622m.f(1L)) {
            byte readByte = this.f9623n.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f9602j) {
                                        return (char) readByte;
                                    }
                                    throw Y("Invalid escape sequence: \\" + ((char) readByte));
                                } else if (this.f9622m.f(4L)) {
                                    char c8 = 0;
                                    for (int i10 = 0; i10 < 4; i10++) {
                                        byte m8 = this.f9623n.m(i10);
                                        char c9 = (char) (c8 << 4);
                                        if (m8 >= 48 && m8 <= 57) {
                                            i9 = m8 - 48;
                                        } else {
                                            if (m8 >= 97 && m8 <= 102) {
                                                i8 = m8 - 97;
                                            } else if (m8 < 65 || m8 > 70) {
                                                throw Y("\\u" + this.f9623n.s0(4L));
                                            } else {
                                                i8 = m8 - 65;
                                            }
                                            i9 = i8 + 10;
                                        }
                                        c8 = (char) (c9 + i9);
                                    }
                                    this.f9623n.skip(4L);
                                    return c8;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw Y("Unterminated escape sequence");
    }

    private void I0(ByteString byteString) throws IOException {
        while (true) {
            long G = this.f9622m.G(byteString);
            if (G != -1) {
                if (this.f9623n.m(G) == 92) {
                    this.f9623n.skip(G + 1);
                    G0();
                } else {
                    this.f9623n.skip(G + 1);
                    return;
                }
            } else {
                throw Y("Unterminated string");
            }
        }
    }

    private boolean K0() throws IOException {
        boolean z7;
        long size;
        BufferedSource bufferedSource = this.f9622m;
        ByteString byteString = f9621w;
        long B = bufferedSource.B(byteString);
        if (B != -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        Buffer buffer = this.f9623n;
        if (z7) {
            size = B + byteString.z();
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
        return z7;
    }

    private void P0() throws IOException {
        long size;
        long G = this.f9622m.G(f9620v);
        Buffer buffer = this.f9623n;
        if (G != -1) {
            size = G + 1;
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
    }

    private void R0() throws IOException {
        long G = this.f9622m.G(f9619u);
        Buffer buffer = this.f9623n;
        if (G == -1) {
            G = buffer.size();
        }
        buffer.skip(G);
    }

    private void Z() throws IOException {
        if (this.f9602j) {
            return;
        }
        throw Y("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int c0() throws IOException {
        int[] iArr = this.f9599g;
        int i8 = this.f9598f;
        int i9 = iArr[i8 - 1];
        if (i9 == 1) {
            iArr[i8 - 1] = 2;
        } else if (i9 == 2) {
            int k02 = k0(true);
            this.f9623n.readByte();
            if (k02 != 44) {
                if (k02 != 59) {
                    if (k02 == 93) {
                        this.f9624o = 4;
                        return 4;
                    }
                    throw Y("Unterminated array");
                }
                Z();
            }
        } else if (i9 != 3 && i9 != 5) {
            if (i9 == 4) {
                iArr[i8 - 1] = 5;
                int k03 = k0(true);
                this.f9623n.readByte();
                if (k03 != 58) {
                    if (k03 == 61) {
                        Z();
                        if (this.f9622m.f(1L) && this.f9623n.m(0L) == 62) {
                            this.f9623n.readByte();
                        }
                    } else {
                        throw Y("Expected ':'");
                    }
                }
            } else if (i9 == 6) {
                iArr[i8 - 1] = 7;
            } else if (i9 == 7) {
                if (k0(false) == -1) {
                    this.f9624o = 18;
                    return 18;
                }
                Z();
            } else if (i9 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i8 - 1] = 4;
            if (i9 == 5) {
                int k04 = k0(true);
                this.f9623n.readByte();
                if (k04 != 44) {
                    if (k04 != 59) {
                        if (k04 == 125) {
                            this.f9624o = 2;
                            return 2;
                        }
                        throw Y("Unterminated object");
                    }
                    Z();
                }
            }
            int k05 = k0(true);
            if (k05 != 34) {
                if (k05 != 39) {
                    if (k05 != 125) {
                        Z();
                        if (f0((char) k05)) {
                            this.f9624o = 14;
                            return 14;
                        }
                        throw Y("Expected name");
                    } else if (i9 != 5) {
                        this.f9623n.readByte();
                        this.f9624o = 2;
                        return 2;
                    } else {
                        throw Y("Expected name");
                    }
                }
                this.f9623n.readByte();
                Z();
                this.f9624o = 12;
                return 12;
            }
            this.f9623n.readByte();
            this.f9624o = 13;
            return 13;
        }
        int k06 = k0(true);
        if (k06 != 34) {
            if (k06 != 39) {
                if (k06 != 44 && k06 != 59) {
                    if (k06 != 91) {
                        if (k06 != 93) {
                            if (k06 != 123) {
                                int C0 = C0();
                                if (C0 != 0) {
                                    return C0;
                                }
                                int D0 = D0();
                                if (D0 != 0) {
                                    return D0;
                                }
                                if (f0(this.f9623n.m(0L))) {
                                    Z();
                                    this.f9624o = 10;
                                    return 10;
                                }
                                throw Y("Expected value");
                            }
                            this.f9623n.readByte();
                            this.f9624o = 1;
                            return 1;
                        } else if (i9 == 1) {
                            this.f9623n.readByte();
                            this.f9624o = 4;
                            return 4;
                        }
                    } else {
                        this.f9623n.readByte();
                        this.f9624o = 3;
                        return 3;
                    }
                }
                if (i9 != 1 && i9 != 2) {
                    throw Y("Unexpected value");
                }
                Z();
                this.f9624o = 7;
                return 7;
            }
            Z();
            this.f9623n.readByte();
            this.f9624o = 8;
            return 8;
        }
        this.f9623n.readByte();
        this.f9624o = 9;
        return 9;
    }

    private int d0(String str, JsonReader.Options options) {
        int length = options.f9604a.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.equals(options.f9604a[i8])) {
                this.f9624o = 0;
                this.f9600h[this.f9598f - 1] = str;
                return i8;
            }
        }
        return -1;
    }

    private boolean f0(int i8) throws IOException {
        if (i8 != 9 && i8 != 10 && i8 != 12 && i8 != 13 && i8 != 32) {
            if (i8 != 35) {
                if (i8 != 44) {
                    if (i8 != 47 && i8 != 61) {
                        if (i8 != 123 && i8 != 125 && i8 != 58) {
                            if (i8 != 59) {
                                switch (i8) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            Z();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.f9623n.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.f9622m.f(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        Z();
        r3 = r6.f9623n.m(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.f9623n.readByte();
        r6.f9623n.readByte();
        P0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.f9623n.readByte();
        r6.f9623n.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (K0() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw Y("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        Z();
        P0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int k0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f9622m
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.f(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f9623n
            long r4 = (long) r1
            byte r1 = r2.m(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.f9623n
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f9622m
            r4 = 2
            boolean r3 = r3.f(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.Z()
            okio.Buffer r3 = r6.f9623n
            r4 = 1
            byte r3 = r3.m(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f9623n
            r1.readByte()
            okio.Buffer r1 = r6.f9623n
            r1.readByte()
            r6.P0()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f9623n
            r1.readByte()
            okio.Buffer r1 = r6.f9623n
            r1.readByte()
            boolean r1 = r6.K0()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.Y(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.Z()
            r6.P0()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.k0(boolean):int");
    }

    private String s0(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long G = this.f9622m.G(byteString);
            if (G != -1) {
                if (this.f9623n.m(G) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f9623n.s0(G));
                    this.f9623n.readByte();
                    sb.append(G0());
                } else if (sb == null) {
                    String s02 = this.f9623n.s0(G);
                    this.f9623n.readByte();
                    return s02;
                } else {
                    sb.append(this.f9623n.s0(G));
                    this.f9623n.readByte();
                    return sb.toString();
                }
            } else {
                throw Y("Unterminated string");
            }
        }
    }

    private String v0() throws IOException {
        long G = this.f9622m.G(f9619u);
        if (G != -1) {
            return this.f9623n.s0(G);
        }
        return this.f9623n.k0();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int I(JsonReader.Options options) throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 < 12 || i8 > 15) {
            return -1;
        }
        if (i8 == 15) {
            return d0(this.f9627r, options);
        }
        int k12 = this.f9622m.k1(options.f9605b);
        if (k12 != -1) {
            this.f9624o = 0;
            this.f9600h[this.f9598f - 1] = options.f9604a[k12];
            return k12;
        }
        String str = this.f9600h[this.f9598f - 1];
        String q8 = q();
        int d02 = d0(q8, options);
        if (d02 == -1) {
            this.f9624o = 15;
            this.f9627r = q8;
            this.f9600h[this.f9598f - 1] = str;
        }
        return d02;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void N() throws IOException {
        if (!this.f9603k) {
            int i8 = this.f9624o;
            if (i8 == 0) {
                i8 = c0();
            }
            if (i8 == 14) {
                R0();
            } else if (i8 == 13) {
                I0(f9618t);
            } else if (i8 == 12) {
                I0(f9617s);
            } else if (i8 != 15) {
                throw new JsonDataException("Expected a name but was " + y() + " at path " + getPath());
            }
            this.f9624o = 0;
            this.f9600h[this.f9598f - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + y() + " at " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void O() throws IOException {
        if (!this.f9603k) {
            int i8 = 0;
            do {
                int i9 = this.f9624o;
                if (i9 == 0) {
                    i9 = c0();
                }
                if (i9 == 3) {
                    F(1);
                } else if (i9 == 1) {
                    F(3);
                } else {
                    if (i9 == 4) {
                        i8--;
                        if (i8 >= 0) {
                            this.f9598f--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                        }
                    } else if (i9 == 2) {
                        i8--;
                        if (i8 >= 0) {
                            this.f9598f--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                        }
                    } else if (i9 != 14 && i9 != 10) {
                        if (i9 != 9 && i9 != 13) {
                            if (i9 != 8 && i9 != 12) {
                                if (i9 == 17) {
                                    this.f9623n.skip(this.f9626q);
                                } else if (i9 == 18) {
                                    throw new JsonDataException("Expected a value but was " + y() + " at path " + getPath());
                                }
                            } else {
                                I0(f9617s);
                            }
                        } else {
                            I0(f9618t);
                        }
                    } else {
                        R0();
                    }
                    this.f9624o = 0;
                }
                i8++;
                this.f9624o = 0;
            } while (i8 != 0);
            int[] iArr = this.f9601i;
            int i10 = this.f9598f;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
            this.f9600h[i10 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + y() + " at " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 3) {
            F(1);
            this.f9601i[this.f9598f - 1] = 0;
            this.f9624o = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + y() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9624o = 0;
        this.f9599g[0] = 8;
        this.f9598f = 1;
        this.f9623n.a();
        this.f9622m.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 1) {
            F(3);
            this.f9624o = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + y() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void g() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 4) {
            int i9 = this.f9598f - 1;
            this.f9598f = i9;
            int[] iArr = this.f9601i;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
            this.f9624o = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + y() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void h() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 2) {
            int i9 = this.f9598f - 1;
            this.f9598f = i9;
            this.f9600h[i9] = null;
            int[] iArr = this.f9601i;
            int i10 = i9 - 1;
            iArr[i10] = iArr[i10] + 1;
            this.f9624o = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + y() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean j() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 != 2 && i8 != 4 && i8 != 18) {
            return true;
        }
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean k() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 5) {
            this.f9624o = 0;
            int[] iArr = this.f9601i;
            int i9 = this.f9598f - 1;
            iArr[i9] = iArr[i9] + 1;
            return true;
        } else if (i8 == 6) {
            this.f9624o = 0;
            int[] iArr2 = this.f9601i;
            int i10 = this.f9598f - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + y() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double l() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 16) {
            this.f9624o = 0;
            int[] iArr = this.f9601i;
            int i9 = this.f9598f - 1;
            iArr[i9] = iArr[i9] + 1;
            return this.f9625p;
        }
        if (i8 == 17) {
            this.f9627r = this.f9623n.s0(this.f9626q);
        } else if (i8 == 9) {
            this.f9627r = s0(f9618t);
        } else if (i8 == 8) {
            this.f9627r = s0(f9617s);
        } else if (i8 == 10) {
            this.f9627r = v0();
        } else if (i8 != 11) {
            throw new JsonDataException("Expected a double but was " + y() + " at path " + getPath());
        }
        this.f9624o = 11;
        try {
            double parseDouble = Double.parseDouble(this.f9627r);
            if (!this.f9602j && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.f9627r = null;
            this.f9624o = 0;
            int[] iArr2 = this.f9601i;
            int i10 = this.f9598f - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f9627r + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int m() throws IOException {
        String s02;
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 16) {
            long j8 = this.f9625p;
            int i9 = (int) j8;
            if (j8 == i9) {
                this.f9624o = 0;
                int[] iArr = this.f9601i;
                int i10 = this.f9598f - 1;
                iArr[i10] = iArr[i10] + 1;
                return i9;
            }
            throw new JsonDataException("Expected an int but was " + this.f9625p + " at path " + getPath());
        }
        if (i8 == 17) {
            this.f9627r = this.f9623n.s0(this.f9626q);
        } else if (i8 != 9 && i8 != 8) {
            if (i8 != 11) {
                throw new JsonDataException("Expected an int but was " + y() + " at path " + getPath());
            }
        } else {
            if (i8 == 9) {
                s02 = s0(f9618t);
            } else {
                s02 = s0(f9617s);
            }
            this.f9627r = s02;
            try {
                int parseInt = Integer.parseInt(s02);
                this.f9624o = 0;
                int[] iArr2 = this.f9601i;
                int i11 = this.f9598f - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9624o = 11;
        try {
            double parseDouble = Double.parseDouble(this.f9627r);
            int i12 = (int) parseDouble;
            if (i12 == parseDouble) {
                this.f9627r = null;
                this.f9624o = 0;
                int[] iArr3 = this.f9601i;
                int i13 = this.f9598f - 1;
                iArr3[i13] = iArr3[i13] + 1;
                return i12;
            }
            throw new JsonDataException("Expected an int but was " + this.f9627r + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f9627r + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String q() throws IOException {
        String str;
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 14) {
            str = v0();
        } else if (i8 == 13) {
            str = s0(f9618t);
        } else if (i8 == 12) {
            str = s0(f9617s);
        } else if (i8 == 15) {
            str = this.f9627r;
        } else {
            throw new JsonDataException("Expected a name but was " + y() + " at path " + getPath());
        }
        this.f9624o = 0;
        this.f9600h[this.f9598f - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String t() throws IOException {
        String s02;
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        if (i8 == 10) {
            s02 = v0();
        } else if (i8 == 9) {
            s02 = s0(f9618t);
        } else if (i8 == 8) {
            s02 = s0(f9617s);
        } else if (i8 == 11) {
            s02 = this.f9627r;
            this.f9627r = null;
        } else if (i8 == 16) {
            s02 = Long.toString(this.f9625p);
        } else if (i8 == 17) {
            s02 = this.f9623n.s0(this.f9626q);
        } else {
            throw new JsonDataException("Expected a string but was " + y() + " at path " + getPath());
        }
        this.f9624o = 0;
        int[] iArr = this.f9601i;
        int i9 = this.f9598f - 1;
        iArr[i9] = iArr[i9] + 1;
        return s02;
    }

    public String toString() {
        return "JsonReader(" + this.f9622m + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token y() throws IOException {
        int i8 = this.f9624o;
        if (i8 == 0) {
            i8 = c0();
        }
        switch (i8) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
