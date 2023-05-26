package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* compiled from: Credentials.kt */
/* loaded from: classes5.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String username, String password) {
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        return basic$default(username, password, null, 4, null);
    }

    public static final String basic(String username, String password, Charset charset) {
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        Intrinsics.f(charset, "charset");
        return Intrinsics.n("Basic ", ByteString.f52591i.c(username + ':' + password, charset).a());
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            Intrinsics.e(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }
}
