package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: CollectionDescriptors.kt */
/* loaded from: classes5.dex */
public abstract class ListLikeDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f52197a;

    /* renamed from: b  reason: collision with root package name */
    private final int f52198b;

    private ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.f52197a = serialDescriptor;
        this.f52198b = 1;
    }

    public /* synthetic */ ListLikeDescriptor(SerialDescriptor serialDescriptor, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialDescriptor);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Integer m8;
        Intrinsics.f(name, "name");
        m8 = StringsKt__StringNumberConversionsKt.m(name);
        if (m8 != null) {
            return m8.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.LIST.f52125a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f52198b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        if (Intrinsics.a(this.f52197a, listLikeDescriptor.f52197a) && Intrinsics.a(i(), listLikeDescriptor.i())) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i8) {
        return String.valueOf(i8);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> g(int i8) {
        boolean z7;
        List<Annotation> k8;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return this.f52197a;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.f52197a.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.f52197a + ')';
    }
}
