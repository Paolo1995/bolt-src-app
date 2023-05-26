package ee.mtakso.driver.network.client.tile;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import ee.mtakso.driver.network.client.tile.TileClient;
import ee.mtakso.driver.network.client.tile.TileVariant;
import ee.mtakso.driver.network.internal.MediaTypes;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.driver.maps.tile.mvt.MvtTile;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: TileClient.kt */
/* loaded from: classes3.dex */
public final class TileClient {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f22866a;

    /* renamed from: b  reason: collision with root package name */
    private final UrlFactory f22867b;

    @Inject
    public TileClient(OkHttpClient okhttp, UrlFactory urlFactory) {
        Intrinsics.f(okhttp, "okhttp");
        Intrinsics.f(urlFactory, "urlFactory");
        this.f22866a = okhttp;
        this.f22867b = urlFactory;
    }

    private final TileVariant b(Response response) {
        if (response.code() == 204) {
            return TileVariant.Empty.f22870a;
        }
        ResponseBody body = response.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            MediaTypes mediaTypes = MediaTypes.f22978a;
            if (Intrinsics.a(contentType, mediaTypes.c())) {
                return new TileVariant.Raster(body.bytes());
            }
            if (Intrinsics.a(contentType, mediaTypes.a())) {
                return new TileVariant.Mvt(MvtTile.f41536c.a(body.bytes()));
            }
            throw new RuntimeException("Unsupported Content Type: " + body + ".contentType()");
        }
        throw new RuntimeException("Empty tile response body");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TileVariant d(TileClient this$0, String collectionId, int i8, int i9, int i10) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(collectionId, "$collectionId");
        return this$0.b(FirebasePerfOkHttpClient.execute(this$0.f22866a.newCall(new Request.Builder().url(this$0.f22867b.p(collectionId, i8, i9, i10)).build())));
    }

    public final Single<TileVariant> c(final String collectionId, final int i8, final int i9, final int i10) {
        Intrinsics.f(collectionId, "collectionId");
        Single<TileVariant> u7 = Single.u(new Callable() { // from class: w1.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TileVariant d8;
                d8 = TileClient.d(TileClient.this, collectionId, i8, i9, i10);
                return d8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …tTile(response)\n        }");
        return u7;
    }
}
