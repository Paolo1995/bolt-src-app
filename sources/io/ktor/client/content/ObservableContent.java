package io.ktor.client.content;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ObservableContent.kt */
/* loaded from: classes5.dex */
public final class ObservableContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f46101a;

    /* renamed from: b  reason: collision with root package name */
    private final Function3<Long, Long, Continuation<? super Unit>, Object> f46102b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteReadChannel f46103c;

    /* renamed from: d  reason: collision with root package name */
    private final OutgoingContent f46104d;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservableContent(OutgoingContent delegate, CoroutineContext callContext, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> listener) {
        ByteReadChannel channel;
        Intrinsics.f(delegate, "delegate");
        Intrinsics.f(callContext, "callContext");
        Intrinsics.f(listener, "listener");
        this.f46101a = callContext;
        this.f46102b = listener;
        if (delegate instanceof OutgoingContent.ByteArrayContent) {
            channel = ByteChannelCtorKt.a(((OutgoingContent.ByteArrayContent) delegate).e());
        } else if (!(delegate instanceof OutgoingContent.ProtocolUpgrade)) {
            if (delegate instanceof OutgoingContent.NoContent) {
                channel = ByteReadChannel.f47328a.a();
            } else if (delegate instanceof OutgoingContent.ReadChannelContent) {
                channel = ((OutgoingContent.ReadChannelContent) delegate).e();
            } else if (delegate instanceof OutgoingContent.WriteChannelContent) {
                channel = CoroutinesKt.b(GlobalScope.f51286f, callContext, true, new ObservableContent$content$1(delegate, null)).getChannel();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new UnsupportedContentTypeException(delegate);
        }
        this.f46103c = channel;
        this.f46104d = delegate;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long a() {
        return this.f46104d.a();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType b() {
        return this.f46104d.b();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers c() {
        return this.f46104d.c();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode d() {
        return this.f46104d.d();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel e() {
        return ByteChannelUtilsKt.a(this.f46103c, this.f46101a, a(), this.f46102b);
    }
}
