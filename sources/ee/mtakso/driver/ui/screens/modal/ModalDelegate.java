package ee.mtakso.driver.ui.screens.modal;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.modal.BannerAction;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalDelegate.kt */
/* loaded from: classes3.dex */
public final class ModalDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f30879c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f30880d = View.generateViewId();

    /* renamed from: a  reason: collision with root package name */
    private final PromoDialogDelegate f30881a;

    /* renamed from: b  reason: collision with root package name */
    private Function1<? super ModalAction, Unit> f30882b;

    /* compiled from: ModalDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ModalDelegate(PromoDialogDelegate promoDialogDelegate) {
        Intrinsics.f(promoDialogDelegate, "promoDialogDelegate");
        this.f30881a = promoDialogDelegate;
        this.f30882b = new Function1<ModalAction, Unit>() { // from class: ee.mtakso.driver.ui.screens.modal.ModalDelegate$actionCallback$1
            public final void b(ModalAction it) {
                Intrinsics.f(it, "it");
                throw new IllegalStateException("Callback should be assigned by restoreCallbacks");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModalAction modalAction) {
                b(modalAction);
                return Unit.f50853a;
            }
        };
    }

    private final View e(ViewGroup viewGroup) {
        int i8 = f30880d;
        View findViewById = viewGroup.findViewById(i8);
        if (findViewById == null) {
            View view = new View(viewGroup.getContext());
            view.setId(i8);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(view);
            return view;
        }
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(f30880d);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
    }

    private final void h(Fragment fragment, View view, final ModalDialogResponse.Banner banner) {
        final ViewGroup contentView = (ViewGroup) fragment.requireView().findViewById(R.id.workCoordinator);
        final Snackbar v02 = Snackbar.v0(contentView, banner.b().b(), -2);
        Intrinsics.e(v02, "make(contentView, banner…ackbar.LENGTH_INDEFINITE)");
        v02.X(view);
        final BannerAction a8 = banner.b().a();
        if (a8 != null) {
            v02.x0(a8.c(), new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.modal.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ModalDelegate.i(ModalDelegate.this, a8, banner, view2);
                }
            });
        }
        Intrinsics.e(contentView, "contentView");
        e(contentView).setOnTouchListener(new View.OnTouchListener() { // from class: ee.mtakso.driver.ui.screens.modal.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean j8;
                j8 = ModalDelegate.j(Snackbar.this, view2, motionEvent);
                return j8;
            }
        });
        v02.u(new Snackbar.Callback() { // from class: ee.mtakso.driver.ui.screens.modal.ModalDelegate$showBanner$3
            @Override // com.google.android.material.snackbar.Snackbar.Callback, com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /* renamed from: c */
            public void a(Snackbar snackbar, int i8) {
                ModalDelegate modalDelegate = ModalDelegate.this;
                ViewGroup contentView2 = contentView;
                Intrinsics.e(contentView2, "contentView");
                modalDelegate.f(contentView2);
            }
        });
        v02.e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ModalDelegate this$0, BannerAction action, ModalDialogResponse.Banner banner, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(action, "$action");
        Intrinsics.f(banner, "$banner");
        this$0.f30882b.invoke(new ModalAction(action.a(), banner.a(), banner.d(), banner.c(), action.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(Snackbar snackbar, View view, MotionEvent motionEvent) {
        Intrinsics.f(snackbar, "$snackbar");
        if (snackbar.O()) {
            snackbar.A();
        }
        view.performClick();
        return false;
    }

    public final void g(Fragment fragment, Function1<? super ModalAction, Unit> callback) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(callback, "callback");
        this.f30882b = callback;
        this.f30881a.r(new Function1<DynamicModalDialog.ActionModel, Unit>() { // from class: ee.mtakso.driver.ui.screens.modal.ModalDelegate$restoreCallbacks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DynamicModalDialog.ActionModel model) {
                Function1 function1;
                String str;
                String str2;
                String str3;
                Intrinsics.f(model, "model");
                function1 = ModalDelegate.this.f30882b;
                String a8 = model.a();
                DynamicModalDialog.ModalInfo c8 = model.c();
                if (c8 != null) {
                    str = c8.a();
                } else {
                    str = null;
                }
                DynamicModalDialog.ModalInfo c9 = model.c();
                if (c9 != null) {
                    str2 = c9.c();
                } else {
                    str2 = null;
                }
                DynamicModalDialog.ModalInfo c10 = model.c();
                if (c10 != null) {
                    str3 = c10.b();
                } else {
                    str3 = null;
                }
                function1.invoke(new ModalAction(a8, str, str2, str3, model.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DynamicModalDialog.ActionModel actionModel) {
                b(actionModel);
                return Unit.f50853a;
            }
        });
        this.f30881a.s(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.modal.ModalDelegate$restoreCallbacks$2
            public final void b() {
                throw new IllegalStateException("Unsupported callback");
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        PromoDialogDelegate promoDialogDelegate = this.f30881a;
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.e(requireActivity, "fragment.requireActivity()");
        promoDialogDelegate.q(requireActivity);
    }

    public final void k(Fragment fragment, View view, ModalDialogResponse modal) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(modal, "modal");
        if (modal instanceof ModalDialogResponse.Banner) {
            h(fragment, view, (ModalDialogResponse.Banner) modal);
        } else if (modal instanceof ModalDialogResponse.Dialog) {
            PromoDialogDelegate promoDialogDelegate = this.f30881a;
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.e(requireActivity, "fragment.requireActivity()");
            PromoDialogDelegate.B(promoDialogDelegate, requireActivity, new PromoDialog.Dynamic((ModalDialogResponse.Dialog) modal), null, null, 12, null);
        } else {
            String str = "Unsupported modal type " + modal;
            Kalev.e(new IllegalArgumentException(str), str);
        }
    }
}
