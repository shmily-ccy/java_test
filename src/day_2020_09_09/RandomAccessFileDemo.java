package day_2020_09_09;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Auther: ccy
 * @Date: 2020/9/14 - 12:39
 * @Description:随机访问文件
 * @version: 1.0
 */
public class RandomAccessFileDemo {
    /**
     * 分块读取文件,文件特别大,所以进行分块读取
     * @param args
     */
    public static void main(String[] args) {
        File file=new File("doc.txt");
        //整个文件的大小
        long length = file.length();
        //规定块的大小
        int blockSize=1024;
        //确定一下文件可以切分成多少块,长度不可能是1024的整数倍
        int size=(int)Math.ceil(length*1.0/blockSize);//向上取整
        System.out.printf("要被切成<%d>个块",size);
        //规定实际的偏移量
        int beginPos=0;
        int actuaSize=(int)(blockSize>length?length:blockSize);
        for (int i=0;i<size;i++){
            //每次读取块的时候,起始偏移量
           beginPos=i*blockSize;
           if(i==size-1){
               //当时最后一个块的时候
               actuaSize=(int)length;
           }else {
               actuaSize=blockSize;
               length-=actuaSize;
           }
            System.out.println(i+"--->起始位置是:"+beginPos+"--->读取的大小是:"+actuaSize);
            readSplit(i,beginPos,actuaSize);
        }



    }
    public static void readSplit(int i,int beginPos,int actuaSize){
        RandomAccessFile randomAccessFile=null;
        try {
             randomAccessFile=new RandomAccessFile(new File("doc.txt"),"r");
            //设置文件指针偏移，从该文件的开头测量，发生下一次读取或写入。
            randomAccessFile.seek(beginPos);//表示从哪个偏移量开始读取数据
            byte[] bytes=new byte[1024];
            int length=0;
            while((length=randomAccessFile.read(bytes))!=-1){
                //当前文件一次就读完了
                if(actuaSize>length){
                    System.out.println(new String(bytes,0,length));
                    actuaSize-=length;
                }else{
                    System.out.println(new String(bytes,0,actuaSize));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
