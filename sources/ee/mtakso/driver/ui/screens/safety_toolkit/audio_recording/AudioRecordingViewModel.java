package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.android.audio_recording_engine.exception.NotEnoughStorageException;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioRecordingViewModel.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingViewModel extends BaseViewModel {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f32554k = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final AudioRecordingManager f32555f;

    /* renamed from: g  reason: collision with root package name */
    private final StartRecordingInteractor f32556g;

    /* renamed from: h  reason: collision with root package name */
    private final AudioRecordingAnalytics f32557h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<RecorderState> f32558i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveEvent<Unit> f32559j;

    /* compiled from: AudioRecordingViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AudioRecordingViewModel(AudioRecordingManager audioRecordingManager, StartRecordingInteractor startRecordingInteractor, AudioRecordingAnalytics audioRecordingAnalytics) {
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        Intrinsics.f(startRecordingInteractor, "startRecordingInteractor");
        Intrinsics.f(audioRecordingAnalytics, "audioRecordingAnalytics");
        this.f32555f = audioRecordingManager;
        this.f32556g = startRecordingInteractor;
        this.f32557h = audioRecordingAnalytics;
        this.f32558i = new MutableLiveData<>();
        this.f32559j = new LiveEvent<>();
    }

    private final void L() {
        Observable g8 = ObservableExtKt.g(this.f32555f.f());
        final Function1<RecorderState, Unit> function1 = new Function1<RecorderState, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel$observeRecorderStateInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RecorderState recorderState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AudioRecordingViewModel.this.f32558i;
                mutableLiveData.o(recorderState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecorderState recorderState) {
                b(recorderState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AudioRecordingViewModel.M(Function1.this, obj);
            }
        };
        final AudioRecordingViewModel$observeRecorderStateInternal$2 audioRecordingViewModel$observeRecorderStateInternal$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel$observeRecorderStateInternal$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Kalev.d("Unable to fetch Audio Recording State");
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AudioRecordingViewModel.N(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeRecor…  }).autoDispose()\n\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P() {
        Kalev.b("Recording started with successful crypto key");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        L();
    }

    public final LiveEvent<Unit> J() {
        return this.f32559j;
    }

    public final LiveData<RecorderState> K() {
        MutableLiveData<RecorderState> mutableLiveData = this.f32558i;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<eu.bolt.android.audio_recording_engine.engine.RecorderState>");
        return mutableLiveData;
    }

    public final void O() {
        this.f32557h.Y();
        Completable a8 = CompletableExtKt.a(this.f32556g.g());
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                AudioRecordingViewModel.P();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel$startRecording$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                LiveEvent liveEvent;
                if (it instanceof NotEnoughStorageException) {
                    liveEvent = AudioRecordingViewModel.this.f32559j;
                    liveEvent.o(Unit.f50853a);
                }
                Intrinsics.e(it, "it");
                Kalev.e(it, "Error starting recording");
            }
        };
        Disposable G = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AudioRecordingViewModel.Q(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "fun startRecording() {\n …     .autoDispose()\n    }");
        v(G);
    }

    public final void R(RecorderState recorderState) {
        Intrinsics.f(recorderState, "recorderState");
        if (Intrinsics.a(recorderState, RecorderState.Initial.f36679a)) {
            this.f32557h.f3("Start Recording");
        } else if (recorderState instanceof RecorderState.InProgress) {
            this.f32557h.f3("In Progress");
        } else if (recorderState instanceof RecorderState.Paused) {
            this.f32557h.f3("Paused");
        }
    }
}
