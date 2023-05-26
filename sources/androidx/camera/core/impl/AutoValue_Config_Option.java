package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_Config_Option<T> extends Config.Option<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f3529a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f3530b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f3531c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Config_Option(String str, Class<T> cls, Object obj) {
        if (str != null) {
            this.f3529a = str;
            if (cls != null) {
                this.f3530b = cls;
                this.f3531c = obj;
                return;
            }
            throw new NullPointerException("Null valueClass");
        }
        throw new NullPointerException("Null id");
    }

    @Override // androidx.camera.core.impl.Config.Option
    @NonNull
    public String c() {
        return this.f3529a;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public Object d() {
        return this.f3531c;
    }

    @Override // androidx.camera.core.impl.Config.Option
    @NonNull
    public Class<T> e() {
        return this.f3530b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config.Option)) {
            return false;
        }
        Config.Option option = (Config.Option) obj;
        if (this.f3529a.equals(option.c()) && this.f3530b.equals(option.e())) {
            Object obj2 = this.f3531c;
            if (obj2 == null) {
                if (option.d() == null) {
                    return true;
                }
            } else if (obj2.equals(option.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((this.f3529a.hashCode() ^ 1000003) * 1000003) ^ this.f3530b.hashCode()) * 1000003;
        Object obj = this.f3531c;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "Option{id=" + this.f3529a + ", valueClass=" + this.f3530b + ", token=" + this.f3531c + "}";
    }
}
