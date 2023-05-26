package eu.bolt.verification.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.io.File;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class cf {

    /* renamed from: c  reason: collision with root package name */
    public static final b f42502c = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final c0 f42503a;

    /* renamed from: b  reason: collision with root package name */
    private final xg f42504b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f42505a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42506b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f42507c;

        /* renamed from: d  reason: collision with root package name */
        private final File f42508d;

        /* renamed from: e  reason: collision with root package name */
        private final File f42509e;

        public a(int i8, int i9, Rect cutoffRect, File inputFile, File outputFile) {
            Intrinsics.f(cutoffRect, "cutoffRect");
            Intrinsics.f(inputFile, "inputFile");
            Intrinsics.f(outputFile, "outputFile");
            this.f42505a = i8;
            this.f42506b = i9;
            this.f42507c = cutoffRect;
            this.f42508d = inputFile;
            this.f42509e = outputFile;
        }

        public final Rect a() {
            return this.f42507c;
        }

        public final int b() {
            return this.f42506b;
        }

        public final File c() {
            return this.f42508d;
        }

        public final File d() {
            return this.f42509e;
        }

        public final int e() {
            return this.f42505a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public cf(c0 fileWriter, xg rxSchedulers) {
        Intrinsics.f(fileWriter, "fileWriter");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        this.f42503a = fileWriter;
        this.f42504b = rxSchedulers;
    }

    private final float b(File file) {
        int i8 = new ExifInterface(file.getAbsolutePath()).i("Orientation", 1);
        if (i8 != 3) {
            if (i8 != 6) {
                return i8 != 8 ? 0.0f : 270.0f;
            }
            return 90.0f;
        }
        return 180.0f;
    }

    private final Bitmap c(int i8, int i9, Rect rect, File file) {
        try {
            Bitmap rotatedBitmap = e0.a(BitmapFactory.decodeFile(file.getAbsolutePath()), b(file));
            Intrinsics.e(rotatedBitmap, "rotatedBitmap");
            return e(d(rotatedBitmap, i8, i9), i8, i9, rect);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Bitmap d(Bitmap bitmap, int i8, int i9) {
        double d8 = i9;
        double d9 = i8;
        if (bitmap.getHeight() / bitmap.getWidth() < d8 / d9) {
            i9 = (int) ((d9 / bitmap.getWidth()) * bitmap.getHeight());
        } else {
            i8 = (int) ((d8 / bitmap.getHeight()) * bitmap.getWidth());
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i8, i9, false);
        Intrinsics.e(createScaledBitmap, "createScaledBitmap(bitma…caledBitmapHeight, false)");
        return createScaledBitmap;
    }

    private final Bitmap e(Bitmap bitmap, int i8, int i9, Rect rect) {
        int i10;
        int height;
        if (bitmap.getWidth() / bitmap.getHeight() > i8 / i9) {
            i10 = rect.left + ((bitmap.getWidth() - i8) / 2);
            height = rect.top;
        } else {
            i10 = rect.left;
            height = rect.top + ((bitmap.getHeight() - i9) / 2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i10, height, rect.width(), rect.height());
        Intrinsics.e(createBitmap, "createBitmap(bitmap, lef…h(), cutoffRect.height())");
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(cf this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        Bitmap c8 = this$0.c(args.e(), args.b(), args.a(), args.c());
        if (c8 != null) {
            this$0.f42503a.c(c8, args.d());
        }
    }

    private final Completable h(final a aVar) {
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.qr
            @Override // io.reactivex.functions.Action
            public final void run() {
                cf.g(cf.this, aVar);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        val…tputFile)\n        }\n    }");
        return u7;
    }

    public Completable f(a args) {
        Intrinsics.f(args, "args");
        Completable I = h(args).I(this.f42504b.b());
        Intrinsics.e(I, "writeFile(args).subscribeOn(rxSchedulers.io)");
        return I;
    }
}
