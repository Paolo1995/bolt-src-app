package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.InterfaceC0120d;

/* renamed from: j$.util.stream.s  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0237s implements InterfaceC0120d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f50669b;

    public /* synthetic */ C0237s(BiConsumer biConsumer, int i8) {
        this.f50668a = i8;
        this.f50669b = biConsumer;
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f50668a) {
            case 0:
                return BiFunction.CC.$default$andThen(this, function);
            case 1:
                return BiFunction.CC.$default$andThen(this, function);
            default:
                return BiFunction.CC.$default$andThen(this, function);
        }
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f50668a) {
            case 0:
                this.f50669b.accept(obj, obj2);
                return obj;
            case 1:
                BiConsumer biConsumer = this.f50669b;
                int i8 = AbstractC0182e0.f50570s;
                biConsumer.accept(obj, obj2);
                return obj;
            default:
                BiConsumer biConsumer2 = this.f50669b;
                int i9 = AbstractC0207k0.f50604s;
                biConsumer2.accept(obj, obj2);
                return obj;
        }
    }
}
