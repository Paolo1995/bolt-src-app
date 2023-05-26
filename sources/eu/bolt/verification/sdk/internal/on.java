package eu.bolt.verification.sdk.internal;

import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class on {
    private MediaType a(File file) {
        String name = file.getName();
        String str = "image/png";
        if (!name.endsWith(".png")) {
            if (name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                str = "image/jpeg";
            } else {
                Timber.b("unexpected file extension%s", file.getPath());
            }
        }
        return MediaType.parse(str);
    }

    public MultipartBody.Part b(File file) {
        return MultipartBody.Part.createFormData(hc.PART_IMAGE.c(), file.getName(), RequestBody.create(a(file), file));
    }
}
