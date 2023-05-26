package okhttp3.internal.ws;

import okio.ByteString;

/* compiled from: MessageDeflater.kt */
/* loaded from: classes5.dex */
public final class MessageDeflaterKt {
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.f52591i.b("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
}
