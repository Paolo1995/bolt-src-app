package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes5.dex */
public final class ClassSerialDescriptorBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final String f52080a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Annotation> f52081b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f52082c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<String> f52083d;

    /* renamed from: e  reason: collision with root package name */
    private final List<SerialDescriptor> f52084e;

    /* renamed from: f  reason: collision with root package name */
    private final List<List<Annotation>> f52085f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Boolean> f52086g;

    public ClassSerialDescriptorBuilder(String serialName) {
        List<? extends Annotation> k8;
        Intrinsics.f(serialName, "serialName");
        this.f52080a = serialName;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f52081b = k8;
        this.f52082c = new ArrayList();
        this.f52083d = new HashSet();
        this.f52084e = new ArrayList();
        this.f52085f = new ArrayList();
        this.f52086g = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.k();
        }
        if ((i8 & 8) != 0) {
            z7 = false;
        }
        classSerialDescriptorBuilder.a(str, serialDescriptor, list, z7);
    }

    public final void a(String elementName, SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean z7) {
        Intrinsics.f(elementName, "elementName");
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(annotations, "annotations");
        if (this.f52083d.add(elementName)) {
            this.f52082c.add(elementName);
            this.f52084e.add(descriptor);
            this.f52085f.add(annotations);
            this.f52086g.add(Boolean.valueOf(z7));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered").toString());
    }

    public final List<Annotation> c() {
        return this.f52081b;
    }

    public final List<List<Annotation>> d() {
        return this.f52085f;
    }

    public final List<SerialDescriptor> e() {
        return this.f52084e;
    }

    public final List<String> f() {
        return this.f52082c;
    }

    public final List<Boolean> g() {
        return this.f52086g;
    }

    public final void h(List<? extends Annotation> list) {
        Intrinsics.f(list, "<set-?>");
        this.f52081b = list;
    }
}
