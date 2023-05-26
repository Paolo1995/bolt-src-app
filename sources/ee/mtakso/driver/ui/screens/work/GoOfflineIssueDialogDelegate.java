package ee.mtakso.driver.ui.screens.work;

import android.view.View;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.network.response.ErrorAction;
import ee.mtakso.driver.service.modules.status.GoOfflineIssue;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.DynamicActionDialog;
import eu.bolt.kalev.Kalev;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOfflineIssueDialogDelegate.kt */
/* loaded from: classes5.dex */
public final class GoOfflineIssueDialogDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f33638c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Function1<ErrorAction, Unit> f33639a;

    /* renamed from: b  reason: collision with root package name */
    private final GoOfflineIssueDialogDelegate$dialogCallback$1 f33640b;

    /* compiled from: GoOfflineIssueDialogDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GoOfflineIssueDialogDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33641a;

        static {
            int[] iArr = new int[ErrorAction.UiType.values().length];
            try {
                iArr[ErrorAction.UiType.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorAction.UiType.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorAction.UiType.DANGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f33641a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.ui.screens.work.GoOfflineIssueDialogDelegate$dialogCallback$1] */
    public GoOfflineIssueDialogDelegate(Function1<? super ErrorAction, Unit> actionCallback) {
        Intrinsics.f(actionCallback, "actionCallback");
        this.f33639a = actionCallback;
        this.f33640b = new DialogCallback() { // from class: ee.mtakso.driver.ui.screens.work.GoOfflineIssueDialogDelegate$dialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Function1 function1;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                function1 = GoOfflineIssueDialogDelegate.this.f33639a;
                function1.invoke((ErrorAction) payload);
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
            }
        };
    }

    private final UiKitRoundButtonType b(ErrorAction.UiType uiType) {
        int i8 = WhenMappings.f33641a[uiType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return UiKitRoundButtonType.f36163m;
                }
                throw new NoWhenBranchMatchedException();
            }
            return UiKitRoundButtonType.f36164n;
        }
        return UiKitRoundButtonType.f36162l;
    }

    public final void c(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        BaseDialogFragment.f41026i.a(fragment.getChildFragmentManager(), "tag_go_offline_issue", this.f33640b);
    }

    public final void d(Fragment fragment, GoOfflineIssue issue) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(issue, "issue");
        if (!(issue instanceof GoOfflineIssue.Blocked)) {
            return;
        }
        GoOfflineIssue.Blocked blocked = (GoOfflineIssue.Blocked) issue;
        String d8 = blocked.a().d();
        String c8 = blocked.a().c();
        ErrorAction a8 = blocked.a().a();
        if (a8 == null) {
            Kalev.m(new IllegalArgumentException("Missed field primaryAction when going offline error"), "Missed field primaryAction when going offline error");
            return;
        }
        ErrorAction b8 = blocked.a().b();
        if (b8 == null) {
            Kalev.m(new IllegalArgumentException("Missed field secondaryAction when going offline error"), "Missed field secondaryAction when going offline error");
            return;
        }
        DynamicActionDialog.Companion companion = DynamicActionDialog.f41090m;
        if (d8 == null) {
            d8 = "";
        }
        if (c8 == null) {
            c8 = "";
        }
        FragmentUtils.b(companion.a(new DynamicActionDialog.Model(d8, c8, new DynamicActionDialog.Action(a8.a(), b(a8.d()), a8), new DynamicActionDialog.Action(b8.a(), b(b8.d()), b8)), this.f33640b), fragment, "tag_go_offline_issue");
    }
}
