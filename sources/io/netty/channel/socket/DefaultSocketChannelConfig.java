package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: classes5.dex */
public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    protected final Socket javaSocket;

    public DefaultSocketChannelConfig(SocketChannel socketChannel, Socket socket) {
        super(socketChannel);
        this.javaSocket = (Socket) ObjectUtil.checkNotNull(socket, "javaSocket");
        if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
            try {
                setTcpNoDelay(true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        if (channelOption == ChannelOption.TCP_NODELAY) {
            return (T) Boolean.valueOf(isTcpNoDelay());
        }
        if (channelOption == ChannelOption.SO_KEEPALIVE) {
            return (T) Boolean.valueOf(isKeepAlive());
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (channelOption == ChannelOption.SO_LINGER) {
            return (T) Integer.valueOf(getSoLinger());
        }
        if (channelOption == ChannelOption.IP_TOS) {
            return (T) Integer.valueOf(getTrafficClass());
        }
        if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            return (T) Boolean.valueOf(isAllowHalfClosure());
        }
        return (T) super.getOption(channelOption);
    }

    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return this.javaSocket.getSoLinger();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    public boolean isKeepAlive() {
        try {
            return this.javaSocket.getKeepAlive();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public boolean isTcpNoDelay() {
        try {
            return this.javaSocket.getTcpNoDelay();
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public SocketChannelConfig setAllowHalfClosure(boolean z7) {
        this.allowHalfClosure = z7;
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setKeepAlive(boolean z7) {
        try {
            this.javaSocket.setKeepAlive(z7);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t7) {
        validate(channelOption, t7);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t7).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t7).intValue());
            return true;
        } else if (channelOption == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) t7).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) t7).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t7).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t7).intValue());
            return true;
        } else if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t7).intValue());
            return true;
        } else if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t7).booleanValue());
            return true;
        } else {
            return super.setOption(channelOption, t7);
        }
    }

    public SocketChannelConfig setReceiveBufferSize(int i8) {
        try {
            this.javaSocket.setReceiveBufferSize(i8);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public SocketChannelConfig setReuseAddress(boolean z7) {
        try {
            this.javaSocket.setReuseAddress(z7);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public SocketChannelConfig setSendBufferSize(int i8) {
        try {
            this.javaSocket.setSendBufferSize(i8);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public SocketChannelConfig setSoLinger(int i8) {
        try {
            if (i8 < 0) {
                this.javaSocket.setSoLinger(false, 0);
            } else {
                this.javaSocket.setSoLinger(true, i8);
            }
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTcpNoDelay(boolean z7) {
        try {
            this.javaSocket.setTcpNoDelay(z7);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    public SocketChannelConfig setTrafficClass(int i8) {
        try {
            this.javaSocket.setTrafficClass(i8);
            return this;
        } catch (SocketException e8) {
            throw new ChannelException(e8);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setAutoClose(boolean z7) {
        super.setAutoClose(z7);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setAutoRead(boolean z7) {
        super.setAutoRead(z7);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setConnectTimeoutMillis(int i8) {
        super.setConnectTimeoutMillis(i8);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    @Deprecated
    public SocketChannelConfig setMaxMessagesPerRead(int i8) {
        super.setMaxMessagesPerRead(i8);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setWriteBufferHighWaterMark(int i8) {
        super.setWriteBufferHighWaterMark(i8);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setWriteBufferLowWaterMark(int i8) {
        super.setWriteBufferLowWaterMark(i8);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig
    public SocketChannelConfig setWriteSpinCount(int i8) {
        super.setWriteSpinCount(i8);
        return this;
    }
}
