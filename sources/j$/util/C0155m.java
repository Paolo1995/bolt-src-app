package j$.util;

import j$.util.function.C0130i;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0135l;

/* renamed from: j$.util.m  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0155m implements InterfaceC0135l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f50360a;

    public /* synthetic */ C0155m(Consumer consumer) {
        this.f50360a = consumer;
    }

    @Override // j$.util.function.InterfaceC0135l
    public final void accept(double d8) {
        this.f50360a.accept(Double.valueOf(d8));
    }

    @Override // j$.util.function.InterfaceC0135l
    public final InterfaceC0135l l(InterfaceC0135l interfaceC0135l) {
        interfaceC0135l.getClass();
        return new C0130i(this, interfaceC0135l);
    }
}
