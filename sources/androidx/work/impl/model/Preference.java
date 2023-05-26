package androidx.work.impl.model;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Preference {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public String f8590a;

    /* renamed from: b  reason: collision with root package name */
    public Long f8591b;

    public Preference(@NonNull String str, boolean z7) {
        this(str, z7 ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.f8590a.equals(preference.f8590a)) {
            return false;
        }
        Long l8 = this.f8591b;
        Long l9 = preference.f8591b;
        if (l8 != null) {
            return l8.equals(l9);
        }
        if (l9 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = this.f8590a.hashCode() * 31;
        Long l8 = this.f8591b;
        if (l8 != null) {
            i8 = l8.hashCode();
        } else {
            i8 = 0;
        }
        return hashCode + i8;
    }

    public Preference(@NonNull String str, long j8) {
        this.f8590a = str;
        this.f8591b = Long.valueOf(j8);
    }
}
