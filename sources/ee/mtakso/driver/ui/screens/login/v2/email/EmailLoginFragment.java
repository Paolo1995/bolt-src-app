package ee.mtakso.driver.ui.screens.login.v2.email;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailLoginFragment.kt */
/* loaded from: classes3.dex */
public final class EmailLoginFragment extends BazeMvvmFragment<EmailLoginViewModel> {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f30461p = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f30462o;

    /* compiled from: EmailLoginFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String str) {
            return BundleKt.a(TuplesKt.a("PREFILED_EMAIL", str));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EmailLoginFragment(BaseUiDependencies baseUiDependencies) {
        super(baseUiDependencies, R.layout.fragment_login_email, null, 4, null);
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        this.f30462o = new LinkedHashMap();
    }

    private final SpannableStringBuilder X(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.magic_link_link_was_sent_to_email_v2)).append((CharSequence) " ").append((CharSequence) str);
        spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EmailLoginFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(EmailLoginFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        KeyboardUtils.f34304a.a((TextInputView) this$0.V(R.id.inputEmail));
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(EmailLoginFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((RoundButton) this$0.V(R.id.btnRequest)).setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(EmailLoginFragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        ((TextInputView) this$0.V(R.id.inputEmail)).setError(false);
        Group group_input = (Group) this$0.V(R.id.group_input);
        Intrinsics.e(group_input, "group_input");
        ViewExtKt.e(group_input, false, 0, 2, null);
        TextView labelError = (TextView) this$0.V(R.id.labelError);
        Intrinsics.e(labelError, "labelError");
        ViewExtKt.e(labelError, false, 0, 2, null);
        Group group_success = (Group) this$0.V(R.id.group_success);
        Intrinsics.e(group_success, "group_success");
        ViewExtKt.e(group_success, false, 0, 3, null);
        Object b8 = LiveDataExtKt.b(this$0.M().K());
        Intrinsics.e(b8, "viewModel.email.requireValue()");
        ((TextView) this$0.V(R.id.lblMessage)).setText(this$0.X((String) b8));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30462o.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((TextInputView) V(R.id.inputEmail)).setEnabled(true);
        ((RoundButton) V(R.id.btnRequest)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        String k8;
        Intrinsics.f(error, "error");
        super.H(error);
        ((TextInputView) V(R.id.inputEmail)).setError(true);
        int i8 = R.id.labelError;
        TextView labelError = (TextView) V(i8);
        Intrinsics.e(labelError, "labelError");
        ViewExtKt.e(labelError, false, 0, 3, null);
        TextView textView = (TextView) V(i8);
        if (ApiExceptionUtils.m(error, 200)) {
            k8 = getString(R.string.login_email_not_found);
        } else if (ApiExceptionUtils.m(error, 702)) {
            k8 = getString(R.string.login_email_invalid);
        } else {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            k8 = ApiExceptionUtils.k(error, requireContext);
        }
        textView.setText(k8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((TextInputView) V(R.id.inputEmail)).setEnabled(false);
        ((RoundButton) V(R.id.btnRequest)).k();
        KeyboardUtils.f34304a.a(getView());
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30462o;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: c0 */
    public EmailLoginViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (EmailLoginViewModel) new ViewModelProvider(this, E.d()).a(EmailLoginViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.inputEmail;
        ((TextInputView) V(i8)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                EmailLoginViewModel M;
                Intrinsics.f(it, "it");
                M = EmailLoginFragment.this.M();
                M.K().o(it);
                EmailLoginFragment emailLoginFragment = EmailLoginFragment.this;
                int i9 = R.id.labelError;
                ((TextView) emailLoginFragment.V(i9)).setText((CharSequence) null);
                TextView labelError = (TextView) EmailLoginFragment.this.V(i9);
                Intrinsics.e(labelError, "labelError");
                ViewExtKt.e(labelError, false, 0, 2, null);
                ((TextInputView) EmailLoginFragment.this.V(R.id.inputEmail)).setError(false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                b(str2);
                return Unit.f50853a;
            }
        });
        ((RoundButton) V(R.id.btnRequest)).setOnClickListener(new View.OnClickListener() { // from class: f4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EmailLoginFragment.Y(EmailLoginFragment.this, view2);
            }
        });
        ((ImageView) V(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: f4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EmailLoginFragment.Z(EmailLoginFragment.this, view2);
            }
        });
        M().M().i(getViewLifecycleOwner(), new Observer() { // from class: f4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmailLoginFragment.a0(EmailLoginFragment.this, (Boolean) obj);
            }
        });
        M().L().i(getViewLifecycleOwner(), new Observer() { // from class: f4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmailLoginFragment.b0(EmailLoginFragment.this, obj);
            }
        });
        TextInputView textInputView = (TextInputView) V(i8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("PREFILED_EMAIL");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        textInputView.setText(str);
    }
}
