package eu.bolt.android.rib;

import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.delegate.BaseRibDelegate;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: BaseRibInteractor.kt */
/* loaded from: classes5.dex */
public abstract class BaseRibInteractor<R extends Router> extends RibInteractor<R> {

    /* renamed from: j  reason: collision with root package name */
    private final CompositeDisposable f37041j = new CompositeDisposable();

    /* renamed from: k  reason: collision with root package name */
    private final String f37042k = "modelKey";

    /* renamed from: l  reason: collision with root package name */
    private final MutableStateFlow<Unit> f37043l = StateFlowKt.a(null);

    /* renamed from: m  reason: collision with root package name */
    private final List<BaseRibDelegate> f37044m;

    public BaseRibInteractor() {
        List<BaseRibDelegate> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f37044m = k8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void S(BaseRibInteractor baseRibInteractor, Disposable disposable, Function1 function1, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                function1 = null;
            }
            baseRibInteractor.R(disposable, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addToDisposables");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        this.f37043l.d(null);
        super.K(bundle);
        RibLogger ribLogger = RibLogger.f37068a;
        String D = D();
        int hashCode = hashCode();
        ribLogger.a(D + " didBecomeActive. Hashcode=" + hashCode + " SavedInstanceState=" + bundle);
        for (BaseRibDelegate baseRibDelegate : T()) {
            baseRibDelegate.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.RibInteractor
    public void P() {
        this.f37043l.d(Unit.f50853a);
        super.P();
        RibLogger ribLogger = RibLogger.f37068a;
        String D = D();
        int hashCode = hashCode();
        ribLogger.a(D + " willResignActive. Hashcode=" + hashCode);
        for (BaseRibDelegate baseRibDelegate : T()) {
            baseRibDelegate.J();
        }
        this.f37041j.d();
        String D2 = D();
        B("Interactor " + D2 + " will resign active");
    }

    public final void Q(Disposable disposable) {
        Intrinsics.f(disposable, "disposable");
        this.f37041j.b(disposable);
    }

    protected final void R(Disposable disposable, Function1<? super Disposable, Unit> function1) {
        Intrinsics.f(disposable, "<this>");
        this.f37041j.b(disposable);
        if (function1 != null) {
            function1.invoke(disposable);
        }
    }

    protected List<BaseRibDelegate> T() {
        return this.f37044m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String U() {
        return this.f37042k;
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        RibLogger ribLogger = RibLogger.f37068a;
        String D = D();
        ribLogger.a(D + " handleBackPress(hasChildren:" + z7 + ")");
        return super.z(z7);
    }
}
