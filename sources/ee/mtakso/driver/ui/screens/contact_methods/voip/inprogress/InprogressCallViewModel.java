package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InprogressCallViewModel.kt */
/* loaded from: classes3.dex */
public final class InprogressCallViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final InprogressCallInteractor f28032f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<InprogressCallDetails> f28033g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<Boolean> f28034h;

    /* renamed from: i  reason: collision with root package name */
    private CompositeDisposable f28035i;

    @Inject
    public InprogressCallViewModel(InprogressCallInteractor inprogressCallInteractor) {
        Intrinsics.f(inprogressCallInteractor, "inprogressCallInteractor");
        this.f28032f = inprogressCallInteractor;
        this.f28033g = new MutableLiveData<>();
        this.f28034h = new MutableLiveData<>();
        this.f28035i = new CompositeDisposable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f28035i.d();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f28035i = compositeDisposable;
        Observable<InprogressCallDetails> distinctUntilChanged = this.f28032f.i().distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "inprogressCallInteractor…  .distinctUntilChanged()");
        Observable f8 = ObservableExtKt.f(distinctUntilChanged);
        final Function1<InprogressCallDetails, Unit> function1 = new Function1<InprogressCallDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(InprogressCallDetails inprogressCallDetails) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                if (inprogressCallDetails.a() == VoipCall.State.ENDED) {
                    mutableLiveData2 = InprogressCallViewModel.this.f28034h;
                    mutableLiveData2.o(Boolean.TRUE);
                }
                mutableLiveData = InprogressCallViewModel.this.f28033g;
                mutableLiveData.o(inprogressCallDetails);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InprogressCallDetails inprogressCallDetails) {
                b(inprogressCallDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InprogressCallViewModel.K(Function1.this, obj);
            }
        };
        final InprogressCallViewModel$onStart$2 inprogressCallViewModel$onStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallViewModel$onStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.o(it);
            }
        };
        compositeDisposable.b(f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InprogressCallViewModel.L(Function1.this, obj);
            }
        }));
    }

    public final void H() {
        this.f28032f.h();
    }

    public final LiveData<InprogressCallDetails> I() {
        return this.f28033g;
    }

    public final LiveData<Boolean> J() {
        return this.f28034h;
    }

    public final void M() {
        this.f28032f.l();
    }

    public final void N() {
        this.f28032f.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f28035i.d();
    }
}
