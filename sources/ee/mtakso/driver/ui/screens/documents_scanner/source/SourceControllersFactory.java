package ee.mtakso.driver.ui.screens.documents_scanner.source;

import ee.mtakso.driver.ui.screens.documents_scanner.source.camera.CameraSourceController;
import ee.mtakso.driver.ui.screens.documents_scanner.source.gallery.GallerySourceController;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SourceControllersFactory.kt */
/* loaded from: classes3.dex */
public final class SourceControllersFactory {

    /* renamed from: a  reason: collision with root package name */
    private final FilesUriProvider f28467a;

    /* compiled from: SourceControllersFactory.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28468a;

        static {
            int[] iArr = new int[SourceType.values().length];
            try {
                iArr[SourceType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SourceType.GALLERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28468a = iArr;
        }
    }

    @Inject
    public SourceControllersFactory(FilesUriProvider filesUriProvider) {
        Intrinsics.f(filesUriProvider, "filesUriProvider");
        this.f28467a = filesUriProvider;
    }

    public final SourceController a(SourceType type) {
        Intrinsics.f(type, "type");
        int i8 = WhenMappings.f28468a[type.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return new GallerySourceController();
            }
            throw new NoWhenBranchMatchedException();
        }
        return new CameraSourceController(this.f28467a);
    }
}
