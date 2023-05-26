package androidx.work.impl.model;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class SystemIdInfo {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f8595a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8596b;

    public SystemIdInfo(@NonNull String str, int i8) {
        this.f8595a = str;
        this.f8596b = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        if (this.f8596b != systemIdInfo.f8596b) {
            return false;
        }
        return this.f8595a.equals(systemIdInfo.f8595a);
    }

    public int hashCode() {
        return (this.f8595a.hashCode() * 31) + this.f8596b;
    }
}
