package eu.bolt.driver.earnings.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButtonAction.kt */
@JsonAdapter(DriverButtonActionDeserializer.class)
/* loaded from: classes5.dex */
public abstract class DriverButtonAction {

    /* compiled from: DriverButtonAction.kt */
    /* loaded from: classes5.dex */
    public static final class Close extends DriverButtonAction {

        /* renamed from: a  reason: collision with root package name */
        public static final Close f41357a = new Close();

        private Close() {
            super(null);
        }
    }

    /* compiled from: DriverButtonAction.kt */
    /* loaded from: classes5.dex */
    public static final class DeepLink extends DriverButtonAction {
        @SerializedName(ImagesContract.URL)

        /* renamed from: a  reason: collision with root package name */
        private final String f41358a;

        public final String a() {
            return this.f41358a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeepLink) && Intrinsics.a(this.f41358a, ((DeepLink) obj).f41358a);
        }

        public int hashCode() {
            return this.f41358a.hashCode();
        }

        public String toString() {
            String str = this.f41358a;
            return "DeepLink(url=" + str + ")";
        }
    }

    /* compiled from: DriverButtonAction.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        CLOSE,
        DEEP_LINK,
        UNKNOWN
    }

    /* compiled from: DriverButtonAction.kt */
    /* loaded from: classes5.dex */
    public static final class Unknown extends DriverButtonAction {

        /* renamed from: a  reason: collision with root package name */
        public static final Unknown f41359a = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private DriverButtonAction() {
    }

    public /* synthetic */ DriverButtonAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
