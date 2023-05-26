package j$.util;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;

/* renamed from: j$.util.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0107b implements java.util.Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50187b;

    public /* synthetic */ C0107b(int i8, Object obj) {
        this.f50186a = i8;
        this.f50187b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f50186a) {
            case 0:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f50187b;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 1:
                ToIntFunction toIntFunction = (ToIntFunction) this.f50187b;
                return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            case 2:
                ToLongFunction toLongFunction = (ToLongFunction) this.f50187b;
                return Long.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
            default:
                Function function = (Function) this.f50187b;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
        }
    }
}
