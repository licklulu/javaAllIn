package NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOCopy {
public static void main(String[] args) {
    //1.创建channel对象
    try ( FileChannel srcchannel= FileChannel.open(Paths.get("E:/test.txt"), StandardOpenOption.READ);
            FileChannel targetChannel=FileChannel.open(Paths.get("E:/test1.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE)
            ){
        //FileChannel channel=Files.newByteChannel(Paths.get("E:/test.txt"), StandardOpenOption.READ);
        //读取Channel内容
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int flag=srcchannel.read(buffer);
        while(flag!=-1){
            buffer.flip();//切换写模式到读模式
            targetChannel.write(buffer);
            buffer.clear();
            flag=srcchannel.read(buffer);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    
}
}
