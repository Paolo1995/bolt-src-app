package ee.mtakso.driver.ui.screens.modal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalAction.kt */
/* loaded from: classes3.dex */
public final class ModalAction {

    /* renamed from: a  reason: collision with root package name */
    private final String f30874a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30875b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30876c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30877d;

    /* renamed from: e  reason: collision with root package name */
    private final String f30878e;

    public ModalAction(String str, String str2, String str3, String str4, String str5) {
        this.f30874a = str;
        this.f30875b = str2;
        this.f30876c = str3;
        this.f30877d = str4;
        this.f30878e = str5;
    }

    public final String a() {
        return this.f30874a;
    }

    public final String b() {
        return this.f30878e;
    }

    public final String c() {
        return this.f30876c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModalAction) {
            ModalAction modalAction = (ModalAction) obj;
            return Intrinsics.a(this.f30874a, modalAction.f30874a) && Intrinsics.a(this.f30875b, modalAction.f30875b) && Intrinsics.a(this.f30876c, modalAction.f30876c) && Intrinsics.a(this.f30877d, modalAction.f30877d) && Intrinsics.a(this.f30878e, modalAction.f30878e);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f30874a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f30875b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f30876c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f30877d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f30878e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        String str = this.f30874a;
        String str2 = this.f30875b;
        String str3 = this.f30876c;
        String str4 = this.f30877d;
        String str5 = this.f30878e;
        return "ModalAction(actionId=" + str + ", modalId=" + str2 + ", pollEntryId=" + str3 + ", pollCampaignId=" + str4 + ", link=" + str5 + ")";
    }
}
