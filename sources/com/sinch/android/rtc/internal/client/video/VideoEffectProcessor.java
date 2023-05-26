package com.sinch.android.rtc.internal.client.video;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.sinch.android.rtc.video.VideoFrame;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.webrtc.EglBase;
import org.webrtc.GlShader;
import org.webrtc.GlUtil;
import org.webrtc.JavaI420Buffer;
import org.webrtc.JniCommon;
import org.webrtc.VideoFrame;
import org.webrtc.g;

/* loaded from: classes3.dex */
public class VideoEffectProcessor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private EglBase rootEglBase;
    private YuvConverter yuvConverter;

    /* loaded from: classes3.dex */
    public static class YuvConverter {
        private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D fboTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(fboTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(fboTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(fboTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(fboTex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
        private static final String FRAGMENT_SHADER_CUSTOM = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nvoid main() {\n     vec3 c = texture2D(oesTex, interp_tc).rgb;\n     c = pow(c, vec3(0.6, 0.6, 0.6));\n     c = c * 3.0;\n     c = floor(c);\n     c = c / 3.0;\n     c = pow(c, vec3(1.0/0.6));\n     gl_FragColor = vec4(c, 1.0);\n}\n";
        private static final String FRAGMENT_SHADER_DEFAULT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nvoid main() {\n     gl_FragColor = texture2D(oesTex, interp_tc).rgba;\n}\n";
        private static final String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
        private static final String VERTEX_SHADER_CUSTOM = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = in_tc.xy;\n}\n";
        private int coeffsLoc;
        private GlShader customShader;
        private GlShader defaultCustomShader;
        private final EglBase eglBase;
        private int fboHeight;
        private int fboWidth;
        private GlShader shader;
        private int texMatrixLoc;
        private int xUnitLoc;
        private static final FloatBuffer DEVICE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        private static final FloatBuffer TEXTURE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        private boolean released = false;
        private int[] fbo = new int[1];
        private int[] offscreenTexture = new int[1];
        private int[] depthRb = new int[1];
        private boolean fboInitialized = false;

        public YuvConverter(EglBase.Context context) {
            EglBase d8 = g.d(context, EglBase.CONFIG_PIXEL_RGBA_BUFFER);
            this.eglBase = d8;
            d8.createDummyPbufferSurface();
            d8.makeCurrent();
            this.shader = new GlShader(VERTEX_SHADER, FRAGMENT_SHADER);
            this.customShader = new GlShader(VERTEX_SHADER_CUSTOM, FRAGMENT_SHADER_CUSTOM);
            this.defaultCustomShader = new GlShader(VERTEX_SHADER_CUSTOM, FRAGMENT_SHADER_DEFAULT);
            d8.detachCurrent();
        }

        private static final float[] horizontalFlipMatrix() {
            return new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
        }

        private static final float[] identityMatrix() {
            return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }

        private void installColorConvertShader() {
            this.shader.useProgram();
            GlUtil.checkNoGLES2Error("Initialize fragment shader.");
            this.texMatrixLoc = this.shader.getUniformLocation("texMatrix");
            this.xUnitLoc = this.shader.getUniformLocation("xUnit");
            this.coeffsLoc = this.shader.getUniformLocation("coeffs");
            GLES20.glUniform1i(this.shader.getUniformLocation("fboTex"), 0);
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            this.shader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
            this.shader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
        }

        private void installCustomShader() {
            this.customShader.useProgram();
            GLES20.glUniform1i(this.customShader.getUniformLocation("oesTex"), 0);
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            this.customShader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
            this.customShader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
        }

        private void installDefaultCustomShader() {
            this.defaultCustomShader.useProgram();
            GLES20.glUniform1i(this.customShader.getUniformLocation("oesTex"), 0);
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            this.defaultCustomShader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
            this.defaultCustomShader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
        }

        private static float[] multiplyMatrices(float[] fArr, float[] fArr2) {
            float[] fArr3 = new float[16];
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            return fArr3;
        }

        private static final float[] verticalFlipMatrix() {
            return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        }

        public VideoFrame.I420Buffer convert(int i8, int i9, int i10, float[] fArr, boolean z7) {
            int i11 = ((i8 + 7) / 8) * 8;
            int i12 = (i9 + 1) / 2;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer((i9 + i12 + 1) * i11);
            convert(nativeAllocateByteBuffer, i8, i9, i11, i10, fArr, z7);
            int i13 = (i11 * i9) + 0;
            int i14 = (i11 / 2) + i13;
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i13);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i13);
            int i15 = i12 * i11;
            nativeAllocateByteBuffer.limit(i13 + i15);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i14);
            nativeAllocateByteBuffer.limit(i14 + i15);
            return JavaI420Buffer.wrap(i8, i9, slice, i11, slice2, i11, nativeAllocateByteBuffer.slice(), i11, new Runnable() { // from class: com.sinch.android.rtc.internal.client.video.VideoEffectProcessor.YuvConverter.1
                @Override // java.lang.Runnable
                public void run() {
                    JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[Catch: all -> 0x014a, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:9:0x0013, B:11:0x0029, B:13:0x003b, B:15:0x0045, B:20:0x005d, B:22:0x0067, B:23:0x006c, B:25:0x0079, B:27:0x0080, B:26:0x007d, B:17:0x004d, B:18:0x0054, B:19:0x0058, B:30:0x012a, B:31:0x0131, B:32:0x0132, B:33:0x0139, B:34:0x013a, B:35:0x0141, B:36:0x0142, B:37:0x0149), top: B:41:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[Catch: all -> 0x014a, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:9:0x0013, B:11:0x0029, B:13:0x003b, B:15:0x0045, B:20:0x005d, B:22:0x0067, B:23:0x006c, B:25:0x0079, B:27:0x0080, B:26:0x007d, B:17:0x004d, B:18:0x0054, B:19:0x0058, B:30:0x012a, B:31:0x0131, B:32:0x0132, B:33:0x0139, B:34:0x013a, B:35:0x0141, B:36:0x0142, B:37:0x0149), top: B:41:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007d A[Catch: all -> 0x014a, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:9:0x0013, B:11:0x0029, B:13:0x003b, B:15:0x0045, B:20:0x005d, B:22:0x0067, B:23:0x006c, B:25:0x0079, B:27:0x0080, B:26:0x007d, B:17:0x004d, B:18:0x0054, B:19:0x0058, B:30:0x012a, B:31:0x0131, B:32:0x0132, B:33:0x0139, B:34:0x013a, B:35:0x0141, B:36:0x0142, B:37:0x0149), top: B:41:0x0009 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void convert(java.nio.ByteBuffer r17, int r18, int r19, int r20, int r21, float[] r22, boolean r23) {
            /*
                Method dump skipped, instructions count: 333
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sinch.android.rtc.internal.client.video.VideoEffectProcessor.YuvConverter.convert(java.nio.ByteBuffer, int, int, int, int, float[], boolean):void");
        }

        public void initFramebuffer(int i8, int i9) {
            GLES20.glGenFramebuffers(1, this.fbo, 0);
            GLES20.glBindFramebuffer(36160, this.fbo[0]);
            GLES20.glGenTextures(1, this.offscreenTexture, 0);
            GLES20.glBindTexture(3553, this.offscreenTexture[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexImage2D(3553, 0, 32854, i8, i9, 0, 6408, 5121, null);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.offscreenTexture[0], 0);
            GLES20.glGenRenderbuffers(1, this.depthRb, 0);
            GLES20.glBindRenderbuffer(36161, this.depthRb[0]);
            GLES20.glRenderbufferStorage(36161, 33189, i8, i9);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthRb[0]);
            if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
                throw new RuntimeException("Error creating FBO");
            }
        }

        public synchronized void release() {
            this.released = true;
            this.eglBase.makeCurrent();
            this.shader.release();
            this.eglBase.release();
        }
    }

    public VideoEffectProcessor(EglBase eglBase) {
        this.rootEglBase = eglBase;
    }

    private static native int convertI420toNV21(long j8, long j9, long j10, int i8, int i9, int i10, long j11, long j12, int i11, int i12, int i13, int i14);

    public static com.sinch.android.rtc.video.VideoFrame convertI420toNv21(com.sinch.android.rtc.video.VideoFrame videoFrame) {
        int width = ((videoFrame.width() + 15) >> 4) << 4;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((videoFrame.height() * width) * 3) / 2);
        allocateDirect.position(videoFrame.height() * width);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(0);
        VideoFrame.DefaultVideoFrame defaultVideoFrame = new VideoFrame.DefaultVideoFrame(new ByteBuffer[]{allocateDirect, slice}, new int[]{width, width, width}, videoFrame.width(), videoFrame.height(), videoFrame.getRotation(), 17);
        convertI420toNV21(getBufferAddress(videoFrame.yuvPlanes()[0]), getBufferAddress(videoFrame.yuvPlanes()[1]), getBufferAddress(videoFrame.yuvPlanes()[2]), videoFrame.yuvStrides()[0], videoFrame.yuvStrides()[1], videoFrame.yuvStrides()[2], getBufferAddress(allocateDirect), getBufferAddress(slice), width, width, videoFrame.width(), videoFrame.height());
        return defaultVideoFrame;
    }

    private static native int convertNV21toI420(long j8, long j9, int i8, int i9, long j10, long j11, long j12, int i10, int i11, int i12, int i13, int i14);

    public static com.sinch.android.rtc.video.VideoFrame convertNv21ToI420(com.sinch.android.rtc.video.VideoFrame videoFrame) {
        int width = ((videoFrame.width() + 15) >> 4) << 4;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((videoFrame.height() * width) * 3) / 2);
        allocateDirect.position(videoFrame.height() * width);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(0);
        int i8 = width / 2;
        slice.position((videoFrame.height() * i8) / 2);
        ByteBuffer slice2 = slice.slice();
        slice.position(0);
        VideoFrame.DefaultVideoFrame defaultVideoFrame = new VideoFrame.DefaultVideoFrame(new ByteBuffer[]{allocateDirect, slice, slice2}, new int[]{width, i8, i8}, videoFrame.width(), videoFrame.height(), videoFrame.getRotation(), 35);
        convertNV21toI420(getBufferAddress(videoFrame.yuvPlanes()[0]), getBufferAddress(videoFrame.yuvPlanes()[1]), videoFrame.yuvStrides()[0], videoFrame.yuvStrides()[1], getBufferAddress(defaultVideoFrame.yuvPlanes()[0]), getBufferAddress(defaultVideoFrame.yuvPlanes()[1]), getBufferAddress(defaultVideoFrame.yuvPlanes()[2]), width, i8, i8, videoFrame.width(), videoFrame.height());
        return defaultVideoFrame;
    }

    private static long getBufferAddress(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() ? getByteArrayAddressNative(byteBuffer.array()) + byteBuffer.arrayOffset() : getByteBufferAddressNative(byteBuffer);
    }

    private static native long getByteArrayAddressNative(byte[] bArr);

    private static native long getByteBufferAddressNative(ByteBuffer byteBuffer);

    private YuvConverter getYuvConverter() {
        YuvConverter yuvConverter;
        YuvConverter yuvConverter2 = this.yuvConverter;
        if (yuvConverter2 != null) {
            return yuvConverter2;
        }
        synchronized (this) {
            if (this.yuvConverter == null) {
                this.yuvConverter = new YuvConverter(this.rootEglBase.getEglBaseContext());
            }
            yuvConverter = this.yuvConverter;
        }
        return yuvConverter;
    }

    public org.webrtc.VideoFrame convertTextureToBuffer(org.webrtc.VideoFrame videoFrame) {
        return new org.webrtc.VideoFrame(videoFrame.getBuffer().toI420(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }
}
