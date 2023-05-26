package ee.mtakso.driver.ui.interactor.modaldialog;

import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.modal.ModalClient;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleModalDialogInteractor.kt */
/* loaded from: classes3.dex */
public final class SingleModalDialogInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ModalClient f26673a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f26674b;

    @Inject
    public SingleModalDialogInteractor(ModalClient modalClient, Features features) {
        Intrinsics.f(modalClient, "modalClient");
        Intrinsics.f(features, "features");
        this.f26673a = modalClient;
        this.f26674b = features;
    }

    public final Single<Optional<ModalDialogResponse>> a(String event) {
        Intrinsics.f(event, "event");
        if (this.f26674b.b(Feature.Type.MODAL_DIALOGS)) {
            return this.f26673a.b(event);
        }
        Single<Optional<ModalDialogResponse>> w7 = Single.w(Optional.a());
        Intrinsics.e(w7, "{\n            Single.jus…tional.empty())\n        }");
        return w7;
    }
}
