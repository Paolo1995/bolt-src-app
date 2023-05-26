package ee.mtakso.driver.network.client;

import dagger.Lazy;
import ee.mtakso.driver.network.client.dashboard.DashboardApi;
import ee.mtakso.driver.network.client.driver.DriverApi;
import ee.mtakso.driver.network.client.fleet.ShardFleetApi;
import ee.mtakso.driver.network.client.order.OrderApi;
import ee.mtakso.driver.network.client.priority.DriverPriorityApi;
import ee.mtakso.driver.network.client.settings.SettingsApi;
import ee.mtakso.driver.param.DriverProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.OkHttpClient;

/* compiled from: ShardApiProvider.kt */
@Singleton
/* loaded from: classes3.dex */
public final class ShardApiProvider {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f21325j = {Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "settingsApi", "getSettingsApi()Lee/mtakso/driver/network/client/settings/SettingsApi;", 0)), Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "orderApi", "getOrderApi()Lee/mtakso/driver/network/client/order/OrderApi;", 0)), Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "fleetApi", "getFleetApi()Lee/mtakso/driver/network/client/fleet/ShardFleetApi;", 0)), Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "driverApi", "getDriverApi()Lee/mtakso/driver/network/client/driver/DriverApi;", 0)), Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "dashboardApi", "getDashboardApi()Lee/mtakso/driver/network/client/dashboard/DashboardApi;", 0)), Reflection.f(new PropertyReference1Impl(ShardApiProvider.class, "driverPriorityApi", "getDriverPriorityApi()Lee/mtakso/driver/network/client/priority/DriverPriorityApi;", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final ApiFactory f21326a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy<OkHttpClient> f21327b;

    /* renamed from: c  reason: collision with root package name */
    private final ShardItemDelegate f21328c;

    /* renamed from: d  reason: collision with root package name */
    private final ShardItemDelegate f21329d;

    /* renamed from: e  reason: collision with root package name */
    private final ShardItemDelegate f21330e;

    /* renamed from: f  reason: collision with root package name */
    private final ShardItemDelegate f21331f;

    /* renamed from: g  reason: collision with root package name */
    private final ShardItemDelegate f21332g;

    /* renamed from: h  reason: collision with root package name */
    private final ShardItemDelegate f21333h;

    /* renamed from: i  reason: collision with root package name */
    private final InvocationHandler f21334i;

    @Inject
    public ShardApiProvider(ApiFactory apiFactory, DriverProvider driverProvider, Lazy<OkHttpClient> authHttpClient) {
        Intrinsics.f(apiFactory, "apiFactory");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(authHttpClient, "authHttpClient");
        this.f21326a = apiFactory;
        this.f21327b = authHttpClient;
        this.f21328c = new ShardItemDelegate(driverProvider, new Function1<String, SettingsApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$settingsApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SettingsApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(SettingsApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, SettingsApi.class, str, null, 8, null);
                }
                return (SettingsApi) d8;
            }
        });
        this.f21329d = new ShardItemDelegate(driverProvider, new Function1<String, OrderApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$orderApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(OrderApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, OrderApi.class, str, null, 8, null);
                }
                return (OrderApi) d8;
            }
        });
        this.f21330e = new ShardItemDelegate(driverProvider, new Function1<String, ShardFleetApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$fleetApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ShardFleetApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(ShardFleetApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, ShardFleetApi.class, str, null, 8, null);
                }
                return (ShardFleetApi) d8;
            }
        });
        this.f21331f = new ShardItemDelegate(driverProvider, new Function1<String, DriverApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$driverApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(DriverApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, DriverApi.class, str, null, 8, null);
                }
                return (DriverApi) d8;
            }
        });
        this.f21332g = new ShardItemDelegate(driverProvider, new Function1<String, DashboardApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$dashboardApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DashboardApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(DashboardApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, DashboardApi.class, str, null, 8, null);
                }
                return (DashboardApi) d8;
            }
        });
        this.f21333h = new ShardItemDelegate(driverProvider, new Function1<String, DriverPriorityApi>() { // from class: ee.mtakso.driver.network.client.ShardApiProvider$driverPriorityApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverPriorityApi invoke(String str) {
                ApiFactory apiFactory2;
                Lazy lazy;
                Object d8;
                ShardApiProvider shardApiProvider = ShardApiProvider.this;
                if (str == null) {
                    d8 = shardApiProvider.e(DriverPriorityApi.class);
                } else {
                    apiFactory2 = shardApiProvider.f21326a;
                    lazy = shardApiProvider.f21327b;
                    Object obj = lazy.get();
                    Intrinsics.e(obj, "authHttpClient.get()");
                    d8 = ApiFactory.d(apiFactory2, (OkHttpClient) obj, DriverPriorityApi.class, str, null, 8, null);
                }
                return (DriverPriorityApi) d8;
            }
        });
        this.f21334i = new InvocationHandler() { // from class: ee.mtakso.driver.network.client.a
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object f8;
                f8 = ShardApiProvider.f(obj, method, objArr);
                return f8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T e(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this.f21334i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object obj, Method method, Object[] objArr) {
        Class<?> returnType = method.getReturnType();
        Intrinsics.e(returnType, "method.returnType");
        Method method2 = returnType.getMethod("error", Throwable.class);
        String name = method.getName();
        return method2.invoke(returnType, new IllegalStateException("Dummy API invoked: " + name));
    }

    public final DashboardApi g() {
        return (DashboardApi) this.f21332g.a(this, f21325j[4]);
    }

    public final DriverApi h() {
        return (DriverApi) this.f21331f.a(this, f21325j[3]);
    }

    public final DriverPriorityApi i() {
        return (DriverPriorityApi) this.f21333h.a(this, f21325j[5]);
    }

    public final ShardFleetApi j() {
        return (ShardFleetApi) this.f21330e.a(this, f21325j[2]);
    }

    public final OrderApi k() {
        return (OrderApi) this.f21329d.a(this, f21325j[1]);
    }

    public final SettingsApi l() {
        return (SettingsApi) this.f21328c.a(this, f21325j[0]);
    }
}
