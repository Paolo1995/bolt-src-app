package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.engine.html.view.DesignHtmlTextView;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: AudioRecordingBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingBottomSheetFragment extends BaseMvvmBottomSheetDialogFragment<AudioRecordingViewModel> {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f32540w = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final HtmlEngine f32541r;

    /* renamed from: s  reason: collision with root package name */
    private final int f32542s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f32543t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f32544u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f32545v;

    /* compiled from: AudioRecordingBottomSheetFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AudioRecordingBottomSheetFragment(HtmlEngine htmlEngine) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f32545v = new LinkedHashMap();
        this.f32541r = htmlEngine;
        this.f32542s = R.layout.fragment_audio_recording_bottom_sheet;
        b8 = LazyKt__LazyJVMKt.b(new Function0<AudioRecordingViewModel>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AudioRecordingViewModel invoke() {
                AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment = AudioRecordingBottomSheetFragment.this;
                return (AudioRecordingViewModel) new ViewModelProvider(audioRecordingBottomSheetFragment, audioRecordingBottomSheetFragment.Q()).a(AudioRecordingViewModel.class);
            }
        });
        this.f32543t = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<LowStorageDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment$lowStorageDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LowStorageDialogDelegate invoke() {
                Context requireContext = AudioRecordingBottomSheetFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return new LowStorageDialogDelegate(requireContext);
            }
        });
        this.f32544u = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LowStorageDialogDelegate h0() {
        return (LowStorageDialogDelegate) this.f32544u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(AudioRecordingBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(AudioRecordingBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(long j8) {
        ((TextView) c0(R.id.cc)).setText(R.string.audio_recording_title_in_progress);
        ((TextView) c0(R.id.subTitle)).setText(R.string.audio_recording_subtitle_in_progress);
        RoundButton startRecording = (RoundButton) c0(R.id.startRecording);
        Intrinsics.e(startRecording, "startRecording");
        ViewExtKt.e(startRecording, false, 0, 2, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("<timer timestamp=\"%s\" format=\"mm':'ss\" type=\"count_up\"/>", Arrays.copyOf(new Object[]{String.valueOf(TimeUnit.MILLISECONDS.toSeconds(j8) - 1)}, 1));
        Intrinsics.e(format, "format(format, *args)");
        int i8 = R.id.timerCounter;
        DesignHtmlTextView timerCounter = (DesignHtmlTextView) c0(i8);
        Intrinsics.e(timerCounter, "timerCounter");
        ViewExtKt.e(timerCounter, false, 0, 3, null);
        ((DesignHtmlTextView) c0(i8)).setText(this.f32541r.a(format));
        SafetyUIUtils safetyUIUtils = SafetyUIUtils.f32878a;
        LottieAnimationView audioBarInProgressAnimationView = (LottieAnimationView) c0(R.id.audioBarInProgressAnimationView);
        Intrinsics.e(audioBarInProgressAnimationView, "audioBarInProgressAnimationView");
        safetyUIUtils.b(audioBarInProgressAnimationView, 0);
        AppCompatImageView pauseIcon = (AppCompatImageView) c0(R.id.pauseIcon);
        Intrinsics.e(pauseIcon, "pauseIcon");
        ViewExtKt.e(pauseIcon, false, 0, 2, null);
        AppCompatTextView pausedText = (AppCompatTextView) c0(R.id.pausedText);
        Intrinsics.e(pausedText, "pausedText");
        ViewExtKt.e(pausedText, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        ((TextView) c0(R.id.cc)).setText(R.string.audio_recording_title);
        ((TextView) c0(R.id.subTitle)).setText(R.string.audio_recording_subtitle_initial);
        RoundButton startRecording = (RoundButton) c0(R.id.startRecording);
        Intrinsics.e(startRecording, "startRecording");
        ViewExtKt.e(startRecording, false, 0, 3, null);
        DesignHtmlTextView timerCounter = (DesignHtmlTextView) c0(R.id.timerCounter);
        Intrinsics.e(timerCounter, "timerCounter");
        ViewExtKt.e(timerCounter, false, 0, 2, null);
        AppCompatImageView audioBarInitialStateView = (AppCompatImageView) c0(R.id.audioBarInitialStateView);
        Intrinsics.e(audioBarInitialStateView, "audioBarInitialStateView");
        ViewExtKt.e(audioBarInitialStateView, false, 0, 2, null);
        SafetyUIUtils safetyUIUtils = SafetyUIUtils.f32878a;
        LottieAnimationView audioBarInProgressAnimationView = (LottieAnimationView) c0(R.id.audioBarInProgressAnimationView);
        Intrinsics.e(audioBarInProgressAnimationView, "audioBarInProgressAnimationView");
        safetyUIUtils.b(audioBarInProgressAnimationView, 8);
        AppCompatImageView pauseIcon = (AppCompatImageView) c0(R.id.pauseIcon);
        Intrinsics.e(pauseIcon, "pauseIcon");
        ViewExtKt.e(pauseIcon, false, 0, 2, null);
        AppCompatTextView pausedText = (AppCompatTextView) c0(R.id.pausedText);
        Intrinsics.e(pausedText, "pausedText");
        ViewExtKt.e(pausedText, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        ((TextView) c0(R.id.cc)).setText(R.string.audio_recording_title_paused);
        ((TextView) c0(R.id.subTitle)).setText(R.string.audio_recording_subtitle_paused);
        RoundButton startRecording = (RoundButton) c0(R.id.startRecording);
        Intrinsics.e(startRecording, "startRecording");
        ViewExtKt.e(startRecording, false, 0, 2, null);
        DesignHtmlTextView timerCounter = (DesignHtmlTextView) c0(R.id.timerCounter);
        Intrinsics.e(timerCounter, "timerCounter");
        ViewExtKt.e(timerCounter, false, 0, 2, null);
        AppCompatImageView audioBarInitialStateView = (AppCompatImageView) c0(R.id.audioBarInitialStateView);
        Intrinsics.e(audioBarInitialStateView, "audioBarInitialStateView");
        ViewExtKt.e(audioBarInitialStateView, false, 0, 2, null);
        SafetyUIUtils safetyUIUtils = SafetyUIUtils.f32878a;
        LottieAnimationView audioBarInProgressAnimationView = (LottieAnimationView) c0(R.id.audioBarInProgressAnimationView);
        Intrinsics.e(audioBarInProgressAnimationView, "audioBarInProgressAnimationView");
        safetyUIUtils.b(audioBarInProgressAnimationView, 8);
        AppCompatImageView pauseIcon = (AppCompatImageView) c0(R.id.pauseIcon);
        Intrinsics.e(pauseIcon, "pauseIcon");
        ViewExtKt.e(pauseIcon, false, 0, 3, null);
        AppCompatTextView pausedText = (AppCompatTextView) c0(R.id.pausedText);
        Intrinsics.e(pausedText, "pausedText");
        ViewExtKt.e(pausedText, false, 0, 3, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f32545v.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f32542s;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().r(this);
    }

    public View c0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32545v;
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
    /* renamed from: i0 */
    public AudioRecordingViewModel P() {
        return (AudioRecordingViewModel) this.f32543t.getValue();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        bottomSheetDialog.n().Q0(3);
        return bottomSheetDialog;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LowStorageDialogDelegate h02 = h0();
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "requireActivity().supportFragmentManager");
        h02.d(supportFragmentManager);
        LiveData<RecorderState> K = P().K();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<RecorderState, Unit> function1 = new Function1<RecorderState, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RecorderState it) {
                AudioRecordingViewModel P = AudioRecordingBottomSheetFragment.this.P();
                Intrinsics.e(it, "it");
                P.R(it);
                if (Intrinsics.a(it, RecorderState.Complete.f36677a)) {
                    AudioRecordingBottomSheetFragment.this.o0();
                } else if (it instanceof RecorderState.InProgress) {
                    AudioRecordingBottomSheetFragment.this.n0(((RecorderState.InProgress) it).a());
                } else if (Intrinsics.a(it, RecorderState.Initial.f36679a)) {
                    AudioRecordingBottomSheetFragment.this.o0();
                } else if (it instanceof RecorderState.Paused) {
                    AudioRecordingBottomSheetFragment.this.p0();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecorderState recorderState) {
                b(recorderState);
                return Unit.f50853a;
            }
        };
        K.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudioRecordingBottomSheetFragment.j0(Function1.this, obj);
            }
        });
        LiveEvent<Unit> J = P().J();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                LowStorageDialogDelegate h03;
                h03 = AudioRecordingBottomSheetFragment.this.h0();
                FragmentActivity requireActivity = AudioRecordingBottomSheetFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                h03.b(requireActivity);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        J.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudioRecordingBottomSheetFragment.k0(Function1.this, obj);
            }
        });
        ((RoundButton) c0(R.id.startRecording)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AudioRecordingBottomSheetFragment.l0(AudioRecordingBottomSheetFragment.this, view2);
            }
        });
        ((ImageView) c0(R.id.closeAudioRecording)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AudioRecordingBottomSheetFragment.m0(AudioRecordingBottomSheetFragment.this, view2);
            }
        });
    }
}
