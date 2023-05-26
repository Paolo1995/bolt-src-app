package eu.bolt.verification.sdk.internal;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class y3 implements Comparable<y3>, Serializable {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final String f45716f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final String f45717g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final String f45718h;

    /* renamed from: i  reason: collision with root package name */
    private int f45719i;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull y3 y3Var) {
        return c().compareTo(y3Var.c());
    }

    @NonNull
    public String c() {
        return this.f45718h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        y3 y3Var = (y3) obj;
        if (this.f45716f.equals(y3Var.f45716f)) {
            String str = this.f45717g;
            if (str == null ? y3Var.f45717g == null : str.equals(y3Var.f45717g)) {
                String str2 = this.f45718h;
                String str3 = y3Var.f45718h;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f45716f.hashCode() * 31;
        String str = this.f45717g;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f45718h;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Country{countryCode='" + this.f45716f + "', phonePrefix='" + this.f45717g + "', countryName='" + this.f45718h + "', flagRes=" + this.f45719i + '}';
    }
}
