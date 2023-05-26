package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Compat f5922a;

    /* loaded from: classes.dex */
    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final BuilderCompat f5923a;

        public Builder(@NonNull ClipData clipData, int i8) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f5923a = new BuilderCompat31Impl(clipData, i8);
            } else {
                this.f5923a = new BuilderCompatImpl(clipData, i8);
            }
        }

        @NonNull
        public ContentInfoCompat a() {
            return this.f5923a.build();
        }

        @NonNull
        public Builder b(Bundle bundle) {
            this.f5923a.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder c(int i8) {
            this.f5923a.b(i8);
            return this;
        }

        @NonNull
        public Builder d(Uri uri) {
            this.f5923a.a(uri);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private interface BuilderCompat {
        void a(Uri uri);

        void b(int i8);

        @NonNull
        ContentInfoCompat build();

        void setExtras(Bundle bundle);
    }

    /* loaded from: classes.dex */
    private static final class BuilderCompat31Impl implements BuilderCompat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f5924a;

        BuilderCompat31Impl(@NonNull ClipData clipData, int i8) {
            this.f5924a = new ContentInfo.Builder(clipData, i8);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void a(Uri uri) {
            this.f5924a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void b(int i8) {
            this.f5924a.setFlags(i8);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f5924a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f5924a.setExtras(bundle);
        }
    }

    /* loaded from: classes.dex */
    private static final class BuilderCompatImpl implements BuilderCompat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        ClipData f5925a;

        /* renamed from: b  reason: collision with root package name */
        int f5926b;

        /* renamed from: c  reason: collision with root package name */
        int f5927c;

        /* renamed from: d  reason: collision with root package name */
        Uri f5928d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f5929e;

        BuilderCompatImpl(@NonNull ClipData clipData, int i8) {
            this.f5925a = clipData;
            this.f5926b = i8;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void a(Uri uri) {
            this.f5928d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void b(int i8) {
            this.f5927c = i8;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f5929e = bundle;
        }
    }

    /* loaded from: classes.dex */
    private interface Compat {
        ContentInfo a();

        @NonNull
        ClipData b();

        int c();

        int getSource();
    }

    /* loaded from: classes.dex */
    private static final class Compat31Impl implements Compat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f5930a;

        Compat31Impl(@NonNull ContentInfo contentInfo) {
            this.f5930a = (ContentInfo) Preconditions.g(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ContentInfo a() {
            return this.f5930a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData b() {
            return this.f5930a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int c() {
            return this.f5930a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f5930a.getSource();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.f5930a + "}";
        }
    }

    /* loaded from: classes.dex */
    private static final class CompatImpl implements Compat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f5931a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5932b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5933c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f5934d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f5935e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f5931a = (ClipData) Preconditions.g(builderCompatImpl.f5925a);
            this.f5932b = Preconditions.c(builderCompatImpl.f5926b, 0, 5, "source");
            this.f5933c = Preconditions.f(builderCompatImpl.f5927c, 1);
            this.f5934d = builderCompatImpl.f5928d;
            this.f5935e = builderCompatImpl.f5929e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo a() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData b() {
            return this.f5931a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int c() {
            return this.f5933c;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.f5932b;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f5931a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.e(this.f5932b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.a(this.f5933c));
            String str2 = "";
            if (this.f5934d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f5934d.toString().length() + ")";
            }
            sb.append(str);
            if (this.f5935e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    ContentInfoCompat(@NonNull Compat compat) {
        this.f5922a = compat;
    }

    @NonNull
    static String a(int i8) {
        if ((i8 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i8);
    }

    @NonNull
    static String e(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 != 5) {
                                return String.valueOf(i8);
                            }
                            return "SOURCE_PROCESS_TEXT";
                        }
                        return "SOURCE_AUTOFILL";
                    }
                    return "SOURCE_DRAG_AND_DROP";
                }
                return "SOURCE_INPUT_METHOD";
            }
            return "SOURCE_CLIPBOARD";
        }
        return "SOURCE_APP";
    }

    @NonNull
    public static ContentInfoCompat g(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    @NonNull
    public ClipData b() {
        return this.f5922a.b();
    }

    public int c() {
        return this.f5922a.c();
    }

    public int d() {
        return this.f5922a.getSource();
    }

    @NonNull
    public ContentInfo f() {
        ContentInfo a8 = this.f5922a.a();
        Objects.requireNonNull(a8);
        return a8;
    }

    @NonNull
    public String toString() {
        return this.f5922a.toString();
    }
}
