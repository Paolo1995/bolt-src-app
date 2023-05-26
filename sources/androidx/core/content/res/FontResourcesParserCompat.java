package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.core.R$styleable;
import androidx.core.provider.FontRequest;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FontResourcesParserCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static int a(TypedArray typedArray, int i8) {
            return typedArray.getType(i8);
        }
    }

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final FontFileResourceEntry[] f5696a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f5696a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] a() {
            return this.f5696a;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f5697a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5698b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f5699c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5700d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5701e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5702f;

        public FontFileResourceEntry(@NonNull String str, int i8, boolean z7, String str2, int i9, int i10) {
            this.f5697a = str;
            this.f5698b = i8;
            this.f5699c = z7;
            this.f5700d = str2;
            this.f5701e = i9;
            this.f5702f = i10;
        }

        @NonNull
        public String a() {
            return this.f5697a;
        }

        public int b() {
            return this.f5702f;
        }

        public int c() {
            return this.f5701e;
        }

        public String d() {
            return this.f5700d;
        }

        public int e() {
            return this.f5698b;
        }

        public boolean f() {
            return this.f5699c;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final FontRequest f5703a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5704b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5705c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5706d;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i8, int i9, String str) {
            this.f5703a = fontRequest;
            this.f5705c = i8;
            this.f5704b = i9;
            this.f5706d = str;
        }

        public int a() {
            return this.f5705c;
        }

        @NonNull
        public FontRequest b() {
            return this.f5703a;
        }

        public String c() {
            return this.f5706d;
        }

        public int d() {
            return this.f5704b;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int a(TypedArray typedArray, int i8) {
        return Api21Impl.a(typedArray, i8);
    }

    public static FamilyResourceEntry b(@NonNull XmlPullParser xmlPullParser, @NonNull Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, int i8) {
        if (i8 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i8);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i9 = 0; i9 < obtainTypedArray.length(); i9++) {
                    int resourceId = obtainTypedArray.getResourceId(i9, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i8)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static FamilyResourceEntry d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f5518h);
        String string = obtainAttributes.getString(R$styleable.f5519i);
        String string2 = obtainAttributes.getString(R$styleable.f5523m);
        String string3 = obtainAttributes.getString(R$styleable.f5524n);
        int resourceId = obtainAttributes.getResourceId(R$styleable.f5520j, 0);
        int integer = obtainAttributes.getInteger(R$styleable.f5521k, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.f5522l, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        String string4 = obtainAttributes.getString(R$styleable.f5525o);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        boolean z7;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f5526p);
        int i8 = R$styleable.f5535y;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R$styleable.f5528r;
        }
        int i9 = obtainAttributes.getInt(i8, 400);
        int i10 = R$styleable.f5533w;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = R$styleable.f5529s;
        }
        if (1 == obtainAttributes.getInt(i10, 0)) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i11 = R$styleable.f5536z;
        if (!obtainAttributes.hasValue(i11)) {
            i11 = R$styleable.f5530t;
        }
        int i12 = R$styleable.f5534x;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = R$styleable.f5531u;
        }
        String string = obtainAttributes.getString(i12);
        int i13 = obtainAttributes.getInt(i11, 0);
        int i14 = R$styleable.f5532v;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = R$styleable.f5527q;
        }
        int resourceId = obtainAttributes.getResourceId(i14, 0);
        String string2 = obtainAttributes.getString(i14);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i9, z7, string, i13, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i8 = 1;
        while (i8 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i8--;
                }
            } else {
                i8++;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
