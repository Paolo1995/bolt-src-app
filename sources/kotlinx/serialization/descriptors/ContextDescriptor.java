package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ContextAware.kt */
/* loaded from: classes5.dex */
final class ContextDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialDescriptor f52087a;

    /* renamed from: b  reason: collision with root package name */
    public final KClass<?> f52088b;

    /* renamed from: c  reason: collision with root package name */
    private final String f52089c;

    public ContextDescriptor(SerialDescriptor original, KClass<?> kClass) {
        Intrinsics.f(original, "original");
        Intrinsics.f(kClass, "kClass");
        this.f52087a = original;
        this.f52088b = kClass;
        this.f52089c = original.i() + '<' + kClass.d() + '>';
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return this.f52087a.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.f(name, "name");
        return this.f52087a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f52087a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f52087a.e();
    }

    public boolean equals(Object obj) {
        ContextDescriptor contextDescriptor;
        if (obj instanceof ContextDescriptor) {
            contextDescriptor = (ContextDescriptor) obj;
        } else {
            contextDescriptor = null;
        }
        if (contextDescriptor == null || !Intrinsics.a(this.f52087a, contextDescriptor.f52087a) || !Intrinsics.a(contextDescriptor.f52088b, this.f52088b)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i8) {
        return this.f52087a.f(i8);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> g(int i8) {
        return this.f52087a.g(i8);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.f52087a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        return this.f52087a.h(i8);
    }

    public int hashCode() {
        return (this.f52088b.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52089c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f52087a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i8) {
        return this.f52087a.j(i8);
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f52088b + ", original: " + this.f52087a + ')';
    }
}
