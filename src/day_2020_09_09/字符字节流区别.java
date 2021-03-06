package day_2020_09_09;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 20:20
 * @Description:
 * @version: 1.0
 */
public class 字符字节流区别 {
    //字节流:io流中字节流是万能的,任何格式的都可以用字节流
    //字符流:如果是纯文本的话,可以用字符流,效率比较高,使用字符流的时候,用bufferedReader比较多,因为该流可以读取一整行数据
    /**
     * outPutStreamWriter,InPutStreamReader包装类,在进行操作的时候,只能包装可以转换为字符流的字节流,因为在其进行缓存操作的时候是char数组,对于图片的字节
     * 在char数组缓存中很容易乱码
     *
     *
     * 中文在进行传输的时候,可以转换成字符,但是必须要对的上,有的中文是两个字节,有的是三个字节,中文的字节是没有办法确定的,所以,最好使用字节流
     *
     *
     * 如果一个纯文本中只有英文字符,中文等,可以用字符流
     * 但是如果一个文本中,有英文,有中文,有图片,视频等,就必须要用字节流,字符流处理视频是会乱码的
     */
}
