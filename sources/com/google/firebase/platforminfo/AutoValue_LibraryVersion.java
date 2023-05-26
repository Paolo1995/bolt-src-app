package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {

    /* renamed from: a  reason: collision with root package name */
    private final String f17003a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17004b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.f17003a = str;
            if (str2 != null) {
                this.f17004b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String b() {
        return this.f17003a;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public String c() {
        return this.f17004b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        if (this.f17003a.equals(libraryVersion.b()) && this.f17004b.equals(libraryVersion.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f17003a.hashCode() ^ 1000003) * 1000003) ^ this.f17004b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f17003a + ", version=" + this.f17004b + "}";
    }
}
