package com.online.site.start.sensitfilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 初始化敏感词汇，读取文件中敏感词
 */
public class TabooedWords {

    private final Set<String> tabooedWords = new HashSet<String>();

    /**
     * 从默认的敏感词汇文件中读取词汇, 初始化敏感词汇列表.
     */
    public synchronized void initialize() {
        InputStream in = TabooedUtils.class.getClassLoader().getResourceAsStream("tabooed.words");
        initialize(in, "UTF-8");
    }

    /**
     * 从指定的敏感词汇输入流中读取词汇, 初始化敏感词汇列表.
     *
     * @param in      敏感词汇输入流
     * @param charset 编码方式
     */
    public synchronized void initialize(InputStream in, String charset) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, charset));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (null != line && line.trim().length() > 0) {
                    tabooedWords.add(line.toLowerCase());
                }
            }
        } catch (Exception e) {
            // Ignore
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ioe) {
                // ignore
            }
        }
    }

    /**
     * 获取所有读取到的敏感词汇.
     *
     * @return 敏感词汇
     */
    public Set<String> getTabooedWords() {
        return tabooedWords;
    }
}
