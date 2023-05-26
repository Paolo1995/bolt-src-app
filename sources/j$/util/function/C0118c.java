package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.function.BinaryOperator;

/* renamed from: j$.util.function.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0118c implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0120d f50314a;

    private /* synthetic */ C0118c(InterfaceC0120d interfaceC0120d) {
        this.f50314a = interfaceC0120d;
    }

    public static /* synthetic */ BinaryOperator a(InterfaceC0120d interfaceC0120d) {
        if (interfaceC0120d == null) {
            return null;
        }
        return interfaceC0120d instanceof C0116b ? ((C0116b) interfaceC0120d).f50311a : new C0118c(interfaceC0120d);
    }

    @Override // java.util.function.BiFunction
    public final /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
        return BiFunction.Wrapper.convert(this.f50314a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    @Override // java.util.function.BiFunction
    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f50314a.apply(obj, obj2);
    }
}
