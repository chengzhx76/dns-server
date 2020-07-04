package com.github.chengzhx76.dns.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Description
 * @Author admin
 * @Date 2020/3/10 18:41
 * @Version 3.0
 */
public class DnsServer {


    public static void main(String[] args) throws InterruptedException {
        /*EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioDatagramChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ServerInitializer())
                    .option(ChannelOption.SO_BROADCAST, true);

            ChannelFuture dns = bootstrap.bind(53);
            ChannelFuture http = bootstrap.bind(8089);

            dns.channel().closeFuture().sync();
            http.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }*/

        /*final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        final EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            final ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .channel(NioServerSocketChannel.class)
				    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ServerInitializer());

            final Channel channel = bootstrap.bind(8089).sync().channel();
            System.out.println("start---->");
            channel.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }*/
    }

}
