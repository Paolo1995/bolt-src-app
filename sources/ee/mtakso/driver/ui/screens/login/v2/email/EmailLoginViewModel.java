package ee.mtakso.driver.ui.screens.login.v2.email;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.driver.MagicTokenRequestInteractor;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailLoginViewModel.kt */
/* loaded from: classes3.dex */
public final class EmailLoginViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final MagicTokenRequestInteractor f30465f;

    /* renamed from: g  reason: collision with root package name */
    private final LoginAnalytics f30466g;

    /* renamed from: h  reason: collision with root package name */
    private final Pattern f30467h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<String> f30468i;

    /* renamed from: j  reason: collision with root package name */
    private final MediatorLiveData<Boolean> f30469j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<Boolean> f30470k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<Object> f30471l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<Object> f30472m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f30473n;

    @Inject
    public EmailLoginViewModel(MagicTokenRequestInteractor magicTokenRequestInteractor, LoginAnalytics loginAnalytics) {
        Intrinsics.f(magicTokenRequestInteractor, "magicTokenRequestInteractor");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        this.f30465f = magicTokenRequestInteractor;
        this.f30466g = loginAnalytics;
        this.f30467h = Pattern.compile("[\\s\\S]+\\@[\\s\\S]+");
        this.f30468i = new MutableLiveData<>("");
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.f30469j = mediatorLiveData;
        this.f30470k = mediatorLiveData;
        MutableLiveData<Object> mutableLiveData = new MutableLiveData<>();
        this.f30471l = mutableLiveData;
        this.f30472m = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(EmailLoginViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(EmailLoginViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30471l.o(new Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        this.f30469j.o(Boolean.valueOf(this.f30467h.matcher((CharSequence) LiveDataExtKt.b(this.f30468i)).matches()));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f30466g.v();
        MediatorLiveData<Boolean> mediatorLiveData = this.f30469j;
        MutableLiveData<String> mutableLiveData = this.f30468i;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                EmailLoginViewModel.this.T();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData, new Observer() { // from class: f4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmailLoginViewModel.N(Function1.this, obj);
            }
        });
    }

    public final MutableLiveData<String> K() {
        return this.f30468i;
    }

    public final LiveData<Object> L() {
        return this.f30472m;
    }

    public final LiveData<Boolean> M() {
        return this.f30470k;
    }

    public final void O() {
        this.f30466g.m1();
        MagicTokenRequestInteractor magicTokenRequestInteractor = this.f30465f;
        Object b8 = LiveDataExtKt.b(this.f30468i);
        Intrinsics.e(b8, "email.requireValue()");
        Completable a8 = magicTokenRequestInteractor.a((String) b8);
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel$requestMagicToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = EmailLoginViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable s7 = a8.r(new Consumer() { // from class: f4.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmailLoginViewModel.P(Function1.this, obj);
            }
        }).s(new Action() { // from class: f4.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                EmailLoginViewModel.Q(EmailLoginViewModel.this);
            }
        });
        Action action = new Action() { // from class: f4.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                EmailLoginViewModel.R(EmailLoginViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel$requestMagicToken$4
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
                EmailLoginViewModel emailLoginViewModel = EmailLoginViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(emailLoginViewModel, it, null, 2, null);
            }
        };
        this.f30473n = s7.G(action, new Consumer() { // from class: f4.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmailLoginViewModel.S(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30473n;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
