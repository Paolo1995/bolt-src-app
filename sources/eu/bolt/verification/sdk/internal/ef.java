package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
final class ef<T> extends vd<T> {

    /* renamed from: f  reason: collision with root package name */
    private final T f42760f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(T t7) {
        this.f42760f = t7;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public T d() {
        return this.f42760f;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ef) {
            return this.f42760f.equals(((ef) obj).f42760f);
        }
        return false;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public boolean f() {
        return true;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public T g() {
        return this.f42760f;
    }

    public int hashCode() {
        return this.f42760f.hashCode() + 1502476572;
    }

    public String toString() {
        T t7 = this.f42760f;
        return "Optional.of(" + t7 + ")";
    }
}
