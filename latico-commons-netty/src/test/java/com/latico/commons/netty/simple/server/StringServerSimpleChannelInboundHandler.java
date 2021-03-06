package com.latico.commons.netty.simple.server;

import com.latico.commons.netty.NettyTcpUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
public class StringServerSimpleChannelInboundHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = NettyTcpUtils.getChannel(ctx);
        channel.writeAndFlush("Login authentication\n" +
                "\n" +
                "\n" +
                "Username:");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        Channel incoming = NettyTcpUtils.getChannel(ctx);
        System.out.println("**" + incoming.remoteAddress() + " 发来: " + msg);
        // System.out.println("server: " + msg);
        NettyTcpUtils.writeAndFlush(incoming, "服务端的回复: " + msg + ">");
    }
}
