package ee.mtakso.driver.ui.interactor.warnings;

import ee.mtakso.driver.network.client.driver.PollMessage;
import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WarningMessage.kt */
/* loaded from: classes3.dex */
public abstract class WarningMessage {

    /* compiled from: WarningMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Connection extends WarningMessage {

        /* renamed from: a  reason: collision with root package name */
        private final ConnectionMessage f26952a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Connection(ConnectionMessage message) {
            super(null);
            Intrinsics.f(message, "message");
            this.f26952a = message;
        }

        public final ConnectionMessage a() {
            return this.f26952a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Connection) && Intrinsics.a(this.f26952a, ((Connection) obj).f26952a);
        }

        public int hashCode() {
            return this.f26952a.hashCode();
        }

        public String toString() {
            ConnectionMessage connectionMessage = this.f26952a;
            return "Connection(message=" + connectionMessage + ")";
        }
    }

    /* compiled from: WarningMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends WarningMessage {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f26953a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: WarningMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Location extends WarningMessage {

        /* renamed from: a  reason: collision with root package name */
        private final GeoLocationManagerState f26954a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Location(GeoLocationManagerState status) {
            super(null);
            Intrinsics.f(status, "status");
            this.f26954a = status;
        }

        public final GeoLocationManagerState a() {
            return this.f26954a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Location) && this.f26954a == ((Location) obj).f26954a;
        }

        public int hashCode() {
            return this.f26954a.hashCode();
        }

        public String toString() {
            GeoLocationManagerState geoLocationManagerState = this.f26954a;
            return "Location(status=" + geoLocationManagerState + ")";
        }
    }

    /* compiled from: WarningMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Polling extends WarningMessage {

        /* renamed from: a  reason: collision with root package name */
        private final PollMessage f26955a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Polling(PollMessage message) {
            super(null);
            Intrinsics.f(message, "message");
            this.f26955a = message;
        }

        public final PollMessage a() {
            return this.f26955a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Polling) && Intrinsics.a(this.f26955a, ((Polling) obj).f26955a);
        }

        public int hashCode() {
            return this.f26955a.hashCode();
        }

        public String toString() {
            PollMessage pollMessage = this.f26955a;
            return "Polling(message=" + pollMessage + ")";
        }
    }

    private WarningMessage() {
    }

    public /* synthetic */ WarningMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
