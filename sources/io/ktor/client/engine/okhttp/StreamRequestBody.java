package io.ktor.client.engine.okhttp;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* compiled from: StreamRequestBody.kt */
/* loaded from: classes5.dex */
public final class StreamRequestBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private final Long f46225a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<ByteReadChannel> f46226b;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamRequestBody(Long l8, Function0<? extends ByteReadChannel> block) {
        Intrinsics.f(block, "block");
        this.f46225a = l8;
        this.f46226b = block;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        Long l8 = this.f46225a;
        if (l8 != null) {
            return l8.longValue();
        }
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return null;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return true;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) {
        Intrinsics.f(sink, "sink");
        Source k8 = Okio.k(BlockingKt.d(this.f46226b.invoke(), null, 1, null));
        try {
            sink.V(k8);
            CloseableKt.a(k8, null);
        } finally {
        }
    }
}
