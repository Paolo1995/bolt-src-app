package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_Packet<T> extends Packet<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f3963a;

    /* renamed from: b  reason: collision with root package name */
    private final Exif f3964b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3965c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f3966d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f3967e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3968f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f3969g;

    /* renamed from: h  reason: collision with root package name */
    private final CameraCaptureResult f3970h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Packet(T t7, Exif exif, int i8, Size size, Rect rect, int i9, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        if (t7 != null) {
            this.f3963a = t7;
            this.f3964b = exif;
            this.f3965c = i8;
            if (size != null) {
                this.f3966d = size;
                if (rect != null) {
                    this.f3967e = rect;
                    this.f3968f = i9;
                    if (matrix != null) {
                        this.f3969g = matrix;
                        if (cameraCaptureResult != null) {
                            this.f3970h = cameraCaptureResult;
                            return;
                        }
                        throw new NullPointerException("Null cameraCaptureResult");
                    }
                    throw new NullPointerException("Null sensorToBufferTransform");
                }
                throw new NullPointerException("Null cropRect");
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null data");
    }

    @Override // androidx.camera.core.processing.Packet
    @NonNull
    public CameraCaptureResult a() {
        return this.f3970h;
    }

    @Override // androidx.camera.core.processing.Packet
    @NonNull
    public Rect b() {
        return this.f3967e;
    }

    @Override // androidx.camera.core.processing.Packet
    @NonNull
    public T c() {
        return this.f3963a;
    }

    @Override // androidx.camera.core.processing.Packet
    public Exif d() {
        return this.f3964b;
    }

    @Override // androidx.camera.core.processing.Packet
    public int e() {
        return this.f3965c;
    }

    public boolean equals(Object obj) {
        Exif exif;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Packet)) {
            return false;
        }
        Packet packet = (Packet) obj;
        if (this.f3963a.equals(packet.c()) && ((exif = this.f3964b) != null ? exif.equals(packet.d()) : packet.d() == null) && this.f3965c == packet.e() && this.f3966d.equals(packet.h()) && this.f3967e.equals(packet.b()) && this.f3968f == packet.f() && this.f3969g.equals(packet.g()) && this.f3970h.equals(packet.a())) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.core.processing.Packet
    public int f() {
        return this.f3968f;
    }

    @Override // androidx.camera.core.processing.Packet
    @NonNull
    public Matrix g() {
        return this.f3969g;
    }

    @Override // androidx.camera.core.processing.Packet
    @NonNull
    public Size h() {
        return this.f3966d;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f3963a.hashCode() ^ 1000003) * 1000003;
        Exif exif = this.f3964b;
        if (exif == null) {
            hashCode = 0;
        } else {
            hashCode = exif.hashCode();
        }
        return ((((((((((((hashCode2 ^ hashCode) * 1000003) ^ this.f3965c) * 1000003) ^ this.f3966d.hashCode()) * 1000003) ^ this.f3967e.hashCode()) * 1000003) ^ this.f3968f) * 1000003) ^ this.f3969g.hashCode()) * 1000003) ^ this.f3970h.hashCode();
    }

    public String toString() {
        return "Packet{data=" + this.f3963a + ", exif=" + this.f3964b + ", format=" + this.f3965c + ", size=" + this.f3966d + ", cropRect=" + this.f3967e + ", rotationDegrees=" + this.f3968f + ", sensorToBufferTransform=" + this.f3969g + ", cameraCaptureResult=" + this.f3970h + "}";
    }
}
