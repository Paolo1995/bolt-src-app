package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OutgoingContent.kt */
/* loaded from: classes5.dex */
public abstract class OutgoingContent {

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class ByteArrayContent extends OutgoingContent {
        public ByteArrayContent() {
            super(null);
        }

        public abstract byte[] e();
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class NoContent extends OutgoingContent {
        public NoContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class ProtocolUpgrade extends OutgoingContent {
        public ProtocolUpgrade() {
            super(null);
        }

        @Override // io.ktor.http.content.OutgoingContent
        public final HttpStatusCode d() {
            return HttpStatusCode.f46855c.Q();
        }
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public ReadChannelContent() {
            super(null);
        }

        public abstract ByteReadChannel e();
    }

    /* compiled from: OutgoingContent.kt */
    /* loaded from: classes5.dex */
    public static abstract class WriteChannelContent extends OutgoingContent {
        public WriteChannelContent() {
            super(null);
        }

        public abstract Object e(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation);
    }

    private OutgoingContent() {
    }

    public /* synthetic */ OutgoingContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public Long a() {
        return null;
    }

    public ContentType b() {
        return null;
    }

    public Headers c() {
        return Headers.f46777a.a();
    }

    public HttpStatusCode d() {
        return null;
    }
}
