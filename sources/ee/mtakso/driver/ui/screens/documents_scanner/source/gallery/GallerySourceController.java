package ee.mtakso.driver.ui.screens.documents_scanner.source.gallery;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController;
import ee.mtakso.driver.ui.screens.documents_scanner.source.gallery.GallerySourceController;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GallerySourceController.kt */
/* loaded from: classes3.dex */
public final class GallerySourceController implements SourceController {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f28482b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<Uri> f28483a;

    /* compiled from: GallerySourceController.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GallerySourceController() {
        PublishSubject<Uri> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Uri>()");
        this.f28483a = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationCommand e() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        return new IntentFragmentNavigationCommand(intent, 672, null, 4, null);
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public Observable<Uri> a() {
        return this.f28483a;
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public Single<NavigationCommand<Fragment>> b() {
        Single<NavigationCommand<Fragment>> u7 = Single.u(new Callable() { // from class: l3.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                NavigationCommand e8;
                e8 = GallerySourceController.e();
                return e8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …E\n            )\n        }");
        return u7;
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public boolean c(int i8, int i9, Intent intent) {
        Uri uri;
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        if (i8 == 672 && i9 == -1 && uri != null) {
            this.f28483a.onNext(uri);
            return true;
        }
        return false;
    }
}
