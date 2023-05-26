package eu.bolt.chat.util;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoroutineRunner.kt */
/* loaded from: classes5.dex */
public final class StableCoroutineRunner implements CoroutineRunner {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineScope f39703a;

    public StableCoroutineRunner(CoroutineScope scope) {
        Intrinsics.f(scope, "scope");
        this.f39703a = scope;
    }

    @Override // eu.bolt.chat.util.CoroutineRunner
    public Job a(Function2<? super CoroutineRunner, ? super Continuation<? super Unit>, ? extends Object> block) {
        Job d8;
        Intrinsics.f(block, "block");
        d8 = BuildersKt__Builders_commonKt.d(this.f39703a, null, null, new StableCoroutineRunner$launch$1(block, this, null), 3, null);
        return d8;
    }
}
