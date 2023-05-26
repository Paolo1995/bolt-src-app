package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.ButtonType;
import ee.mtakso.driver.network.client.modal.ModalDialogAction;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingEvent;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingRetryAction;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrainingDelegate.kt */
/* loaded from: classes3.dex */
public final class TrainingDelegate {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f29915b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private Function1<? super TrainingRetryAction, Unit> f29916a = new Function1<TrainingRetryAction, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingDelegate$onActionRequested$1
        public final void b(TrainingRetryAction it) {
            Intrinsics.f(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TrainingRetryAction trainingRetryAction) {
            b(trainingRetryAction);
            return Unit.f50853a;
        }
    };

    /* compiled from: TrainingDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean c(boolean z7) {
        if (z7) {
            this.f29916a.invoke(TrainingRetryAction.ConfirmFinishStories.f29925a);
            return true;
        }
        return true;
    }

    private final void f(TrainingEvent.ShowStoriesTraining showStoriesTraining, Fragment fragment) {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        Context requireContext = fragment.requireContext();
        Bundle a8 = StorySetFragment.f41557p.a(showStoriesTraining.a(), true);
        Intrinsics.e(requireContext, "requireContext()");
        fragment.startActivityForResult(companion.g(requireContext, StorySetFragment.class, a8, false), 102);
    }

    private final void g(Fragment fragment, String str, final TrainingRetryAction trainingRetryAction) {
        ConfirmationWithIconDialog a8;
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        Context requireContext = fragment.requireContext();
        Intrinsics.e(requireContext, "fragment.requireContext()");
        int d8 = ContextUtilsKt.d(requireContext, R.attr.errorIconBig);
        String string = fragment.getString(R.string.something_went_wrong);
        Intrinsics.e(string, "fragment.getString(R.string.something_went_wrong)");
        if (str == null) {
            str = fragment.getString(R.string.error_not_internet_connection_message);
            Intrinsics.e(str, "fragment.getString(R.str…ernet_connection_message)");
        }
        String string2 = fragment.getString(R.string.try_again);
        Intrinsics.e(string2, "fragment.getString(R.string.try_again)");
        String string3 = fragment.getString(R.string.close);
        Intrinsics.e(string3, "fragment.getString(R.string.close)");
        a8 = companion.a(d8, string, str, string2, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : null, string3, new DialogCallback() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingDelegate$showTrainingError$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    TrainingDelegate.this.a().invoke(trainingRetryAction);
                }
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
            }
        }, (r20 & 128) != 0 ? null : null);
        FragmentUtils.b(a8, fragment, "TRAINING_CONFIRMED_DIALOG");
    }

    private final void h(Fragment fragment, ModalDialogResponse.Dialog.DialogPayload dialogPayload) {
        if (dialogPayload == null) {
            String string = fragment.getString(R.string.training_dialog_done_title);
            String string2 = fragment.getString(R.string.training_dialog_done_message);
            String string3 = fragment.getString(R.string.training_dialog_done_confirm);
            ButtonType buttonType = ButtonType.ACTION;
            Intrinsics.e(string3, "getString(R.string.training_dialog_done_confirm)");
            ModalDialogAction modalDialogAction = new ModalDialogAction(null, buttonType, string3, null);
            Intrinsics.e(string, "getString(R.string.training_dialog_done_title)");
            Intrinsics.e(string2, "getString(R.string.training_dialog_done_message)");
            dialogPayload = new ModalDialogResponse.Dialog.DialogPayload(null, string, string2, null, modalDialogAction, null, null);
        }
        this.f29916a.invoke(new TrainingRetryAction.ShowConfirmFinishStories(dialogPayload));
    }

    public final Function1<TrainingRetryAction, Unit> a() {
        return this.f29916a;
    }

    public final boolean b(int i8, int i9) {
        boolean z7 = false;
        if (i8 != 102) {
            return false;
        }
        if (i9 == -1) {
            z7 = true;
        }
        return c(z7);
    }

    public final void d(TrainingEvent ev, Fragment fragment) {
        Intrinsics.f(ev, "ev");
        Intrinsics.f(fragment, "fragment");
        if (ev instanceof TrainingEvent.ShowStoriesTraining) {
            f((TrainingEvent.ShowStoriesTraining) ev, fragment);
        } else if (ev instanceof TrainingEvent.ShowTrainingConfirmation) {
            h(fragment, ((TrainingEvent.ShowTrainingConfirmation) ev).a());
        } else if (ev instanceof TrainingEvent.ShowStoriesError) {
            TrainingEvent.ShowStoriesError showStoriesError = (TrainingEvent.ShowStoriesError) ev;
            g(fragment, showStoriesError.a(), showStoriesError.b());
        }
    }

    public final void e(Function1<? super TrainingRetryAction, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f29916a = function1;
    }
}
