package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceContent.kt */
/* loaded from: classes3.dex */
public abstract class EarningsBalanceContent<T> {

    /* compiled from: EarningsBalanceContent.kt */
    /* loaded from: classes3.dex */
    public static final class Error<T> extends EarningsBalanceContent<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f28771a;

        /* renamed from: b  reason: collision with root package name */
        private final T f28772b;

        public /* synthetic */ Error(Throwable th, Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(th, (i8 & 2) != 0 ? null : obj);
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent
        public T a() {
            return this.f28772b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return Intrinsics.a(this.f28771a, error.f28771a) && Intrinsics.a(a(), error.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f28771a.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            Throwable th = this.f28771a;
            T a8 = a();
            return "Error(error=" + th + ", data=" + a8 + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error, T t7) {
            super(null);
            Intrinsics.f(error, "error");
            this.f28771a = error;
            this.f28772b = t7;
        }
    }

    /* compiled from: EarningsBalanceContent.kt */
    /* loaded from: classes3.dex */
    public static final class Loading<T> extends EarningsBalanceContent<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f28773a;

        public Loading() {
            this(null, 1, null);
        }

        public /* synthetic */ Loading(Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : obj);
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent
        public T a() {
            return this.f28773a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.a(a(), ((Loading) obj).a());
        }

        public int hashCode() {
            if (a() == null) {
                return 0;
            }
            return a().hashCode();
        }

        public String toString() {
            T a8 = a();
            return "Loading(data=" + a8 + ")";
        }

        public Loading(T t7) {
            super(null);
            this.f28773a = t7;
        }
    }

    /* compiled from: EarningsBalanceContent.kt */
    /* loaded from: classes3.dex */
    public static final class LoadingByRetry<T> extends EarningsBalanceContent<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f28774a;

        public LoadingByRetry() {
            this(null, 1, null);
        }

        public /* synthetic */ LoadingByRetry(Object obj, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : obj);
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent
        public T a() {
            return this.f28774a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadingByRetry) && Intrinsics.a(a(), ((LoadingByRetry) obj).a());
        }

        public int hashCode() {
            if (a() == null) {
                return 0;
            }
            return a().hashCode();
        }

        public String toString() {
            T a8 = a();
            return "LoadingByRetry(data=" + a8 + ")";
        }

        public LoadingByRetry(T t7) {
            super(null);
            this.f28774a = t7;
        }
    }

    /* compiled from: EarningsBalanceContent.kt */
    /* loaded from: classes3.dex */
    public static final class Success<T> extends EarningsBalanceContent<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f28775a;

        public Success(T t7) {
            super(null);
            this.f28775a = t7;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent
        public T a() {
            return this.f28775a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.a(a(), ((Success) obj).a());
        }

        public int hashCode() {
            if (a() == null) {
                return 0;
            }
            return a().hashCode();
        }

        public String toString() {
            T a8 = a();
            return "Success(data=" + a8 + ")";
        }
    }

    private EarningsBalanceContent() {
    }

    public /* synthetic */ EarningsBalanceContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract T a();
}
