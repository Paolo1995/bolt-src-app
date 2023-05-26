package j$.util.function;

import java.util.function.LongConsumer;

/* renamed from: j$.util.function.c0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0119c0 implements InterfaceC0123e0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongConsumer f50315a;

    private /* synthetic */ C0119c0(LongConsumer longConsumer) {
        this.f50315a = longConsumer;
    }

    public static /* synthetic */ InterfaceC0123e0 a(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return longConsumer instanceof C0121d0 ? ((C0121d0) longConsumer).f50316a : new C0119c0(longConsumer);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final /* synthetic */ void accept(long j8) {
        this.f50315a.accept(j8);
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final /* synthetic */ InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        return a(this.f50315a.andThen(C0121d0.a(interfaceC0123e0)));
    }
}
