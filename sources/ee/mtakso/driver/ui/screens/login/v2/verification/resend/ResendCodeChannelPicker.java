package ee.mtakso.driver.ui.screens.login.v2.verification.resend;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment;
import ee.mtakso.driver.uikit.utils.Dimens;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResendCodeChannelPicker.kt */
/* loaded from: classes3.dex */
public final class ResendCodeChannelPicker extends BaseBottomSheetDialogFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f30628n = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f30629k;

    /* renamed from: l  reason: collision with root package name */
    private Function1<? super VerificationChannel, Unit> f30630l;

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f30631m = new LinkedHashMap();

    /* compiled from: ResendCodeChannelPicker.kt */
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

    /* compiled from: ResendCodeChannelPicker.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30632a;

        static {
            int[] iArr = new int[VerificationChannel.values().length];
            try {
                iArr[VerificationChannel.SMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationChannel.CALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationChannel.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationChannel.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30632a = iArr;
        }
    }

    public ResendCodeChannelPicker() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<VerificationConfig>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.resend.ResendCodeChannelPicker$authData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final VerificationConfig invoke() {
                Parcelable parcelable = ResendCodeChannelPicker.this.requireArguments().getParcelable("auth");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.login.common.VerificationConfig");
                return (VerificationConfig) parcelable;
            }
        });
        this.f30629k = b8;
        this.f30630l = new Function1<VerificationChannel, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.resend.ResendCodeChannelPicker$onChannelSelected$1
            public final void b(VerificationChannel it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerificationChannel verificationChannel) {
                b(verificationChannel);
                return Unit.f50853a;
            }
        };
    }

    private final void L(int i8, int i9, final VerificationChannel verificationChannel, boolean z7) {
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i10 = R.id.channelPickerRoot;
        View inflate = from.inflate(R.layout.item_channel, (ViewGroup) ((LinearLayout) K(i10)), false);
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(i8);
        ((TextView) inflate.findViewById(R.id.title)).setText(i9);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.resend.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResendCodeChannelPicker.M(ResendCodeChannelPicker.this, verificationChannel, view);
            }
        });
        ((LinearLayout) K(i10)).addView(inflate);
        if (!z7) {
            View view = new View(getContext());
            view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.neutral200));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Dimens.c(1));
            layoutParams.setMarginStart(Dimens.c(24));
            layoutParams.setMarginEnd(Dimens.c(39));
            ((LinearLayout) K(i10)).addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ResendCodeChannelPicker this$0, VerificationChannel item, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(item, "$item");
        this$0.f30630l.invoke(item);
        this$0.dismissAllowingStateLoss();
    }

    private final VerificationConfig N() {
        return (VerificationConfig) this.f30629k.getValue();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f30631m.clear();
    }

    public View K(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30631m;
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

    public final void O(Function1<? super VerificationChannel, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f30630l = function1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        setStyle(0, 2132017511);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_login_verification_channel_picker, viewGroup, false);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z7;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            VerificationConfig N = N();
            FastLog.DefaultImpls.a(g8, "Drawing channels: " + N, null, 2, null);
        }
        ((TextView) K(R.id.labelCodeTarget)).setText(getString(R.string.verification_code_target, N().g()));
        int i8 = 0;
        for (Object obj : N().c()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            VerificationChannel verificationChannel = (VerificationChannel) obj;
            if (i8 == N().c().size() - 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            int i10 = WhenMappings.f30632a[verificationChannel.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    L(R.drawable.ic_call_25dp, R.string.verification_code_call, verificationChannel, z7);
                }
            } else {
                L(R.drawable.ic_sms_20dp, R.string.verification_code_sms, verificationChannel, z7);
            }
            i8 = i9;
        }
    }
}
