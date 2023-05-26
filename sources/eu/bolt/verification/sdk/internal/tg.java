package eu.bolt.verification.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class tg extends Lambda implements Function0<Object> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function0<Object> f45199f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f45200g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg(Function0<Object> function0, Function0<Unit> function02) {
        super(0);
        this.f45199f = function0;
        this.f45200g = function02;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object invoke = this.f45199f.invoke();
        this.f45200g.invoke();
        return invoke;
    }
}
