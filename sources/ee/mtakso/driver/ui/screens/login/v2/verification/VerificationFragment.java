package ee.mtakso.driver.ui.screens.login.v2.verification;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate;
import ee.mtakso.driver.ui.screens.login.v2.verification.resend.ResendCodeChannelPicker;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.SimpleTextWatcher;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.widgets.CodeInputView;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationFragment.kt */
/* loaded from: classes3.dex */
public final class VerificationFragment extends BazeMvvmFragment<VerificationViewModel> implements GoBackDelegate {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f30556t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f30557o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f30558p;

    /* renamed from: q  reason: collision with root package name */
    private WarningLabelDelegate f30559q;

    /* renamed from: r  reason: collision with root package name */
    private Color.Attr f30560r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f30561s;

    /* compiled from: VerificationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(VerificationConfig data) {
            Intrinsics.f(data, "data");
            return BundleKt.a(TuplesKt.a("auth", data));
        }
    }

    /* compiled from: VerificationFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30562a;

        static {
            int[] iArr = new int[VerificationChannel.values().length];
            try {
                iArr[VerificationChannel.CALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f30562a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public VerificationFragment(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactoryAnonymous, PermissionManager permissionManager, AppThemeManager appThemeManager, FragmentFactory factory) {
        super(new BaseUiDependencies(screenAnalytics, viewModelFactoryAnonymous, permissionManager, appThemeManager), R.layout.fragment_login_verification, null, 4, null);
        Lazy b8;
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactoryAnonymous, "viewModelFactoryAnonymous");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(factory, "factory");
        this.f30561s = new LinkedHashMap();
        this.f30557o = factory;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ProgressViewController>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment$progressDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ProgressViewController invoke() {
                ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
                View view = VerificationFragment.this.getView();
                Intrinsics.d(view, "null cannot be cast to non-null type android.view.ViewGroup");
                String string = VerificationFragment.this.getString(R.string.verification_progress);
                Intrinsics.e(string, "getString(R.string.verification_progress)");
                return progressViewInflater.d((ViewGroup) view, string);
            }
        });
        this.f30558p = b8;
        this.f30560r = new Color.Attr(R.attr.linkAlternative);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerificationConfig c0() {
        return (VerificationConfig) LiveDataExtKt.b(M().f0());
    }

    private final ProgressViewController d0() {
        return (ProgressViewController) this.f30558p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(VerificationFragment this$0, GeoLocationManagerState it) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.f30559q;
        if (warningLabelDelegate != null) {
            Intrinsics.e(it, "it");
            warningLabelDelegate.h(new WarningMessage.Location(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0(VerificationFragment this$0, View view, int i8, KeyEvent keyEvent) {
        Intrinsics.f(this$0, "this$0");
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i8 != 67) {
            switch (i8) {
            }
            return false;
        }
        int i9 = R.id.inputCode;
        if (((CodeInputView) this$0.Z(i9)).h()) {
            ((CodeInputView) this$0.Z(i9)).setText((CharSequence) null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(final VerificationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Integer f8 = this$0.M().g0().f();
        if (f8 == null) {
            f8 = 1;
        }
        if (f8.intValue() <= 0) {
            FragmentFactory fragmentFactory = this$0.f30557o;
            Context requireContext = this$0.requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            ResendCodeChannelPicker resendCodeChannelPicker = (ResendCodeChannelPicker) FragmentFactoryUtils.b(fragmentFactory, requireContext, ResendCodeChannelPicker.class, ResendCodeChannelPicker.f30628n.a(this$0.c0()));
            resendCodeChannelPicker.O(new Function1<VerificationChannel, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment$onViewCreated$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(VerificationChannel it) {
                    VerificationViewModel M;
                    VerificationConfig c02;
                    Intrinsics.f(it, "it");
                    M = VerificationFragment.this.M();
                    c02 = VerificationFragment.this.c0();
                    M.l0(c02.h(), it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VerificationChannel verificationChannel) {
                    b(verificationChannel);
                    return Unit.f50853a;
                }
            });
            resendCodeChannelPicker.show(this$0.getChildFragmentManager(), "picker");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(VerificationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(VerificationFragment this$0, Integer it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.intValue() > 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = this$0.getString(R.string.verification_code_timer);
            Intrinsics.e(string, "getString(R.string.verification_code_timer)");
            ((TextView) this$0.Z(R.id.btnResendCode)).setText(spannableStringBuilder.append((CharSequence) SpannableUtilsKt.b(string, ContextCompat.getColor(this$0.requireContext(), R.color.neutral400))).append((CharSequence) " ").append((CharSequence) SpannableUtilsKt.b(String.valueOf(it), ContextCompat.getColor(this$0.requireContext(), R.color.neutral900))));
            return;
        }
        String string2 = this$0.getString(R.string.verification_code_issue);
        Intrinsics.e(string2, "getString(R.string.verification_code_issue)");
        Color.Attr attr = this$0.f30560r;
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((TextView) this$0.Z(R.id.btnResendCode)).setText(SpannableUtilsKt.b(string2, ColorKt.a(attr, requireContext)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(VerificationFragment this$0, Boolean dismissed) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(dismissed, "dismissed");
        if (dismissed.booleanValue()) {
            FragmentExtKt.a(this$0).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(VerificationFragment this$0, View view, VerificationChannel verificationChannel) {
        int i8;
        int i9;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        if (verificationChannel == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30562a[verificationChannel.ordinal()];
        }
        if (i8 == 1) {
            i9 = R.string.verification_sent_new_call;
        } else {
            i9 = R.string.verification_sent_new;
        }
        String string = this$0.getString(i9);
        Intrinsics.e(string, "getString(\n             …          }\n            )");
        Snackbar.t0(new ContextThemeWrapper(this$0.requireContext(), (int) R$style.Theme_Dark), view, string, -1).e0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30561s.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        d0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        if (ApiExceptionUtils.m(error, 58000)) {
            TextView labelWrongCode = (TextView) Z(R.id.labelWrongCode);
            Intrinsics.e(labelWrongCode, "labelWrongCode");
            ViewExtKt.e(labelWrongCode, false, 0, 3, null);
            ((CodeInputView) Z(R.id.inputCode)).setError(true);
            return;
        }
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        d0().b();
    }

    public View Z(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30561s;
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

    @Override // ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate
    public boolean c() {
        if (Intrinsics.a(M().h0().f(), Boolean.TRUE)) {
            return false;
        }
        M().V();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: m0 */
    public VerificationViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (VerificationViewModel) new ViewModelProvider(this, E.d()).a(VerificationViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f30559q = new WarningLabelDelegate(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("auth");
        Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.login.common.VerificationConfig");
        M().c0((VerificationConfig) parcelable);
        M().r0(c0().f(), c0().e());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (Intrinsics.a(FragmentExtKt.a(this).g(), this)) {
            FragmentExtKt.a(this).l(null);
        }
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        KeyboardUtils.f34304a.a(getView());
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().o0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentExtKt.a(this).l(this);
        ((TextView) Z(R.id.labelTarget)).setText(c0().g());
        int i8 = R.id.inputCode;
        ((CodeInputView) Z(i8)).setDigitCount(c0().d());
        MutableLiveData<String> X = M().X();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                ((CodeInputView) VerificationFragment.this.Z(R.id.inputCode)).setText(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        X.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationFragment.e0(Function1.this, obj);
            }
        });
        M().Y().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationFragment.f0(VerificationFragment.this, (GeoLocationManagerState) obj);
            }
        });
        ((CodeInputView) Z(i8)).addTextChangedListener(new SimpleTextWatcher() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment$onViewCreated$3
            /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
            @Override // ee.mtakso.driver.uicore.utils.SimpleTextWatcher, android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void afterTextChanged(android.text.Editable r4) {
                /*
                    r3 = this;
                    r0 = 0
                    if (r4 == 0) goto L15
                    int r1 = r4.length()
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment r2 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.this
                    ee.mtakso.driver.ui.screens.login.common.VerificationConfig r2 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.a0(r2)
                    int r2 = r2.d()
                    if (r1 != r2) goto L15
                    r1 = 1
                    goto L16
                L15:
                    r1 = 0
                L16:
                    if (r1 == 0) goto L2f
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment r1 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.this
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel r1 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.b0(r1)
                    java.lang.String r4 = r4.toString()
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment r2 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.this
                    ee.mtakso.driver.ui.screens.login.common.VerificationConfig r2 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.a0(r2)
                    java.lang.String r2 = r2.h()
                    r1.W(r4, r2)
                L2f:
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment r4 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.this
                    int r1 = ee.mtakso.driver.R.id.inputCode
                    android.view.View r4 = r4.Z(r1)
                    ee.mtakso.driver.uikit.widgets.CodeInputView r4 = (ee.mtakso.driver.uikit.widgets.CodeInputView) r4
                    r4.setError(r0)
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment r4 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment.this
                    int r1 = ee.mtakso.driver.R.id.labelWrongCode
                    android.view.View r4 = r4.Z(r1)
                    android.widget.TextView r4 = (android.widget.TextView) r4
                    java.lang.String r1 = "labelWrongCode"
                    kotlin.jvm.internal.Intrinsics.e(r4, r1)
                    r1 = 2
                    r2 = 0
                    ee.mtakso.driver.uicore.utils.ViewExtKt.e(r4, r0, r0, r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment$onViewCreated$3.afterTextChanged(android.text.Editable):void");
            }
        });
        ((CodeInputView) Z(i8)).setOnKeyListener(new View.OnKeyListener() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.c
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i9, KeyEvent keyEvent) {
                boolean g02;
                g02 = VerificationFragment.g0(VerificationFragment.this, view2, i9, keyEvent);
                return g02;
            }
        });
        ((TextView) Z(R.id.btnResendCode)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerificationFragment.h0(VerificationFragment.this, view2);
            }
        });
        ((ImageView) Z(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerificationFragment.i0(VerificationFragment.this, view2);
            }
        });
        KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
        CodeInputView inputCode = (CodeInputView) Z(i8);
        Intrinsics.e(inputCode, "inputCode");
        KeyboardUtils.c(keyboardUtils, inputCode, false, 2, null);
        M().g0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationFragment.j0(VerificationFragment.this, (Integer) obj);
            }
        });
        M().h0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationFragment.k0(VerificationFragment.this, (Boolean) obj);
            }
        });
        M().i0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationFragment.l0(VerificationFragment.this, view, (VerificationChannel) obj);
            }
        });
    }
}
