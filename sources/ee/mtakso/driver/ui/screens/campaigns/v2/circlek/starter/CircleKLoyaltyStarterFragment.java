package ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircleKLoyaltyStarterFragment.kt */
/* loaded from: classes3.dex */
public final class CircleKLoyaltyStarterFragment extends BazeMvvmFragment<CircleKLoyaltyStarterViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f27388q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f27389o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f27390p;

    /* compiled from: CircleKLoyaltyStarterFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CircleKLoyaltyStarterFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_plain, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f27390p = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<ProgressViewController>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment$loadingDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ProgressViewController invoke() {
                ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
                ConstraintLayout rootView = (ConstraintLayout) CircleKLoyaltyStarterFragment.this.S(R.id.rootView);
                Intrinsics.e(rootView, "rootView");
                return progressViewInflater.c(rootView);
            }
        });
        this.f27389o = b8;
    }

    private final ProgressViewController U() {
        return (ProgressViewController) this.f27389o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator V() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(CircleKLoyaltyStarterFragment this$0, LiveDataNotification it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.W(it);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27390p.clear();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27390p;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void W(LiveDataNotification<String> notification) {
        Intrinsics.f(notification, "notification");
        if (notification.c()) {
            U().b();
            return;
        }
        U().a();
        if (notification.b() != null) {
            CircleKLoyaltyFragment.Companion companion = CircleKLoyaltyFragment.f27371t;
            Navigator V = V();
            String b8 = notification.b();
            Intrinsics.c(b8);
            companion.b(V, b8);
        } else if (notification.a() != null) {
            NotificationDialog.Companion companion2 = NotificationDialog.f28313n;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            NotificationDialog a8 = companion2.a(requireContext, notification.a(), new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment$onCircleKLoyaltyMagicLinkLoaded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                public final void b(DialogFragment dialogFragment, View view, Object obj) {
                    Navigator V2;
                    Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                    V2 = CircleKLoyaltyStarterFragment.this.V();
                    V2.c();
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                    b(dialogFragment, view, obj);
                    return Unit.f50853a;
                }
            });
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            FragmentUtils.c(a8, requireActivity, "error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: Y */
    public CircleKLoyaltyStarterViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (CircleKLoyaltyStarterViewModel) new ViewModelProvider(this, E.d()).a(CircleKLoyaltyStarterViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().setRequestedOrientation(14);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        M().G().i(getViewLifecycleOwner(), new Observer() { // from class: x2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CircleKLoyaltyStarterFragment.X(CircleKLoyaltyStarterFragment.this, (LiveDataNotification) obj);
            }
        });
    }
}
