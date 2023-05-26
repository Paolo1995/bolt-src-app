package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Section.kt */
/* loaded from: classes3.dex */
public final class Section {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21569a;
    @SerializedName("html_body")

    /* renamed from: b  reason: collision with root package name */
    private final String f21570b;

    public final String a() {
        return this.f21570b;
    }

    public final String b() {
        return this.f21569a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Section) {
            Section section = (Section) obj;
            return Intrinsics.a(this.f21569a, section.f21569a) && Intrinsics.a(this.f21570b, section.f21570b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21569a.hashCode() * 31) + this.f21570b.hashCode();
    }

    public String toString() {
        String str = this.f21569a;
        String str2 = this.f21570b;
        return "Section(sectionTitle=" + str + ", htmlBody=" + str2 + ")";
    }
}
