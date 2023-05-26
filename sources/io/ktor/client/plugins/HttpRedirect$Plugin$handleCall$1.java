package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRedirect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRedirect.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin", f = "HttpRedirect.kt", l = {107}, m = "handleCall")
/* loaded from: classes5.dex */
public final class HttpRedirect$Plugin$handleCall$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46345f;

    /* renamed from: g  reason: collision with root package name */
    Object f46346g;

    /* renamed from: h  reason: collision with root package name */
    Object f46347h;

    /* renamed from: i  reason: collision with root package name */
    Object f46348i;

    /* renamed from: j  reason: collision with root package name */
    Object f46349j;

    /* renamed from: k  reason: collision with root package name */
    Object f46350k;

    /* renamed from: l  reason: collision with root package name */
    Object f46351l;

    /* renamed from: m  reason: collision with root package name */
    Object f46352m;

    /* renamed from: n  reason: collision with root package name */
    boolean f46353n;

    /* renamed from: o  reason: collision with root package name */
    /* synthetic */ Object f46354o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ HttpRedirect.Plugin f46355p;

    /* renamed from: q  reason: collision with root package name */
    int f46356q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$handleCall$1(HttpRedirect.Plugin plugin, Continuation<? super HttpRedirect$Plugin$handleCall$1> continuation) {
        super(continuation);
        this.f46355p = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e8;
        this.f46354o = obj;
        this.f46356q |= Integer.MIN_VALUE;
        e8 = this.f46355p.e(null, null, null, false, null, this);
        return e8;
    }
}
