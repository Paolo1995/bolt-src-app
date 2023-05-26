package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerCallDetails.kt */
/* loaded from: classes3.dex */
public final class NoAnswerCallDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f28048a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28049b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f28050c;

    public NoAnswerCallDetails(String str, String str2, Long l8) {
        this.f28048a = str;
        this.f28049b = str2;
        this.f28050c = l8;
    }

    public final String a() {
        return this.f28049b;
    }

    public final String b() {
        return this.f28048a;
    }

    public final Long c() {
        return this.f28050c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NoAnswerCallDetails) {
            NoAnswerCallDetails noAnswerCallDetails = (NoAnswerCallDetails) obj;
            return Intrinsics.a(this.f28048a, noAnswerCallDetails.f28048a) && Intrinsics.a(this.f28049b, noAnswerCallDetails.f28049b) && Intrinsics.a(this.f28050c, noAnswerCallDetails.f28050c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f28048a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f28049b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l8 = this.f28050c;
        return hashCode2 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        String str = this.f28048a;
        String str2 = this.f28049b;
        Long l8 = this.f28050c;
        return "NoAnswerCallDetails(passengerName=" + str + ", passengerAddress=" + str2 + ", timeToDestination=" + l8 + ")";
    }
}
