package com.tbruyelle.rxpermissions2;

/* loaded from: classes3.dex */
public class Permission {

    /* renamed from: a  reason: collision with root package name */
    public final String f19728a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f19729b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f19730c;

    public Permission(String str, boolean z7, boolean z8) {
        this.f19728a = str;
        this.f19729b = z7;
        this.f19730c = z8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.f19729b != permission.f19729b || this.f19730c != permission.f19730c) {
            return false;
        }
        return this.f19728a.equals(permission.f19728a);
    }

    public int hashCode() {
        return (((this.f19728a.hashCode() * 31) + (this.f19729b ? 1 : 0)) * 31) + (this.f19730c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f19728a + "', granted=" + this.f19729b + ", shouldShowRequestPermissionRationale=" + this.f19730c + '}';
    }
}
