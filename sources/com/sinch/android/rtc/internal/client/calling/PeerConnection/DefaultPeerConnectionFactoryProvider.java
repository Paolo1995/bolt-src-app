package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.VideoCodecInfo;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public class DefaultPeerConnectionFactoryProvider implements PeerConnectionFactoryProvider, Executor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Context mContext;
    private final boolean mEnableVideo;
    private final ScheduledExecutorService mExecutor;
    private FutureTask<PeerConnectionFactoryWrapper> mFuturePeerConnectionFactoryWrapper;
    private boolean mIsClosing = false;
    private static final String TAG = DefaultPeerConnectionFactoryProvider.class.getSimpleName();
    private static int sRefCnt = 0;
    private static boolean isPeerConnectionFactoryInitialized = false;
    private static EglBase rootEglBase = getRootEglBase();

    private DefaultPeerConnectionFactoryProvider(Context context, boolean z7) {
        this.mContext = context;
        this.mEnableVideo = z7;
        String str = TAG;
        Log.d(str, "Attempting to create PeerConnectionFactory, wrapper's sRefCnt = " + sRefCnt);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mExecutor = newSingleThreadScheduledExecutor;
        FutureTask<PeerConnectionFactoryWrapper> futurePeerConnectionFactory = getFuturePeerConnectionFactory();
        this.mFuturePeerConnectionFactoryWrapper = futurePeerConnectionFactory;
        newSingleThreadScheduledExecutor.execute(futurePeerConnectionFactory);
    }

    public static synchronized PeerConnectionFactoryProvider createDefaultPeerConnectionFactoryWrapper(Context context, boolean z7) {
        DefaultPeerConnectionFactoryProvider defaultPeerConnectionFactoryProvider;
        synchronized (DefaultPeerConnectionFactoryProvider.class) {
            sRefCnt++;
            defaultPeerConnectionFactoryProvider = new DefaultPeerConnectionFactoryProvider(context, z7);
        }
        return defaultPeerConnectionFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: disposeInternal */
    public void lambda$dispose$1() {
        int i8 = sRefCnt - 1;
        sRefCnt = i8;
        this.mIsClosing = true;
        if (i8 == 0) {
            this.mExecutor.shutdown();
            rootEglBase.release();
            rootEglBase = null;
            Log.d(TAG, "PeerConnectionFactoryWrapper disposed: exeture shut down, root EglBase released.");
        }
    }

    private FutureTask<PeerConnectionFactoryWrapper> getFuturePeerConnectionFactory() {
        return new FutureTask<>(new Callable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                PeerConnectionFactoryWrapper lambda$getFuturePeerConnectionFactory$0;
                lambda$getFuturePeerConnectionFactory$0 = DefaultPeerConnectionFactoryProvider.this.lambda$getFuturePeerConnectionFactory$0();
                return lambda$getFuturePeerConnectionFactory$0;
            }
        });
    }

    public static EglBase getRootEglBase() {
        if (rootEglBase == null) {
            try {
                rootEglBase = org.webrtc.g.b();
            } catch (RuntimeException e8) {
                if (!e8.getMessage().equals("Stub!")) {
                    throw e8;
                }
            }
        }
        return rootEglBase;
    }

    public static synchronized void initializePeerConnectionFactoryIfNeeded(Context context) {
        synchronized (DefaultPeerConnectionFactoryProvider.class) {
            if (!isPeerConnectionFactoryInitialized) {
                Log.d(TAG, "Initializing PeerConnectionFactory (WebRTC)");
                isPeerConnectionFactoryInitialized = true;
                PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials("").setEnableInternalTracer(false).setNativeLibraryName("sinch-android-rtc").createInitializationOptions());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryWrapper lambda$getFuturePeerConnectionFactory$0() throws java.lang.Exception {
        /*
            r8 = this;
            java.lang.String r0 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.TAG
            java.lang.String r1 = "Attempting to create PeerConnectionFactory: (inside mExecutor):"
            android.util.Log.d(r0, r1)
            android.content.Context r1 = r8.mContext
            initializePeerConnectionFactoryIfNeeded(r1)
            boolean r1 = r8.mEnableVideo
            if (r1 == 0) goto L15
            com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionParameters r1 = com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionParameters.getDefaultPeerConnectionParameters()
            goto L19
        L15:
            com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionParameters r1 = com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionParameters.getDefaultAudioPeerConnectionParameters()
        L19:
            com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionUtils.setupAudioProcessing(r1)
            org.webrtc.PeerConnectionFactory$Options r1 = new org.webrtc.PeerConnectionFactory$Options
            r1.<init>()
            r2 = 0
            r1.networkIgnoreMask = r2
            org.webrtc.audio.AudioDeviceModule r3 = r8.createJavaAudioDevice()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Factory networkIgnoreMask option: "
            r4.append(r5)
            int r5 = r1.networkIgnoreMask
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r0, r4)
            r4 = 0
            r5 = 1
            java.lang.String r6 = "Peer connection will attempt to use HW codec factories."
            android.util.Log.d(r0, r6)     // Catch: java.lang.Throwable -> L77
            org.webrtc.HardwareVideoEncoderFactory r0 = new org.webrtc.HardwareVideoEncoderFactory     // Catch: java.lang.Throwable -> L77
            org.webrtc.EglBase r6 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.rootEglBase     // Catch: java.lang.Throwable -> L77
            org.webrtc.EglBase$Context r6 = r6.getEglBaseContext()     // Catch: java.lang.Throwable -> L77
            r0.<init>(r6, r2, r5)     // Catch: java.lang.Throwable -> L77
            org.webrtc.HardwareVideoDecoderFactory r6 = new org.webrtc.HardwareVideoDecoderFactory     // Catch: java.lang.Throwable -> L75
            org.webrtc.EglBase r7 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.rootEglBase     // Catch: java.lang.Throwable -> L75
            org.webrtc.EglBase$Context r7 = r7.getEglBaseContext()     // Catch: java.lang.Throwable -> L75
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L75
            org.webrtc.VideoCodecInfo[] r4 = r0.getSupportedCodecs()     // Catch: java.lang.Throwable -> L72
            boolean r4 = r8.has264Codec(r4)     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L73
            org.webrtc.VideoCodecInfo[] r4 = r6.getSupportedCodecs()     // Catch: java.lang.Throwable -> L72
            boolean r4 = r8.has264Codec(r4)     // Catch: java.lang.Throwable -> L72
            if (r4 != 0) goto L70
            goto L73
        L70:
            r4 = 0
            goto L7b
        L72:
        L73:
            r4 = r6
            goto L79
        L75:
            goto L79
        L77:
            r0 = r4
        L79:
            r6 = r4
            r4 = 1
        L7b:
            if (r4 == 0) goto L9a
            java.lang.String r0 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.TAG
            java.lang.String r6 = "HW Codec factories do not expose required codecs - falling back to SW codec factories."
            android.util.Log.d(r0, r6)
            org.webrtc.DefaultVideoEncoderFactory r0 = new org.webrtc.DefaultVideoEncoderFactory
            org.webrtc.EglBase r6 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.rootEglBase
            org.webrtc.EglBase$Context r6 = r6.getEglBaseContext()
            r0.<init>(r6, r2, r5)
            org.webrtc.DefaultVideoDecoderFactory r6 = new org.webrtc.DefaultVideoDecoderFactory
            org.webrtc.EglBase r2 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.rootEglBase
            org.webrtc.EglBase$Context r2 = r2.getEglBaseContext()
            r6.<init>(r2)
        L9a:
            org.webrtc.PeerConnectionFactory$Builder r2 = org.webrtc.PeerConnectionFactory.builder()
            org.webrtc.PeerConnectionFactory$Builder r1 = r2.setOptions(r1)
            org.webrtc.PeerConnectionFactory$Builder r1 = r1.setAudioDeviceModule(r3)
            org.webrtc.PeerConnectionFactory$Builder r1 = r1.setVideoEncoderFactory(r0)
            org.webrtc.PeerConnectionFactory$Builder r1 = r1.setVideoDecoderFactory(r6)
            org.webrtc.PeerConnectionFactory r1 = r1.createPeerConnectionFactory()
            java.lang.String r2 = com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.TAG
            java.lang.String r7 = "Peer connection factory created."
            android.util.Log.d(r2, r7)
            r3.release()
            com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryWrapper r2 = new com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryWrapper
            org.webrtc.VideoCodecInfo[] r0 = r0.getSupportedCodecs()
            org.webrtc.VideoCodecInfo[] r3 = r6.getSupportedCodecs()
            r4 = r4 ^ r5
            r2.<init>(r1, r0, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.lambda$getFuturePeerConnectionFactory$0():com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryWrapper");
    }

    public AudioDeviceModule createJavaAudioDevice() {
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.1
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordError(String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioRecordError: " + str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordInitError(String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioRecordInitError: " + str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioRecordStartError: " + audioRecordStartErrorCode + ". " + str);
            }
        };
        return JavaAudioDeviceModule.builder(this.mContext).setAudioRecordErrorCallback(audioRecordErrorCallback).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider.2
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackError(String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioTrackError: " + str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackInitError(String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioTrackInitError: " + str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
                String str2 = DefaultPeerConnectionFactoryProvider.TAG;
                Log.e(str2, "onWebRtcAudioTrackStartError: " + audioTrackStartErrorCode + ". " + str);
            }
        }).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).createAudioDeviceModule();
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider
    public void dispose() {
        String str = TAG;
        Log.d(str, "Attempting to dispose PeerConnectionFactory, sRefCnt = " + sRefCnt);
        synchronized (DefaultPeerConnectionFactoryProvider.class) {
            this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.c0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultPeerConnectionFactoryProvider.this.lambda$dispose$1();
                }
            });
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this) {
            if (!this.mIsClosing) {
                this.mExecutor.execute(runnable);
            }
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider
    public EglBase getEglRootContext() {
        return rootEglBase;
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider
    public ScheduledExecutorService getExecutor() {
        return this.mExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider
    public PeerConnectionFactoryWrapper getFactoryWrapper() {
        String str;
        StringBuilder sb;
        String str2;
        PeerConnectionFactoryWrapper peerConnectionFactoryWrapper;
        String str3 = TAG;
        Log.d(str3, "Attempting to getFactory, futuret task  = " + this.mFuturePeerConnectionFactoryWrapper);
        try {
            peerConnectionFactoryWrapper = this.mFuturePeerConnectionFactoryWrapper.get();
        } catch (InterruptedException e8) {
            e = e8;
        } catch (ExecutionException e9) {
            e = e9;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Acquired factory: ");
            sb2.append(peerConnectionFactoryWrapper != 0 ? peerConnectionFactoryWrapper.getFactory() : null);
            Log.d(str3, sb2.toString());
            return peerConnectionFactoryWrapper;
        } catch (InterruptedException e10) {
            e = e10;
            r1 = peerConnectionFactoryWrapper;
            str = TAG;
            sb = new StringBuilder();
            str2 = "Failed to getFactory, InterruptedException: ";
            sb.append(str2);
            sb.append(e.toString());
            Log.e(str, sb.toString());
            e.printStackTrace();
            return r1;
        } catch (ExecutionException e11) {
            e = e11;
            r1 = peerConnectionFactoryWrapper;
            str = TAG;
            sb = new StringBuilder();
            str2 = "Failed to getFactory, ExecutionException: ";
            sb.append(str2);
            sb.append(e.toString());
            Log.e(str, sb.toString());
            e.printStackTrace();
            return r1;
        }
    }

    public boolean has264Codec(VideoCodecInfo[] videoCodecInfoArr) {
        for (VideoCodecInfo videoCodecInfo : videoCodecInfoArr) {
            String str = videoCodecInfo.name;
            if (str != null && str.toLowerCase().contains("h264")) {
                return true;
            }
        }
        return false;
    }
}
