package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import j$.util.Spliterator;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/* loaded from: classes3.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, Uri uri2, int i8, int i9, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i8;
        this.mRequiredHeight = i9;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        int i8;
        if (bitmap != null) {
            i8 = bitmap.getByteCount();
        } else {
            i8 = 0;
        }
        if (i8 <= MAX_BITMAP_SIZE) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    private void copyFile(@NonNull Uri uri, Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        Log.d(TAG, "copyFile");
        if (uri2 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.mContext.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                    try {
                        if (inputStream != null) {
                            byte[] bArr = new byte[Spliterator.IMMUTABLE];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    BitmapLoadUtils.close(fileOutputStream2);
                                    BitmapLoadUtils.close(inputStream);
                                    this.mInputUri = this.mOutputUri;
                                    return;
                                }
                            }
                        } else {
                            throw new NullPointerException("InputStream for given input Uri is null");
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        BitmapLoadUtils.close(fileOutputStream);
                        BitmapLoadUtils.close(inputStream);
                        this.mInputUri = this.mOutputUri;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } else {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
    }

    private void downloadFile(@NonNull Uri uri, Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        Response execute;
        BufferedSource source;
        Log.d(TAG, "downloadFile");
        if (uri2 != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            BufferedSource bufferedSource = null;
            try {
                execute = FirebasePerfOkHttpClient.execute(okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()));
                try {
                    source = execute.body().source();
                } catch (Throwable th) {
                    th = th;
                    response = execute;
                    closeable = null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                response = null;
            }
            try {
                OutputStream openOutputStream = this.mContext.getContentResolver().openOutputStream(uri2);
                if (openOutputStream != null) {
                    Sink g8 = Okio.g(openOutputStream);
                    source.e1(g8);
                    BitmapLoadUtils.close(source);
                    BitmapLoadUtils.close(g8);
                    BitmapLoadUtils.close(execute.body());
                    okHttpClient.dispatcher().cancelAll();
                    this.mInputUri = this.mOutputUri;
                    return;
                }
                throw new NullPointerException("OutputStream for given output Uri is null");
            } catch (Throwable th3) {
                th = th3;
                response = execute;
                closeable = null;
                bufferedSource = source;
                BitmapLoadUtils.close(bufferedSource);
                BitmapLoadUtils.close(closeable);
                if (response != null) {
                    BitmapLoadUtils.close(response.body());
                }
                okHttpClient.dispatcher().cancelAll();
                this.mInputUri = this.mOutputUri;
                throw th;
            }
        }
        throw new NullPointerException("Output Uri is null - cannot download image");
    }

    private void processInputUri() throws NullPointerException, IOException {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            if ("content".equals(scheme)) {
                try {
                    copyFile(this.mInputUri, this.mOutputUri);
                    return;
                } catch (IOException | NullPointerException e8) {
                    Log.e(TAG, "Copying failed", e8);
                    throw e8;
                }
            } else if (!"file".equals(scheme)) {
                Log.e(TAG, "Invalid Uri scheme " + scheme);
                throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
            } else {
                return;
            }
        }
        try {
            downloadFile(this.mInputUri, this.mOutputUri);
        } catch (IOException | NullPointerException e9) {
            Log.e(TAG, "Downloading failed", e9);
            throw e9;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream openInputStream;
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z7 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z7) {
                try {
                    openInputStream = this.mContext.getContentResolver().openInputStream(this.mInputUri);
                } catch (IOException e8) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e8);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e8));
                } catch (OutOfMemoryError e9) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e9);
                    options.inSampleSize *= 2;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        BitmapLoadUtils.close(openInputStream);
                        if (!checkSize(bitmap, options)) {
                            z7 = true;
                        }
                    } else {
                        return new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                    }
                } finally {
                    BitmapLoadUtils.close(openInputStream);
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
            Matrix matrix = new Matrix();
            if (exifToDegrees != 0) {
                matrix.preRotate(exifToDegrees);
            }
            if (exifToTranslation != 1) {
                matrix.postScale(exifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
            }
            return new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e10) {
            return new BitmapWorkerResult(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc == null) {
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            String path = this.mInputUri.getPath();
            Uri uri = this.mOutputUri;
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, path, uri == null ? null : uri.getPath());
            return;
        }
        this.mBitmapLoadCallback.onFailure(exc);
    }

    /* loaded from: classes3.dex */
    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(@NonNull Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
