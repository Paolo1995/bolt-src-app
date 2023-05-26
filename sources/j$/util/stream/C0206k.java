package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0116b;
import j$.util.function.Function;
import j$.util.function.InterfaceC0120d;
import j$.util.function.Supplier;
import java.util.Set;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.k  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0206k implements InterfaceC0214m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collector f50603a;

    private /* synthetic */ C0206k(Collector collector) {
        this.f50603a = collector;
    }

    public static /* synthetic */ InterfaceC0214m d(Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof C0210l ? ((C0210l) collector).f50610a : new C0206k(collector);
    }

    public final /* synthetic */ BiConsumer a() {
        return BiConsumer.VivifiedWrapper.convert(this.f50603a.accumulator());
    }

    public final /* synthetic */ Set b() {
        return this.f50603a.characteristics();
    }

    public final /* synthetic */ InterfaceC0120d c() {
        return C0116b.a(this.f50603a.combiner());
    }

    public final /* synthetic */ Function e() {
        return Function.VivifiedWrapper.convert(this.f50603a.finisher());
    }

    public final /* synthetic */ Supplier f() {
        return j$.util.function.F0.a(this.f50603a.supplier());
    }
}
