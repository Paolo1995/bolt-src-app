package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
class FontProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f5825a = new Comparator() { // from class: androidx.core.provider.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g8;
            g8 = FontProvider.g((byte[]) obj, (byte[]) obj2);
            return g8;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private FontProvider() {
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            if (!Arrays.equals(list.get(i8), list2.get(i8))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(FontRequest fontRequest, Resources resources) {
        if (fontRequest.b() != null) {
            return fontRequest.b();
        }
        return FontResourcesParserCompat.c(resources, fontRequest.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static FontsContractCompat.FontFamilyResult e(@NonNull Context context, @NonNull FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo f8 = f(context.getPackageManager(), fontRequest, context.getResources());
        if (f8 == null) {
            return FontsContractCompat.FontFamilyResult.a(1, null);
        }
        return FontsContractCompat.FontFamilyResult.a(0, h(context, fontRequest, f8.authority, cancellationSignal));
    }

    static ProviderInfo f(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String e8 = fontRequest.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e8, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(fontRequest.f())) {
                List<byte[]> b8 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(b8, f5825a);
                List<List<byte[]>> d8 = d(fontRequest, resources);
                for (int i8 = 0; i8 < d8.size(); i8++) {
                    ArrayList arrayList = new ArrayList(d8.get(i8));
                    Collections.sort(arrayList, f5825a);
                    if (c(b8, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + e8 + ", but package was not " + fontRequest.f());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + e8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i8 = 0; i8 < bArr.length; i8++) {
            byte b8 = bArr[i8];
            byte b9 = bArr2[i8];
            if (b8 != b9) {
                return b8 - b9;
            }
        }
        return 0;
    }

    @NonNull
    static FontsContractCompat.FontInfo[] h(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        int i8;
        int i9;
        int i10;
        Uri withAppendedId;
        int i11;
        int i12;
        boolean z7;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = Api16Impl.a(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.g()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    if (columnIndex != -1) {
                        i8 = cursor.getInt(columnIndex);
                    } else {
                        i8 = 0;
                    }
                    if (columnIndex4 != -1) {
                        i9 = cursor.getInt(columnIndex4);
                    } else {
                        i9 = 0;
                    }
                    if (columnIndex3 == -1) {
                        i10 = i8;
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i10 = i8;
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i11 = cursor.getInt(columnIndex5);
                    } else {
                        i11 = 400;
                    }
                    if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                        i12 = i10;
                        z7 = true;
                    } else {
                        i12 = i10;
                        z7 = false;
                    }
                    arrayList2.add(FontsContractCompat.FontInfo.a(withAppendedId, i9, i11, z7, i12));
                }
                arrayList = arrayList2;
            }
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
