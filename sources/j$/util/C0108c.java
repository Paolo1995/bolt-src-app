package j$.util;

import j$.util.function.Function;
import java.io.Serializable;

/* renamed from: j$.util.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0108c implements java.util.Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ java.util.Comparator f50193b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f50194c;

    public /* synthetic */ C0108c(java.util.Comparator comparator, Object obj, int i8) {
        this.f50192a = i8;
        this.f50193b = comparator;
        this.f50194c = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f50192a) {
            case 0:
                java.util.Comparator comparator = this.f50193b;
                java.util.Comparator comparator2 = (java.util.Comparator) this.f50194c;
                int compare = comparator.compare(obj, obj2);
                return compare != 0 ? compare : comparator2.compare(obj, obj2);
            default:
                java.util.Comparator comparator3 = this.f50193b;
                Function function = (Function) this.f50194c;
                return comparator3.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
