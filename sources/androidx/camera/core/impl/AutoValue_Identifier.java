package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class AutoValue_Identifier extends Identifier {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Identifier(Object obj) {
        if (obj != null) {
            this.f3532a = obj;
            return;
        }
        throw new NullPointerException("Null value");
    }

    @Override // androidx.camera.core.impl.Identifier
    @NonNull
    public Object b() {
        return this.f3532a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Identifier) {
            return this.f3532a.equals(((Identifier) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f3532a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.f3532a + "}";
    }
}
