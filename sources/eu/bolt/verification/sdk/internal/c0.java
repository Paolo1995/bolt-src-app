package eu.bolt.verification.sdk.internal;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentTransaction;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42421a = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(Bitmap bitmap, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, FragmentTransaction.TRANSIT_EXIT_MASK);
        try {
            b(bufferedOutputStream, bitmap);
            Unit unit = Unit.f50853a;
            CloseableKt.a(bufferedOutputStream, null);
        } finally {
        }
    }

    private final void b(OutputStream outputStream, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
    }

    public final void c(Bitmap bitmap, File file) {
        Intrinsics.f(bitmap, "bitmap");
        Intrinsics.f(file, "file");
        a(bitmap, file);
    }
}
