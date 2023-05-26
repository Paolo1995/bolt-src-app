package ee.mtakso.driver.network.client.training;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrainingModal.kt */
/* loaded from: classes3.dex */
public final class TrainingModal {
    @SerializedName("modal")

    /* renamed from: a  reason: collision with root package name */
    private final ModalDialogResponse.Dialog.DialogPayload f22879a;

    public final ModalDialogResponse.Dialog.DialogPayload a() {
        return this.f22879a;
    }

    public final ModalDialogResponse.Dialog.DialogPayload b() {
        return this.f22879a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TrainingModal) && Intrinsics.a(this.f22879a, ((TrainingModal) obj).f22879a);
    }

    public int hashCode() {
        return this.f22879a.hashCode();
    }

    public String toString() {
        ModalDialogResponse.Dialog.DialogPayload dialogPayload = this.f22879a;
        return "TrainingModal(dialogInfo=" + dialogPayload + ")";
    }
}
