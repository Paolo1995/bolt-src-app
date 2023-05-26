package eu.bolt.verification.sdk.internal;

import android.os.Build;
import android.util.IntProperty;
import android.util.Property;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class na {

    /* renamed from: a  reason: collision with root package name */
    public static final na f44315a = new na();

    /* loaded from: classes5.dex */
    public static final class a extends IntProperty {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function2<T, Integer, Unit> f44316a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1<T, Integer> f44317b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(final String str, Function2<? super T, ? super Integer, Unit> function2, Function1<? super T, Integer> function1) {
            new Property(str) { // from class: android.util.IntProperty
                static {
                    throw new NoClassDefFoundError();
                }
            };
            this.f44316a = function2;
            this.f44317b = function1;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(T t7) {
            return this.f44317b.invoke(t7);
        }

        public void setValue(T t7, int i8) {
            this.f44316a.s(t7, Integer.valueOf(i8));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes5.dex */
    public static final class b<T> extends Property<T, Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function1<T, Integer> f44318a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function2<T, Integer, Unit> f44319b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super T, Integer> function1, Function2<? super T, ? super Integer, Unit> function2, Class<Integer> cls) {
            super(cls, str);
            this.f44318a = function1;
            this.f44319b = function2;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(T t7) {
            return this.f44318a.invoke(t7);
        }

        public void b(T t7, int i8) {
            this.f44319b.s(t7, Integer.valueOf(i8));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Integer num) {
            b(obj, num.intValue());
        }
    }

    private na() {
    }

    public final <T> Property<T, Integer> a(String propName, Function2<? super T, ? super Integer, Unit> setter, Function1<? super T, Integer> getter) {
        Intrinsics.f(propName, "propName");
        Intrinsics.f(setter, "setter");
        Intrinsics.f(getter, "getter");
        return Build.VERSION.SDK_INT >= 24 ? new a(propName, setter, getter) : new b(propName, getter, setter, Integer.TYPE);
    }
}
