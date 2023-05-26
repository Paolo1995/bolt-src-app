package kotlin.jvm.internal;

/* compiled from: PackageReference.kt */
/* loaded from: classes5.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f51010a;

    /* renamed from: b  reason: collision with root package name */
    private final String f51011b;

    public PackageReference(Class<?> jClass, String moduleName) {
        Intrinsics.f(jClass, "jClass");
        Intrinsics.f(moduleName, "moduleName");
        this.f51010a = jClass;
        this.f51011b = moduleName;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> b() {
        return this.f51010a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PackageReference) && Intrinsics.a(b(), ((PackageReference) obj).b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
