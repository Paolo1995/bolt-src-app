package ee.mtakso.driver.ui.interactor.promodialog;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomePromoDialogInteractor.kt */
/* loaded from: classes3.dex */
public abstract class PromoDialog {

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class AutoAcceptance extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final AutoAcceptance f26819a = new AutoAcceptance();

        private AutoAcceptance() {
            super(null);
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class AutoNavigation extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final AutoNavigation f26820a = new AutoNavigation();

        private AutoNavigation() {
            super(null);
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Banner extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Banner f26821a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Banner(ModalDialogResponse.Banner model) {
            super(null);
            Intrinsics.f(model, "model");
            this.f26821a = model;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Banner) && Intrinsics.a(this.f26821a, ((Banner) obj).f26821a);
        }

        public int hashCode() {
            return this.f26821a.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Banner banner = this.f26821a;
            return "Banner(model=" + banner + ")";
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class DriverScoreDropped extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        private final String f26822a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DriverScoreDropped(String droppedScoreValue) {
            super(null);
            Intrinsics.f(droppedScoreValue, "droppedScoreValue");
            this.f26822a = droppedScoreValue;
        }

        public final String a() {
            return this.f26822a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DriverScoreDropped) && Intrinsics.a(this.f26822a, ((DriverScoreDropped) obj).f26822a);
        }

        public int hashCode() {
            return this.f26822a.hashCode();
        }

        public String toString() {
            String str = this.f26822a;
            return "DriverScoreDropped(droppedScoreValue=" + str + ")";
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Dynamic extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Dialog f26823a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dynamic(ModalDialogResponse.Dialog model) {
            super(null);
            Intrinsics.f(model, "model");
            this.f26823a = model;
        }

        public final ModalDialogResponse.Dialog a() {
            return this.f26823a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Dynamic) && Intrinsics.a(this.f26823a, ((Dynamic) obj).f26823a);
        }

        public int hashCode() {
            return this.f26823a.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Dialog dialog = this.f26823a;
            return "Dynamic(model=" + dialog + ")";
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class LowStorage extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final LowStorage f26824a = new LowStorage();

        private LowStorage() {
            super(null);
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class NotificationPermission extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final NotificationPermission f26825a = new NotificationPermission();

        private NotificationPermission() {
            super(null);
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class QuickAccess extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final QuickAccess f26826a = new QuickAccess();

        private QuickAccess() {
            super(null);
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Story extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Story f26827a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Story(ModalDialogResponse.Story model) {
            super(null);
            Intrinsics.f(model, "model");
            this.f26827a = model;
        }

        public final ModalDialogResponse.Story a() {
            return this.f26827a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Story) && Intrinsics.a(this.f26827a, ((Story) obj).f26827a);
        }

        public int hashCode() {
            return this.f26827a.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Story story = this.f26827a;
            return "Story(model=" + story + ")";
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Training extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        private final ModalDialogResponse.Dialog.DialogPayload f26828a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Training(ModalDialogResponse.Dialog.DialogPayload modal) {
            super(null);
            Intrinsics.f(modal, "modal");
            this.f26828a = modal;
        }

        public final ModalDialogResponse.Dialog.DialogPayload a() {
            return this.f26828a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Training) && Intrinsics.a(this.f26828a, ((Training) obj).f26828a);
        }

        public int hashCode() {
            return this.f26828a.hashCode();
        }

        public String toString() {
            ModalDialogResponse.Dialog.DialogPayload dialogPayload = this.f26828a;
            return "Training(modal=" + dialogPayload + ")";
        }
    }

    /* compiled from: HomePromoDialogInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Voip extends PromoDialog {

        /* renamed from: a  reason: collision with root package name */
        public static final Voip f26829a = new Voip();

        private Voip() {
            super(null);
        }
    }

    private PromoDialog() {
    }

    public /* synthetic */ PromoDialog(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
