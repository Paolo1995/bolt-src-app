package eu.bolt.verification.sdk.internal;

import android.os.Build;
import android.util.FloatProperty;
import android.util.Property;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j7 {

    /* renamed from: a  reason: collision with root package name */
    public static final j7 f43664a = new j7();

    /* loaded from: classes5.dex */
    public static final class a extends FloatProperty {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function2<T, Float, Unit> f43665a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1<T, Float> f43666b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(final String str, Function2<? super T, ? super Float, Unit> function2, Function1<? super T, Float> function1) {
            new Property(str) { // from class: android.util.FloatProperty
                static {
                    throw new NoClassDefFoundError();
                }
            };
            this.f43665a = function2;
            this.f43666b = function1;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(T t7) {
            return this.f43666b.invoke(t7);
        }

        public void setValue(T t7, float f8) {
            this.f43665a.s(t7, Float.valueOf(f8));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes5.dex */
    public static final class b<T> extends Property<T, Float> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function1<T, Float> f43667a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function2<T, Float, Unit> f43668b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super T, Float> function1, Function2<? super T, ? super Float, Unit> function2, Class<Float> cls) {
            super(cls, str);
            this.f43667a = function1;
            this.f43668b = function2;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(T t7) {
            return this.f43667a.invoke(t7);
        }

        public void b(T t7, float f8) {
            this.f43668b.s(t7, Float.valueOf(f8));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Float f8) {
            b(obj, f8.floatValue());
        }
    }

    private j7() {
    }

    public final <T> Property<T, Float> a(String propName, Function2<? super T, ? super Float, Unit> setter, Function1<? super T, Float> getter) {
        Intrinsics.f(propName, "propName");
        Intrinsics.f(setter, "setter");
        Intrinsics.f(getter, "getter");
        return Build.VERSION.SDK_INT >= 24 ? new a(propName, setter, getter) : new b(propName, getter, setter, Float.TYPE);
    }
}
