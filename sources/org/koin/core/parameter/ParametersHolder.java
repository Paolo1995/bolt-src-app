package org.koin.core.parameter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.NoParameterFoundException;
import org.koin.ext.KClassExtKt;

/* compiled from: ParametersHolder.kt */
/* loaded from: classes5.dex */
public class ParametersHolder {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f52777b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f52778a;

    /* compiled from: ParametersHolder.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ParametersHolder() {
        this(null, 1, null);
    }

    public ParametersHolder(List<Object> _values) {
        Intrinsics.f(_values, "_values");
        this.f52778a = _values;
    }

    public <T> T a(int i8, KClass<?> clazz) {
        Intrinsics.f(clazz, "clazz");
        if (this.f52778a.size() > i8) {
            return (T) this.f52778a.get(i8);
        }
        throw new NoParameterFoundException("Can't get injected parameter #" + i8 + " from " + this + " for type '" + KClassExtKt.a(clazz) + '\'');
    }

    public <T> T b(KClass<?> clazz) {
        T t7;
        Intrinsics.f(clazz, "clazz");
        Iterator<T> it = this.f52778a.iterator();
        do {
            t7 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (clazz.a(next) && next != null) {
                t7 = next;
                continue;
            }
        } while (t7 == null);
        return t7;
    }

    public String toString() {
        List H0;
        StringBuilder sb = new StringBuilder();
        sb.append("DefinitionParameters");
        H0 = CollectionsKt___CollectionsKt.H0(this.f52778a);
        sb.append(H0);
        return sb.toString();
    }

    public /* synthetic */ ParametersHolder(List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new ArrayList() : list);
    }
}
