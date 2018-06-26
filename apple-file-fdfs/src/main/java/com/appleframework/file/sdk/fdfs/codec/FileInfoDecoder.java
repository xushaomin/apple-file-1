package com.appleframework.file.sdk.fdfs.codec;

import com.appleframework.file.sdk.fdfs.FastdfsUtils;
import com.appleframework.file.sdk.fdfs.FileInfo;
import com.appleframework.file.sdk.fdfs.exchange.Replier;
import io.netty.buffer.ByteBuf;

/**
 * @author siuming
 */
public enum FileInfoDecoder implements Replier.Decoder<FileInfo> {

    INSTANCE;

    @Override
    public FileInfo decode(ByteBuf buf) {
        long fileSize = buf.readLong();
        long createTime = buf.readLong();
        long crc32 = buf.readLong();
        String address = FastdfsUtils.readString(buf, 16);
        return FileInfo.newBuilder()
                        .fileSize(fileSize)
                        .createTime(createTime)
                        .crc32(crc32)
                        .address(address)
                        .build();
    }
}
