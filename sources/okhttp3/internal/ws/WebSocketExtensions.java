package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* compiled from: WebSocketExtensions.kt */
/* loaded from: classes5.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* compiled from: WebSocketExtensions.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            boolean w7;
            boolean w8;
            String str;
            boolean w9;
            Integer m8;
            boolean w10;
            boolean w11;
            Integer m9;
            boolean w12;
            Intrinsics.f(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            int i8 = 0;
            boolean z7 = false;
            Integer num = null;
            boolean z8 = false;
            Integer num2 = null;
            boolean z9 = false;
            boolean z10 = false;
            while (i8 < size) {
                int i9 = i8 + 1;
                w7 = StringsKt__StringsJVMKt.w(responseHeaders.name(i8), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true);
                if (w7) {
                    String value = responseHeaders.value(i8);
                    int i10 = 0;
                    while (i10 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i10, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i10, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i10, delimiterOffset);
                        int i11 = delimiterOffset + 1;
                        w8 = StringsKt__StringsJVMKt.w(trimSubstring, "permessage-deflate", true);
                        if (w8) {
                            if (z7) {
                                z10 = true;
                            }
                            i10 = i11;
                            while (i10 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i10, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i10, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i10, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = StringsKt__StringsKt.u0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"");
                                } else {
                                    str = null;
                                }
                                i10 = delimiterOffset2 + 1;
                                w9 = StringsKt__StringsJVMKt.w(trimSubstring2, "client_max_window_bits", true);
                                if (w9) {
                                    if (num != null) {
                                        z10 = true;
                                    }
                                    if (str == null) {
                                        num = null;
                                    } else {
                                        m8 = StringsKt__StringNumberConversionsKt.m(str);
                                        num = m8;
                                    }
                                    if (num == null) {
                                        z10 = true;
                                    }
                                } else {
                                    w10 = StringsKt__StringsJVMKt.w(trimSubstring2, "client_no_context_takeover", true);
                                    if (w10) {
                                        if (z8) {
                                            z10 = true;
                                        }
                                        if (str != null) {
                                            z10 = true;
                                        }
                                        z8 = true;
                                    } else {
                                        w11 = StringsKt__StringsJVMKt.w(trimSubstring2, "server_max_window_bits", true);
                                        if (w11) {
                                            if (num2 != null) {
                                                z10 = true;
                                            }
                                            if (str == null) {
                                                num2 = null;
                                            } else {
                                                m9 = StringsKt__StringNumberConversionsKt.m(str);
                                                num2 = m9;
                                            }
                                            if (num2 == null) {
                                                z10 = true;
                                            }
                                        } else {
                                            w12 = StringsKt__StringsJVMKt.w(trimSubstring2, "server_no_context_takeover", true);
                                            if (w12) {
                                                if (z9) {
                                                    z10 = true;
                                                }
                                                if (str != null) {
                                                    z10 = true;
                                                }
                                                z9 = true;
                                            } else {
                                                z10 = true;
                                            }
                                        }
                                    }
                                }
                            }
                            z7 = true;
                        } else {
                            i10 = i11;
                            z10 = true;
                        }
                    }
                }
                i8 = i9;
            }
            return new WebSocketExtensions(z7, num, z8, num2, z9, z10);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10) {
        this.perMessageDeflate = z7;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z8;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z9;
        this.unknownValues = z10;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = webSocketExtensions.perMessageDeflate;
        }
        if ((i8 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i8 & 4) != 0) {
            z8 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z11 = z8;
        if ((i8 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i8 & 16) != 0) {
            z9 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z12 = z9;
        if ((i8 & 32) != 0) {
            z10 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z7, num3, z11, num4, z12, z10);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10) {
        return new WebSocketExtensions(z7, num, z8, num2, z9, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebSocketExtensions) {
            WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
            return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z7 = this.perMessageDeflate;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (i8 + (num == null ? 0 : num.hashCode())) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i9 = r22;
        if (r22 != 0) {
            i9 = 1;
        }
        int i10 = (hashCode + i9) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int hashCode2 = (i10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i11 = r23;
        if (r23 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode2 + i11) * 31;
        boolean z8 = this.unknownValues;
        return i12 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z7) {
        if (z7) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public /* synthetic */ WebSocketExtensions(boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? false : z8, (i8 & 8) == 0 ? num2 : null, (i8 & 16) != 0 ? false : z9, (i8 & 32) != 0 ? false : z10);
    }
}
