package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: StringJsonLexer.kt */
/* loaded from: classes5.dex */
public final class StringJsonLexer extends AbstractJsonLexer {

    /* renamed from: e  reason: collision with root package name */
    private final String f52443e;

    public StringJsonLexer(String source) {
        Intrinsics.f(source, "source");
        this.f52443e = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int G(int i8) {
        if (i8 >= C().length()) {
            return -1;
        }
        return i8;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int I() {
        char charAt;
        int i8 = this.f52364a;
        if (i8 == -1) {
            return i8;
        }
        while (i8 < C().length() && ((charAt = C().charAt(i8)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i8++;
        }
        this.f52364a = i8;
        return i8;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.f52364a++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    /* renamed from: P */
    public String C() {
        return this.f52443e;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean f() {
        int i8 = this.f52364a;
        if (i8 == -1) {
            return false;
        }
        while (i8 < C().length()) {
            char charAt = C().charAt(i8);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f52364a = i8;
                return D(charAt);
            }
            i8++;
        }
        this.f52364a = i8;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String k() {
        int a02;
        o('\"');
        int i8 = this.f52364a;
        a02 = StringsKt__StringsKt.a0(C(), '\"', i8, false, 4, null);
        if (a02 != -1) {
            for (int i9 = i8; i9 < a02; i9++) {
                if (C().charAt(i9) == '\\') {
                    return r(C(), this.f52364a, i9);
                }
            }
            this.f52364a = a02 + 1;
            String substring = C().substring(i8, a02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        z((byte) 1);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String l(String keyToMatch, boolean z7) {
        String t7;
        String t8;
        Intrinsics.f(keyToMatch, "keyToMatch");
        int i8 = this.f52364a;
        try {
            if (m() != 6) {
                return null;
            }
            if (z7) {
                t7 = k();
            } else {
                t7 = t();
            }
            if (!Intrinsics.a(t7, keyToMatch)) {
                return null;
            }
            if (m() != 5) {
                return null;
            }
            if (z7) {
                t8 = q();
            } else {
                t8 = t();
            }
            return t8;
        } finally {
            this.f52364a = i8;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte m() {
        byte a8;
        String C = C();
        do {
            int i8 = this.f52364a;
            if (i8 != -1 && i8 < C.length()) {
                int i9 = this.f52364a;
                this.f52364a = i9 + 1;
                a8 = AbstractJsonLexerKt.a(C.charAt(i9));
            } else {
                return (byte) 10;
            }
        } while (a8 == 3);
        return a8;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void o(char c8) {
        if (this.f52364a == -1) {
            N(c8);
        }
        String C = C();
        while (this.f52364a < C.length()) {
            int i8 = this.f52364a;
            this.f52364a = i8 + 1;
            char charAt = C.charAt(i8);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == c8) {
                    return;
                }
                N(c8);
            }
        }
        N(c8);
    }
}
