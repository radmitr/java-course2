package io_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 13. Channel и Buffer. Важные методы */
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
public class ChannelBufferEx2 {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("test5.txt", "r");
             FileChannel channel = file.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer); // write 5 bytes to the buffer from the channel (position = 5)
            buffer.flip(); // buffer write mode -> buffer read mode (limit = position, position = 0)
            System.out.println((char)buffer.get()); // >> "a" (position = 1)
            System.out.println((char)buffer.get()); // >> "b" (position = 2)
            System.out.println((char)buffer.get()); // >> "c" (position = 3)

            // 1 - rewind()
            // rewind, position is set to zero and the mark is discarded. Stay at buffer read mode (position = 0)
            buffer.rewind();
            System.out.println((char)buffer.get()); // >> "a" (position = 1)

            System.out.println("-----------------------------------------");

            // 2 - compact()
            // buffer read mode -> buffer write mode (limit = capacity = 4, position = 5 - 1 = 4),
            // almost as clear(), the bytes between the buffer's current position and its limit,
            // if any, are copied to the beginning of the buffer;
            buffer.compact();
            // write 1 byte to the buffer from the channel (position = 5)
            channel.read(buffer);
            // buffer write mode -> buffer read mode (limit = position, position = 0)
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get()); // >> "b", >> "c", >> "d", >> "e", >> "f" (position = 5)
            }

            System.out.println("-----------------------------------------");

            // 3 - mark(), reset()
            // buffer read mode -> buffer write mode (limit = capacity, position = 0)
            buffer.clear();
            // write last 4 bytes to the buffer from the channel (position = 4)
            channel.read(buffer);
            // buffer write mode -> buffer read mode (limit = position = 4, position = 0)
            buffer.flip();
            System.out.println((char)buffer.get()); // >> "g" (position = 1)
            // set this buffer's mark at its position (mark = position = 1)
            buffer.mark();
            System.out.println((char)buffer.get()); // >> "h" (position = 2)
            System.out.println((char)buffer.get()); // >> "i" (position = 3)
            // reset this buffer's position to the previously-marked position (position = mark = 1)
            buffer.reset();
            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get()); // >> "h", >> "i", >> "j" (position = 4)
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
