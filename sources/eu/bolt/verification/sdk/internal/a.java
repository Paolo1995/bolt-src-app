package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
final class a<T> extends vd<T> {

    /* renamed from: f  reason: collision with root package name */
    static final a<Object> f41939f = new a<>();

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> vd<T> h() {
        return f41939f;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public T d() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public boolean e() {
        return true;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public boolean f() {
        return false;
    }

    @Override // eu.bolt.verification.sdk.internal.vd
    public T g() {
        return null;
    }

    public int hashCode() {
        return 1502476572;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
