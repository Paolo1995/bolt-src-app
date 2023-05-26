package eu.bolt.android.rib;

import eu.bolt.logger.StaticLogger;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: BaseViewRibPresenter.kt */
/* loaded from: classes5.dex */
public interface BaseViewRibPresenter<UiEvent> {

    /* compiled from: BaseViewRibPresenter.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <UiEvent> Observable<UiEvent> a(BaseViewRibPresenter<UiEvent> baseViewRibPresenter) {
            StaticLogger.f41686a.i("[observeUiEventsFlow] should be used");
            Observable<UiEvent> empty = Observable.empty();
            Intrinsics.e(empty, "empty()");
            return empty;
        }

        public static <UiEvent> Flow<UiEvent> b(BaseViewRibPresenter<UiEvent> baseViewRibPresenter) {
            return RxConvertKt.b(baseViewRibPresenter.h());
        }
    }

    Observable<UiEvent> h();

    Flow<UiEvent> p();
}
