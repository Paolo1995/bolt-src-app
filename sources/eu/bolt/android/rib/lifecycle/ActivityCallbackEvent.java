package eu.bolt.android.rib.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ActivityCallbackEvent {

    /* renamed from: b  reason: collision with root package name */
    private static final ActivityCallbackEvent f37135b = new ActivityCallbackEvent(Type.LOW_MEMORY);

    /* renamed from: a  reason: collision with root package name */
    private final Type f37136a;

    /* renamed from: eu.bolt.android.rib.lifecycle.ActivityCallbackEvent$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37137a;

        static {
            int[] iArr = new int[Type.values().length];
            f37137a = iArr;
            try {
                iArr[Type.LOW_MEMORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ActivityResult extends ActivityCallbackEvent {

        /* renamed from: c  reason: collision with root package name */
        private final Intent f37138c;

        /* renamed from: d  reason: collision with root package name */
        private final int f37139d;

        /* renamed from: e  reason: collision with root package name */
        private final int f37140e;

        private ActivityResult(Intent intent, int i8, int i9) {
            super(Type.ACTIVITY_RESULT);
            this.f37138c = intent;
            this.f37139d = i8;
            this.f37140e = i9;
        }

        public Intent e() {
            return this.f37138c;
        }

        public int f() {
            return this.f37139d;
        }

        public int g() {
            return this.f37140e;
        }
    }

    /* loaded from: classes5.dex */
    public static class SaveInstanceState extends ActivityCallbackEvent {

        /* renamed from: c  reason: collision with root package name */
        private Bundle f37141c;

        private SaveInstanceState(Bundle bundle) {
            super(Type.SAVE_INSTANCE_STATE);
            this.f37141c = bundle;
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        LOW_MEMORY,
        ACTIVITY_RESULT,
        SAVE_INSTANCE_STATE
    }

    private ActivityCallbackEvent(Type type) {
        this.f37136a = type;
    }

    private static String a(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static ActivityCallbackEvent b(Type type) {
        if (AnonymousClass1.f37137a[type.ordinal()] == 1) {
            return f37135b;
        }
        throw new IllegalArgumentException("Use the createOn" + a(type.name().toLowerCase(Locale.US)) + "Event() method for this type!");
    }

    public static ActivityResult c(int i8, int i9, Intent intent) {
        return new ActivityResult(intent, i8, i9);
    }

    public static ActivityCallbackEvent d(Bundle bundle) {
        return new SaveInstanceState(bundle);
    }
}
