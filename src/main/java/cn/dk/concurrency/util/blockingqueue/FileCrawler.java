package cn.dk.concurrency.util.blockingqueue;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingDeque;

/**
 * 文件搜索生产者
 */
public class FileCrawler implements Runnable {
    private final BlockingDeque<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawler(BlockingDeque<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {

    }

    private void crawl(File root){
        File[] entries = this.root.listFiles(this.fileFilter);
        if (entries != null){
            for (File entry: entries ) {
                if (entry.isDirectory()){
                    crawl(entry);
                }else if (!alreadyIndexed(entry)){

                }
            }
        }
    }

    private boolean alreadyIndexed(File entry){
        return this.fileQueue.contains(entry);
    }
}
