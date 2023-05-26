package ee.mtakso.driver.ui.interactor.modaldialog;

import ee.mtakso.driver.network.client.modal.ModalClient;
import ee.mtakso.driver.network.client.modal.ModalDialogActionReport;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackendModalDialogActionReporterInteractor.kt */
/* loaded from: classes3.dex */
public final class BackendModalDialogActionReporterInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ModalClient f26656a;

    @Inject
    public BackendModalDialogActionReporterInteractor(ModalClient modalClient) {
        Intrinsics.f(modalClient, "modalClient");
        this.f26656a = modalClient;
    }

    public final Completable a(String str, String str2) {
        if (str2 != null && str != null) {
            Completable v7 = this.f26656a.d(new ModalDialogActionReport(str, str2)).v();
            Intrinsics.e(v7, "{\n            modalClien…ignoreElement()\n        }");
            return v7;
        }
        Completable g8 = Completable.g();
        Intrinsics.e(g8, "{\n            Completable.complete()\n        }");
        return g8;
    }
}
