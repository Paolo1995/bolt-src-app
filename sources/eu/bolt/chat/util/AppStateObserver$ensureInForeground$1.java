package eu.bolt.chat.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppStateObserver.kt */
@DebugMetadata(c = "eu.bolt.chat.util.AppStateObserver", f = "AppStateObserver.kt", l = {36}, m = "ensureInForeground")
/* loaded from: classes5.dex */
public final class AppStateObserver$ensureInForeground$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39679f;

    /* renamed from: g  reason: collision with root package name */
    boolean f39680g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39681h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ AppStateObserver f39682i;

    /* renamed from: j  reason: collision with root package name */
    int f39683j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppStateObserver$ensureInForeground$1(AppStateObserver appStateObserver, Continuation<? super AppStateObserver$ensureInForeground$1> continuation) {
        super(continuation);
        this.f39682i = appStateObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39681h = obj;
        this.f39683j |= Integer.MIN_VALUE;
        return this.f39682i.c(this);
    }
}
