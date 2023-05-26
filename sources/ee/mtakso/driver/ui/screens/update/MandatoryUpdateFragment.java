package ee.mtakso.driver.ui.screens.update;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentRoutingCommand;
import ee.mtakso.driver.ui.screens.update.MandatoryUpdateFragment;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.kalev.Kalev;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MandatoryUpdateFragment.kt */
/* loaded from: classes5.dex */
public final class MandatoryUpdateFragment extends BazeFragment {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f33492p = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final SystemUrlLauncher f33493m;

    /* renamed from: n  reason: collision with root package name */
    private final LanguageManager f33494n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f33495o;

    /* compiled from: MandatoryUpdateFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(MandatoryUpdateFragmentParams mandatoryUpdateFragmentParams) {
            Intrinsics.f(mandatoryUpdateFragmentParams, "mandatoryUpdateFragmentParams");
            Bundle bundle = new Bundle();
            bundle.putSerializable("args", mandatoryUpdateFragmentParams);
            return bundle;
        }

        public final RouterFragmentRoutingCommand b(MandatoryUpdateFragmentParams mandatoryUpdateFragmentParams) {
            Intrinsics.f(mandatoryUpdateFragmentParams, "mandatoryUpdateFragmentParams");
            return new RouterFragmentRoutingCommand(new RoutingCommand.FragmentClass(new RoutingState(SimpleActivity.class, null, 2, null), MandatoryUpdateFragment.class, a(mandatoryUpdateFragmentParams)), true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MandatoryUpdateFragment(BaseUiDependencies deps, SystemUrlLauncher urlLauncher, LanguageManager languageManager) {
        super(deps, R.layout.content_disabled_banner, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(languageManager, "languageManager");
        this.f33495o = new LinkedHashMap();
        this.f33493m = urlLauncher;
        this.f33494n = languageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(String str, MandatoryUpdateFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            this$0.startActivity(intent);
        } catch (ActivityNotFoundException e8) {
            Kalev.d("Activity can not be found to execute the given Intent: " + str + " " + e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(String str, MandatoryUpdateFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (str != null) {
            this$0.f33493m.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MandatoryUpdateFragment this$0, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.f();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33495o.clear();
    }

    public View M(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33495o;
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
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Serializable serializable;
        MandatoryUpdateFragmentParams mandatoryUpdateFragmentParams;
        final String str;
        final String str2;
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z7;
        boolean z8;
        Text f8;
        Text h8;
        String c8;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                mandatoryUpdateFragmentParams = (MandatoryUpdateFragmentParams) arguments.getSerializable("args", MandatoryUpdateFragmentParams.class);
            }
            mandatoryUpdateFragmentParams = null;
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                serializable = arguments2.getSerializable("args");
            } else {
                serializable = null;
            }
            if (serializable instanceof MandatoryUpdateFragmentParams) {
                mandatoryUpdateFragmentParams = (MandatoryUpdateFragmentParams) serializable;
            }
            mandatoryUpdateFragmentParams = null;
        }
        if (mandatoryUpdateFragmentParams != null) {
            str = mandatoryUpdateFragmentParams.e();
        } else {
            str = null;
        }
        if (mandatoryUpdateFragmentParams != null && (c8 = mandatoryUpdateFragmentParams.c()) != null) {
            str2 = c8 + this.f33494n.f().b();
        } else {
            str2 = null;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) M(R.id.cc);
        if (mandatoryUpdateFragmentParams != null && (h8 = mandatoryUpdateFragmentParams.h()) != null) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            charSequence = TextKt.a(h8, requireContext);
        } else {
            charSequence = null;
        }
        appCompatTextView.setText(charSequence);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) M(R.id.S2);
        if (mandatoryUpdateFragmentParams != null && (f8 = mandatoryUpdateFragmentParams.f()) != null) {
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            charSequence2 = TextKt.a(f8, requireContext2);
        } else {
            charSequence2 = null;
        }
        appCompatTextView2.setText(charSequence2);
        int i8 = R.id.closeImageButton;
        AppCompatImageButton closeImageButton = (AppCompatImageButton) M(i8);
        Intrinsics.e(closeImageButton, "closeImageButton");
        ViewExtKt.d(closeImageButton, true, 0, 2, null);
        int i9 = R.id.updateButton;
        RoundButton updateButton = (RoundButton) M(i9);
        Intrinsics.e(updateButton, "updateButton");
        if (str != null && str.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.d(updateButton, !z7, 0, 2, null);
        int i10 = R.id.guideButton;
        RoundButton guideButton = (RoundButton) M(i10);
        Intrinsics.e(guideButton, "guideButton");
        if (str2 != null && str2.length() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        ViewExtKt.d(guideButton, true ^ z8, 0, 2, null);
        ((RoundButton) M(i9)).setOnClickListener(new View.OnClickListener() { // from class: h5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MandatoryUpdateFragment.N(str, this, view2);
            }
        });
        ((RoundButton) M(i10)).setOnClickListener(new View.OnClickListener() { // from class: h5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MandatoryUpdateFragment.O(str2, this, view2);
            }
        });
        ((AppCompatImageButton) M(i8)).setOnClickListener(new View.OnClickListener() { // from class: h5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MandatoryUpdateFragment.P(MandatoryUpdateFragment.this, view2);
            }
        });
    }
}
