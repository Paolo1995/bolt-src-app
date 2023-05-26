package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AbstractJsonLexer.kt */
/* loaded from: classes5.dex */
public abstract class AbstractJsonLexer {

    /* renamed from: a  reason: collision with root package name */
    protected int f52364a;

    /* renamed from: c  reason: collision with root package name */
    private String f52366c;

    /* renamed from: b  reason: collision with root package name */
    public final JsonPath f52365b = new JsonPath();

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f52367d = new StringBuilder();

    private final int B(CharSequence charSequence, int i8) {
        boolean z7;
        boolean z8;
        char charAt = charSequence.charAt(i8);
        boolean z9 = true;
        if ('0' <= charAt && charAt < ':') {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return charAt - '0';
        }
        char c8 = 'a';
        if ('a' <= charAt && charAt < 'g') {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            c8 = 'A';
            if (!(('A' > charAt || charAt >= 'G') ? false : false)) {
                y(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c8) + 10;
    }

    private final String K() {
        String str = this.f52366c;
        Intrinsics.c(str);
        this.f52366c = null;
        return str;
    }

    private final boolean O() {
        if (C().charAt(this.f52364a - 1) != '\"') {
            return true;
        }
        return false;
    }

    private final int b(int i8) {
        int G = G(i8);
        if (G != -1) {
            int i9 = G + 1;
            char charAt = C().charAt(G);
            if (charAt == 'u') {
                return d(C(), i9);
            }
            char b8 = AbstractJsonLexerKt.b(charAt);
            if (b8 != 0) {
                this.f52367d.append(b8);
                return i9;
            }
            y(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int c(int i8, int i9) {
        e(i8, i9);
        return b(i9 + 1);
    }

    private final int d(CharSequence charSequence, int i8) {
        int i9 = i8 + 4;
        if (i9 >= charSequence.length()) {
            this.f52364a = i8;
            v();
            if (this.f52364a + 4 < charSequence.length()) {
                return d(charSequence, this.f52364a);
            }
            y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        this.f52367d.append((char) ((B(charSequence, i8) << 12) + (B(charSequence, i8 + 1) << 8) + (B(charSequence, i8 + 2) << 4) + B(charSequence, i8 + 3)));
        return i9;
    }

    private final boolean h(int i8) {
        int G = G(i8);
        if (G < C().length() && G != -1) {
            int i9 = G + 1;
            int charAt = C().charAt(G) | ' ';
            if (charAt != 102) {
                if (charAt == 116) {
                    j("rue", i9);
                    return true;
                }
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            j("alse", i9);
            return false;
        }
        y(this, "EOF", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void j(String str, int i8) {
        if (C().length() - i8 >= str.length()) {
            int length = str.length();
            for (int i9 = 0; i9 < length; i9++) {
                if (str.charAt(i9) != (C().charAt(i8 + i9) | ' ')) {
                    y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
            this.f52364a = i8 + str.length();
            return;
        }
        y(this, "Unexpected end of boolean literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String u(int i8, int i9) {
        e(i8, i9);
        String sb = this.f52367d.toString();
        Intrinsics.e(sb, "escapedString.toString()");
        this.f52367d.setLength(0);
        return sb;
    }

    public static /* synthetic */ Void y(AbstractJsonLexer abstractJsonLexer, String str, int i8, String str2, int i9, Object obj) {
        if (obj == null) {
            if ((i9 & 2) != 0) {
                i8 = abstractJsonLexer.f52364a;
            }
            if ((i9 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.x(str, i8, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final void A(String key) {
        int h02;
        Intrinsics.f(key, "key");
        h02 = StringsKt__StringsKt.h0(J(0, this.f52364a), key, 0, false, 6, null);
        x("Encountered an unknown key '" + key + '\'', h02, "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence C();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean D(char c8) {
        return !(((c8 == '}' || c8 == ']') || c8 == ':') || c8 == ',');
    }

    public final byte E() {
        CharSequence C = C();
        int i8 = this.f52364a;
        while (true) {
            int G = G(i8);
            if (G != -1) {
                char charAt = C.charAt(G);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    this.f52364a = G;
                    return AbstractJsonLexerKt.a(charAt);
                }
                i8 = G + 1;
            } else {
                this.f52364a = G;
                return (byte) 10;
            }
        }
    }

    public final String F(boolean z7) {
        String q8;
        byte E = E();
        if (z7) {
            if (E != 1 && E != 0) {
                return null;
            }
            q8 = s();
        } else if (E != 1) {
            return null;
        } else {
            q8 = q();
        }
        this.f52366c = q8;
        return q8;
    }

    public abstract int G(int i8);

    public final void H(boolean z7) {
        Object h02;
        Object h03;
        ArrayList arrayList = new ArrayList();
        byte E = E();
        if (E != 8 && E != 6) {
            s();
            return;
        }
        while (true) {
            byte E2 = E();
            boolean z8 = true;
            if (E2 == 1) {
                if (z7) {
                    s();
                } else {
                    k();
                }
            } else {
                if (E2 != 8 && E2 != 6) {
                    z8 = false;
                }
                if (z8) {
                    arrayList.add(Byte.valueOf(E2));
                } else if (E2 == 9) {
                    h03 = CollectionsKt___CollectionsKt.h0(arrayList);
                    if (((Number) h03).byteValue() == 8) {
                        CollectionsKt__MutableCollectionsKt.J(arrayList);
                    } else {
                        int i8 = this.f52364a;
                        throw JsonExceptionsKt.e(i8, "found ] instead of } at path: " + this.f52365b, C());
                    }
                } else if (E2 == 7) {
                    h02 = CollectionsKt___CollectionsKt.h0(arrayList);
                    if (((Number) h02).byteValue() == 6) {
                        CollectionsKt__MutableCollectionsKt.J(arrayList);
                    } else {
                        int i9 = this.f52364a;
                        throw JsonExceptionsKt.e(i9, "found } instead of ] at path: " + this.f52365b, C());
                    }
                } else if (E2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            }
        }
    }

    public int I() {
        int G;
        char charAt;
        int i8 = this.f52364a;
        while (true) {
            G = G(i8);
            if (G == -1 || !((charAt = C().charAt(G)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                break;
            }
            i8 = G + 1;
        }
        this.f52364a = G;
        return G;
    }

    public String J(int i8, int i9) {
        return C().subSequence(i8, i9).toString();
    }

    public abstract boolean L();

    public final boolean M() {
        int G = G(I());
        int length = C().length() - G;
        if (length < 4 || G == -1) {
            return true;
        }
        for (int i8 = 0; i8 < 4; i8++) {
            if ("null".charAt(i8) != C().charAt(G + i8)) {
                return true;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.a(C().charAt(G + 4)) == 0) {
            return true;
        }
        this.f52364a = G + 4;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(char c8) {
        int i8 = this.f52364a - 1;
        this.f52364a = i8;
        if (i8 >= 0 && c8 == '\"' && Intrinsics.a(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.f52364a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new KotlinNothingValueException();
        } else {
            z(AbstractJsonLexerKt.a(c8));
            throw new KotlinNothingValueException();
        }
    }

    protected void e(int i8, int i9) {
        this.f52367d.append(C(), i8, i9);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean i() {
        boolean z7;
        int I = I();
        if (I != C().length()) {
            if (C().charAt(I) == '\"') {
                I++;
                z7 = true;
            } else {
                z7 = false;
            }
            boolean h8 = h(I);
            if (z7) {
                if (this.f52364a != C().length()) {
                    if (C().charAt(this.f52364a) == '\"') {
                        this.f52364a++;
                    } else {
                        y(this, "Expected closing quotation mark", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    y(this, "EOF", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
            return h8;
        }
        y(this, "EOF", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public abstract String k();

    public abstract String l(String str, boolean z7);

    public abstract byte m();

    public final byte n(byte b8) {
        byte m8 = m();
        if (m8 == b8) {
            return m8;
        }
        z(b8);
        throw new KotlinNothingValueException();
    }

    public void o(char c8) {
        v();
        CharSequence C = C();
        int i8 = this.f52364a;
        while (true) {
            int G = G(i8);
            if (G != -1) {
                int i9 = G + 1;
                char charAt = C.charAt(G);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                    this.f52364a = i9;
                    if (charAt == c8) {
                        return;
                    }
                    N(c8);
                }
                i8 = i9;
            } else {
                this.f52364a = G;
                N(c8);
                return;
            }
        }
    }

    public final long p() {
        boolean z7;
        boolean z8;
        int G = G(I());
        if (G < C().length() && G != -1) {
            if (C().charAt(G) == '\"') {
                G++;
                if (G != C().length()) {
                    z7 = true;
                } else {
                    y(this, "EOF", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                z7 = false;
            }
            int i8 = G;
            long j8 = 0;
            boolean z9 = true;
            boolean z10 = false;
            while (z9) {
                char charAt = C().charAt(i8);
                if (charAt == '-') {
                    if (i8 == G) {
                        i8++;
                        z10 = true;
                    } else {
                        y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                } else if (AbstractJsonLexerKt.a(charAt) != 0) {
                    break;
                } else {
                    i8++;
                    if (i8 != C().length()) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int i9 = charAt - '0';
                    if (i9 >= 0 && i9 < 10) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        j8 = (j8 * 10) - i9;
                        if (j8 > 0) {
                            y(this, "Numeric value overflow", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        y(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (G != i8 && (!z10 || G != i8 - 1)) {
                if (z7) {
                    if (z9) {
                        if (C().charAt(i8) == '\"') {
                            i8++;
                        } else {
                            y(this, "Expected closing quotation mark", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        y(this, "EOF", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                }
                this.f52364a = i8;
                if (!z10) {
                    if (j8 != Long.MIN_VALUE) {
                        return -j8;
                    }
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                return j8;
            }
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        y(this, "EOF", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        if (this.f52366c != null) {
            return K();
        }
        return k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String r(CharSequence source, int i8, int i9) {
        String u7;
        int G;
        Intrinsics.f(source, "source");
        char charAt = source.charAt(i9);
        boolean z7 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                G = G(c(i8, i9));
                if (G == -1) {
                    y(this, "EOF", G, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i9++;
                if (i9 >= source.length()) {
                    e(i8, i9);
                    G = G(i9);
                    if (G == -1) {
                        y(this, "EOF", G, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = source.charAt(i9);
                }
            }
            i8 = G;
            i9 = i8;
            z7 = true;
            charAt = source.charAt(i9);
        }
        if (!z7) {
            u7 = J(i8, i9);
        } else {
            u7 = u(i8, i9);
        }
        this.f52364a = i9 + 1;
        return u7;
    }

    public final String s() {
        String u7;
        if (this.f52366c != null) {
            return K();
        }
        int I = I();
        if (I < C().length() && I != -1) {
            byte a8 = AbstractJsonLexerKt.a(C().charAt(I));
            if (a8 == 1) {
                return q();
            }
            if (a8 == 0) {
                boolean z7 = false;
                while (AbstractJsonLexerKt.a(C().charAt(I)) == 0) {
                    I++;
                    if (I >= C().length()) {
                        e(this.f52364a, I);
                        int G = G(I);
                        if (G == -1) {
                            this.f52364a = I;
                            return u(0, 0);
                        }
                        I = G;
                        z7 = true;
                    }
                }
                if (!z7) {
                    u7 = J(this.f52364a, I);
                } else {
                    u7 = u(this.f52364a, I);
                }
                this.f52364a = I;
                return u7;
            }
            y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        y(this, "EOF", I, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final String t() {
        String s7 = s();
        if (Intrinsics.a(s7, "null") && O()) {
            y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return s7;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f52364a + ')';
    }

    public void v() {
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.f52364a - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void x(String message, int i8, String hint) {
        boolean z7;
        String str;
        Intrinsics.f(message, "message");
        Intrinsics.f(hint, "hint");
        if (hint.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw JsonExceptionsKt.e(i8, message + " at path: " + this.f52365b.a() + str, C());
    }

    public final Void z(byte b8) {
        String str;
        String str2;
        if (b8 == 1) {
            str = "quotation mark '\"'";
        } else if (b8 == 4) {
            str = "comma ','";
        } else if (b8 == 5) {
            str = "colon ':'";
        } else if (b8 == 6) {
            str = "start of the object '{'";
        } else if (b8 == 7) {
            str = "end of the object '}'";
        } else if (b8 == 8) {
            str = "start of the array '['";
        } else if (b8 == 9) {
            str = "end of the array ']'";
        } else {
            str = "valid token";
        }
        if (this.f52364a != C().length() && this.f52364a > 0) {
            str2 = String.valueOf(C().charAt(this.f52364a - 1));
        } else {
            str2 = "EOF";
        }
        y(this, "Expected " + str + ", but had '" + str2 + "' instead", this.f52364a - 1, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
