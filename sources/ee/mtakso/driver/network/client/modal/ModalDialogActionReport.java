package ee.mtakso.driver.network.client.modal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalDialogActionReport.kt */
/* loaded from: classes3.dex */
public final class ModalDialogActionReport {
    @SerializedName("modal_poll_entry_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f22287a;
    @SerializedName("action")

    /* renamed from: b  reason: collision with root package name */
    private final String f22288b;

    public ModalDialogActionReport(String pollEntryId, String action) {
        Intrinsics.f(pollEntryId, "pollEntryId");
        Intrinsics.f(action, "action");
        this.f22287a = pollEntryId;
        this.f22288b = action;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModalDialogActionReport) {
            ModalDialogActionReport modalDialogActionReport = (ModalDialogActionReport) obj;
            return Intrinsics.a(this.f22287a, modalDialogActionReport.f22287a) && Intrinsics.a(this.f22288b, modalDialogActionReport.f22288b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22287a.hashCode() * 31) + this.f22288b.hashCode();
    }

    public String toString() {
        String str = this.f22287a;
        String str2 = this.f22288b;
        return "ModalDialogActionReport(pollEntryId=" + str + ", action=" + str2 + ")";
    }
}
