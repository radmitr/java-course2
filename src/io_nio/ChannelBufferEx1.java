package io_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 11. Введение в Channel и Buffer. Чтение из файла */
/* 12. Channel и Buffer. Запись в файл */
/**
    ----------------------
     Buffers and Channels
    ----------------------
    Buffer – Это блок памяти, в который мы можем записывать информацию, а также читать её.

    В отличии от стримов Channel может как читать файл, так и записывать в него.

    Чтении файла: Channel читает информацию из файла и записываетв Buffer.
    Запись в файл: Channel читает информацию из Buffer и записывает её в файл.

    FileChannel channel = file.getChannel();
    ByteBuffer buffer = ByteBuffer.allocate(100);

    Методы: channel.read(buffer), buffer.flip(), buffer.hasRemaining(), buffer.get(), buffer.clear(),
            buffer.put(...), channel.write(buffer), buffer.rewind(), buffer.compact(), buffer.mark(),
            buffer.reset().
*/
public class ChannelBufferEx1 {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("test10.txt", "rw");
             FileChannel channel = file.getChannel();) {

            /* ------------- 11. Введение в Channel и Buffer. Чтение из файла ------------- */
            // allocate(), read(), flip(), hasRemaining(), clear(), read()
            ByteBuffer buffer = ByteBuffer.allocate(25); // capacity->, position->, limit->
            StringBuilder verse = new StringBuilder();

            // write a number of bytes to the buffer from the channel (update position)
            int byteRead = channel.read(buffer);
            while (byteRead > 0) {
                System.out.println("Read " + byteRead);

                // buffer write mode -> buffer read mode (limit = position, position = 0)
                buffer.flip();
                while (buffer.hasRemaining()) { // until position <= limit
                    // read one byte from the buffer (increment position)
                    verse.append((char)buffer.get());
                }

                // buffer read mode -> buffer write mode (limit = capacity, position = 0)
                buffer.clear();
                // write a number of bytes to the buffer from the channel (update position)
                byteRead = channel.read(buffer);

            }

            System.out.println(verse);

            /* ------------- 12. Channel и Buffer. Запись в файл -------------- */
            String text = "\nThere are only two ways to live your life." +
                    "One is as though nothing is a miracle. The other is as" +
                    "though everything is a miracle.";
            // 1 - allocate(), put(), flip(), write()
//            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length);
//            // write all bytes to the buffer from string (update position)
//            buffer2.put(text.getBytes());
//            // buffer write mode -> buffer read mode (limit = position, position = 0)
//            buffer2.flip();
//            channel.write(buffer2);

            // 2 - wrap(), write()
            // wrap == allocate + put + flip
            ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes());
            channel.write(buffer2);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
