package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f9597l = new String[128];

    /* renamed from: f  reason: collision with root package name */
    int f9598f;

    /* renamed from: g  reason: collision with root package name */
    int[] f9599g = new int[32];

    /* renamed from: h  reason: collision with root package name */
    String[] f9600h = new String[32];

    /* renamed from: i  reason: collision with root package name */
    int[] f9601i = new int[32];

    /* renamed from: j  reason: collision with root package name */
    boolean f9602j;

    /* renamed from: k  reason: collision with root package name */
    boolean f9603k;

    /* loaded from: classes.dex */
    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        final String[] f9604a;

        /* renamed from: b  reason: collision with root package name */
        final okio.Options f9605b;

        private Options(String[] strArr, okio.Options options) {
            this.f9604a = strArr;
            this.f9605b = options;
        }

        public static Options a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i8 = 0; i8 < strArr.length; i8++) {
                    JsonReader.X(buffer, strArr[i8]);
                    buffer.readByte();
                    byteStringArr[i8] = buffer.N0();
                }
                return new Options((String[]) strArr.clone(), okio.Options.o(byteStringArr));
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i8 = 0; i8 <= 31; i8++) {
            f9597l[i8] = String.format("\\u%04x", Integer.valueOf(i8));
        }
        String[] strArr = f9597l;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void X(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f9597l
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.U(r8, r4, r3)
        L2e:
            r7.Q(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.U(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.X(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader w(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F(int i8) {
        int i9 = this.f9598f;
        int[] iArr = this.f9599g;
        if (i9 == iArr.length) {
            if (i9 != 256) {
                this.f9599g = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f9600h;
                this.f9600h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f9601i;
                this.f9601i = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f9599g;
        int i10 = this.f9598f;
        this.f9598f = i10 + 1;
        iArr3[i10] = i8;
    }

    public abstract int I(Options options) throws IOException;

    public abstract void N() throws IOException;

    public abstract void O() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException Y(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void c() throws IOException;

    public abstract void e() throws IOException;

    public abstract void g() throws IOException;

    public final String getPath() {
        return JsonScope.a(this.f9598f, this.f9599g, this.f9600h, this.f9601i);
    }

    public abstract void h() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract boolean k() throws IOException;

    public abstract double l() throws IOException;

    public abstract int m() throws IOException;

    public abstract String q() throws IOException;

    public abstract String t() throws IOException;

    public abstract Token y() throws IOException;
}
