package j$.util;

import j$.util.function.C0117b0;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;

/* renamed from: j$.util.v  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0271v implements InterfaceC0123e0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f50732a;

    public /* synthetic */ C0271v(Consumer consumer) {
        this.f50732a = consumer;
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final void accept(long j8) {
        this.f50732a.accept(Long.valueOf(j8));
    }

    @Override // j$.util.function.InterfaceC0123e0
    public final InterfaceC0123e0 h(InterfaceC0123e0 interfaceC0123e0) {
        interfaceC0123e0.getClass();
        return new C0117b0(this, interfaceC0123e0);
    }
}
