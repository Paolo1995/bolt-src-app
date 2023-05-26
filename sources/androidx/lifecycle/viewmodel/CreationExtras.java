package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public abstract class CreationExtras {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key<?>, Object> f6811a = new LinkedHashMap();

    /* compiled from: CreationExtras.kt */
    /* loaded from: classes.dex */
    public static final class Empty extends CreationExtras {

        /* renamed from: b  reason: collision with root package name */
        public static final Empty f6812b = new Empty();

        private Empty() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        public <T> T a(Key<T> key) {
            Intrinsics.f(key, "key");
            return null;
        }
    }

    /* compiled from: CreationExtras.kt */
    /* loaded from: classes.dex */
    public interface Key<T> {
    }

    public abstract <T> T a(Key<T> key);

    public final Map<Key<?>, Object> b() {
        return this.f6811a;
    }
}
