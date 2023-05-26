package j$.util.function;

import java.util.function.LongConsumer;

/* renamed from: j$.util.function.d0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0121d0 implements LongConsumer {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0123e0 f50316a;

    private /* synthetic */ C0121d0(InterfaceC0123e0 interfaceC0123e0) {
        this.f50316a = interfaceC0123e0;
    }

    public static /* synthetic */ LongConsumer a(InterfaceC0123e0 interfaceC0123e0) {
        if (interfaceC0123e0 == null) {
            return null;
        }
        return interfaceC0123e0 instanceof C0119c0 ? ((C0119c0) interfaceC0123e0).f50315a : new C0121d0(interfaceC0123e0);
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j8) {
        this.f50316a.accept(j8);
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a(this.f50316a.h(C0119c0.a(longConsumer)));
    }
}
