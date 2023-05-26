package ee.mtakso.driver.ui.screens.login.v3.verification;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentRoutingCommand;
import ee.mtakso.driver.ui.screens.login.v2.verification.resend.ResendCodeChannelPicker;
import ee.mtakso.driver.ui.screens.login.v3.common.DeprecatedAppDelegate;
import ee.mtakso.driver.ui.screens.login.v3.common.LoginPermissionsDelegate;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.utils.SimpleTextWatcher;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.CodeInputView;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationV3Fragment.kt */
/* loaded from: classes3.dex */
public final class VerificationV3Fragment extends BazeMvvmFragment<VerificationV3ViewModel> implements GoBackDelegate {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f30784u = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f30785o;

    /* renamed from: p  reason: collision with root package name */
    private WarningLabelDelegate f30786p;

    /* renamed from: q  reason: collision with root package name */
    private final LoginPermissionsDelegate f30787q;

    /* renamed from: r  reason: collision with root package name */
    private final DeprecatedAppDelegate f30788r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f30789s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f30790t;

    /* compiled from: VerificationV3Fragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouterFragmentRoutingCommand a(VerificationConfig verificationConfig, String phonePrefix, String phone) {
            Intrinsics.f(phonePrefix, "phonePrefix");
            Intrinsics.f(phone, "phone");
            return new RouterFragmentRoutingCommand(new RoutingCommand.FragmentClass(new RoutingState(SimpleActivity.class, null, 2, null), VerificationV3Fragment.class, BundleKt.a(TuplesKt.a("AUTH_DATA", verificationConfig), TuplesKt.a("PHONE_PREFIX", phonePrefix), TuplesKt.a("PHONE", phone))), false, 2, null);
        }
    }

    /* compiled from: VerificationV3Fragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30791a;

        static {
            int[] iArr = new int[VerificationChannel.values().length];
            try {
                iArr[VerificationChannel.CALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f30791a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public VerificationV3Fragment(BaseUiDependencies baseUiDependencies, FragmentFactory factory, AppResolver appResolver, PlatformManager platformManager) {
        super(baseUiDependencies, R.layout.fragment_login_otp, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(factory, "factory");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(platformManager, "platformManager");
        this.f30790t = new LinkedHashMap();
        this.f30785o = factory;
        this.f30787q = new LoginPermissionsDelegate(this, new VerificationV3Fragment$loginPermissionsDialogDelegate$1(this), new VerificationV3Fragment$loginPermissionsDialogDelegate$2(this));
        this.f30788r = new DeprecatedAppDelegate(this, appResolver, platformManager, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$deprecatedAppDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                VerificationV3ViewModel M;
                M = VerificationV3Fragment.this.M();
                M.H0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function0<AppVersionState>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$deprecatedAppDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AppVersionState invoke() {
                VerificationV3ViewModel M;
                M = VerificationV3Fragment.this.M();
                return (AppVersionState) LiveDataExtKt.b(M.c0());
            }
        });
        b8 = LazyKt__LazyJVMKt.b(new Function0<ProgressViewController>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$progressDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ProgressViewController invoke() {
                ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
                View view = VerificationV3Fragment.this.getView();
                Intrinsics.d(view, "null cannot be cast to non-null type android.view.ViewGroup");
                String string = VerificationV3Fragment.this.getString(R.string.verification_progress);
                Intrinsics.e(string, "getString(R.string.verification_progress)");
                return progressViewInflater.d((ViewGroup) view, string);
            }
        });
        this.f30789s = b8;
    }

    private final void A0() {
        Object W;
        List<VerificationChannel> c8 = i0().c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c8.iterator();
        while (true) {
            boolean z7 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((VerificationChannel) next) != VerificationChannel.UNKNOWN) {
                z7 = false;
            }
            if (!z7) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 1) {
            W = CollectionsKt___CollectionsKt.W(i0().c());
            M().x0((VerificationChannel) W);
            return;
        }
        C0();
    }

    private final void B0() {
        int i8 = R.id.infoBlockNoSms;
        View infoBlockNoSms = e0(i8);
        Intrinsics.e(infoBlockNoSms, "infoBlockNoSms");
        new InfoBlockController(infoBlockNoSms).b(new InfoBlockData(InfoBlockType.INFO, null, new Text.Resource(R.string.verification_no_sms_infoblock_short, null, 2, null), true));
        View infoBlockNoSms2 = e0(i8);
        Intrinsics.e(infoBlockNoSms2, "infoBlockNoSms");
        ViewExtKt.e(infoBlockNoSms2, false, 0, 2, null);
        TextView btnResendCode = (TextView) e0(R.id.btnResendCode);
        Intrinsics.e(btnResendCode, "btnResendCode");
        ViewExtKt.e(btnResendCode, false, 0, 2, null);
    }

    private final void C0() {
        KeyboardUtils.f34304a.a((CodeInputView) e0(R.id.inputCode));
        FragmentFactory fragmentFactory = this.f30785o;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ResendCodeChannelPicker resendCodeChannelPicker = (ResendCodeChannelPicker) FragmentFactoryUtils.b(fragmentFactory, requireContext, ResendCodeChannelPicker.class, ResendCodeChannelPicker.f30628n.a(i0()));
        resendCodeChannelPicker.O(new Function1<VerificationChannel, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$showResendOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VerificationChannel it) {
                VerificationV3ViewModel M;
                Intrinsics.f(it, "it");
                M = VerificationV3Fragment.this.M();
                M.x0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerificationChannel verificationChannel) {
                b(verificationChannel);
                return Unit.f50853a;
            }
        });
        resendCodeChannelPicker.show(getChildFragmentManager(), "picker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerificationConfig i0() {
        return (VerificationConfig) LiveDataExtKt.b(M().n0());
    }

    private final ErrorDialogDelegate j0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new ErrorDialogDelegate(requireActivity);
    }

    private final ProgressViewController k0() {
        return (ProgressViewController) this.f30789s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        M().t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(VerificationV3Fragment this$0) {
        Intrinsics.f(this$0, "this$0");
        CodeInputView codeInputView = (CodeInputView) this$0.e0(R.id.inputCode);
        if (codeInputView != null) {
            KeyboardUtils.f34304a.b(codeInputView, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n0(VerificationV3Fragment this$0, View view, int i8, KeyEvent keyEvent) {
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
        if (((CodeInputView) this$0.e0(i9)).h()) {
            ((CodeInputView) this$0.e0(i9)).setText((CharSequence) null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(VerificationV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().X();
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(VerificationV3Fragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(VerificationV3Fragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        int i8 = R.id.inputCode;
        ((CodeInputView) this$0.e0(i8)).setError(false);
        ((CodeInputView) this$0.e0(i8)).setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(VerificationV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(VerificationV3Fragment this$0, View view) {
        int i8;
        Intrinsics.f(this$0, "this$0");
        VerificationV3ViewModel.CoolDownData f8 = this$0.M().q0().f();
        if (f8 != null) {
            i8 = f8.d();
        } else {
            i8 = 1;
        }
        if (i8 < 0) {
            this$0.A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(VerificationV3Fragment this$0, VerificationV3ViewModel.CoolDownData coolDownData) {
        Intrinsics.f(this$0, "this$0");
        if (coolDownData.d() >= 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = this$0.getString(R.string.verification_code_timer);
            Intrinsics.e(string, "getString(R.string.verification_code_timer)");
            Color.Attr attr = new Color.Attr(R.attr.contentSecondary);
            Context requireContext = this$0.requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) SpannableUtilsKt.b(string, ColorKt.a(attr, requireContext))).append((CharSequence) " ");
            String valueOf = String.valueOf(coolDownData.d());
            Color.Attr attr2 = new Color.Attr(R.attr.contentPrimary);
            Context requireContext2 = this$0.requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            ((TextView) this$0.e0(R.id.btnResendCode)).setText(append.append((CharSequence) SpannableUtilsKt.b(valueOf, ColorKt.a(attr2, requireContext2))));
        } else {
            String string2 = this$0.getString(R.string.verification_code_sms);
            Intrinsics.e(string2, "getString(R.string.verification_code_sms)");
            Color.Attr attr3 = new Color.Attr(R.attr.linkAlternative);
            Context requireContext3 = this$0.requireContext();
            Intrinsics.e(requireContext3, "requireContext()");
            ((TextView) this$0.e0(R.id.btnResendCode)).setText(SpannableUtilsKt.b(string2, ColorKt.a(attr3, requireContext3)));
        }
        View infoBlockNoSms = this$0.e0(R.id.infoBlockNoSms);
        Intrinsics.e(infoBlockNoSms, "infoBlockNoSms");
        ViewExtKt.e(infoBlockNoSms, coolDownData.b(), 0, 2, null);
        TextView btnDidNotReceiveCode = (TextView) this$0.e0(R.id.btnDidNotReceiveCode);
        Intrinsics.e(btnDidNotReceiveCode, "btnDidNotReceiveCode");
        ViewExtKt.e(btnDidNotReceiveCode, !coolDownData.b(), 0, 2, null);
        TextView btnResendCode = (TextView) this$0.e0(R.id.btnResendCode);
        Intrinsics.e(btnResendCode, "btnResendCode");
        ViewExtKt.e(btnResendCode, coolDownData.c(), 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(VerificationV3Fragment this$0, View view, VerificationChannel verificationChannel) {
        int i8;
        int i9;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        if (verificationChannel == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30791a[verificationChannel.ordinal()];
        }
        if (i8 == 1) {
            i9 = R.string.verification_sent_new_call;
        } else {
            i9 = R.string.verification_sent_new;
        }
        String string = this$0.getString(i9);
        Intrinsics.e(string, "getString(\n             …          }\n            )");
        Snackbar.t0(new ContextThemeWrapper(this$0.requireContext(), 2132017818), view, string, -1).X(this$0.e0(R.id.infoBlockNoSms)).e0();
        KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
        CodeInputView inputCode = (CodeInputView) this$0.e0(R.id.inputCode);
        Intrinsics.e(inputCode, "inputCode");
        keyboardUtils.b(inputCode, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(VerificationV3Fragment this$0, String str) {
        Intrinsics.f(this$0, "this$0");
        ((CodeInputView) this$0.e0(R.id.inputCode)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(VerificationV3Fragment this$0, AppVersionState it) {
        Intrinsics.f(this$0, "this$0");
        DeprecatedAppDelegate deprecatedAppDelegate = this$0.f30788r;
        Intrinsics.e(it, "it");
        deprecatedAppDelegate.f(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(VerificationV3Fragment this$0, PermissionManager.PermissionInfo it) {
        Intrinsics.f(this$0, "this$0");
        LoginPermissionsDelegate loginPermissionsDelegate = this$0.f30787q;
        Intrinsics.e(it, "it");
        loginPermissionsDelegate.d(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(VerificationV3Fragment this$0, GeoLocationManagerState it) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.f30786p;
        if (warningLabelDelegate != null) {
            Intrinsics.e(it, "it");
            warningLabelDelegate.h(new WarningMessage.Location(it));
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30790t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        k0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        ApiException apiException;
        String str;
        Intrinsics.f(error, "error");
        if (error instanceof ApiException) {
            apiException = (ApiException) error;
        } else {
            apiException = null;
        }
        if (apiException != null) {
            str = apiException.e();
        } else {
            str = null;
        }
        if (str != null) {
            int i8 = R.id.labelWrongCode;
            ((TextView) e0(i8)).setText(str);
            TextView labelWrongCode = (TextView) e0(i8);
            Intrinsics.e(labelWrongCode, "labelWrongCode");
            ViewExtKt.e(labelWrongCode, false, 0, 3, null);
            ((CodeInputView) e0(R.id.inputCode)).setError(true);
            return;
        }
        j0().a(error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        k0().b();
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate
    public boolean c() {
        M().X();
        return false;
    }

    public View e0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30790t;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f30786p = new WarningLabelDelegate(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("PHONE_PREFIX", "");
        Intrinsics.e(string, "requireArguments().getString(PHONE_PREFIX, \"\")");
        String string2 = requireArguments().getString("PHONE", "");
        Intrinsics.e(string2, "requireArguments().getString(PHONE, \"\")");
        M().k0((VerificationConfig) requireArguments().getParcelable("AUTH_DATA"), string, string2);
        M().D0(i0().f(), i0().e());
        this.f30787q.c();
        this.f30788r.e();
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
        CodeInputView codeInputView = (CodeInputView) e0(R.id.inputCode);
        if (codeInputView != null) {
            codeInputView.post(new Runnable() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.a
                @Override // java.lang.Runnable
                public final void run() {
                    VerificationV3Fragment.m0(VerificationV3Fragment.this);
                }
            });
        }
        M().w0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentExtKt.a(this).l(this);
        ((TextView) e0(R.id.labelTarget)).setText(i0().g());
        int i8 = R.id.inputCode;
        ((CodeInputView) e0(i8)).setDigitCount(i0().d());
        ((CodeInputView) e0(i8)).addTextChangedListener(new SimpleTextWatcher() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$onViewCreated$1
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
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment r2 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.this
                    ee.mtakso.driver.ui.screens.login.common.VerificationConfig r2 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.f0(r2)
                    int r2 = r2.d()
                    if (r1 != r2) goto L15
                    r1 = 1
                    goto L16
                L15:
                    r1 = 0
                L16:
                    if (r1 == 0) goto L2f
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment r1 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.this
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel r1 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.g0(r1)
                    java.lang.String r4 = r4.toString()
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment r2 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.this
                    ee.mtakso.driver.ui.screens.login.common.VerificationConfig r2 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.f0(r2)
                    java.lang.String r2 = r2.h()
                    r1.Y(r4, r2)
                L2f:
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment r4 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.this
                    int r1 = ee.mtakso.driver.R.id.inputCode
                    android.view.View r4 = r4.e0(r1)
                    ee.mtakso.driver.uikit.widgets.CodeInputView r4 = (ee.mtakso.driver.uikit.widgets.CodeInputView) r4
                    r4.setError(r0)
                    ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment r4 = ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment.this
                    int r1 = ee.mtakso.driver.R.id.labelWrongCode
                    android.view.View r4 = r4.e0(r1)
                    android.widget.TextView r4 = (android.widget.TextView) r4
                    java.lang.String r1 = "labelWrongCode"
                    kotlin.jvm.internal.Intrinsics.e(r4, r1)
                    r1 = 2
                    r2 = 0
                    ee.mtakso.driver.uicore.utils.ViewExtKt.e(r4, r0, r0, r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment$onViewCreated$1.afterTextChanged(android.text.Editable):void");
            }
        });
        ((CodeInputView) e0(i8)).setOnKeyListener(new View.OnKeyListener() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.e
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i9, KeyEvent keyEvent) {
                boolean n02;
                n02 = VerificationV3Fragment.n0(VerificationV3Fragment.this, view2, i9, keyEvent);
                return n02;
            }
        });
        ((ImageView) e0(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerificationV3Fragment.o0(VerificationV3Fragment.this, view2);
            }
        });
        ((TextView) e0(R.id.btnDidNotReceiveCode)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerificationV3Fragment.r0(VerificationV3Fragment.this, view2);
            }
        });
        ((TextView) e0(R.id.btnResendCode)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerificationV3Fragment.s0(VerificationV3Fragment.this, view2);
            }
        });
        M().q0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.t0(VerificationV3Fragment.this, (VerificationV3ViewModel.CoolDownData) obj);
            }
        });
        M().r0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.u0(VerificationV3Fragment.this, view, (VerificationChannel) obj);
            }
        });
        LiveEvent<String> p02 = M().p0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        p02.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.v0(VerificationV3Fragment.this, (String) obj);
            }
        });
        M().c0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.w0(VerificationV3Fragment.this, (AppVersionState) obj);
            }
        });
        M().d0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.x0(VerificationV3Fragment.this, (PermissionManager.PermissionInfo) obj);
            }
        });
        M().e0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.y0(VerificationV3Fragment.this, (GeoLocationManagerState) obj);
            }
        });
        LiveEvent<Object> o02 = M().o0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        o02.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.p0(VerificationV3Fragment.this, obj);
            }
        });
        LiveEvent<Object> s02 = M().s0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner3, "viewLifecycleOwner");
        s02.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.login.v3.verification.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerificationV3Fragment.q0(VerificationV3Fragment.this, obj);
            }
        });
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: z0 */
    public VerificationV3ViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (VerificationV3ViewModel) new ViewModelProvider(this, E.d()).a(VerificationV3ViewModel.class);
    }
}
