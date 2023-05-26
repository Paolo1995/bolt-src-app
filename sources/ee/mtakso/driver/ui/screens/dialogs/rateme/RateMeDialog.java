package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ShareUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeDialog.kt */
/* loaded from: classes3.dex */
public final class RateMeDialog extends FullScreenDialogFragment {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f28351u = new Companion(null);
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public RateMePrefsManager f28352l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public DriverProvider f28353m;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public RateMeAnalytics f28354n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public Features f28355o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public PlatformManager f28356p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f28357q;

    /* renamed from: r  reason: collision with root package name */
    private final ActivityResultLauncher<String> f28358r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f28359s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f28360t = new LinkedHashMap();

    /* compiled from: RateMeDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RateMeDialog a(DialogConfig dialogConfig) {
            Intrinsics.f(dialogConfig, "dialogConfig");
            RateMeDialog rateMeDialog = new RateMeDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("CONFIG", dialogConfig);
            rateMeDialog.setArguments(bundle);
            return rateMeDialog;
        }
    }

    /* compiled from: RateMeDialog.kt */
    /* loaded from: classes3.dex */
    public static final class DialogConfig implements Parcelable {
        public static final Parcelable.Creator<DialogConfig> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f28361f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28362g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28363h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28364i;

        /* renamed from: j  reason: collision with root package name */
        private final RateAction f28365j;

        /* compiled from: RateMeDialog.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DialogConfig> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DialogConfig createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DialogConfig(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), RateAction.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DialogConfig[] newArray(int i8) {
                return new DialogConfig[i8];
            }
        }

        public DialogConfig(int i8, String title, String subtitle, String message, RateAction selectedAction) {
            Intrinsics.f(title, "title");
            Intrinsics.f(subtitle, "subtitle");
            Intrinsics.f(message, "message");
            Intrinsics.f(selectedAction, "selectedAction");
            this.f28361f = i8;
            this.f28362g = title;
            this.f28363h = subtitle;
            this.f28364i = message;
            this.f28365j = selectedAction;
        }

        public final int a() {
            return this.f28361f;
        }

        public final String b() {
            return this.f28364i;
        }

        public final RateAction c() {
            return this.f28365j;
        }

        public final String d() {
            return this.f28363h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f28362g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DialogConfig) {
                DialogConfig dialogConfig = (DialogConfig) obj;
                return this.f28361f == dialogConfig.f28361f && Intrinsics.a(this.f28362g, dialogConfig.f28362g) && Intrinsics.a(this.f28363h, dialogConfig.f28363h) && Intrinsics.a(this.f28364i, dialogConfig.f28364i) && this.f28365j == dialogConfig.f28365j;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f28361f * 31) + this.f28362g.hashCode()) * 31) + this.f28363h.hashCode()) * 31) + this.f28364i.hashCode()) * 31) + this.f28365j.hashCode();
        }

        public String toString() {
            int i8 = this.f28361f;
            String str = this.f28362g;
            String str2 = this.f28363h;
            String str3 = this.f28364i;
            RateAction rateAction = this.f28365j;
            return "DialogConfig(iconResource=" + i8 + ", title=" + str + ", subtitle=" + str2 + ", message=" + str3 + ", selectedAction=" + rateAction + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f28361f);
            out.writeString(this.f28362g);
            out.writeString(this.f28363h);
            out.writeString(this.f28364i);
            out.writeString(this.f28365j.name());
        }
    }

    /* compiled from: RateMeDialog.kt */
    /* loaded from: classes3.dex */
    public static final class PickCategoryContract extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* renamed from: a */
        public Intent createIntent(Context context, String input) {
            Intrinsics.f(context, "context");
            Intrinsics.f(input, "input");
            return SimpleActivity.Companion.h(SimpleActivity.f27004l, context, RateMeCategoriesFragment.class, null, false, 4, null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* renamed from: b */
        public Boolean parseResult(int i8, Intent intent) {
            boolean z7;
            if (i8 == -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    /* compiled from: RateMeDialog.kt */
    /* loaded from: classes3.dex */
    public enum RateAction {
        NONE,
        LIKE,
        DISLIKE
    }

    /* compiled from: RateMeDialog.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28370a;

        static {
            int[] iArr = new int[RateAction.values().length];
            try {
                iArr[RateAction.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RateAction.LIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RateAction.DISLIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28370a = iArr;
        }
    }

    public RateMeDialog() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DialogConfig>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RateMeDialog.DialogConfig invoke() {
                Parcelable parcelable = RateMeDialog.this.requireArguments().getParcelable("CONFIG");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog.DialogConfig");
                return (RateMeDialog.DialogConfig) parcelable;
            }
        });
        this.f28357q = b8;
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new PickCategoryContract(), new ActivityResultCallback() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                RateMeDialog.g0(RateMeDialog.this, (Boolean) obj);
            }
        });
        Intrinsics.e(registerForActivityResult, "registerForActivityResul…AllowingStateLoss()\n    }");
        this.f28358r = registerForActivityResult;
        this.f28359s = true;
    }

    private final void R() {
        if (getChildFragmentManager().getBackStackEntryCount() == 1) {
            dismissAllowingStateLoss();
        } else {
            getChildFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a0(RateMeDialog this$0, DialogInterface dialogInterface, int i8, KeyEvent keyEvent) {
        Intrinsics.f(this$0, "this$0");
        if (i8 == 4) {
            this$0.R();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(RateMeDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(RateMeDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RateMeDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.R();
    }

    private final void e0() {
        Y().c();
        X().c4();
        h0();
    }

    private final void f0() {
        Y().c();
        X().P3();
        PlatformManager.DefaultImpls.a(W(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RateMeDialog this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.dismissAllowingStateLoss();
        }
    }

    private final void h0() {
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FeedbackMessageBuilder feedbackMessageBuilder = new FeedbackMessageBuilder(requireContext, U());
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        new ShareUtils(requireContext2).a("driver-app-feedback@bolt.eu", feedbackMessageBuilder.b(), feedbackMessageBuilder.a());
    }

    private final void i0(int i8, String str, String str2, String str3, String str4) {
        RateMeActionContentFragment a8 = RateMeActionContentFragment.f28319h.a(i8, str, str2, str3, str4);
        AppCompatImageView back_button = (AppCompatImageView) Q(R.id.back_button);
        Intrinsics.e(back_button, "back_button");
        ViewExtKt.e(back_button, false, 0, 3, null);
        k0(a8);
    }

    private final void j0() {
        this.f28358r.launch("");
    }

    private final void k0(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.innerContainer, fragment).addToBackStack(null).commit();
    }

    private final void m0() {
        RateMeInitialContentFragment a8 = RateMeInitialContentFragment.f28376h.a(T().a(), T().e(), T().d(), T().b());
        AppCompatImageView back_button = (AppCompatImageView) Q(R.id.back_button);
        Intrinsics.e(back_button, "back_button");
        ViewExtKt.e(back_button, false, 0, 2, null);
        k0(a8);
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28360t.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    protected boolean I() {
        return this.f28359s;
    }

    public View Q(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28360t;
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

    public final void S() {
        if (V().b(Feature.Type.RATE_APP_V2)) {
            j0();
        } else {
            l0();
        }
    }

    public final DialogConfig T() {
        return (DialogConfig) this.f28357q.getValue();
    }

    public final DriverProvider U() {
        DriverProvider driverProvider = this.f28353m;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final Features V() {
        Features features = this.f28355o;
        if (features != null) {
            return features;
        }
        Intrinsics.w("features");
        return null;
    }

    public final PlatformManager W() {
        PlatformManager platformManager = this.f28356p;
        if (platformManager != null) {
            return platformManager;
        }
        Intrinsics.w("platformManager");
        return null;
    }

    public final RateMeAnalytics X() {
        RateMeAnalytics rateMeAnalytics = this.f28354n;
        if (rateMeAnalytics != null) {
            return rateMeAnalytics;
        }
        Intrinsics.w("rateMeAnalytics");
        return null;
    }

    public final RateMePrefsManager Y() {
        RateMePrefsManager rateMePrefsManager = this.f28352l;
        if (rateMePrefsManager != null) {
            return rateMePrefsManager;
        }
        Intrinsics.w("rateMePrefsManager");
        return null;
    }

    public final void Z(String actionTag) {
        Intrinsics.f(actionTag, "actionTag");
        if (Intrinsics.a(actionTag, "ACTION_LIKE")) {
            f0();
        } else if (Intrinsics.a(actionTag, "ACTION_DISLIKE")) {
            e0();
        }
        dismissAllowingStateLoss();
    }

    public final void l0() {
        String string = getString(R.string.rate_me_dislike_title);
        Intrinsics.e(string, "getString(R.string.rate_me_dislike_title)");
        String string2 = getString(R.string.rate_me_dislike_message);
        Intrinsics.e(string2, "getString(R.string.rate_me_dislike_message)");
        String string3 = getString(R.string.rate_me_dislike_button);
        Intrinsics.e(string3, "getString(R.string.rate_me_dislike_button)");
        i0(R.drawable.ic_message, string, string2, string3, "ACTION_DISLIKE");
    }

    public final void n0() {
        String string = getString(R.string.rate_me_like_title);
        Intrinsics.e(string, "getString(R.string.rate_me_like_title)");
        String string2 = getString(R.string.rate_me_like_message);
        Intrinsics.e(string2, "getString(R.string.rate_me_like_message)");
        String string3 = getString(R.string.rate_me_like_button);
        Intrinsics.e(string3, "getString(R.string.rate_me_like_button)");
        i0(R.drawable.ic_heart, string, string2, string3, "ACTION_LIKE");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Injector.f20166d.b().Y1().q(this);
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCancelable(false);
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.h
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i8, KeyEvent keyEvent) {
                boolean a02;
                a02 = RateMeDialog.a0(RateMeDialog.this, dialogInterface, i8, keyEvent);
                return a02;
            }
        });
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_rate, viewGroup, false);
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            int i8 = WhenMappings.f28370a[T().c().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        S();
                    }
                } else {
                    n0();
                }
            } else {
                m0();
            }
        }
        ((RoundButton) view.findViewById(R.id.footerButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeDialog.b0(RateMeDialog.this, view2);
            }
        });
        ((AppCompatImageView) Q(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeDialog.c0(RateMeDialog.this, view2);
            }
        });
        ((AppCompatImageView) Q(R.id.back_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateMeDialog.d0(RateMeDialog.this, view2);
            }
        });
    }
}
