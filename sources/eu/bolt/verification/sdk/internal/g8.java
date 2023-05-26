package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseViewRibPresenter;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import io.reactivex.Observable;

/* loaded from: classes5.dex */
public interface g8 extends BaseViewRibPresenter<b> {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Observable<b> a(g8 g8Var) {
            return BaseViewRibPresenter.DefaultImpls.a(g8Var);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {

        /* loaded from: classes5.dex */
        public static final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f43131a = new a();

            private a() {
            }
        }
    }

    void u(DesignToolbarView.c cVar);
}
