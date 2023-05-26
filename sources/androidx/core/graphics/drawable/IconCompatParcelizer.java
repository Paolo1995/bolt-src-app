package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f5773a = versionedParcel.p(iconCompat.f5773a, 1);
        iconCompat.f5775c = versionedParcel.j(iconCompat.f5775c, 2);
        iconCompat.f5776d = versionedParcel.r(iconCompat.f5776d, 3);
        iconCompat.f5777e = versionedParcel.p(iconCompat.f5777e, 4);
        iconCompat.f5778f = versionedParcel.p(iconCompat.f5778f, 5);
        iconCompat.f5779g = (ColorStateList) versionedParcel.r(iconCompat.f5779g, 6);
        iconCompat.f5781i = versionedParcel.t(iconCompat.f5781i, 7);
        iconCompat.f5782j = versionedParcel.t(iconCompat.f5782j, 8);
        iconCompat.o();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.p(versionedParcel.f());
        int i8 = iconCompat.f5773a;
        if (-1 != i8) {
            versionedParcel.F(i8, 1);
        }
        byte[] bArr = iconCompat.f5775c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f5776d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i9 = iconCompat.f5777e;
        if (i9 != 0) {
            versionedParcel.F(i9, 4);
        }
        int i10 = iconCompat.f5778f;
        if (i10 != 0) {
            versionedParcel.F(i10, 5);
        }
        ColorStateList colorStateList = iconCompat.f5779g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f5781i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f5782j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
