package ee.mtakso.driver.ui.screens.documents_scanner.screens;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceController;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceControllersFactory;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceType;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsScannerViewModel.kt */
/* loaded from: classes3.dex */
public final class DocumentsScannerViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final SourceControllersFactory f28414f;

    /* renamed from: g  reason: collision with root package name */
    private final FilesUriProvider f28415g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<Uri> f28416h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<InputOutputUri> f28417i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveEvent<NavigationCommand<Fragment>> f28418j;

    /* renamed from: k  reason: collision with root package name */
    private SourceController f28419k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f28420l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f28421m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f28422n;

    /* compiled from: DocumentsScannerViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class InputOutputUri {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f28423a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f28424b;

        public InputOutputUri(Uri inputUri, Uri outputUri) {
            Intrinsics.f(inputUri, "inputUri");
            Intrinsics.f(outputUri, "outputUri");
            this.f28423a = inputUri;
            this.f28424b = outputUri;
        }

        public final Uri a() {
            return this.f28423a;
        }

        public final Uri b() {
            return this.f28424b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InputOutputUri) {
                InputOutputUri inputOutputUri = (InputOutputUri) obj;
                return Intrinsics.a(this.f28423a, inputOutputUri.f28423a) && Intrinsics.a(this.f28424b, inputOutputUri.f28424b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f28423a.hashCode() * 31) + this.f28424b.hashCode();
        }

        public String toString() {
            Uri uri = this.f28423a;
            Uri uri2 = this.f28424b;
            return "InputOutputUri(inputUri=" + uri + ", outputUri=" + uri2 + ")";
        }
    }

    @Inject
    public DocumentsScannerViewModel(SourceControllersFactory sourceControllersFactory, FilesUriProvider fileProvider) {
        Intrinsics.f(sourceControllersFactory, "sourceControllersFactory");
        Intrinsics.f(fileProvider, "fileProvider");
        this.f28414f = sourceControllersFactory;
        this.f28415g = fileProvider;
        this.f28416h = new MutableLiveData<>();
        this.f28417i = new MutableLiveData<>();
        this.f28418j = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final LiveData<InputOutputUri> M() {
        return this.f28417i;
    }

    public final LiveData<NavigationCommand<Fragment>> N() {
        return this.f28418j;
    }

    public final LiveData<Uri> O() {
        return this.f28416h;
    }

    public final void P(int i8, int i9, Intent intent) {
        SourceController sourceController = this.f28419k;
        if (sourceController != null) {
            sourceController.c(i8, i9, intent);
        }
    }

    public final void Q(SourceType sourceType) {
        Intrinsics.f(sourceType, "sourceType");
        if (this.f28416h.f() != null) {
            return;
        }
        SourceController a8 = this.f28414f.a(sourceType);
        this.f28419k = a8;
        Observable g8 = ObservableExtKt.g(a8.a());
        final Function1<Uri, Unit> function1 = new Function1<Uri, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$onSourceTypeReceived$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Uri uri) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DocumentsScannerViewModel.this.f28416h;
                mutableLiveData.o(uri);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                b(uri);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.R(Function1.this, obj);
            }
        };
        final DocumentsScannerViewModel$onSourceTypeReceived$2 documentsScannerViewModel$onSourceTypeReceived$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$onSourceTypeReceived$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Cannot load source data");
            }
        };
        this.f28420l = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.S(Function1.this, obj);
            }
        });
    }

    public final void T() {
        Single d8 = SingleExtKt.d(this.f28415g.j());
        final Function1<Optional<Uri>, Unit> function1 = new Function1<Optional<Uri>, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$prepareCropOutputUri$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<Uri> optional) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                if (!optional.d()) {
                    mutableLiveData = DocumentsScannerViewModel.this.f28417i;
                    mutableLiveData2 = DocumentsScannerViewModel.this.f28416h;
                    Object b8 = LiveDataExtKt.b(mutableLiveData2);
                    Intrinsics.e(b8, "uriLiveData.requireValue()");
                    Uri b9 = optional.b();
                    Intrinsics.e(b9, "outputUri.value");
                    mutableLiveData.o(new DocumentsScannerViewModel.InputOutputUri((Uri) b8, b9));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<Uri> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.U(Function1.this, obj);
            }
        };
        final DocumentsScannerViewModel$prepareCropOutputUri$2 documentsScannerViewModel$prepareCropOutputUri$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$prepareCropOutputUri$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Cannot load source data");
            }
        };
        this.f28422n = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.V(Function1.this, obj);
            }
        });
    }

    public final void W() {
        SourceController sourceController = this.f28419k;
        if (sourceController == null) {
            return;
        }
        Disposable disposable = this.f28421m;
        if (disposable != null) {
            disposable.dispose();
        }
        Single d8 = SingleExtKt.d(sourceController.b());
        final Function1<NavigationCommand<Fragment>, Unit> function1 = new Function1<NavigationCommand<Fragment>, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$takePhoto$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NavigationCommand<Fragment> navigationCommand) {
                LiveEvent liveEvent;
                liveEvent = DocumentsScannerViewModel.this.f28418j;
                liveEvent.o(navigationCommand);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationCommand<Fragment> navigationCommand) {
                b(navigationCommand);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.X(Function1.this, obj);
            }
        };
        final DocumentsScannerViewModel$takePhoto$2 documentsScannerViewModel$takePhoto$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel$takePhoto$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Cannot create navigation command");
            }
        };
        this.f28421m = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DocumentsScannerViewModel.Y(Function1.this, obj);
            }
        });
    }

    public final void Z(Uri newUri) {
        Intrinsics.f(newUri, "newUri");
        this.f28416h.o(newUri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28420l;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f28420l = null;
        Disposable disposable2 = this.f28421m;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f28421m = null;
        Disposable disposable3 = this.f28422n;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.f28422n = null;
    }
}
