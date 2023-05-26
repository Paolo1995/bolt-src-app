package ee.mtakso.driver.ui.views.quickaccess;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessDetailsState.kt */
/* loaded from: classes5.dex */
public final class QuickAccessRatingState {

    /* renamed from: a  reason: collision with root package name */
    private final String f34492a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34493b;

    public QuickAccessRatingState(String str, String str2) {
        this.f34492a = str;
        this.f34493b = str2;
    }

    public final String a() {
        return this.f34492a;
    }

    public final String b() {
        return this.f34493b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickAccessRatingState) {
            QuickAccessRatingState quickAccessRatingState = (QuickAccessRatingState) obj;
            return Intrinsics.a(this.f34492a, quickAccessRatingState.f34492a) && Intrinsics.a(this.f34493b, quickAccessRatingState.f34493b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f34492a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f34493b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f34492a;
        String str2 = this.f34493b;
        return "QuickAccessRatingState(rating=" + str + ", rides=" + str2 + ")";
    }
}
