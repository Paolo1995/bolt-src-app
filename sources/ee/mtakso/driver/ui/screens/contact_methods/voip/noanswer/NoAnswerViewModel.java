package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerViewModel.kt */
/* loaded from: classes3.dex */
public final class NoAnswerViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final NoAnswerInteractor f28063f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<NoAnswerCallDetails> f28064g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f28065h;

    @Inject
    public NoAnswerViewModel(NoAnswerInteractor noAnswerInteractor) {
        Intrinsics.f(noAnswerInteractor, "noAnswerInteractor");
        this.f28063f = noAnswerInteractor;
        this.f28064g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable f8 = ObservableExtKt.f(this.f28063f.c());
        final Function1<NoAnswerCallDetails, Unit> function1 = new Function1<NoAnswerCallDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NoAnswerCallDetails noAnswerCallDetails) {
                MutableLiveData mutableLiveData;
                mutableLiveData = NoAnswerViewModel.this.f28064g;
                mutableLiveData.o(noAnswerCallDetails);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoAnswerCallDetails noAnswerCallDetails) {
                b(noAnswerCallDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoAnswerViewModel.I(Function1.this, obj);
            }
        };
        final NoAnswerViewModel$onStart$2 noAnswerViewModel$onStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerViewModel$onStart$2
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
        this.f28065h = f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NoAnswerViewModel.J(Function1.this, obj);
            }
        });
    }

    public final LiveData<NoAnswerCallDetails> G() {
        return this.f28064g;
    }

    public final void H() {
        this.f28063f.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f28065h;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }
}
