package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Protocol;
import okhttp3.Response;

/* compiled from: StatusLine.kt */
/* loaded from: classes5.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* compiled from: StatusLine.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatusLine get(Response response) {
            Intrinsics.f(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws IOException {
            boolean L;
            boolean L2;
            Protocol protocol;
            String str;
            Intrinsics.f(statusLine, "statusLine");
            L = StringsKt__StringsJVMKt.L(statusLine, "HTTP/1.", false, 2, null);
            int i8 = 9;
            if (L) {
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt != 0) {
                        if (charAt == 1) {
                            protocol = Protocol.HTTP_1_1;
                        } else {
                            throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
                        }
                    } else {
                        protocol = Protocol.HTTP_1_0;
                    }
                } else {
                    throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
                }
            } else {
                L2 = StringsKt__StringsJVMKt.L(statusLine, "ICY ", false, 2, null);
                if (L2) {
                    protocol = Protocol.HTTP_1_0;
                    i8 = 4;
                } else {
                    throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
                }
            }
            int i9 = i8 + 3;
            if (statusLine.length() >= i9) {
                try {
                    String substring = statusLine.substring(i8, i9);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (statusLine.length() > i9) {
                        if (statusLine.charAt(i9) == ' ') {
                            str = statusLine.substring(i8 + 4);
                            Intrinsics.e(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
                        }
                    } else {
                        str = "";
                    }
                    return new StatusLine(protocol, parseInt, str);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
                }
            }
            throw new ProtocolException(Intrinsics.n("Unexpected status line: ", statusLine));
        }
    }

    public StatusLine(Protocol protocol, int i8, String message) {
        Intrinsics.f(protocol, "protocol");
        Intrinsics.f(message, "message");
        this.protocol = protocol;
        this.code = i8;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
