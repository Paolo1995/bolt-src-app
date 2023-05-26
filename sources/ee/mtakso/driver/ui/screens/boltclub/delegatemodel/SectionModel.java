package ee.mtakso.driver.ui.screens.boltclub.delegatemodel;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SectionModel.kt */
/* loaded from: classes3.dex */
public final class SectionModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f27189a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f27190b;

    public SectionModel(String sectionTitle, CharSequence description) {
        Intrinsics.f(sectionTitle, "sectionTitle");
        Intrinsics.f(description, "description");
        this.f27189a = sectionTitle;
        this.f27190b = description;
    }

    public final CharSequence a() {
        return this.f27190b;
    }

    public final String b() {
        return this.f27189a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SectionModel) {
            SectionModel sectionModel = (SectionModel) obj;
            return Intrinsics.a(this.f27189a, sectionModel.f27189a) && Intrinsics.a(this.f27190b, sectionModel.f27190b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f27189a.hashCode() * 31) + this.f27190b.hashCode();
    }

    public String toString() {
        String str = this.f27189a;
        CharSequence charSequence = this.f27190b;
        return "SectionModel(sectionTitle=" + str + ", description=" + ((Object) charSequence) + ")";
    }
}
