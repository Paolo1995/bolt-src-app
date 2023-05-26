package ee.mtakso.driver.ui.screens.home.v3.delegate;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrainingEvent.kt */
/* loaded from: classes3.dex */
public abstract class TrainingEvent {

    /* compiled from: TrainingEvent.kt */
    /* loaded from: classes3.dex */
    public static final class ShowStoriesError extends TrainingEvent {

        /* renamed from: a  reason: collision with root package name */
        private final String f29921a;

        /* renamed from: b  reason: collision with root package name */
        private final TrainingRetryAction f29922b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowStoriesError(String str, TrainingRetryAction retryAction) {
            super(null);
            Intrinsics.f(retryAction, "retryAction");
            this.f29921a = str;
            this.f29922b = retryAction;
        }

        public final String a() {
            return this.f29921a;
        }

        public final TrainingRetryAction b() {
            return this.f29922b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowStoriesError) {
                ShowStoriesError showStoriesError = (ShowStoriesError) obj;
                return Intrinsics.a(this.f29921a, showStoriesError.f29921a) && Intrinsics.a(this.f29922b, showStoriesError.f29922b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f29921a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f29922b.hashCode();
        }

        public String toString() {
            String str = this.f29921a;
            TrainingRetryAction trainingRetryAction = this.f29922b;
            return "ShowStoriesError(message=" + str + ", retryAction=" + trainingRetryAction + ")";
        }
    }

    /* compiled from: TrainingEvent.kt */
    /* loaded from: classes3.dex */
    public static final class ShowStoriesTraining extends TrainingEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f29923a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowStoriesTraining(List<String> stories) {
            super(null);
            Intrinsics.f(stories, "stories");
            this.f29923a = stories;
        }

        public final List<String> a() {
            return this.f29923a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowStoriesTraining) && Intrinsics.a(this.f29923a, ((ShowStoriesTraining) obj).f29923a);
        }

        public int hashCode() {
            return this.f29923a.hashCode();
        }

        public String toString() {
            List<String> list = this.f29923a;
            return "ShowStoriesTraining(stories=" + list + ")";
        }
    }

    /* compiled from: TrainingEvent.kt */
    /* loaded from: classes3.dex */
    public static final class ShowTrainingConfirmation extends TrainingEvent {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Dialog.DialogPayload f29924a;

        public ShowTrainingConfirmation(ModalDialogResponse.Dialog.DialogPayload dialogPayload) {
            super(null);
            this.f29924a = dialogPayload;
        }

        public final ModalDialogResponse.Dialog.DialogPayload a() {
            return this.f29924a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowTrainingConfirmation) && Intrinsics.a(this.f29924a, ((ShowTrainingConfirmation) obj).f29924a);
        }

        public int hashCode() {
            ModalDialogResponse.Dialog.DialogPayload dialogPayload = this.f29924a;
            if (dialogPayload == null) {
                return 0;
            }
            return dialogPayload.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Dialog.DialogPayload dialogPayload = this.f29924a;
            return "ShowTrainingConfirmation(modal=" + dialogPayload + ")";
        }
    }

    private TrainingEvent() {
    }

    public /* synthetic */ TrainingEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
