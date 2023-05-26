package ee.mtakso.driver.ui.screens.home.v3.delegate;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrainingRetryAction.kt */
/* loaded from: classes3.dex */
public abstract class TrainingRetryAction {

    /* compiled from: TrainingRetryAction.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmFinishStories extends TrainingRetryAction {

        /* renamed from: a  reason: collision with root package name */
        public static final ConfirmFinishStories f29925a = new ConfirmFinishStories();

        private ConfirmFinishStories() {
            super(null);
        }
    }

    /* compiled from: TrainingRetryAction.kt */
    /* loaded from: classes3.dex */
    public static final class RefreshDashboard extends TrainingRetryAction {

        /* renamed from: a  reason: collision with root package name */
        public static final RefreshDashboard f29926a = new RefreshDashboard();

        private RefreshDashboard() {
            super(null);
        }
    }

    /* compiled from: TrainingRetryAction.kt */
    /* loaded from: classes3.dex */
    public static final class RequestStart extends TrainingRetryAction {

        /* renamed from: a  reason: collision with root package name */
        public static final RequestStart f29927a = new RequestStart();

        private RequestStart() {
            super(null);
        }
    }

    /* compiled from: TrainingRetryAction.kt */
    /* loaded from: classes3.dex */
    public static final class ShowConfirmFinishStories extends TrainingRetryAction {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Dialog.DialogPayload f29928a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowConfirmFinishStories(ModalDialogResponse.Dialog.DialogPayload modal) {
            super(null);
            Intrinsics.f(modal, "modal");
            this.f29928a = modal;
        }

        public final ModalDialogResponse.Dialog.DialogPayload a() {
            return this.f29928a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowConfirmFinishStories) && Intrinsics.a(this.f29928a, ((ShowConfirmFinishStories) obj).f29928a);
        }

        public int hashCode() {
            return this.f29928a.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Dialog.DialogPayload dialogPayload = this.f29928a;
            return "ShowConfirmFinishStories(modal=" + dialogPayload + ")";
        }
    }

    private TrainingRetryAction() {
    }

    public /* synthetic */ TrainingRetryAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
