package ee.mtakso.driver.ui.screens.documents_scanner.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FilesUriProvider.kt */
/* loaded from: classes3.dex */
public final class FilesUriProvider {

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f28484c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f28485a;

    /* renamed from: b  reason: collision with root package name */
    private final SimpleDateFormat f28486b;

    /* compiled from: FilesUriProvider.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FilesUriProvider(Context context) {
        Intrinsics.f(context, "context");
        this.f28485a = context;
        this.f28486b = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
    }

    private final Optional<File> f() {
        try {
            File externalFilesDir = this.f28485a.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir == null) {
                Optional<File> a8 = Optional.a();
                Intrinsics.e(a8, "empty()");
                return a8;
            }
            Optional<File> f8 = Optional.f(File.createTempFile(m(), ".jpg", externalFilesDir));
            Intrinsics.e(f8, "of(\n                    …storageDir)\n            )");
            return f8;
        } catch (IOException unused) {
            Optional<File> a9 = Optional.a();
            Intrinsics.e(a9, "empty()");
            return a9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional h(FilesUriProvider this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional k(FilesUriProvider this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    private final String m() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("document_%s", Arrays.copyOf(new Object[]{n()}, 1));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final String n() {
        String format = this.f28486b.format(new Date());
        Intrinsics.e(format, "dateFormatter.format(Date())");
        return format;
    }

    public final Single<Optional<Uri>> g() {
        Single u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional h8;
                h8 = FilesUriProvider.h(FilesUriProvider.this);
                return h8;
            }
        });
        final Function1<Optional<File>, Optional<Uri>> function1 = new Function1<Optional<File>, Optional<Uri>>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider$createNewMaskedUriUri$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<Uri> invoke(Optional<File> it) {
                Context context;
                Intrinsics.f(it, "it");
                if (it.d()) {
                    return Optional.a();
                }
                File b8 = it.b();
                Intrinsics.e(b8, "it.value");
                context = FilesUriProvider.this.f28485a;
                return Optional.f(FileProvider.f(context, "ee.mtakso.driver.fileprovider", b8));
            }
        };
        Single<Optional<Uri>> x7 = u7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional i8;
                i8 = FilesUriProvider.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(x7, "fun createNewMaskedUriUr…ntentUri)\n        }\n    }");
        return x7;
    }

    public final Single<Optional<Uri>> j() {
        Single u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional k8;
                k8 = FilesUriProvider.k(FilesUriProvider.this);
                return k8;
            }
        });
        final FilesUriProvider$createNewUnmaskedUri$2 filesUriProvider$createNewUnmaskedUri$2 = new Function1<Optional<File>, Optional<Uri>>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider$createNewUnmaskedUri$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<Uri> invoke(Optional<File> it) {
                Intrinsics.f(it, "it");
                if (it.d()) {
                    return Optional.a();
                }
                return Optional.f(Uri.fromFile(it.b()));
            }
        };
        Single<Optional<Uri>> x7 = u7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.utils.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional l8;
                l8 = FilesUriProvider.l(Function1.this, obj);
                return l8;
            }
        });
        Intrinsics.e(x7, "fromCallable {\n         …File(it.value))\n        }");
        return x7;
    }
}
