package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes5.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final String f52101a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialKind f52102b;

    /* renamed from: c  reason: collision with root package name */
    private final int f52103c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Annotation> f52104d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f52105e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f52106f;

    /* renamed from: g  reason: collision with root package name */
    private final SerialDescriptor[] f52107g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Annotation>[] f52108h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean[] f52109i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Integer> f52110j;

    /* renamed from: k  reason: collision with root package name */
    private final SerialDescriptor[] f52111k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f52112l;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i8, List<? extends SerialDescriptor> typeParameters, ClassSerialDescriptorBuilder builder) {
        HashSet F0;
        boolean[] C0;
        Iterable<IndexedValue> k02;
        int v7;
        Map<String, Integer> q8;
        Lazy b8;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(kind, "kind");
        Intrinsics.f(typeParameters, "typeParameters");
        Intrinsics.f(builder, "builder");
        this.f52101a = serialName;
        this.f52102b = kind;
        this.f52103c = i8;
        this.f52104d = builder.c();
        F0 = CollectionsKt___CollectionsKt.F0(builder.f());
        this.f52105e = F0;
        Object[] array = builder.f().toArray(new String[0]);
        Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        this.f52106f = strArr;
        this.f52107g = Platform_commonKt.b(builder.e());
        Object[] array2 = builder.d().toArray(new List[0]);
        Intrinsics.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f52108h = (List[]) array2;
        C0 = CollectionsKt___CollectionsKt.C0(builder.g());
        this.f52109i = C0;
        k02 = ArraysKt___ArraysKt.k0(strArr);
        v7 = CollectionsKt__IterablesKt.v(k02, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (IndexedValue indexedValue : k02) {
            arrayList.add(TuplesKt.a(indexedValue.b(), Integer.valueOf(indexedValue.a())));
        }
        q8 = MapsKt__MapsKt.q(arrayList);
        this.f52110j = q8;
        this.f52111k = Platform_commonKt.b(typeParameters);
        b8 = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Integer invoke() {
                SerialDescriptor[] serialDescriptorArr;
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                serialDescriptorArr = serialDescriptorImpl.f52111k;
                return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(serialDescriptorImpl, serialDescriptorArr));
            }
        });
        this.f52112l = b8;
    }

    private final int l() {
        return ((Number) this.f52112l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> a() {
        return this.f52105e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.f(name, "name");
        Integer num = this.f52110j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f52102b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f52103c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.a(i(), serialDescriptor.i()) && Arrays.equals(this.f52111k, ((SerialDescriptorImpl) obj).f52111k) && e() == serialDescriptor.e()) {
                int e8 = e();
                for (int i8 = 0; i8 < e8; i8++) {
                    if (Intrinsics.a(h(i8).i(), serialDescriptor.h(i8).i()) && Intrinsics.a(h(i8).d(), serialDescriptor.h(i8).d())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i8) {
        return this.f52106f[i8];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> g(int i8) {
        return this.f52108h[i8];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.f52104d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        return this.f52107g[i8];
    }

    public int hashCode() {
        return l();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52101a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i8) {
        return this.f52109i[i8];
    }

    public String toString() {
        IntRange o8;
        String f02;
        o8 = RangesKt___RangesKt.o(0, e());
        f02 = CollectionsKt___CollectionsKt.f0(o8, ", ", i() + '(', ")", 0, null, new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final CharSequence b(int i8) {
                return SerialDescriptorImpl.this.f(i8) + ": " + SerialDescriptorImpl.this.h(i8).i();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return b(num.intValue());
            }
        }, 24, null);
        return f02;
    }
}
