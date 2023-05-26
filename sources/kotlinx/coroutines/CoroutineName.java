package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineName.kt */
/* loaded from: classes5.dex */
public final class CoroutineName extends AbstractCoroutineContextElement {

    /* renamed from: h  reason: collision with root package name */
    public static final Key f51246h = new Key(null);

    /* renamed from: g  reason: collision with root package name */
    private final String f51247g;

    /* compiled from: CoroutineName.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<CoroutineName> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineName(String str) {
        super(f51246h);
        this.f51247g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineName) && Intrinsics.a(this.f51247g, ((CoroutineName) obj).f51247g);
    }

    public int hashCode() {
        return this.f51247g.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f51247g + ')';
    }
}
