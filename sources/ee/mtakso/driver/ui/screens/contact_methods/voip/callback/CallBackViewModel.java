package ee.mtakso.driver.ui.screens.contact_methods.voip.callback;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.OutgoingCallInfo;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate;
import ee.mtakso.driver.utils.DisposableExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallBackViewModel.kt */
/* loaded from: classes3.dex */
public final class CallBackViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final VoipCallDelegate f27836f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<OutgoingCallInfo> f27837g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f27838h;

    @Inject
    public CallBackViewModel(VoipCallDelegate callDelegate) {
        Intrinsics.f(callDelegate, "callDelegate");
        this.f27836f = callDelegate;
        this.f27837g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void G(NoAnswerIncomingCall call) {
        Intrinsics.f(call, "call");
        Single<OutgoingCallInfo> h8 = this.f27836f.h(call);
        final Function1<OutgoingCallInfo, Unit> function1 = new Function1<OutgoingCallInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackViewModel$callBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OutgoingCallInfo outgoingCallInfo) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CallBackViewModel.this.f27837g;
                mutableLiveData.m(outgoingCallInfo);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OutgoingCallInfo outgoingCallInfo) {
                b(outgoingCallInfo);
                return Unit.f50853a;
            }
        };
        Consumer<? super OutgoingCallInfo> consumer = new Consumer() { // from class: c3.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CallBackViewModel.H(Function1.this, obj);
            }
        };
        final CallBackViewModel$callBack$2 callBackViewModel$callBack$2 = new CallBackViewModel$callBack$2(this);
        this.f27838h = h8.I(consumer, new Consumer() { // from class: c3.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CallBackViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<OutgoingCallInfo> J() {
        return this.f27837g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f27838h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        super.onCleared();
    }
}
