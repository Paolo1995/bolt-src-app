package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsModal.kt */
/* loaded from: classes3.dex */
public final class EarningsModal {

    /* renamed from: a  reason: collision with root package name */
    private final ModalDialogResponse f29362a;

    public EarningsModal(ModalDialogResponse data) {
        Intrinsics.f(data, "data");
        this.f29362a = data;
    }

    public final ModalDialogResponse a() {
        return this.f29362a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EarningsModal) && Intrinsics.a(this.f29362a, ((EarningsModal) obj).f29362a);
    }

    public int hashCode() {
        return this.f29362a.hashCode();
    }

    public String toString() {
        ModalDialogResponse modalDialogResponse = this.f29362a;
        return "EarningsModal(data=" + modalDialogResponse + ")";
    }
}
