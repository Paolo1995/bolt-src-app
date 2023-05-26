package kotlinx.serialization.json.internal;

/* compiled from: AbstractJsonLexer.kt */
/* loaded from: classes5.dex */
public final class AbstractJsonLexerKt {
    public static final byte a(char c8) {
        if (c8 < '~') {
            return CharMappings.f52377c[c8];
        }
        return (byte) 0;
    }

    public static final char b(int i8) {
        if (i8 < 117) {
            return CharMappings.f52376b[i8];
        }
        return (char) 0;
    }
}
