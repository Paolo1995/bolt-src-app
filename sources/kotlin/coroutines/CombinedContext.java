package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes5.dex */
public final class CombinedContext implements CoroutineContext, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f50906f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext.Element f50907g;

    public CombinedContext(CoroutineContext left, CoroutineContext.Element element) {
        Intrinsics.f(left, "left");
        Intrinsics.f(element, "element");
        this.f50906f = left;
        this.f50907g = element;
    }

    private final boolean b(CoroutineContext.Element element) {
        return Intrinsics.a(g(element.getKey()), element);
    }

    private final boolean d(CombinedContext combinedContext) {
        while (b(combinedContext.f50907g)) {
            CoroutineContext coroutineContext = combinedContext.f50906f;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                Intrinsics.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int f() {
        int i8 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f50906f;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                combinedContext = null;
            }
            if (combinedContext == null) {
                return i8;
            }
            i8++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.f() != f() || !combinedContext.d(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E g(CoroutineContext.Key<E> key) {
        Intrinsics.f(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e8 = (E) combinedContext.f50907g.g(key);
            if (e8 != null) {
                return e8;
            }
            CoroutineContext coroutineContext = combinedContext.f50906f;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.g(key);
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext h(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        if (this.f50907g.g(key) != null) {
            return this.f50906f;
        }
        CoroutineContext h8 = this.f50906f.h(key);
        if (h8 == this.f50906f) {
            return this;
        }
        if (h8 == EmptyCoroutineContext.f50912f) {
            return this.f50907g;
        }
        return new CombinedContext(h8, this.f50907g);
    }

    public int hashCode() {
        return this.f50906f.hashCode() + this.f50907g.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R l(R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.f(operation, "operation");
        return operation.s((Object) this.f50906f.l(r7, operation), this.f50907g);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext s0(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) l("", new Function2<String, CoroutineContext.Element, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final String s(String acc, CoroutineContext.Element element) {
                boolean z7;
                Intrinsics.f(acc, "acc");
                Intrinsics.f(element, "element");
                if (acc.length() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }
}
