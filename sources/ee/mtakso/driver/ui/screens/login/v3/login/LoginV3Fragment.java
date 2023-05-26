package ee.mtakso.driver.ui.screens.login.v3.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.screens.AnonymousSimpleActivity;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment;
import ee.mtakso.driver.ui.screens.login.v3.common.SharedLoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel;
import ee.mtakso.driver.ui.screens.update.GoogleServicesUpdateDelegate;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginV3Fragment.kt */
/* loaded from: classes3.dex */
public final class LoginV3Fragment extends BazeMvvmFragment<LoginV3ViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f30689t = new Companion(null);

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f30690u = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");

    /* renamed from: o  reason: collision with root package name */
    private final RoutingManager f30691o;

    /* renamed from: p  reason: collision with root package name */
    private WarningLabelDelegate f30692p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f30693q;

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f30694r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f30695s;

    /* compiled from: LoginV3Fragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            if (TextUtilsCompat.a(Locale.getDefault()) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: LoginV3Fragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30696a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f30697b;

        static {
            int[] iArr = new int[LoginV3ViewModel.LoginOption.values().length];
            try {
                iArr[LoginV3ViewModel.LoginOption.PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginV3ViewModel.LoginOption.EMAIL_USERNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30696a = iArr;
            int[] iArr2 = new int[SharedLoginV3ViewModel.LoginEvent.values().length];
            try {
                iArr2[SharedLoginV3ViewModel.LoginEvent.CLEAR_USERNAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            f30697b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LoginV3Fragment(BaseUiDependencies baseUiDependencies, RoutingManager routingManager) {
        super(baseUiDependencies, R.layout.fragment_login_v3, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(routingManager, "routingManager");
        this.f30695s = new LinkedHashMap();
        this.f30691o = routingManager;
        b8 = LazyKt__LazyJVMKt.b(new Function0<GoogleServicesUpdateDelegate>() { // from class: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment$googleServicesUpdateDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final GoogleServicesUpdateDelegate invoke() {
                RoutingManager routingManager2;
                ErrorDialogDelegate j02;
                routingManager2 = LoginV3Fragment.this.f30691o;
                j02 = LoginV3Fragment.this.j0();
                return new GoogleServicesUpdateDelegate(routingManager2, j02);
            }
        });
        this.f30693q = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<SharedLoginV3ViewModel>() { // from class: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment$sharedViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SharedLoginV3ViewModel invoke() {
                BaseUiDependencies E;
                LoginV3Fragment loginV3Fragment = LoginV3Fragment.this;
                FragmentActivity requireActivity = loginV3Fragment.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                E = loginV3Fragment.E();
                return (SharedLoginV3ViewModel) new ViewModelProvider(requireActivity, E.d()).a(SharedLoginV3ViewModel.class);
            }
        });
        this.f30694r = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(boolean z7) {
        Group groupInputEmail = (Group) d0(R.id.groupInputEmail);
        Intrinsics.e(groupInputEmail, "groupInputEmail");
        ViewExtKt.e(groupInputEmail, z7, 0, 2, null);
        Group groupInputPhone = (Group) d0(R.id.groupInputPhone);
        Intrinsics.e(groupInputPhone, "groupInputPhone");
        ViewExtKt.e(groupInputPhone, !z7, 0, 2, null);
    }

    private final void B0(Text text) {
        int i8 = R.id.errorLabel;
        AppCompatTextView errorLabel = (AppCompatTextView) d0(i8);
        Intrinsics.e(errorLabel, "errorLabel");
        TextViewExtKt.h(errorLabel, text);
        AppCompatTextView errorLabel2 = (AppCompatTextView) d0(i8);
        Intrinsics.e(errorLabel2, "errorLabel");
        ViewExtKt.e(errorLabel2, false, 0, 3, null);
    }

    private final SpannableStringBuilder i0(int i8, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (f30689t.b()) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            SpannableStringBuilderUtils.a(spannableStringBuilder, ".", SpannableUtilsKt.c(requireContext, i8));
        } else {
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            SpannableStringBuilderUtils.a(spannableStringBuilder, ".", SpannableUtilsKt.c(requireContext2, i8));
        }
        spannableStringBuilder.append((CharSequence) ("  +" + str));
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorDialogDelegate j0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new ErrorDialogDelegate(requireActivity);
    }

    private final GoogleServicesUpdateDelegate k0() {
        return (GoogleServicesUpdateDelegate) this.f30693q.getValue();
    }

    private final SharedLoginV3ViewModel l0() {
        return (SharedLoginV3ViewModel) this.f30694r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(LoginV3Fragment this$0) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.getView() == null) {
            return;
        }
        if (((SegmentControlItemView) this$0.d0(R.id.loginTypeEmailItem)).isActivated()) {
            KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
            TextInputView inputEmailOrUsername = (TextInputView) this$0.d0(R.id.inputEmailOrUsername);
            Intrinsics.e(inputEmailOrUsername, "inputEmailOrUsername");
            keyboardUtils.b(inputEmailOrUsername, true);
        } else if (((SegmentControlItemView) this$0.d0(R.id.loginTypePhoneItem)).isActivated()) {
            KeyboardUtils keyboardUtils2 = KeyboardUtils.f34304a;
            TextInputView inputPhone = (TextInputView) this$0.d0(R.id.inputPhone);
            Intrinsics.e(inputPhone, "inputPhone");
            keyboardUtils2.b(inputPhone, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(LoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.l0().D();
        this$0.M().Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(LoginV3Fragment this$0, Text text) {
        Intrinsics.f(this$0, "this$0");
        this$0.B0(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(LoginV3Fragment this$0, Country country) {
        Object F;
        Intrinsics.f(this$0, "this$0");
        if (country != null) {
            int f8 = country.f();
            F = ArraysKt___ArraysKt.F(country.h());
            ((AppCompatTextView) this$0.d0(R.id.inputPhoneCode)).setText(this$0.i0(f8, (String) F));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LoginV3Fragment this$0, SharedLoginV3ViewModel.LoginEvent loginEvent) {
        int i8;
        Intrinsics.f(this$0, "this$0");
        if (loginEvent == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30697b[loginEvent.ordinal()];
        }
        if (i8 == 1) {
            SegmentControlItemView loginTypePhoneItem = (SegmentControlItemView) this$0.d0(R.id.loginTypePhoneItem);
            Intrinsics.e(loginTypePhoneItem, "loginTypePhoneItem");
            ((SegmentControlView) this$0.d0(R.id.loginTypeSegmentControll)).E(loginTypePhoneItem);
            KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
            TextInputView inputPhone = (TextInputView) this$0.d0(R.id.inputPhone);
            Intrinsics.e(inputPhone, "inputPhone");
            keyboardUtils.b(inputPhone, true);
            this$0.l0().D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        AnonymousSimpleActivity.Companion companion = AnonymousSimpleActivity.f26995k;
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        this$0.startActivityForResult(AnonymousSimpleActivity.Companion.c(companion, requireContext, CountryPickerFragment.class, null, true, 4, null), 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        KeyboardUtils.f34304a.a((TextInputView) this$0.d0(R.id.inputEmailOrUsername));
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LoginV3Fragment this$0, View view) {
        boolean z7;
        String str;
        Intrinsics.f(this$0, "this$0");
        this$0.M().Y();
        int i8 = R.id.inputEmailOrUsername;
        String text = ((TextInputView) this$0.d0(i8)).getText();
        TextInputView inputEmailOrUsername = (TextInputView) this$0.d0(i8);
        Intrinsics.e(inputEmailOrUsername, "inputEmailOrUsername");
        if (inputEmailOrUsername.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        String str2 = null;
        if (!z7) {
            text = null;
        }
        Pattern pattern = f30690u;
        if (text == null) {
            str = "";
        } else {
            str = text;
        }
        if (pattern.matcher(str).matches()) {
            str2 = text;
        }
        Router.DefaultImpls.a(FragmentExtKt.a(this$0), EmailLoginFragment.class, EmailLoginFragment.f30461p.a(str2), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(LoginV3Fragment this$0, LoginV3ViewModel.LoginOption loginOption) {
        SegmentControlItemView selectedView;
        Intrinsics.f(this$0, "this$0");
        if (loginOption == null) {
            return;
        }
        int i8 = WhenMappings.f30696a[loginOption.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                selectedView = (SegmentControlItemView) this$0.d0(R.id.loginTypeEmailItem);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            selectedView = (SegmentControlItemView) this$0.d0(R.id.loginTypePhoneItem);
        }
        if (!selectedView.isActivated()) {
            Intrinsics.e(selectedView, "selectedView");
            ((SegmentControlView) this$0.d0(R.id.loginTypeSegmentControll)).E(selectedView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(LoginV3Fragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((RoundButton) this$0.d0(R.id.btnLogin)).setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(LoginV3Fragment this$0, String it) {
        Intrinsics.f(this$0, "this$0");
        int i8 = R.id.inputEmailOrUsername;
        if (!Intrinsics.a(((TextInputView) this$0.d0(i8)).getText(), it)) {
            Intrinsics.e(it, "it");
            ((TextInputView) this$0.d0(i8)).setText(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(LoginV3Fragment this$0, String it) {
        Intrinsics.f(this$0, "this$0");
        int i8 = R.id.inputPhone;
        if (!Intrinsics.a(((TextInputView) this$0.d0(i8)).getText(), it)) {
            Intrinsics.e(it, "it");
            ((TextInputView) this$0.d0(i8)).setText(it);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30695s.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((RoundButton) d0(R.id.btnLogin)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        ApiException apiException;
        Intrinsics.f(error, "error");
        super.H(error);
        if (error instanceof StoreIntegrityVerificationResult.Error) {
            k0().a(error);
            return;
        }
        String str = null;
        if (error instanceof ApiException) {
            apiException = (ApiException) error;
        } else {
            apiException = null;
        }
        if (apiException != null) {
            str = apiException.e();
        }
        if (str != null) {
            B0(new Text.Value(str));
        } else {
            j0().a(error);
        }
        ((TextInputView) d0(R.id.inputPhone)).setError(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((RoundButton) d0(R.id.btnLogin)).k();
        KeyboardUtils.f34304a.a(getView());
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30695s;
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        Serializable serializable;
        if (i8 == 101 && i9 == -1) {
            if (intent != null) {
                serializable = intent.getSerializableExtra("RESULT_EXTRA_COUNTRY");
            } else {
                serializable = null;
            }
            Country country = (Country) serializable;
            if (country != null) {
                M().G(country);
                KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
                TextInputView inputPhone = (TextInputView) d0(R.id.inputPhone);
                Intrinsics.e(inputPhone, "inputPhone");
                keyboardUtils.b(inputPhone, true);
            }
        }
        super.onActivityResult(i8, i9, intent);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f30692p = new WarningLabelDelegate(activity);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f30692p = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((SegmentControlView) d0(R.id.loginTypeSegmentControll)).post(new Runnable() { // from class: k4.a
            @Override // java.lang.Runnable
            public final void run() {
                LoginV3Fragment.m0(LoginV3Fragment.this);
            }
        });
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.inputPhone;
        ((TextInputView) d0(i8)).setTransformationMethod(null);
        ((TextInputView) d0(R.id.inputEmailOrUsername)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                LoginV3ViewModel M;
                Intrinsics.f(it, "it");
                AppCompatTextView errorLabel = (AppCompatTextView) LoginV3Fragment.this.d0(R.id.errorLabel);
                Intrinsics.e(errorLabel, "errorLabel");
                ViewExtKt.e(errorLabel, false, 0, 2, null);
                M = LoginV3Fragment.this.M();
                M.M(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((TextInputView) d0(i8)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                LoginV3ViewModel M;
                Intrinsics.f(it, "it");
                AppCompatTextView errorLabel = (AppCompatTextView) LoginV3Fragment.this.d0(R.id.errorLabel);
                Intrinsics.e(errorLabel, "errorLabel");
                ViewExtKt.e(errorLabel, false, 0, 2, null);
                ((TextInputView) LoginV3Fragment.this.d0(R.id.inputPhone)).setError(false);
                M = LoginV3Fragment.this.M();
                M.V(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((RoundButton) d0(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() { // from class: k4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginV3Fragment.n0(LoginV3Fragment.this, view2);
            }
        });
        ((ImageView) d0(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: k4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginV3Fragment.s0(LoginV3Fragment.this, view2);
            }
        });
        int i9 = R.id.btnMagicLink;
        ((AppCompatTextView) d0(i9)).setOnClickListener(new View.OnClickListener() { // from class: k4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginV3Fragment.t0(LoginV3Fragment.this, view2);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        AppCompatTextView btnMagicLink = (AppCompatTextView) d0(i9);
        Intrinsics.e(btnMagicLink, "btnMagicLink");
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        RippleProvider.b(rippleProvider, btnMagicLink, ContextUtilsKt.b(requireContext, R.attr.backPrimary), 0, 2, null);
        z0();
        M().R().i(getViewLifecycleOwner(), new Observer() { // from class: k4.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.u0(LoginV3Fragment.this, (LoginV3ViewModel.LoginOption) obj);
            }
        });
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: k4.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.v0(LoginV3Fragment.this, (Boolean) obj);
            }
        });
        M().I().i(getViewLifecycleOwner(), new Observer() { // from class: k4.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.w0(LoginV3Fragment.this, (String) obj);
            }
        });
        M().J().i(getViewLifecycleOwner(), new Observer() { // from class: k4.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.x0(LoginV3Fragment.this, (String) obj);
            }
        });
        LiveEvent<Text> P = M().P();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        P.i(viewLifecycleOwner, new Observer() { // from class: k4.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.o0(LoginV3Fragment.this, (Text) obj);
            }
        });
        M().H().i(getViewLifecycleOwner(), new Observer() { // from class: k4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.p0(LoginV3Fragment.this, (Country) obj);
            }
        });
        l0().E().i(getViewLifecycleOwner(), new Observer() { // from class: k4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginV3Fragment.q0(LoginV3Fragment.this, (SharedLoginV3ViewModel.LoginEvent) obj);
            }
        });
        int i10 = R.id.inputPhoneCode;
        AppCompatTextView inputPhoneCode = (AppCompatTextView) d0(i10);
        Intrinsics.e(inputPhoneCode, "inputPhoneCode");
        Color.Attr attr = new Color.Attr(R.attr.dynamicNeutral01);
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        int a8 = ColorKt.a(attr, requireContext2);
        int color = ContextCompat.getColor(requireContext(), R.color.neutral400);
        float c8 = Dimens.c(8.0f);
        Paint.Style style = Paint.Style.FILL;
        inputPhoneCode.setBackground(rippleProvider.d(a8, color, new RippleProvider.CornerRadiuses(c8, c8, c8, c8), Dimens.c(2.0f), Paint.Style.FILL));
        AppCompatTextView inputPhoneCode2 = (AppCompatTextView) d0(i10);
        Intrinsics.e(inputPhoneCode2, "inputPhoneCode");
        TextViewExtKt.a(inputPhoneCode2, new Color.Attr(R.attr.contentSecondary));
        ((AppCompatTextView) d0(i10)).setOnClickListener(new View.OnClickListener() { // from class: k4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginV3Fragment.r0(LoginV3Fragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: y0 */
    public LoginV3ViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (LoginV3ViewModel) new ViewModelProvider(this, E.d()).a(LoginV3ViewModel.class);
    }

    public final void z0() {
        ((SegmentControlView) d0(R.id.loginTypeSegmentControll)).setOnSelectedListener(new Function2<View, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment$setupSegmentView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(View view, boolean z7) {
                LoginV3ViewModel M;
                LoginV3ViewModel M2;
                Intrinsics.f(view, "view");
                if (z7) {
                    AppCompatTextView errorLabel = (AppCompatTextView) LoginV3Fragment.this.d0(R.id.errorLabel);
                    Intrinsics.e(errorLabel, "errorLabel");
                    ViewExtKt.e(errorLabel, false, 0, 2, null);
                    ((TextInputView) LoginV3Fragment.this.d0(R.id.inputPhone)).setError(false);
                }
                boolean a8 = Intrinsics.a(view, (SegmentControlItemView) LoginV3Fragment.this.d0(R.id.loginTypeEmailItem));
                LoginV3Fragment.this.A0(a8);
                if (a8) {
                    M2 = LoginV3Fragment.this.M();
                    M2.W();
                    KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
                    TextInputView inputEmailOrUsername = (TextInputView) LoginV3Fragment.this.d0(R.id.inputEmailOrUsername);
                    Intrinsics.e(inputEmailOrUsername, "inputEmailOrUsername");
                    keyboardUtils.b(inputEmailOrUsername, true);
                    return;
                }
                M = LoginV3Fragment.this.M();
                M.X();
                KeyboardUtils keyboardUtils2 = KeyboardUtils.f34304a;
                TextInputView inputPhone = (TextInputView) LoginV3Fragment.this.d0(R.id.inputPhone);
                Intrinsics.e(inputPhone, "inputPhone");
                keyboardUtils2.b(inputPhone, true);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(View view, Boolean bool) {
                b(view, bool.booleanValue());
                return Unit.f50853a;
            }
        });
    }
}
