package ee.mtakso.driver.uikit.utils.image;

/* compiled from: ImageSize.kt */
/* loaded from: classes5.dex */
public final class ImageSize {

    /* renamed from: a  reason: collision with root package name */
    private final int f36083a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36084b;

    public ImageSize(int i8, int i9) {
        this.f36083a = i8;
        this.f36084b = i9;
    }

    public static /* synthetic */ ImageSize b(ImageSize imageSize, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = imageSize.f36083a;
        }
        if ((i10 & 2) != 0) {
            i9 = imageSize.f36084b;
        }
        return imageSize.a(i8, i9);
    }

    public final ImageSize a(int i8, int i9) {
        return new ImageSize(i8, i9);
    }

    public final int c() {
        return this.f36084b;
    }

    public final int d() {
        return this.f36083a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageSize) {
            ImageSize imageSize = (ImageSize) obj;
            return this.f36083a == imageSize.f36083a && this.f36084b == imageSize.f36084b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f36083a * 31) + this.f36084b;
    }

    public String toString() {
        int i8 = this.f36083a;
        int i9 = this.f36084b;
        return "ImageSize(width=" + i8 + ", height=" + i9 + ")";
    }
}
