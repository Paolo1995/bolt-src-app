package j$.util.stream;

import j$.util.function.Predicate;

/* renamed from: j$.util.stream.o0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0223o0 extends AbstractC0238s0 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EnumC0242t0 f50629c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Predicate f50630d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0223o0(Predicate predicate, EnumC0242t0 enumC0242t0) {
        super(enumC0242t0);
        this.f50629c = enumC0242t0;
        this.f50630d = predicate;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        boolean z7;
        boolean z8;
        if (this.f50670a) {
            return;
        }
        boolean test = this.f50630d.test(obj);
        z7 = this.f50629c.f50677a;
        if (test == z7) {
            this.f50670a = true;
            z8 = this.f50629c.f50678b;
            this.f50671b = z8;
        }
    }
}
