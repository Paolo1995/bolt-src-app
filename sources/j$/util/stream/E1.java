package j$.util.stream;

import j$.util.Optional;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0120d;

/* loaded from: classes2.dex */
final class E1 implements P1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f50385a;

    /* renamed from: b  reason: collision with root package name */
    private Object f50386b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50387c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E1(InterfaceC0120d interfaceC0120d) {
        this.f50387c = interfaceC0120d;
    }

    @Override // j$.util.stream.InterfaceC0193g2, j$.util.stream.InterfaceC0179d2, j$.util.function.InterfaceC0135l
    public final /* synthetic */ void accept(double d8) {
        AbstractC0254w0.o0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(int i8) {
        AbstractC0254w0.v0();
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void accept(long j8) {
        AbstractC0254w0.w0();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        if (this.f50385a) {
            this.f50385a = false;
        } else {
            obj = this.f50387c.apply(this.f50386b, obj);
        }
        this.f50386b = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        this.f50385a = true;
        this.f50386b = null;
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final /* synthetic */ boolean g() {
        return false;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return this.f50385a ? Optional.a() : Optional.b(this.f50386b);
    }

    @Override // j$.util.stream.P1
    public final void j(P1 p12) {
        E1 e12 = (E1) p12;
        if (e12.f50385a) {
            return;
        }
        accept(e12.f50386b);
    }
}
