package ee.mtakso.driver.ui.screens.documents_scanner.source.camera;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.routing.command.IntentFragmentNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraSourceController.kt */
/* loaded from: classes3.dex */
public final class CameraSourceController implements SourceController {

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f28473d = new Companion(null);
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    private static final CameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1 f28474e = new NavigationCommand<Fragment>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.source.camera.CameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1
        @Override // ee.mtakso.driver.routing.command.NavigationCommand
        /* renamed from: b */
        public void a(Fragment context) {
            Intrinsics.f(context, "context");
            Kalev.d("Empty navigation command was called");
            AssertUtils.a("Empty navigation command was called");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final FilesUriProvider f28475a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<Uri> f28476b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f28477c;

    /* compiled from: CameraSourceController.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CameraSourceController(FilesUriProvider filesUriProvider) {
        Intrinsics.f(filesUriProvider, "filesUriProvider");
        this.f28475a = filesUriProvider;
        PublishSubject<Uri> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Uri>()");
        this.f28476b = e8;
    }

    private final void h() {
        Uri uri = this.f28477c;
        if (uri != null) {
            this.f28476b.onNext(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationCommand j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (NavigationCommand) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public Observable<Uri> a() {
        return this.f28476b;
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public Single<NavigationCommand<Fragment>> b() {
        Single<Optional<Uri>> g8 = this.f28475a.g();
        final Function1<Optional<Uri>, Unit> function1 = new Function1<Optional<Uri>, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.source.camera.CameraSourceController$createNavigationCommand$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<Uri> optional) {
                CameraSourceController.this.f28477c = optional.c();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<Uri> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Single<Optional<Uri>> o8 = g8.o(new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.source.camera.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CameraSourceController.i(Function1.this, obj);
            }
        });
        final CameraSourceController$createNavigationCommand$2 cameraSourceController$createNavigationCommand$2 = new Function1<Optional<Uri>, NavigationCommand<Fragment>>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.source.camera.CameraSourceController$createNavigationCommand$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final NavigationCommand<Fragment> invoke(Optional<Uri> it) {
                CameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1 cameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1;
                Intrinsics.f(it, "it");
                if (it.d()) {
                    cameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1 = CameraSourceController.f28474e;
                    return cameraSourceController$Companion$EMPTY_NAVIGATION_COMMAND$1;
                }
                Uri b8 = it.b();
                Intrinsics.e(b8, "it.value");
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", b8);
                return new IntentFragmentNavigationCommand(intent, 81, null, 4, null);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.source.camera.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NavigationCommand j8;
                j8 = CameraSourceController.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(x7, "override fun createNavig…)\n                }\n    }");
        return x7;
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController
    public boolean c(int i8, int i9, Intent intent) {
        if (i8 == 81 && i9 == -1) {
            h();
            return true;
        }
        return false;
    }
}
