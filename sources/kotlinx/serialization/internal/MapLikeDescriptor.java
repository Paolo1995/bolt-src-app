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
public abstract class MapLikeDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f52209a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f52210b;

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f52211c;

    /* renamed from: d  reason: collision with root package name */
    private final int f52212d;

    private MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.f52209a = str;
        this.f52210b = serialDescriptor;
        this.f52211c = serialDescriptor2;
        this.f52212d = 2;
    }

    public /* synthetic */ MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serialDescriptor, serialDescriptor2);
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.MAP.f52126a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f52212d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        if (Intrinsics.a(i(), mapLikeDescriptor.i()) && Intrinsics.a(this.f52210b, mapLikeDescriptor.f52210b) && Intrinsics.a(this.f52211c, mapLikeDescriptor.f52211c)) {
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
            int i9 = i8 % 2;
            if (i9 != 0) {
                if (i9 == 1) {
                    return this.f52211c;
                }
                throw new IllegalStateException("Unreached".toString());
            }
            return this.f52210b;
        }
        throw new IllegalArgumentException(("Illegal index " + i8 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.f52210b.hashCode()) * 31) + this.f52211c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52209a;
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
        return i() + '(' + this.f52210b + ", " + this.f52211c + ')';
    }
}
