package com.github.chengzhx76.dns.server;

import com.github.chengzhx76.dns.server.handler.DnsServerHandler;
import com.github.chengzhx76.dns.server.handler.HttpServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.dns.DatagramDnsQueryDecoder;
import io.netty.handler.codec.dns.DatagramDnsResponseEncoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Description
 * @Author admin
 * @Date 2020/3/10 18:56
 * @Version 3.0
 */
public class ServerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new DatagramDnsQueryDecoder());
        pipeline.addLast(new DatagramDnsResponseEncoder());
        pipeline.addLast(new DnsServerHandler());
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpServerHandler());
    }
}
