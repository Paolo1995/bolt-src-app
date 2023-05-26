package ee.mtakso.driver.ui.screens.sos;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.sos.SosDialogViewModel;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SosDialogFragment.kt */
/* loaded from: classes5.dex */
public final class SosDialogFragment extends BaseMvvmDialogFragment<SosDialogViewModel> {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f33394m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f33395l;

    /* compiled from: SosDialogFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SosDialogFragment.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33396a;

        static {
            int[] iArr = new int[SosDialogViewModel.SosDialogAction.values().length];
            try {
                iArr[SosDialogViewModel.SosDialogAction.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SosDialogViewModel.SosDialogAction.CALL_EMERGENCY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SosDialogViewModel.SosDialogAction.SHOW_TOO_MANY_REQUESTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SosDialogViewModel.SosDialogAction.SHOW_ALREADY_IN_PROCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f33396a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SosDialogFragment(BaseUiDependencies deps) {
        super(deps, R.layout.dialog_fragment_sos);
        Intrinsics.f(deps, "deps");
        this.f33395l = new LinkedHashMap();
    }

    private final void Y(SosDialogViewModel.SosDialogAction sosDialogAction) {
        int i8 = WhenMappings.f33396a[sosDialogAction.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        String string = getString(R.string.error_already_proccessing_sos_request);
                        Intrinsics.e(string, "getString(R.string.error…_proccessing_sos_request)");
                        h0(string);
                        return;
                    }
                    return;
                }
                String string2 = getString(R.string.error_sos_triggered_too_often);
                Intrinsics.e(string2, "getString(R.string.error_sos_triggered_too_often)");
                h0(string2);
                return;
            }
            W();
            return;
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(SosDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H().f0();
        this$0.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(SosDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H().h0();
        this$0.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(SosDialogFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 1) {
            this$0.H().b0();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(SosDialogFragment this$0, Integer count) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(count, "count");
        this$0.g0(count.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(SosDialogFragment this$0, SosDialogViewModel.SosDialogAction action) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(action, "action");
        this$0.Y(action);
    }

    private final void g0(int i8) {
        boolean z7;
        ((TextView) V(R.id.sos_countdown_text)).setText(String.valueOf(i8));
        if (i8 == 0) {
            H().g0();
        }
        ConstraintLayout sos_countdown_layout = (ConstraintLayout) V(R.id.sos_countdown_layout);
        Intrinsics.e(sos_countdown_layout, "sos_countdown_layout");
        boolean z8 = true;
        if (i8 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(sos_countdown_layout, z7, 0, 2, null);
        ConstraintLayout sos_confirm_layout = (ConstraintLayout) V(R.id.sos_confirm_layout);
        Intrinsics.e(sos_confirm_layout, "sos_confirm_layout");
        if (i8 != 0) {
            z8 = false;
        }
        ViewExtKt.e(sos_confirm_layout, z8, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    public void F() {
        this.f33395l.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    protected void P() {
        ProgressBar loading = (ProgressBar) V(R.id.T6);
        Intrinsics.e(loading, "loading");
        ViewExtKt.e(loading, false, 0, 3, null);
        ConstraintLayout sos_confirm_layout = (ConstraintLayout) V(R.id.sos_confirm_layout);
        Intrinsics.e(sos_confirm_layout, "sos_confirm_layout");
        ViewExtKt.e(sos_confirm_layout, false, 0, 2, null);
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33395l;
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

    public final void W() {
        Utils.b(getActivity(), (String) LiveDataExtKt.b(H().R()));
    }

    public final void X() {
        dismissAllowingStateLoss();
    }

    public final void Z() {
        int i8 = R.id.sos_positive_button;
        ((RoundButton) V(i8)).setEnabled(false);
        ((RoundButton) V(i8)).setClickable(false);
        H().O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    /* renamed from: f0 */
    public SosDialogViewModel N() {
        BaseUiDependencies baseUiDependencies;
        baseUiDependencies = ((BaseMvvmDialogFragment) this).f26249f;
        return (SosDialogViewModel) new ViewModelProvider(this, baseUiDependencies.d()).a(SosDialogViewModel.class);
    }

    public final void h0(String msg) {
        Intrinsics.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 1).show();
    }

    public final void i0() {
        H().b0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973835);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        X();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(R.drawable.rounded_dialog);
            window.setLayout(-1, -1);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        H().e0();
        ((RoundButton) V(R.id.sos_positive_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.sos.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SosDialogFragment.a0(SosDialogFragment.this, view2);
            }
        });
        ((RoundButton) V(R.id.sos_negative_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.sos.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SosDialogFragment.b0(SosDialogFragment.this, view2);
            }
        });
        ((ConstraintLayout) V(R.id.sos_countdown_layout)).setOnTouchListener(new View.OnTouchListener() { // from class: ee.mtakso.driver.ui.screens.sos.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean c02;
                c02 = SosDialogFragment.c0(SosDialogFragment.this, view2, motionEvent);
                return c02;
            }
        });
        H().S().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.sos.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SosDialogFragment.d0(SosDialogFragment.this, (Integer) obj);
            }
        });
        H().T().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.sos.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SosDialogFragment.e0(SosDialogFragment.this, (SosDialogViewModel.SosDialogAction) obj);
            }
        });
    }
}
