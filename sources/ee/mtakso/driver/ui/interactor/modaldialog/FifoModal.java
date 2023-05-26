package ee.mtakso.driver.ui.interactor.modaldialog;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoModal.kt */
/* loaded from: classes3.dex */
public final class FifoModal {

    /* renamed from: a  reason: collision with root package name */
    private final ModalDialogResponse f26658a;

    public FifoModal(ModalDialogResponse data) {
        Intrinsics.f(data, "data");
        this.f26658a = data;
    }

    public final ModalDialogResponse a() {
        return this.f26658a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FifoModal) && Intrinsics.a(this.f26658a, ((FifoModal) obj).f26658a);
    }

    public int hashCode() {
        return this.f26658a.hashCode();
    }

    public String toString() {
        ModalDialogResponse modalDialogResponse = this.f26658a;
        return "FifoModal(data=" + modalDialogResponse + ")";
    }
}
