package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.util.MPLog;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
/* loaded from: classes3.dex */
public class UpdateDisplayState implements Parcelable {
    public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new Parcelable.Creator<UpdateDisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UpdateDisplayState createFromParcel(Parcel parcel) {
            Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new UpdateDisplayState(bundle);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public UpdateDisplayState[] newArray(int i8) {
            return new UpdateDisplayState[i8];
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final ReentrantLock f19388i = new ReentrantLock();

    /* renamed from: j  reason: collision with root package name */
    private static long f19389j = -1;

    /* renamed from: k  reason: collision with root package name */
    private static UpdateDisplayState f19390k = null;

    /* renamed from: l  reason: collision with root package name */
    private static int f19391l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static int f19392m = -1;

    /* renamed from: f  reason: collision with root package name */
    private final String f19393f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19394g;

    /* renamed from: h  reason: collision with root package name */
    private final DisplayState f19395h;

    /* loaded from: classes3.dex */
    public static abstract class DisplayState implements Parcelable {
        public static final Parcelable.Creator<DisplayState> CREATOR = new Parcelable.Creator<DisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public DisplayState createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(DisplayState.class.getClassLoader());
                bundle.readFromParcel(parcel);
                String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(string)) {
                    return new InAppNotificationState(bundle2);
                }
                throw new RuntimeException("Unrecognized display state type " + string);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public DisplayState[] newArray(int i8) {
                return new DisplayState[i8];
            }
        };

        /* loaded from: classes3.dex */
        public static final class InAppNotificationState extends DisplayState {
            public static final Parcelable.Creator<InAppNotificationState> CREATOR = new Parcelable.Creator<InAppNotificationState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public InAppNotificationState createFromParcel(Parcel parcel) {
                    Bundle bundle = new Bundle(InAppNotificationState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new InAppNotificationState(bundle);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public InAppNotificationState[] newArray(int i8) {
                    return new InAppNotificationState[i8];
                }
            };

            /* renamed from: h  reason: collision with root package name */
            private static String f19396h = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";

            /* renamed from: i  reason: collision with root package name */
            private static String f19397i = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";

            /* renamed from: f  reason: collision with root package name */
            private final InAppNotification f19398f;

            /* renamed from: g  reason: collision with root package name */
            private final int f19399g;

            public InAppNotification a() {
                return this.f19398f;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i8) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(f19396h, this.f19398f);
                bundle.putInt(f19397i, this.f19399g);
                parcel.writeBundle(bundle);
            }

            public InAppNotificationState(InAppNotification inAppNotification, int i8) {
                super();
                this.f19398f = inAppNotification;
                this.f19399g = i8;
            }

            private InAppNotificationState(Bundle bundle) {
                super();
                this.f19398f = (InAppNotification) bundle.getParcelable(f19396h);
                this.f19399g = bundle.getInt(f19397i);
            }
        }

        private DisplayState() {
        }
    }

    public static UpdateDisplayState a(int i8) {
        ReentrantLock reentrantLock = f19388i;
        reentrantLock.lock();
        try {
            int i9 = f19392m;
            if (i9 > 0 && i9 != i8) {
                reentrantLock.unlock();
                return null;
            } else if (f19390k == null) {
                reentrantLock.unlock();
                return null;
            } else {
                f19389j = System.currentTimeMillis();
                f19392m = i8;
                UpdateDisplayState updateDisplayState = f19390k;
                reentrantLock.unlock();
                return updateDisplayState;
            }
        } catch (Throwable th) {
            f19388i.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReentrantLock c() {
        return f19388i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        if (f19388i.isHeldByCurrentThread()) {
            long currentTimeMillis = System.currentTimeMillis() - f19389j;
            if (f19391l > 0 && currentTimeMillis > 43200000) {
                MPLog.e("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
                f19390k = null;
            }
            if (f19390k != null) {
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(DisplayState displayState, String str, String str2) {
        if (f19388i.isHeldByCurrentThread()) {
            if (!e()) {
                f19389j = System.currentTimeMillis();
                f19390k = new UpdateDisplayState(displayState, str, str2);
                int i8 = f19391l + 1;
                f19391l = i8;
                return i8;
            }
            MPLog.i("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
            return -1;
        }
        throw new AssertionError();
    }

    public static void g(int i8) {
        ReentrantLock reentrantLock = f19388i;
        reentrantLock.lock();
        try {
            if (i8 == f19392m) {
                f19392m = -1;
                f19390k = null;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            f19388i.unlock();
            throw th;
        }
    }

    public DisplayState b() {
        return this.f19395h;
    }

    public String d() {
        return this.f19394g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.f19393f);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.f19394g);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.f19395h);
        parcel.writeBundle(bundle);
    }

    UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.f19393f = str;
        this.f19394g = str2;
        this.f19395h = displayState;
    }

    private UpdateDisplayState(Bundle bundle) {
        this.f19393f = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.f19394g = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.f19395h = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}
