package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: PluginGeneratedSerialDescriptor.kt */
/* loaded from: classes5.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final String f52230a;

    /* renamed from: b  reason: collision with root package name */
    private final GeneratedSerializer<?> f52231b;

    /* renamed from: c  reason: collision with root package name */
    private final int f52232c;

    /* renamed from: d  reason: collision with root package name */
    private int f52233d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f52234e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Annotation>[] f52235f;

    /* renamed from: g  reason: collision with root package name */
    private List<Annotation> f52236g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f52237h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Integer> f52238i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f52239j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f52240k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f52241l;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer<?> generatedSerializer, int i8) {
        Map<String, Integer> f8;
        Lazy a8;
        Lazy a9;
        Lazy a10;
        Intrinsics.f(serialName, "serialName");
        this.f52230a = serialName;
        this.f52231b = generatedSerializer;
        this.f52232c = i8;
        this.f52233d = -1;
        String[] strArr = new String[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            strArr[i9] = "[UNINITIALIZED]";
        }
        this.f52234e = strArr;
        int i10 = this.f52232c;
        this.f52235f = new List[i10];
        this.f52237h = new boolean[i10];
        f8 = MapsKt__MapsKt.f();
        this.f52238i = f8;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        a8 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<KSerializer<?>[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final KSerializer<?>[] invoke() {
                GeneratedSerializer generatedSerializer2;
                KSerializer<?>[] e8;
                generatedSerializer2 = PluginGeneratedSerialDescriptor.this.f52231b;
                if (generatedSerializer2 == null || (e8 = generatedSerializer2.e()) == null) {
                    return PluginHelperInterfacesKt.f52246a;
                }
                return e8;
            }
        });
        this.f52239j = a8;
        a9 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$typeParameterDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor[] invoke() {
                GeneratedSerializer generatedSerializer2;
                ArrayList arrayList;
                KSerializer<?>[] d8;
                generatedSerializer2 = PluginGeneratedSerialDescriptor.this.f52231b;
                if (generatedSerializer2 != null && (d8 = generatedSerializer2.d()) != null) {
                    arrayList = new ArrayList(d8.length);
                    for (KSerializer<?> kSerializer : d8) {
                        arrayList.add(kSerializer.a());
                    }
                } else {
                    arrayList = null;
                }
                return Platform_commonKt.b(arrayList);
            }
        });
        this.f52240k = a9;
        a10 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$_hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Integer invoke() {
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.p()));
            }
        });
        this.f52241l = a10;
    }

    public static /* synthetic */ void m(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            pluginGeneratedSerialDescriptor.l(str, z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final Map<String, Integer> n() {
        HashMap hashMap = new HashMap();
        int length = this.f52234e.length;
        for (int i8 = 0; i8 < length; i8++) {
            hashMap.put(this.f52234e[i8], Integer.valueOf(i8));
        }
        return hashMap;
    }

    private final KSerializer<?>[] o() {
        return (KSerializer[]) this.f52239j.getValue();
    }

    private final int q() {
        return ((Number) this.f52241l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> a() {
        return this.f52238i.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.f(name, "name");
        Integer num = this.f52238i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.CLASS.f52124a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f52232c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.a(i(), serialDescriptor.i()) && Arrays.equals(p(), ((PluginGeneratedSerialDescriptor) obj).p()) && e() == serialDescriptor.e()) {
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
        return this.f52234e[i8];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> g(int i8) {
        List<Annotation> k8;
        List<Annotation> list = this.f52235f[i8];
        if (list == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        return list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        List<Annotation> k8;
        List<Annotation> list = this.f52236g;
        if (list == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        return list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        return o()[i8].a();
    }

    public int hashCode() {
        return q();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52230a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i8) {
        return this.f52237h[i8];
    }

    public final void l(String name, boolean z7) {
        Intrinsics.f(name, "name");
        String[] strArr = this.f52234e;
        int i8 = this.f52233d + 1;
        this.f52233d = i8;
        strArr[i8] = name;
        this.f52237h[i8] = z7;
        this.f52235f[i8] = null;
        if (i8 == this.f52232c - 1) {
            this.f52238i = n();
        }
    }

    public final SerialDescriptor[] p() {
        return (SerialDescriptor[]) this.f52240k.getValue();
    }

    public final void r(Annotation annotation) {
        Intrinsics.f(annotation, "annotation");
        List<Annotation> list = this.f52235f[this.f52233d];
        if (list == null) {
            list = new ArrayList<>(1);
            this.f52235f[this.f52233d] = list;
        }
        list.add(annotation);
    }

    public String toString() {
        IntRange o8;
        String f02;
        o8 = RangesKt___RangesKt.o(0, this.f52232c);
        f02 = CollectionsKt___CollectionsKt.f0(o8, ", ", i() + '(', ")", 0, null, new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final CharSequence b(int i8) {
                return PluginGeneratedSerialDescriptor.this.f(i8) + ": " + PluginGeneratedSerialDescriptor.this.h(i8).i();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return b(num.intValue());
            }
        }, 24, null);
        return f02;
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i9 & 2) != 0 ? null : generatedSerializer, i8);
    }
}
