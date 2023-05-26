package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: NullableSerializer.kt */
/* loaded from: classes5.dex */
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f52254a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52255b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f52256c;

    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.f(original, "original");
        this.f52254a = original;
        this.f52255b = original.i() + '?';
        this.f52256c = Platform_commonKt.a(original);
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> a() {
        return this.f52256c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.f(name, "name");
        return this.f52254a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f52254a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f52254a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SerialDescriptorForNullable) && Intrinsics.a(this.f52254a, ((SerialDescriptorForNullable) obj).f52254a)) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i8) {
        return this.f52254a.f(i8);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> g(int i8) {
        return this.f52254a.g(i8);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.f52254a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        return this.f52254a.h(i8);
    }

    public int hashCode() {
        return this.f52254a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52255b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f52254a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i8) {
        return this.f52254a.j(i8);
    }

    public final SerialDescriptor k() {
        return this.f52254a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f52254a);
        sb.append('?');
        return sb.toString();
    }
}
