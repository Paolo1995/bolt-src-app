package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerItem.kt */
/* loaded from: classes3.dex */
public abstract class BannerItem {

    /* compiled from: BannerItem.kt */
    /* loaded from: classes3.dex */
    public static final class Chevron extends BannerItem {

        /* renamed from: a  reason: collision with root package name */
        private final Image f28987a;

        public Chevron(Image image) {
            super(null);
            this.f28987a = image;
        }

        public final Image a() {
            return this.f28987a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Chevron) && Intrinsics.a(this.f28987a, ((Chevron) obj).f28987a);
        }

        public int hashCode() {
            Image image = this.f28987a;
            if (image == null) {
                return 0;
            }
            return image.hashCode();
        }

        public String toString() {
            Image image = this.f28987a;
            return "Chevron(image=" + image + ")";
        }
    }

    private BannerItem() {
    }

    public /* synthetic */ BannerItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
