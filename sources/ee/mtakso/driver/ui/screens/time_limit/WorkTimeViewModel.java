package ee.mtakso.driver.ui.screens.time_limit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.interactor.WorkTimeInteractor;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkTimeViewModel.kt */
/* loaded from: classes5.dex */
public final class WorkTimeViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final WorkTimeInteractor f33480f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f33481g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<WorkingTimeInfo> f33482h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<WorkingTimeInfo> f33483i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f33484j;

    @Inject
    public WorkTimeViewModel(WorkTimeInteractor workingTimeInteractor, DriverProvider driverProvider) {
        Intrinsics.f(workingTimeInteractor, "workingTimeInteractor");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f33480f = workingTimeInteractor;
        this.f33481g = driverProvider;
        MutableLiveData<WorkingTimeInfo> mutableLiveData = new MutableLiveData<>();
        this.f33482h = mutableLiveData;
        this.f33483i = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        y().o(Boolean.TRUE);
        Observable<WorkingTimeInfo> a8 = this.f33480f.a();
        final Function1<WorkingTimeInfo, Unit> function1 = new Function1<WorkingTimeInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(WorkingTimeInfo workingTimeInfo) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                y7 = WorkTimeViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = WorkTimeViewModel.this.f33482h;
                mutableLiveData.o(workingTimeInfo);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WorkingTimeInfo workingTimeInfo) {
                b(workingTimeInfo);
                return Unit.f50853a;
            }
        };
        Consumer<? super WorkingTimeInfo> consumer = new Consumer() { // from class: g5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkTimeViewModel.J(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel$onStart$2
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
                WorkTimeViewModel workTimeViewModel = WorkTimeViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workTimeViewModel, it, null, 2, null);
            }
        };
        this.f33484j = a8.subscribe(consumer, new Consumer() { // from class: g5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkTimeViewModel.K(Function1.this, obj);
            }
        });
    }

    public final LiveData<WorkingTimeInfo> H() {
        return this.f33483i;
    }

    public final DriverFeaturesConfig.WorkingTimeMode I() {
        return this.f33481g.m().M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33484j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
