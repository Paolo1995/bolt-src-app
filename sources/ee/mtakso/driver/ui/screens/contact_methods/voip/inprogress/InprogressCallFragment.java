package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.VoipAddressLineDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallDetails;
import ee.mtakso.driver.uicore.components.spannable.TypewriterSpannable;
import ee.mtakso.driver.uicore.components.views.CircularWavingButton;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.voip_client.VoipCall;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InprogressCallFragment.kt */
/* loaded from: classes3.dex */
public final class InprogressCallFragment extends ContactMethodsBaseBottomSheetDialog<InprogressCallViewModel> {

    /* renamed from: v  reason: collision with root package name */
    private Animator f28015v;

    /* renamed from: w  reason: collision with root package name */
    private VoipAddressLineDelegate f28016w;

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f28017x;

    /* renamed from: y  reason: collision with root package name */
    private final int f28018y;

    /* renamed from: z  reason: collision with root package name */
    public Map<Integer, View> f28019z = new LinkedHashMap();

    /* compiled from: InprogressCallFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28020a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f28021b;

        static {
            int[] iArr = new int[InprogressCallDetails.ConnectionState.values().length];
            try {
                iArr[InprogressCallDetails.ConnectionState.ESTABLISHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InprogressCallDetails.ConnectionState.ESTABLISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28020a = iArr;
            int[] iArr2 = new int[InprogressCallDetails.ConnectionType.values().length];
            try {
                iArr2[InprogressCallDetails.ConnectionType.INCOMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InprogressCallDetails.ConnectionType.OUTGOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f28021b = iArr2;
        }
    }

    public InprogressCallFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<InprogressCallViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final InprogressCallViewModel invoke() {
                InprogressCallFragment inprogressCallFragment = InprogressCallFragment.this;
                return (InprogressCallViewModel) new ViewModelProvider(inprogressCallFragment, inprogressCallFragment.Q()).a(InprogressCallViewModel.class);
            }
        });
        this.f28017x = b8;
        this.f28018y = R.layout.fragment_inprogress_call;
    }

    private final void h0(CircularWavingButton circularWavingButton, int i8, Color color, Color color2) {
        circularWavingButton.setImageResource(i8);
        ImageViewExtKt.a(circularWavingButton, color2);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        circularWavingButton.setBgColor(ColorKt.a(color, requireContext));
        circularWavingButton.setBgBorderWidth(0.0f);
    }

    private final void i0(CircularWavingButton circularWavingButton, int i8) {
        circularWavingButton.setImageResource(i8);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        circularWavingButton.setBgColor(ContextUtilsKt.b(requireContext, R.attr.colorBgNeutralSecondary));
        ImageViewExtKt.a(circularWavingButton, new Color.Attr(R.attr.colorContentPrimary));
        circularWavingButton.setBgBorderColor(ContextCompat.getColor(requireContext(), R.color.white200));
        circularWavingButton.setBgBorderWidth(Dimens.c(2.0f));
    }

    private final Animator j0(TypewriterSpannable typewriterSpannable, final View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(typewriterSpannable, TypewriterSpannable.f35387g.a(), 0.0f, 1.0f);
        objectAnimator.setDuration(1000L);
        objectAnimator.setRepeatMode(1);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                InprogressCallFragment.k0(view, valueAnimator);
            }
        });
        Intrinsics.e(objectAnimator, "objectAnimator");
        return objectAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(View forView, ValueAnimator it) {
        Intrinsics.f(forView, "$forView");
        Intrinsics.f(it, "it");
        forView.invalidate();
    }

    private final int l0(InprogressCallDetails.ConnectionType connectionType) {
        int i8 = WhenMappings.f28021b[connectionType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.string.voip_inprogress_call_status_calling;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.string.voip_inprogress_call_status_connecting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(InprogressCallFragment this$0, Boolean bool) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(InprogressCallFragment this$0, InprogressCallDetails it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.s0(it);
        this$0.u0(it);
        this$0.t0(it);
        ((TextView) this$0.g0(R.id.passengerName)).setText(it.f());
        VoipAddressLineDelegate voipAddressLineDelegate = this$0.f28016w;
        if (voipAddressLineDelegate == null) {
            Intrinsics.w("voipAddressLineDelegate");
            voipAddressLineDelegate = null;
        }
        voipAddressLineDelegate.c(it.e(), it.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(InprogressCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(InprogressCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(InprogressCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().M();
    }

    private final void s0(InprogressCallDetails inprogressCallDetails) {
        int i8 = WhenMappings.f28020a[inprogressCallDetails.c().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                v0(inprogressCallDetails.b());
                return;
            }
            return;
        }
        w0(inprogressCallDetails.d());
    }

    private final void t0(InprogressCallDetails inprogressCallDetails) {
        if (VoipCall.f36509a.b(inprogressCallDetails.a(), VoipCall.State.ESTABLISHING)) {
            return;
        }
        boolean h8 = inprogressCallDetails.h();
        if (h8) {
            CircularWavingButton muteButton = (CircularWavingButton) g0(R.id.muteButton);
            Intrinsics.e(muteButton, "muteButton");
            h0(muteButton, R.drawable.ic_mute_on, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.contentPrimary));
        } else if (!h8) {
            CircularWavingButton muteButton2 = (CircularWavingButton) g0(R.id.muteButton);
            Intrinsics.e(muteButton2, "muteButton");
            i0(muteButton2, R.drawable.ic_mute_off);
        }
    }

    private final void u0(InprogressCallDetails inprogressCallDetails) {
        if (VoipCall.f36509a.b(inprogressCallDetails.a(), VoipCall.State.ESTABLISHING)) {
            return;
        }
        boolean i8 = inprogressCallDetails.i();
        if (i8) {
            CircularWavingButton speakerButton = (CircularWavingButton) g0(R.id.speakerButton);
            Intrinsics.e(speakerButton, "speakerButton");
            h0(speakerButton, R.drawable.ic_speaker_on, new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.dynamicNeutral01));
        } else if (!i8) {
            CircularWavingButton speakerButton2 = (CircularWavingButton) g0(R.id.speakerButton);
            Intrinsics.e(speakerButton2, "speakerButton");
            i0(speakerButton2, R.drawable.ic_speaker_off);
        }
        if (inprogressCallDetails.a() == VoipCall.State.ESTABLISHED) {
            int i9 = R.id.speakerButton;
            if (!((CircularWavingButton) g0(i9)).d()) {
                ((CircularWavingButton) g0(i9)).e();
            }
        }
    }

    private final void v0(String str) {
        if (str == null) {
            return;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(getString(R.string.voip_inprogress_call_status_speaking)).append((CharSequence) " ").append((CharSequence) str);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        append.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), ContextUtilsKt.d(requireContext, R.attr.contentPrimary))), append.length() - str.length(), append.length(), 33);
        ((TextView) g0(R.id.inprogressCallStatus)).setText(append, TextView.BufferType.SPANNABLE);
    }

    private final void w0(InprogressCallDetails.ConnectionType connectionType) {
        Animator animator = this.f28015v;
        if (animator != null) {
            animator.cancel();
        }
        SpannableString spannableString = new SpannableString(getString(l0(connectionType)));
        TypewriterSpannable typewriterSpannable = new TypewriterSpannable(0.0f, 1, null);
        int i8 = R.id.inprogressCallStatus;
        TextView inprogressCallStatus = (TextView) g0(i8);
        Intrinsics.e(inprogressCallStatus, "inprogressCallStatus");
        this.f28015v = j0(typewriterSpannable, inprogressCallStatus);
        spannableString.setSpan(typewriterSpannable, spannableString.length() - 3, spannableString.length(), 33);
        ((TextView) g0(i8)).setText(spannableString, TextView.BufferType.SPANNABLE);
        Animator animator2 = this.f28015v;
        if (animator2 != null) {
            animator2.start();
        }
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f28019z.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f28018y;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().s(this);
    }

    public View g0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28019z;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: m0 */
    public InprogressCallViewModel P() {
        return (InprogressCallViewModel) this.f28017x.getValue();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        TextView passengerAddress = (TextView) g0(R.id.passengerAddress);
        Intrinsics.e(passengerAddress, "passengerAddress");
        this.f28016w = new VoipAddressLineDelegate(requireContext, passengerAddress);
        P().J().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InprogressCallFragment.n0(InprogressCallFragment.this, (Boolean) obj);
            }
        });
        P().I().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InprogressCallFragment.o0(InprogressCallFragment.this, (InprogressCallDetails) obj);
            }
        });
        ((CircularWavingButton) g0(R.id.declineButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InprogressCallFragment.p0(InprogressCallFragment.this, view2);
            }
        });
        ((CircularWavingButton) g0(R.id.speakerButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InprogressCallFragment.q0(InprogressCallFragment.this, view2);
            }
        });
        ((CircularWavingButton) g0(R.id.muteButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InprogressCallFragment.r0(InprogressCallFragment.this, view2);
            }
        });
    }
}
