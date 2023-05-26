package j$.util.function;

import java.util.function.LongFunction;

/* renamed from: j$.util.function.g0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0127g0 implements LongFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0129h0 f50321a;

    private /* synthetic */ C0127g0(InterfaceC0129h0 interfaceC0129h0) {
        this.f50321a = interfaceC0129h0;
    }

    public static /* synthetic */ LongFunction a(InterfaceC0129h0 interfaceC0129h0) {
        if (interfaceC0129h0 == null) {
            return null;
        }
        return interfaceC0129h0 instanceof C0125f0 ? ((C0125f0) interfaceC0129h0).f50319a : new C0127g0(interfaceC0129h0);
    }

    @Override // java.util.function.LongFunction
    public final /* synthetic */ Object apply(long j8) {
        return this.f50321a.apply(j8);
    }
}
