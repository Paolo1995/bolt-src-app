package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f5772k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f5773a;

    /* renamed from: b  reason: collision with root package name */
    Object f5774b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5775c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f5776d;

    /* renamed from: e  reason: collision with root package name */
    public int f5777e;

    /* renamed from: f  reason: collision with root package name */
    public int f5778f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f5779g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f5780h;

    /* renamed from: i  reason: collision with root package name */
    public String f5781i;

    /* renamed from: j  reason: collision with root package name */
    public String f5782j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static IconCompat a(@NonNull Object obj) {
            Preconditions.g(obj);
            int d8 = d(obj);
            if (d8 != 2) {
                if (d8 != 4) {
                    if (d8 != 6) {
                        IconCompat iconCompat = new IconCompat(-1);
                        iconCompat.f5774b = obj;
                        return iconCompat;
                    }
                    return IconCompat.c(e(obj));
                }
                return IconCompat.f(e(obj));
            }
            return IconCompat.h(null, c(obj), b(obj));
        }

        static int b(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon resource", e8);
                return 0;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon resource", e9);
                return 0;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            }
        }

        static String c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon package", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon package", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            }
        }

        static int d(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e8);
                return -1;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e9);
                return -1;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            }
        }

        static Uri e(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e8) {
                Log.e("IconCompat", "Unable to get icon uri", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e("IconCompat", "Unable to get icon uri", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon g(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.f5773a) {
                case -1:
                    return (Icon) iconCompat.f5774b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f5774b);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.k(), iconCompat.f5777e);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.f5774b, iconCompat.f5777e, iconCompat.f5778f);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.f5774b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = Api26Impl.b((Bitmap) iconCompat.f5774b);
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.b((Bitmap) iconCompat.f5774b, false));
                        break;
                    }
                case 6:
                    int i8 = Build.VERSION.SDK_INT;
                    if (i8 >= 30) {
                        createWithBitmap = Api30Impl.a(iconCompat.m());
                        break;
                    } else if (context != null) {
                        InputStream n8 = iconCompat.n(context);
                        if (n8 != null) {
                            if (i8 >= 26) {
                                createWithBitmap = Api26Impl.b(BitmapFactory.decodeStream(n8));
                                break;
                            } else {
                                createWithBitmap = Icon.createWithBitmap(IconCompat.b(BitmapFactory.decodeStream(n8), false));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.m());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.m());
                    }
            }
            ColorStateList colorStateList = iconCompat.f5779g;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f5780h;
            if (mode != IconCompat.f5772k) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            Icon createWithAdaptiveBitmap;
            createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
            return createWithAdaptiveBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static int a(Object obj) {
            int resId;
            resId = ((Icon) obj).getResId();
            return resId;
        }

        static String b(Object obj) {
            String resPackage;
            resPackage = ((Icon) obj).getResPackage();
            return resPackage;
        }

        static int c(Object obj) {
            int type;
            type = ((Icon) obj).getType();
            return type;
        }

        static Uri d(Object obj) {
            Uri uri;
            uri = ((Icon) obj).getUri();
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static Icon a(Uri uri) {
            Icon createWithAdaptiveBitmapContentUri;
            createWithAdaptiveBitmapContentUri = Icon.createWithAdaptiveBitmapContentUri(uri);
            return createWithAdaptiveBitmapContentUri;
        }
    }

    public IconCompat() {
        this.f5773a = -1;
        this.f5775c = null;
        this.f5776d = null;
        this.f5777e = 0;
        this.f5778f = 0;
        this.f5779g = null;
        this.f5780h = f5772k;
        this.f5781i = null;
    }

    public static IconCompat a(@NonNull Icon icon) {
        return Api23Impl.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z7) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f8 = min;
        float f9 = 0.5f * f8;
        float f10 = 0.9166667f * f9;
        if (z7) {
            float f11 = 0.010416667f * f8;
            paint.setColor(0);
            paint.setShadowLayer(f11, 0.0f, f8 * 0.020833334f, 1023410176);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.setShadowLayer(f11, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f9, f9, f10, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    @NonNull
    public static IconCompat c(@NonNull Uri uri) {
        ObjectsCompat.c(uri);
        return d(uri.toString());
    }

    @NonNull
    public static IconCompat d(@NonNull String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f5774b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat e(@NonNull Bitmap bitmap) {
        ObjectsCompat.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f5774b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat f(@NonNull Uri uri) {
        ObjectsCompat.c(uri);
        return g(uri.toString());
    }

    @NonNull
    public static IconCompat g(@NonNull String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f5774b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat h(Resources resources, @NonNull String str, int i8) {
        ObjectsCompat.c(str);
        if (i8 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f5777e = i8;
            if (resources != null) {
                try {
                    iconCompat.f5774b = resources.getResourceName(i8);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f5774b = str;
            }
            iconCompat.f5782j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String t(int i8) {
        switch (i8) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap i() {
        int i8 = this.f5773a;
        if (i8 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f5774b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i8 == 1) {
            return (Bitmap) this.f5774b;
        } else {
            if (i8 == 5) {
                return b((Bitmap) this.f5774b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int j() {
        int i8 = this.f5773a;
        if (i8 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(this.f5774b);
        }
        if (i8 == 2) {
            return this.f5777e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String k() {
        int i8 = this.f5773a;
        if (i8 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c(this.f5774b);
        }
        if (i8 == 2) {
            String str = this.f5782j;
            if (str != null && !TextUtils.isEmpty(str)) {
                return this.f5782j;
            }
            return ((String) this.f5774b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i8 = this.f5773a;
        if (i8 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.d(this.f5774b);
        }
        return i8;
    }

    @NonNull
    public Uri m() {
        int i8 = this.f5773a;
        if (i8 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.e(this.f5774b);
        }
        if (i8 != 4 && i8 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f5774b);
    }

    public InputStream n(@NonNull Context context) {
        Uri m8 = m();
        String scheme = m8.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.f5774b));
            } catch (FileNotFoundException e8) {
                Log.w("IconCompat", "Unable to load image from path: " + m8, e8);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(m8);
        } catch (Exception e9) {
            Log.w("IconCompat", "Unable to load image from URI: " + m8, e9);
            return null;
        }
    }

    public void o() {
        this.f5780h = PorterDuff.Mode.valueOf(this.f5781i);
        switch (this.f5773a) {
            case -1:
                Parcelable parcelable = this.f5776d;
                if (parcelable != null) {
                    this.f5774b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f5776d;
                if (parcelable2 != null) {
                    this.f5774b = parcelable2;
                    return;
                }
                byte[] bArr = this.f5775c;
                this.f5774b = bArr;
                this.f5773a = 3;
                this.f5777e = 0;
                this.f5778f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f5775c, Charset.forName("UTF-16"));
                this.f5774b = str;
                if (this.f5773a == 2 && this.f5782j == null) {
                    this.f5782j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f5774b = this.f5775c;
                return;
        }
    }

    public void p(boolean z7) {
        this.f5781i = this.f5780h.name();
        switch (this.f5773a) {
            case -1:
                if (!z7) {
                    this.f5776d = (Parcelable) this.f5774b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z7) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f5774b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f5775c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f5776d = (Parcelable) this.f5774b;
                return;
            case 2:
                this.f5775c = ((String) this.f5774b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f5775c = (byte[]) this.f5774b;
                return;
            case 4:
            case 6:
                this.f5775c = this.f5774b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @NonNull
    public Bundle q() {
        Bundle bundle = new Bundle();
        switch (this.f5773a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f5774b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f5774b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f5774b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f5774b);
                break;
        }
        bundle.putInt("type", this.f5773a);
        bundle.putInt("int1", this.f5777e);
        bundle.putInt("int2", this.f5778f);
        bundle.putString("string1", this.f5782j);
        ColorStateList colorStateList = this.f5779g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f5780h;
        if (mode != f5772k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    @NonNull
    @Deprecated
    public Icon r() {
        return s(null);
    }

    @NonNull
    public Icon s(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    @NonNull
    public String toString() {
        if (this.f5773a == -1) {
            return String.valueOf(this.f5774b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(t(this.f5773a));
        switch (this.f5773a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f5774b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f5774b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f5782j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(j())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f5777e);
                if (this.f5778f != 0) {
                    sb.append(" off=");
                    sb.append(this.f5778f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f5774b);
                break;
        }
        if (this.f5779g != null) {
            sb.append(" tint=");
            sb.append(this.f5779g);
        }
        if (this.f5780h != f5772k) {
            sb.append(" mode=");
            sb.append(this.f5780h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i8) {
        this.f5775c = null;
        this.f5776d = null;
        this.f5777e = 0;
        this.f5778f = 0;
        this.f5779g = null;
        this.f5780h = f5772k;
        this.f5781i = null;
        this.f5773a = i8;
    }
}
