package com.latico.commons.netty.nettyclient.impl.obj;

import com.latico.commons.common.util.logging.Logger;
import com.latico.commons.common.util.logging.LoggerFactory;
import com.latico.commons.netty.nettyclient.NettyClient;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.Serializable;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-05-24 17:27
 * @version: 1.0
 */
@ChannelHandler.Sharable
public class ObjectClientChannelInboundHandlerImpl extends SimpleChannelInboundHandler<Serializable> {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectClientChannelInboundHandlerImpl.class);
    private NettyClient nettyClient;

    public ObjectClientChannelInboundHandlerImpl(NettyClient nettyClient){
        this.nettyClient = nettyClient;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Serializable msg) {
        LOG.debug("收到数据:{}", msg);

        //如果业务直接在这个方法处理的话，那么这里也可以不加入队列让外界处理
        this.nettyClient.addReceivedData(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOG.info("远端:[{}] 激活", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOG.info("远端:[{}] 失效", ctx.channel().remoteAddress());
        nettyClient.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        LOG.info("远端:[{}] 加入", ctx.channel().remoteAddress());
    }
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        LOG.info("远端:[{}] 离开", ctx.channel().remoteAddress());
        nettyClient.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOG.info("{}发生异常,可能是服务端强制断开导致", cause, ctx.channel().remoteAddress());
        nettyClient.close();
    }
}
