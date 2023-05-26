package ee.mtakso.driver.ui.screens.login.v3.emailverification;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentRoutingCommand;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailVerificationFragment.kt */
/* loaded from: classes3.dex */
public final class EmailVerificationFragment extends BazeFragment implements GoBackDelegate {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f30661o = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f30662m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f30663n;

    /* compiled from: EmailVerificationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouterFragmentRoutingCommand a(EmailVerificationConfig config) {
            Intrinsics.f(config, "config");
            return new RouterFragmentRoutingCommand(new RoutingCommand.FragmentClass(new RoutingState(SimpleActivity.class, null, 2, null), EmailVerificationFragment.class, BundleKt.a(TuplesKt.a("CONFIG", config))), false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EmailVerificationFragment(BaseUiDependencies baseUiDependencies) {
        super(baseUiDependencies, R.layout.fragment_email_verification, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        this.f30663n = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Router>() { // from class: ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment$router$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Router invoke() {
                FragmentActivity activity = EmailVerificationFragment.this.getActivity();
                if (activity instanceof Router) {
                    return (Router) activity;
                }
                return null;
            }
        });
        this.f30662m = b8;
    }

    private final Router L() {
        return (Router) this.f30662m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(EmailVerificationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Router L = this$0.L();
        if (L != null) {
            L.c();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30663n.clear();
    }

    public View K(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30663n;
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
        return false;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentExtKt.a(this).l(this);
        EmailVerificationConfig emailVerificationConfig = (EmailVerificationConfig) requireArguments().getParcelable("CONFIG");
        if (emailVerificationConfig != null) {
            ((AppCompatTextView) K(R.id.verificationTitle)).setText(emailVerificationConfig.c());
            String a8 = emailVerificationConfig.a();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a8 + "\n");
            SpannableStringBuilderUtils.a(spannableStringBuilder, emailVerificationConfig.b(), new StyleSpan(1));
            ((AppCompatTextView) K(R.id.verificationDescription)).setText(spannableStringBuilder);
            ((ImageView) K(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: i4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EmailVerificationFragment.M(EmailVerificationFragment.this, view2);
                }
            });
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
