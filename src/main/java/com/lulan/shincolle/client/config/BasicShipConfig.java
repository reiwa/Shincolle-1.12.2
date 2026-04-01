package com.lulan.shincolle.config;

import com.lulan.shincolle.utility.LogHelper;
import net.minecraftforge.common.config.Configuration;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasicShipConfig {
    public static final String NEW_LINE = System.lineSeparator();
    protected String defaultEncoding = StandardCharsets.UTF_8.name();
    protected File file;

    protected BasicShipConfig(File file) {
        this.file = file;
    }

    public void runConfig() throws Exception {
        try {
            this.load();
        } catch (Exception e) {
            LogHelper.info("ERROR: load config file: " + this.file + " fail: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    protected void load() throws IOException {
        if (this.file.getParentFile() != null) {
            this.file.getParentFile().mkdirs();
        }
        if (!this.file.exists()) {
            if (this.file.createNewFile()) {
                this.createDefault();
            } else {
                throw new IOException("Create new config file fail: " + this.file.getAbsolutePath());
            }
        }
        if (this.file.canRead()) {
            try (Configuration.UnicodeInputStreamReader input = new Configuration.UnicodeInputStreamReader(new FileInputStream(this.file), this.defaultEncoding);
                 BufferedReader buffer = new BufferedReader(input)) {
                this.defaultEncoding = input.getEncoding();
                List<String> tempList = buffer.lines().collect(Collectors.toList());
                LogHelper.debug("DEBUG: load custom config lines: " + this.file + " " + tempList.size());
                this.parse(new ArrayList<>(tempList));
            }
        }
    }

    protected void createDefault() throws IOException {
        if (this.file.getParentFile() != null) {
            this.file.getParentFile().mkdirs();
        }
        if (!this.file.exists() && !this.file.createNewFile()) {
            throw new IOException("Create default config file fail: " + this.file.getAbsolutePath());
        }
        if (this.file.canWrite()) {
            ArrayList<String> strDefault = this.getDefaultContent();
            if (strDefault != null && !strDefault.isEmpty()) {
                try (BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file), this.defaultEncoding))) {
                    for (String s : strDefault) {
                        buffer.write(s);
                    }
                }
            }
        }
    }

    protected abstract void parse(ArrayList<String> var1);

    protected abstract ArrayList<String> getDefaultContent();

    protected static boolean isCommentString(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (Character.isWhitespace(str.charAt(i))) continue;
            return str.charAt(i) == '#';
        }
        return false;
    }
}
