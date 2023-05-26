package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0118c;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0210l implements Collector {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0214m f50610a;

    private /* synthetic */ C0210l(InterfaceC0214m interfaceC0214m) {
        this.f50610a = interfaceC0214m;
    }

    public static /* synthetic */ Collector a(InterfaceC0214m interfaceC0214m) {
        if (interfaceC0214m == null) {
            return null;
        }
        return interfaceC0214m instanceof C0206k ? ((C0206k) interfaceC0214m).f50603a : new C0210l(interfaceC0214m);
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ BiConsumer accumulator() {
        return BiConsumer.Wrapper.convert(((C0206k) this.f50610a).a());
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Set characteristics() {
        return ((C0206k) this.f50610a).b();
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ BinaryOperator combiner() {
        return C0118c.a(((C0206k) this.f50610a).c());
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Function finisher() {
        return j$.util.function.C.a(((C0206k) this.f50610a).e());
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Supplier supplier() {
        return j$.util.function.G0.a(((C0206k) this.f50610a).f());
    }
}
