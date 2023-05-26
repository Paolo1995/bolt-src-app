package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapStatus.kt */
/* loaded from: classes3.dex */
public abstract class HeatmapStatus {

    /* compiled from: HeatmapStatus.kt */
    /* loaded from: classes3.dex */
    public static final class Available extends HeatmapStatus {

        /* renamed from: a  reason: collision with root package name */
        private final Image f26637a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26638b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26639c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26640d;

        public Available(Image image, String str, String str2, String str3) {
            super(null);
            this.f26637a = image;
            this.f26638b = str;
            this.f26639c = str2;
            this.f26640d = str3;
        }

        public final String a() {
            return this.f26639c;
        }

        public final String b() {
            return this.f26640d;
        }

        public final String c() {
            return this.f26638b;
        }

        public final Image d() {
            return this.f26637a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Available) {
                Available available = (Available) obj;
                return Intrinsics.a(this.f26637a, available.f26637a) && Intrinsics.a(this.f26638b, available.f26638b) && Intrinsics.a(this.f26639c, available.f26639c) && Intrinsics.a(this.f26640d, available.f26640d);
            }
            return false;
        }

        public int hashCode() {
            Image image = this.f26637a;
            int hashCode = (image == null ? 0 : image.hashCode()) * 31;
            String str = this.f26638b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f26639c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f26640d;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            Image image = this.f26637a;
            String str = this.f26638b;
            String str2 = this.f26639c;
            String str3 = this.f26640d;
            return "Available(icon=" + image + ", analyticMapType=" + str + ", analyticCategoryId=" + str2 + ", analyticCategoryName=" + str3 + ")";
        }
    }

    /* compiled from: HeatmapStatus.kt */
    /* loaded from: classes3.dex */
    public static final class Unavailable extends HeatmapStatus {

        /* renamed from: a  reason: collision with root package name */
        public static final Unavailable f26641a = new Unavailable();

        private Unavailable() {
            super(null);
        }
    }

    private HeatmapStatus() {
    }

    public /* synthetic */ HeatmapStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
