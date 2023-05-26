package j$.util.function;

import j$.util.function.BiFunction;
import java.util.function.BinaryOperator;

/* renamed from: j$.util.function.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0116b implements InterfaceC0120d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f50311a;

    private /* synthetic */ C0116b(BinaryOperator binaryOperator) {
        this.f50311a = binaryOperator;
    }

    public static /* synthetic */ InterfaceC0120d a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0118c ? ((C0118c) binaryOperator).f50314a : new C0116b(binaryOperator);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.VivifiedWrapper.convert(this.f50311a.andThen(C.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.f50311a.apply(obj, obj2);
    }
}
