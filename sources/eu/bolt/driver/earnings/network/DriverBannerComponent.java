package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverBannerComponent.kt */
@JsonAdapter(DriverBannerComponentDeserializer.class)
/* loaded from: classes5.dex */
public abstract class DriverBannerComponent {

    /* compiled from: DriverBannerComponent.kt */
    /* loaded from: classes5.dex */
    public static final class Image extends DriverBannerComponent {
        @SerializedName("image")

        /* renamed from: a  reason: collision with root package name */
        private final DriverImage f41349a;

        public final DriverImage a() {
            return this.f41349a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Image) && Intrinsics.a(this.f41349a, ((Image) obj).f41349a);
        }

        public int hashCode() {
            return this.f41349a.hashCode();
        }

        public String toString() {
            DriverImage driverImage = this.f41349a;
            return "Image(image=" + driverImage + ")";
        }
    }

    /* compiled from: DriverBannerComponent.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        IMAGE,
        UNKNOWN
    }

    private DriverBannerComponent() {
    }
}
